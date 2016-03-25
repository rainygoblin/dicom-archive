package com.example.dicom.archive.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.bson.Document;
import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dicom.archive.dto.DataTable;
import com.example.dicom.archive.dto.DicomObjectSimpleDto;
import com.example.dicom.archive.dto.StudyDto;
import com.example.dicom.archive.service.MongoClientProvider;
import com.example.dicom.archive.service.QueryDicomFileService;
import com.example.dicom.archive.util.Json2Dcm;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Service
public class QueryDicomFileServiceImpl implements QueryDicomFileService {
	private static final Logger LOG = LoggerFactory.getLogger(QueryDicomFileServiceImpl.class.getName());

	@Autowired
	private MongoClientProvider mongoClientProvider;

	@Override
	public DataTable<StudyDto> query() {
		DataTable<StudyDto> result = new DataTable<>();
		Map<String,StudyDto> studyTree = new HashMap<>();
		MongoClient mongo = mongoClientProvider.getMongoClient();
		 // get database named "test"  
        MongoDatabase testDatabase = mongo.getDatabase("archive");  

//        MongoCollection<Document> xdsCollection = testDatabase.getCollection("ATNA");  
        MongoCollection<Document> dicomCollection = testDatabase.getCollection("dicom");  

        long startTime = System.nanoTime();
        LOG.info("begin get document(name: dreamoftch, age > 25) >>>>>>");  
        FindIterable<Document> documents= dicomCollection.find().projection(DicomObjectSimpleDto.includes);
        for (Document document :documents) {
        	addSop(studyTree,document);  
        }  
    	result.setData(studyTree.values());
    	result.setRecordsTotal(studyTree.size());
        LOG.info("finish get document(name: dreamoftch, age > 25) >>>>>>. cost:"+(System.nanoTime() - startTime)/1000000000.0);  
        
		return result;
	}
	
	private void addSop(Map<String,StudyDto> studyTree,Document document){
		Json2Dcm json2Dcm = new Json2Dcm();
		Attributes attributes;
		try {
			String id = (String)document.remove("_id");
			attributes = json2Dcm.parse(document.toJson());
			String studyInstanceUID = attributes.getString(Tag.StudyInstanceUID);

			StudyDto studyDto = studyTree.get(studyInstanceUID);
			if(studyDto == null){
				studyDto = StudyDto.buidFrom(attributes,json2Dcm.getFmi());
				studyTree.put(studyInstanceUID, studyDto);
			}
			studyDto.getSopInstanceUIDs().add(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

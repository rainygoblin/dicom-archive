package com.example.dicom.archive.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dicom.archive.dto.DataTable;
import com.example.dicom.archive.dto.DicomObjectSimpleDto;
import com.example.dicom.archive.service.MongoClientProvider;
import com.example.dicom.archive.service.QueryDicomFileService;
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
	public DataTable<Document> query() {
		DataTable<Document> result = new DataTable<>();
		List<Document> data = new ArrayList<>();
		MongoClient mongo = mongoClientProvider.getMongoClient();
		 // get database named "test"  
        MongoDatabase testDatabase = mongo.getDatabase("archive");  

//        MongoCollection<Document> xdsCollection = testDatabase.getCollection("ATNA");  
        MongoCollection<Document> dicomCollection = testDatabase.getCollection("dicom");  

        long startTime = System.nanoTime();
        LOG.info("begin get document(name: dreamoftch, age > 25) >>>>>>");  
        FindIterable<Document> documents= dicomCollection.find().projection(DicomObjectSimpleDto.includes).limit(10);
        for (Document document :documents) {
        	data.add(document);  
        }  
    	result.setData(data);
    	result.setRecordsTotal(10);
        LOG.info("finish get document(name: dreamoftch, age > 25) >>>>>>. cost:"+(System.nanoTime() - startTime)/1000000000.0);  
        
		return result;
	}
	
}

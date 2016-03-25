package com.example.dicom.archive.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;
import org.dcm4che3.util.TagUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dicom.archive.dto.StudyRestfulDto;
import com.example.dicom.archive.service.MongoClientProvider;
import com.example.dicom.archive.service.WADORestfulService;
import com.example.dicom.archive.util.Json2Dcm;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.QueryOperators;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Service
public class WADORestfulServiceImpl implements WADORestfulService {
	private static final Logger LOG = LoggerFactory.getLogger(WADORestfulServiceImpl.class.getName());

	@Autowired
	private MongoClientProvider mongoClientProvider;

	@Override
	public StudyRestfulDto query(String studyInstanceUid) {
		StudyRestfulDto result = null;
		MongoClient mongo = mongoClientProvider.getMongoClient();
		 // get database named "test"  
        MongoDatabase testDatabase = mongo.getDatabase("archive");  
  
        MongoCollection<Document> dicomCollection = testDatabase.getCollection("dicom");  

        long startTime = System.nanoTime();
        LOG.info("begin get document(name: dreamoftch, age > 25) >>>>>>");  
        BasicDBObject queryObject =  new BasicDBObject(TagUtils.toHexString(Tag.StudyInstanceUID)+".Value", studyInstanceUid);

		FindIterable<Document> documents = dicomCollection.find(queryObject);
        List<String> seriesList = new ArrayList<>();
        for (Document document :documents) {
    		Json2Dcm json2Dcm = new Json2Dcm();
        	Attributes attributes = null;
    		try {
    			document.remove("_id");
    			attributes = json2Dcm.parse(document.toJson());
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		if(attributes == null){
    			continue;
    		}
        	if(result == null){
        		result = buidStudyFrom(attributes, json2Dcm.getFmi());
        	}
        	
        	StudyRestfulDto.SeriesRestfulDto seriesRestfulDto = buildSeriesFrom(attributes);
        	if(!seriesList.contains(seriesRestfulDto.getSeriesInstanceUid())){
        		seriesList.add(seriesRestfulDto.getSeriesInstanceUid());
        		result.getSeriesList().add(seriesRestfulDto);
        	}
        	StudyRestfulDto.SeriesRestfulDto.InstanceRestfulDto instanceRestfulDto = buildInstanceFrom(attributes);
        	seriesRestfulDto.getInstances().add(instanceRestfulDto);
        }  
        LOG.info("finish get document(name: dreamoftch, age > 25) >>>>>>. cost:"+(System.nanoTime() - startTime)/1000000000.0);  
        
		return result;
	}

	public StudyRestfulDto buidStudyFrom(Attributes attributes,Attributes fmi) {
		StudyRestfulDto studyDto = new StudyRestfulDto();

		studyDto.setStudyDescription(attributes.getString(Tag.StudyDescription));
		studyDto.setStudyId(attributes.getString(Tag.StudyID));
		studyDto.setStudyInstanceUid(attributes.getString(Tag.StudyInstanceUID));
		studyDto.setStudyTime(attributes.getString(Tag.StudyTime));
		studyDto.setTransferSyntaxUID(fmi.getString(Tag.TransferSyntaxUID));
		studyDto.setAccessionNumber(attributes.getString(Tag.AccessionNumber));
		studyDto.setInstitutionName(attributes.getString(Tag.InstitutionName));
		studyDto.setPatientAge(attributes.getString(Tag.PatientAge));
		studyDto.setPatientBirthDate(attributes.getString(Tag.PatientBirthDate));
		studyDto.setPatientBirthTime(attributes.getString(Tag.PatientBirthTime));
		studyDto.setPatientId(attributes.getString(Tag.PatientID));
		studyDto.setPatientName(attributes.getString(Tag.PatientName));
		studyDto.setPatientSex(attributes.getString(Tag.PatientSex));
		return studyDto;
	}
	
	
	private StudyRestfulDto.SeriesRestfulDto buildSeriesFrom(Attributes attributes){
		StudyRestfulDto.SeriesRestfulDto series = new StudyRestfulDto.SeriesRestfulDto();
		series.setModality(attributes.getString(Tag.Modality));
		series.setSeriesDescription(attributes.getString(Tag.SeriesDescription));
		series.setSeriesInstanceUid(attributes.getString(Tag.SeriesInstanceUID));
		series.setSeriesNumber(attributes.getInt(Tag.SeriesNumber,0));
		return series;
	}
	
	private StudyRestfulDto.SeriesRestfulDto.InstanceRestfulDto buildInstanceFrom(Attributes attributes){
		StudyRestfulDto.SeriesRestfulDto.InstanceRestfulDto instance = new StudyRestfulDto.SeriesRestfulDto.InstanceRestfulDto();
		instance.setBitsAllocated(attributes.getInt(Tag.BitsAllocated,0));
		instance.setBitsStored(attributes.getInt(Tag.BitsStored,0));
		instance.setColumns(attributes.getInt(Tag.Columns,0));
		instance.setFrameOfReferenceUID(attributes.getString(Tag.FrameOfReferenceUID));
		instance.setHighBit(attributes.getInt(Tag.HighBit,0));
		instance.setImageOrientationPatient(attributes.getString(Tag.ImageOrientationPatient));
		instance.setImagePositionPatient(attributes.getString(Tag.ImagePositionPatient));
		instance.setImageType(attributes.getString(Tag.ImageType));
		instance.setInstanceNumber(attributes.getInt(Tag.InstanceNumber,0));
		instance.setPhotometricInterpretation(attributes.getString(Tag.PhotometricInterpretation));
		instance.setPixelRepresentation(attributes.getInt(Tag.PixelRepresentation,0));
		instance.setPixelSpacing(attributes.getString(Tag.PhotometricInterpretation));
		instance.setRescaleIntercept(attributes.getInt(Tag.RescaleIntercept,0));
		instance.setRescaleSlope(attributes.getInt(Tag.RescaleSlope,0));
		instance.setRows(attributes.getInt(Tag.Rows,0));
		instance.setSamplesPerPixel(attributes.getInt(Tag.SamplesPerPixel,0));
		instance.setSliceLocation(attributes.getInt(Tag.SliceLocation,0));
		instance.setSopClassUid(attributes.getString(Tag.SOPClassUID));
		instance.setSopInstanceUid(attributes.getString(Tag.SOPInstanceUID));
		instance.setSourceImageInstanceUid(attributes.getString(Tag.SOPInstanceUID));
		instance.setWindowCenter(attributes.getString(Tag.WindowCenter));
		instance.setWindowWidth(attributes.getString(Tag.WindowWidth));
		return instance;
	}
	
	
}

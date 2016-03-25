package com.example.dicom.archive.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.bson.Document;
import org.dcm4che3.io.DicomInputStream;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class Dcm2JsonTest {
	private static final String DICOM_FILE = "src/test/resources/dicoms/file1.dcm";
	private static final String JSON_FILE = "src/test/resources/dicoms/file1.json";

	@Test
	public void testConvert(){
        String mongoIpAddress = "localhost";
		Integer mongoPort = 27017;
		
		try(MongoClient mongo = new MongoClient(mongoIpAddress, mongoPort)) {
            Dcm2Json dcm2Json = new Dcm2Json();
            ByteArrayOutputStream baos =new ByteArrayOutputStream();
            DicomInputStream dis = new DicomInputStream(new File(DICOM_FILE));
            
            dcm2Json.convert(dis, baos);
            
            String s = baos.toString();
           
            String hash = DigestUtils.md5Hex(dis);
            
            long currentTime = System.currentTimeMillis();
    		MongoDatabase testDatabase = mongo.getDatabase("archive");

    		MongoCollection<Document> requestCollection = testDatabase
    				.getCollection("dicom");
    		
    		Document document = Document.parse( baos.toString());
    		document.put("_id", hash);

    		requestCollection.insertOne(document);

        } catch (Exception e) {
            System.err.println("dcm2xml: " + e.getMessage());
            e.printStackTrace();
            System.exit(2);
        }
	}
}

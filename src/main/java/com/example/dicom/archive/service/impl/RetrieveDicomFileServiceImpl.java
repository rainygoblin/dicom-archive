package com.example.dicom.archive.service.impl;

import java.io.IOException;
import java.io.OutputStream;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.dcm4che3.data.Tag;
import org.dcm4che3.util.TagUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dicom.archive.service.MongoClientProvider;
import com.example.dicom.archive.service.RetrieveDicomFileService;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.QueryOperators;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
@Service
public class RetrieveDicomFileServiceImpl implements RetrieveDicomFileService {
	private static final Logger LOG = LoggerFactory.getLogger(RetrieveDicomFileServiceImpl.class.getName());

	@Autowired
	private MongoClientProvider mongoClientProvider;

	@Override
	public void retrieve(String studyUID, String seriesUID, String objectUID, OutputStream outputStream)
			throws Exception {
		MongoClient mongo = mongoClientProvider.getMongoClient();
		// get database named "test"
		MongoDatabase testDatabase = mongo.getDatabase("archive");

		// MongoCollection<Document> xdsCollection =
		// testDatabase.getCollection("ATNA");
		MongoCollection<Document> dicomCollection = testDatabase.getCollection("dicom");
		long startTime = System.nanoTime();
		LOG.info("begin get document(name: dreamoftch, age > 25) >>>>>>");
		BasicDBObject queryObject = new BasicDBObject().append(QueryOperators.AND,
				new BasicDBObject[] { new BasicDBObject(TagUtils.toHexString(Tag.StudyInstanceUID)+".Value", studyUID),
						new BasicDBObject(TagUtils.toHexString(Tag.SeriesInstanceUID)+".Value", seriesUID),
						new BasicDBObject(TagUtils.toHexString(Tag.SOPInstanceUID)+".Value", objectUID) });
		BasicDBObject projectionObject = new BasicDBObject(1);
		projectionObject.put("_id", true);

		FindIterable<Document> documents = dicomCollection.find(queryObject).projection(projectionObject);
//		FindIterable<Document> documents = dicomCollection.find();
		Document firstDocument = documents.first();
		if (firstDocument != null) {
			String documentId = firstDocument.getString("_id");
			if (documentId != null) {
				final DB archiveDB = mongo.getDB("archive");
				GridFS gridFS = new GridFS(archiveDB, "files");
				try {
					GridFSDBFile gridFSDBFile = gridFS.findOne(new BasicDBObject("_id", documentId));
					if(gridFSDBFile != null){
						gridFSDBFile.writeTo(outputStream);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} else {
			throw new Exception("Can not get the SOP");
		}
		LOG.info("finish get document(name: dreamoftch, age > 25) >>>>>>. cost:"
				+ (System.nanoTime() - startTime) / 1000000000.0);

	}

}

package com.example.dicom.archive.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.bson.Document;
import org.dcm4che3.io.DicomInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.dicom.archive.service.ArchiveDicomFileService;
import com.example.dicom.archive.service.MongoClientProvider;
import com.example.dicom.archive.util.Dcm2Json;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;

@Service
public class ArchiveDicomFileServiceImpl implements ArchiveDicomFileService {
	private static final Logger LOG = LoggerFactory.getLogger(ArchiveDicomFileServiceImpl.class.getName());

	@Autowired
	private MongoClientProvider mongoClientProvider;

	@SuppressWarnings("deprecation")
	@Override
	public Map<String, String> upload(Map<String, MultipartFile> maps) {
		final Map<String, String> result = new HashMap<>();

		MongoClient mongo = mongoClientProvider.getMongoClient();
		try {
			final DB archiveDB = mongo.getDB("archive");
			final MongoDatabase testDatabase = mongo.getDatabase("archive");

			for (final Map.Entry<String, MultipartFile> entry : maps.entrySet()) {
				save(archiveDB, testDatabase, entry, result);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private void save(final DB archiveDB, final MongoDatabase testDatabase, Map.Entry<String, MultipartFile> entry,
			Map<String, String> result) {
		try {
			MultipartFile multipartFile = entry.getValue();
			String hashValue = DigestUtils.md5Hex(multipartFile.getInputStream());
			//query the id
			MongoCollection<Document> requestCollection = testDatabase.getCollection("dicom");
			long count= requestCollection.count(Filters.eq("_id", hashValue));
			if(count > 0){
				result.put(entry.getKey(), "Existing");
				LOG.info("This document Existing");
				return;
			}
			// save the file
			LOG.info("Save the dicom file into the mongodb");
			GridFS gridFS = new GridFS(archiveDB, "files");
			GridFSInputFile gfsFile;
			try {
				String fileName = multipartFile.getOriginalFilename();
				gfsFile = gridFS.createFile(multipartFile.getInputStream(), fileName);
				gfsFile.setId(hashValue);
				gfsFile.setContentType(multipartFile.getContentType());
				gfsFile.save();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// save the metadata
			LOG.info("Save the dicom metadata into the mongodb");
			Dcm2Json dcm2Json = new Dcm2Json();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			DicomInputStream dis = new DicomInputStream(multipartFile.getInputStream());
			dcm2Json.convert(dis, baos);
			Document document = Document.parse(baos.toString());
			document.put("_id", hashValue);
			requestCollection.insertOne(document);
			result.put(entry.getKey(), hashValue);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
		}

	}

}

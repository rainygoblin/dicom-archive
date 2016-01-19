package com.example.dicom.archive.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;

@Service
@Scope("singleton") 
public class MongoClientProvider {

	@Value("${mongodb.address}")
	private String mongoIpAddress;
	@Value("${mongodb.port}")
	private Integer mongoPort;
	
	private MongoClient mongo;

	@PostConstruct
	public void init(){
		mongo = new MongoClient(mongoIpAddress, mongoPort);
	}
	
	@PreDestroy
	public void destroy(){
		mongo.close();
	}

	public MongoClient getMongoClient() {
		return mongo;
	}

}

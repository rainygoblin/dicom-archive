package com.example.dicom.archive.controller;

import java.io.IOException;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dicom.archive.dto.DataTable;
import com.example.dicom.archive.service.QueryDicomFileService;
import com.example.dicom.archive.util.PathConstants;

/**
 * Log out request congtroller
 * 
 * @author Kai Zhang
 *
 */
@Controller  
@RequestMapping(PathConstants.PATH_QUERY)  
public class QueryController {
	private static Logger logger = LoggerFactory.getLogger(QueryController.class);
	
	@Autowired
	private QueryDicomFileService queryDicomFileService;
	
	@RequestMapping(method=RequestMethod.GET) 
	public @ResponseBody DataTable<Document> doGet() throws IOException{
		logger.info("Get the query page request!");
		return queryDicomFileService.query();
//		return RestResponseWrapper.ok(result);
	}
}

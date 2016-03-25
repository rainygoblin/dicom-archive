package com.example.dicom.archive.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dicom.archive.dto.StudyRestfulDto;
import com.example.dicom.archive.service.WADORestfulService;
import com.example.dicom.archive.util.PathConstants;

/**
 * Log out request congtroller
 * 
 * @author Kai Zhang
 *
 */
@Controller  
@RequestMapping(PathConstants.PATH_WADO_RS)  
public class WADORestfulController {
	private static Logger logger = LoggerFactory.getLogger(WADORestfulController.class);
	
	@Autowired
	private WADORestfulService wadoRestfulService;
	
	@RequestMapping(value="/{studyInstanceUid:.+}",method=RequestMethod.GET) 
	public @ResponseBody StudyRestfulDto doGet(@PathVariable String studyInstanceUid) throws IOException{
		logger.info("Get the query page request!");
		return wadoRestfulService.query(studyInstanceUid);
//		return RestResponseWrapper.ok(result);
	}
}

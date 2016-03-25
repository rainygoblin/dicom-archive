package com.example.dicom.archive.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dicom.archive.service.RetrieveDicomFileService;
import com.example.dicom.archive.util.PathConstants;

/**
 * Log out request congtroller
 * 
 * @author Kai Zhang
 *
 */
@Controller  
@RequestMapping(PathConstants.PATH_WADO)  
public class WADOController {
	private static Logger logger = LoggerFactory.getLogger(WADOController.class);
	
	@Autowired
	private RetrieveDicomFileService retrieveDicomFileService;
	
	@RequestMapping(method=RequestMethod.GET) 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		logger.info("Get the query page request!");
		String studyUID = request.getParameter("studyUID");
		String seriesUID = request.getParameter("seriesUID");
		String objectUID = request.getParameter("objectUID");
		
		response.setContentType("application/dicom");
		
		try{
			response.setHeader("Content-Disposition",  "attachment;filename=\"" + objectUID + ".dcm\"");
			retrieveDicomFileService.retrieve(studyUID,seriesUID,objectUID,response.getOutputStream());
		}catch(Exception e){
			e.printStackTrace();
			response.setContentType("text/plain");
			response.setStatus(HttpServletResponse.SC_CONFLICT);
			response.getWriter().println(e.getMessage());
		}
//		return RestResponseWrapper.ok(result);
	}
}

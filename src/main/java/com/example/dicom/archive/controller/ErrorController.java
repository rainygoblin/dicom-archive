package com.example.dicom.archive.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dicom.archive.util.PathConstants;
import com.example.dicom.archive.util.ViewConstants;

/**
 * Log out request congtroller
 * 
 * @author Kai Zhang
 *
 */
@Controller  
@RequestMapping(PathConstants.PATH_ERROR)  
public class ErrorController {
	private static Logger logger = LoggerFactory.getLogger(ErrorController.class);
	
	/**
	 * Renders the home page as HTML in thw web browser.
	 * The home page is different based on whether the user is signed in or not.
	 * @throws IOException 
	 */
	
	@RequestMapping(method=RequestMethod.GET) 
	public String loginGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		logger.info("Get the error page request!");
		return ViewConstants.VIEW_ERROR;
	}
	
}

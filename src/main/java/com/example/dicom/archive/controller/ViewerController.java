package com.example.dicom.archive.controller;

import java.io.IOException;

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
@RequestMapping(PathConstants.PATH_VIEWER)  
public class ViewerController {
	private static Logger logger = LoggerFactory.getLogger(ViewerController.class);
	
	/**
	 * Renders the home page as HTML in thw web browser.
	 * The home page is different based on whether the user is signed in or not.
	 * @throws IOException 
	 */
	
	@RequestMapping(method=RequestMethod.GET) 
	public String loginGet() throws IOException{
		logger.info("Get the index page request!");
		return ViewConstants.VIEW_VIEWER;
	}
	
}

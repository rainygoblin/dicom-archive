package com.example.dicom.archive.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.dicom.archive.dto.RestResponseWrapper;
import com.example.dicom.archive.msg.FileUploadMsgs;
import com.example.dicom.archive.service.ArchiveDicomFileService;
import com.example.dicom.archive.util.PathConstants;
import com.example.dicom.archive.util.ViewConstants;

/**
 * 
 * <p class="detail">
 * 功能：公共Action
 * </p>
 * 
 * @ClassName: BaseAction
 * @version V1.0
 * @date 2014年9月25日
 * @author wangsheng
 */
@Controller
@RequestMapping(PathConstants.PATH_UPLOAD)
public class FileUploadController {
	private static final Logger LOG = LoggerFactory.getLogger(FileUploadController.class.getName());

	@Autowired
	private ArchiveDicomFileService uploadedFileService;
	@RequestMapping(method = RequestMethod.GET)
	public String doGet() {
		return ViewConstants.VIEW_UPLOAD;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody RestResponseWrapper doPost(MultipartHttpServletRequest request, Model model) {
		try {
			Map<String, MultipartFile> maps = request.getFileMap();

			if (maps.size() < 1) {
				return RestResponseWrapper.error(FileUploadMsgs.EMPTY_UPLOAD_FILE);
			}

			Map<String, String> result = uploadedFileService.upload(maps);

			LOG.debug("Upload successfully");
			return RestResponseWrapper.ok(result);
		} catch (Exception e) {
			return RestResponseWrapper.error(e.getMessage());
		}
	}

}
package com.example.dicom.archive.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface ArchiveDicomFileService {

	Map<String, String> upload(Map<String, MultipartFile> maps);

}

package com.example.dicom.archive.service;

import com.example.dicom.archive.dto.StudyRestfulDto;

public interface WADORestfulService {
	public StudyRestfulDto query(String studyInstanceUid);
}

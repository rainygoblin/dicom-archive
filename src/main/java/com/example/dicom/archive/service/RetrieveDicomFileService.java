package com.example.dicom.archive.service;

import java.io.OutputStream;

public interface RetrieveDicomFileService {

	void retrieve(String studyUID, String seriesUID, String objectUID, OutputStream outputStream)
			throws Exception;

}

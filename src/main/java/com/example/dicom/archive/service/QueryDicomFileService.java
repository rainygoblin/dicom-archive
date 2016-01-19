package com.example.dicom.archive.service;

import org.bson.Document;

import com.example.dicom.archive.dto.DataTable;

public interface QueryDicomFileService {

	DataTable<Document> query();

}

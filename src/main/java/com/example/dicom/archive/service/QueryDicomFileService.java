package com.example.dicom.archive.service;

import com.example.dicom.archive.dto.DataTable;
import com.example.dicom.archive.dto.StudyDto;

public interface QueryDicomFileService {

	DataTable<StudyDto> query();

}

package com.example.dicom.archive.dto;

import org.dcm4che3.data.Tag;
import org.dcm4che3.util.TagUtils;

import com.mongodb.BasicDBObject;

public class DicomObjectSimpleDto {
	public static final BasicDBObject includes = new BasicDBObject(10);
	static{
		includes.put(TagUtils.toHexString(Tag.PatientName), true);
		includes.put(TagUtils.toHexString(Tag.PatientID), true);
		includes.put(TagUtils.toHexString(Tag.StudyDate), true);
		includes.put(TagUtils.toHexString(Tag.StudyDescription), true);
	}
}

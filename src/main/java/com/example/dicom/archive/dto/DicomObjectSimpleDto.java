package com.example.dicom.archive.dto;

import org.dcm4che3.data.Tag;
import org.dcm4che3.util.TagUtils;

import com.mongodb.BasicDBObject;

public class DicomObjectSimpleDto {
	public static final BasicDBObject includes = new BasicDBObject(10);
	static{
		includes.put(TagUtils.toHexString(Tag.StudyDescription), true);
		includes.put(TagUtils.toHexString(Tag.StudyDate), true);
		includes.put(TagUtils.toHexString(Tag.StudyID), true);
		includes.put(TagUtils.toHexString(Tag.StudyInstanceUID), true);
		includes.put(TagUtils.toHexString(Tag.StudyTime), true);
		includes.put(TagUtils.toHexString(Tag.Modality), true);
		includes.put(TagUtils.toHexString(Tag.TransferSyntaxUID), true);
		includes.put(TagUtils.toHexString(Tag.AccessionNumber), true);
		includes.put(TagUtils.toHexString(Tag.InstitutionName), true);
		includes.put(TagUtils.toHexString(Tag.PatientAge), true);
		includes.put(TagUtils.toHexString(Tag.PatientBirthDate), true);
		includes.put(TagUtils.toHexString(Tag.PatientBirthName), true);
		includes.put(TagUtils.toHexString(Tag.PatientID), true);
		includes.put(TagUtils.toHexString(Tag.PatientName), true);
		includes.put(TagUtils.toHexString(Tag.PatientSex), true);
		
	}
}

package com.example.dicom.archive.dto;

import java.util.ArrayList;
import java.util.List;

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;

public class StudyDto {
	private String studyDescription;
	private String studyDate;
	private String studyID;
	private String studyInstanceUID;
	private String studyTime;
	private String modality;
	private String transferSyntaxUID;
	private String accessionNumber;
	private String institutionName;
	private String patientAge;
	private String patientBirthDate;
	private String patientBirthName;
	private String patientID;
	private String patientName;
	private String patientSex;
	private List<String> sopInstanceUIDs = new ArrayList<>();
	
	public String getStudyDescription() {
		return studyDescription;
	}
	public void setStudyDescription(String studyDescription) {
		this.studyDescription = studyDescription;
	}
	public String getStudyDate() {
		return studyDate;
	}
	public void setStudyDate(String studyDate) {
		this.studyDate = studyDate;
	}
	public String getStudyID() {
		return studyID;
	}
	public void setStudyID(String studyID) {
		this.studyID = studyID;
	}
	public String getStudyInstanceUID() {
		return studyInstanceUID;
	}
	public void setStudyInstanceUID(String studyInstanceUID) {
		this.studyInstanceUID = studyInstanceUID;
	}
	public String getStudyTime() {
		return studyTime;
	}
	public void setStudyTime(String studyTime) {
		this.studyTime = studyTime;
	}
	public String getModality() {
		return modality;
	}
	public void setModality(String modality) {
		this.modality = modality;
	}
	public String getTransferSyntaxUID() {
		return transferSyntaxUID;
	}
	public void setTransferSyntaxUID(String transferSyntaxUID) {
		this.transferSyntaxUID = transferSyntaxUID;
	}
	public String getAccessionNumber() {
		return accessionNumber;
	}
	public void setAccessionNumber(String accessionNumber) {
		this.accessionNumber = accessionNumber;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public String getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientBirthDate() {
		return patientBirthDate;
	}
	public void setPatientBirthDate(String patientBirthDate) {
		this.patientBirthDate = patientBirthDate;
	}
	public String getPatientBirthName() {
		return patientBirthName;
	}
	public void setPatientBirthName(String patientBirthName) {
		this.patientBirthName = patientBirthName;
	}
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientSex() {
		return patientSex;
	}
	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}
	public List<String> getSopInstanceUIDs() {
		return sopInstanceUIDs;
	}
	public void setSopInstanceUIDs(List<String> sopInstanceUIDs) {
		this.sopInstanceUIDs = sopInstanceUIDs;
	}
	public static StudyDto buidFrom(Attributes attributes,Attributes fmi) {
		StudyDto studyDto = new StudyDto();

		studyDto.setStudyDescription(attributes.getString(Tag.StudyDescription));
		studyDto.setStudyDescription(attributes.getString(Tag.StudyDate));
		studyDto.setStudyID(attributes.getString(Tag.StudyID));
		studyDto.setStudyInstanceUID(attributes.getString(Tag.StudyInstanceUID));
		studyDto.setStudyTime(attributes.getString(Tag.StudyTime));
		studyDto.setModality(attributes.getString(Tag.Modality));
		studyDto.setTransferSyntaxUID(fmi.getString(Tag.TransferSyntaxUID));
		studyDto.setAccessionNumber(attributes.getString(Tag.AccessionNumber));
		studyDto.setInstitutionName(attributes.getString(Tag.InstitutionName));
		studyDto.setPatientAge(attributes.getString(Tag.PatientAge));
		studyDto.setPatientBirthDate(attributes.getString(Tag.PatientBirthDate));
		studyDto.setPatientBirthName(attributes.getString(Tag.PatientBirthName));
		studyDto.setPatientID(attributes.getString(Tag.PatientID));
		studyDto.setPatientName(attributes.getString(Tag.PatientName));
		studyDto.setPatientSex(attributes.getString(Tag.PatientSex));
		return studyDto;
	}
	
}

package com.example.dicom.archive.dto;

import java.util.ArrayList;
import java.util.List;

public class StudyRestfulDto {

	private String transferSyntaxUID;
	
	/**
	 * For the patient level
	 */
	private String patientAge;
	private String patientBirthDate;
	private String patientBirthTime;
	private String patientId;
	private String patientName;
	private String patientSex;
	
	/**
	 * For the Study level
	 */
	private String studyDescription;
	private String studyDate;
	private String studyId;
	private String studyInstanceUid;
	private String studyTime;
	private String accessionNumber;
	private String institutionName;
	private List<StudyRestfulDto.SeriesRestfulDto> seriesList;
	
	public String getTransferSyntaxUID() {
		return transferSyntaxUID;
	}
	public void setTransferSyntaxUID(String transferSyntaxUID) {
		this.transferSyntaxUID = transferSyntaxUID;
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
	public String getPatientBirthTime() {
		return patientBirthTime;
	}
	public void setPatientBirthTime(String patientBirthTime) {
		this.patientBirthTime = patientBirthTime;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
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
	public String getStudyId() {
		return studyId;
	}
	public void setStudyId(String studyId) {
		this.studyId = studyId;
	}
	public String getStudyInstanceUid() {
		return studyInstanceUid;
	}
	public void setStudyInstanceUid(String studyInstanceUid) {
		this.studyInstanceUid = studyInstanceUid;
	}
	public String getStudyTime() {
		return studyTime;
	}
	public void setStudyTime(String studyTime) {
		this.studyTime = studyTime;
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
	
	public List<StudyRestfulDto.SeriesRestfulDto> getSeriesList() {
		if(seriesList == null){
			seriesList = new ArrayList<>();
		}
		return seriesList;
	}
	public void setSeriesList(List<StudyRestfulDto.SeriesRestfulDto> seriesList) {
		this.seriesList = seriesList;
	}

	/**
	 * For the series level
	 */
	public static class SeriesRestfulDto{
		private String modality;
		private String seriesInstanceUid;
		private String seriesDescription;
		private int seriesNumber;
		
		private List<StudyRestfulDto.SeriesRestfulDto.InstanceRestfulDto> instances;
		
		public String getModality() {
			return modality;
		}
		public void setModality(String modality) {
			this.modality = modality;
		}
		public String getSeriesInstanceUid() {
			return seriesInstanceUid;
		}
		public void setSeriesInstanceUid(String seriesInstanceUid) {
			this.seriesInstanceUid = seriesInstanceUid;
		}
		public String getSeriesDescription() {
			return seriesDescription;
		}
		public void setSeriesDescription(String seriesDescription) {
			this.seriesDescription = seriesDescription;
		}
		public int getSeriesNumber() {
			return seriesNumber;
		}
		public void setSeriesNumber(int seriesNumber) {
			this.seriesNumber = seriesNumber;
		}
		
		public List<StudyRestfulDto.SeriesRestfulDto.InstanceRestfulDto> getInstances() {
			if (instances == null){
				instances = new ArrayList<>();
			}
			return instances;
		}
		public void setInstances(List<StudyRestfulDto.SeriesRestfulDto.InstanceRestfulDto> instances) {
			this.instances = instances;
		}

		public static class InstanceRestfulDto{
			private String imageType;
			private String sopClassUid;
			private String sopInstanceUid;
			private int instanceNumber;
			private String imagePositionPatient;
			private String imageOrientationPatient;
			private String frameOfReferenceUID;
			private float sliceLocation;
			private int samplesPerPixel;
			private String photometricInterpretation;
			private int rows;
			private int columns;
			private String pixelSpacing;
			private int bitsAllocated;
			private int bitsStored;
			private int highBit;
			private int pixelRepresentation;
			private String windowCenter;
			private String windowWidth;
			private int rescaleIntercept;
			private int rescaleSlope;
			private String sourceImageInstanceUid;
			private String wadouri;
			public String getImageType() {
				return imageType;
			}
			public void setImageType(String imageType) {
				this.imageType = imageType;
			}
			public String getSopClassUid() {
				return sopClassUid;
			}
			public void setSopClassUid(String sopClassUid) {
				this.sopClassUid = sopClassUid;
			}
			public String getSopInstanceUid() {
				return sopInstanceUid;
			}
			public void setSopInstanceUid(String sopInstanceUid) {
				this.sopInstanceUid = sopInstanceUid;
			}
			public int getInstanceNumber() {
				return instanceNumber;
			}
			public void setInstanceNumber(int instanceNumber) {
				this.instanceNumber = instanceNumber;
			}
			public String getImagePositionPatient() {
				return imagePositionPatient;
			}
			public void setImagePositionPatient(String imagePositionPatient) {
				this.imagePositionPatient = imagePositionPatient;
			}
			public String getImageOrientationPatient() {
				return imageOrientationPatient;
			}
			public void setImageOrientationPatient(String imageOrientationPatient) {
				this.imageOrientationPatient = imageOrientationPatient;
			}
			public String getFrameOfReferenceUID() {
				return frameOfReferenceUID;
			}
			public void setFrameOfReferenceUID(String frameOfReferenceUID) {
				this.frameOfReferenceUID = frameOfReferenceUID;
			}
			public float getSliceLocation() {
				return sliceLocation;
			}
			public void setSliceLocation(float sliceLocation) {
				this.sliceLocation = sliceLocation;
			}
			public int getSamplesPerPixel() {
				return samplesPerPixel;
			}
			public void setSamplesPerPixel(int samplesPerPixel) {
				this.samplesPerPixel = samplesPerPixel;
			}
			public String getPhotometricInterpretation() {
				return photometricInterpretation;
			}
			public void setPhotometricInterpretation(String photometricInterpretation) {
				this.photometricInterpretation = photometricInterpretation;
			}
			public int getRows() {
				return rows;
			}
			public void setRows(int rows) {
				this.rows = rows;
			}
			public int getColumns() {
				return columns;
			}
			public void setColumns(int columns) {
				this.columns = columns;
			}
			public String getPixelSpacing() {
				return pixelSpacing;
			}
			public void setPixelSpacing(String pixelSpacing) {
				this.pixelSpacing = pixelSpacing;
			}
			public int getBitsAllocated() {
				return bitsAllocated;
			}
			public void setBitsAllocated(int bitsAllocated) {
				this.bitsAllocated = bitsAllocated;
			}
			public int getBitsStored() {
				return bitsStored;
			}
			public void setBitsStored(int bitsStored) {
				this.bitsStored = bitsStored;
			}
			public int getHighBit() {
				return highBit;
			}
			public void setHighBit(int highBit) {
				this.highBit = highBit;
			}
			public int getPixelRepresentation() {
				return pixelRepresentation;
			}
			public void setPixelRepresentation(int pixelRepresentation) {
				this.pixelRepresentation = pixelRepresentation;
			}
			public String getWindowCenter() {
				return windowCenter;
			}
			public void setWindowCenter(String windowCenter) {
				this.windowCenter = windowCenter;
			}
			public String getWindowWidth() {
				return windowWidth;
			}
			public void setWindowWidth(String windowWidth) {
				this.windowWidth = windowWidth;
			}
			public int getRescaleIntercept() {
				return rescaleIntercept;
			}
			public void setRescaleIntercept(int rescaleIntercept) {
				this.rescaleIntercept = rescaleIntercept;
			}
			public int getRescaleSlope() {
				return rescaleSlope;
			}
			public void setRescaleSlope(int rescaleSlope) {
				this.rescaleSlope = rescaleSlope;
			}
			public String getSourceImageInstanceUid() {
				return sourceImageInstanceUid;
			}
			public void setSourceImageInstanceUid(String sourceImageInstanceUid) {
				this.sourceImageInstanceUid = sourceImageInstanceUid;
			}
		}
	}
}

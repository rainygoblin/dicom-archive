package com.example.dicom.archive.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application.xml")
public class ArchiveDicomFileServiceTest extends AbstractJUnit4SpringContextTests{
	private static final String DICOM1_FILE = "src/test/resources/dicoms/file1.dcm";
	private static final String DICOM2_FILE = "src/test/resources/dicoms/file2.dcm";
	@Autowired
	private ArchiveDicomFileService archiveDicomFileService;
	
	@Before
	public void init(){
		Assert.assertNotNull(archiveDicomFileService);
	}
	
	@Test
	public void testUpload() throws IOException{
		Map<String, MultipartFile> maps =new HashMap<>();
		MockMultipartFile dicom1File = new MockMultipartFile("dicom", "file1.dcm", "application/dicom", FileUtils.readFileToByteArray(new File(DICOM1_FILE)));
		MockMultipartFile dicom2File = new MockMultipartFile("dicom", "file2.dcm", "application/dicom", FileUtils.readFileToByteArray(new File(DICOM2_FILE)));
		maps.put("test1", dicom1File);
		maps.put("test2", dicom2File);
		archiveDicomFileService.upload(maps);
	}
}

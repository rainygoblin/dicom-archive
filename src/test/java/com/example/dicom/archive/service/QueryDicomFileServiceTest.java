package com.example.dicom.archive.service;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.dicom.archive.dto.DataTable;
import com.example.dicom.archive.dto.StudyDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application.xml")
public class QueryDicomFileServiceTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	private QueryDicomFileService queryDicomFileService;
	
	@Before
	public void init(){
		Assert.assertNotNull(queryDicomFileService);
	}
	
	@Test
	public void testQuery() throws IOException{
		DataTable<StudyDto> result = queryDicomFileService.query();
		Assert.assertNotNull(result);
	}
}

package com.example.dicom.archive.service;

import java.io.File;
import java.io.FileOutputStream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application.xml")
public class RetrieveDicomFileServiceTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private RetrieveDicomFileService retrieveDicomFileService;

	@Test
	public void test() {
		try {
			retrieveDicomFileService.retrieve("1.2.840.113857.1626.160635.1727.151815",
					"1.2.840.113857.1626.160635.1727.151815.1", "1.2.840.113857.1626.160635.1727.151815.1.1",
					new FileOutputStream(new File("src/test/resources/dicoms/download.dcm")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertNotNull("");
	}

}

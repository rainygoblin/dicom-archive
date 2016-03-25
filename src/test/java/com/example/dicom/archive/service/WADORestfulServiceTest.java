package com.example.dicom.archive.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.example.dicom.archive.dto.StudyRestfulDto;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application.xml")
public class WADORestfulServiceTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private WADORestfulService wadoRestfulService;

	@Test
	public void test() {
		StudyRestfulDto result = wadoRestfulService.query("1.2.840.113857.1626.160635.1727.151815");
	    Assert.assertNotNull(result);
	    System.err.println(JSON.toJSONString(result));
  	}

}

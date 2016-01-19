package com.example.dicom.archive.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.example.dicom.archive.util.PathConstants;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextHierarchy({ // 指定容器层次，即spring-config.xml是父容器，而spring-mvc.xml是子容器
		@ContextConfiguration(name = "parent", locations = "classpath:spring/application.xml"),
		@ContextConfiguration(name = "child", locations = "classpath:spring/application-servlet.xml") })
// @ContextConfiguration(locations = { "classpath:spring/application.xml",
// "classpath:spring/application-servlet.xml" })
public class FileUploadControllerTest extends AbstractJUnit4SpringContextTests{
	private static final String DICOM1_FILE = "src/test/resources/dicoms/file1.dcm";

	@Autowired
	private WebApplicationContext webApplicationContext;

	protected MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.addFilters(new CharacterEncodingFilter()).build();
	}

	@Test
	public void testUploadFile() throws Exception {
		MockMultipartFile dicom1File = new MockMultipartFile("dicom", "file1.dcm", "application/dicom", FileUtils.readFileToByteArray(new File(DICOM1_FILE)));
		mockMvc.perform(fileUpload(PathConstants.PATH_UPLOAD).file(dicom1File))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
}

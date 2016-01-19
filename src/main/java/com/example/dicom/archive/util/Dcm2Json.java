package com.example.dicom.archive.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.xml.transform.TransformerConfigurationException;

import org.dcm4che3.io.DicomInputStream;
import org.dcm4che3.io.DicomInputStream.IncludeBulkData;
import org.dcm4che3.json.JSONWriter;

public class Dcm2Json {
	private boolean indent = false;

	public void convert(DicomInputStream dis, OutputStream out) throws IOException {
		dis.setIncludeBulkData(IncludeBulkData.NO);
		JsonGenerator jsonGen = createGenerator(out);
		JSONWriter jsonWriter = new JSONWriter(jsonGen);
		dis.setDicomInputHandler(jsonWriter);
		dis.readDataset(-1, -1);
		jsonGen.flush();
	}

	public void convert(File dicomFile, OutputStream out) throws IOException, TransformerConfigurationException {
		DicomInputStream dis = new DicomInputStream(dicomFile);
		try {
			convert(dis, out);
		} finally {
			dis.close();
		}
	}

	public void convert(File dicomFile, File jsonFile) throws IOException, TransformerConfigurationException {
		OutputStream out = new BufferedOutputStream(new FileOutputStream(jsonFile));
		try {
			convert(dicomFile, out);
		} finally {
			out.close();
		}
	}

	private JsonGenerator createGenerator(OutputStream out) {
		Map<String, ?> conf = new HashMap<String, Object>(2);
		if (indent)
			conf.put(JsonGenerator.PRETTY_PRINTING, null);
		return Json.createGeneratorFactory(conf).createGenerator(out);
	}
}

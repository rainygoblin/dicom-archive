package com.example.dicom.archive.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.json.Json;

import org.apache.commons.io.IOUtils;
import org.dcm4che3.data.Attributes;
import org.dcm4che3.json.JSONReader;
import org.dcm4che3.util.SafeClose;

public class Json2Dcm {
	private Attributes fmi;
	
    public Attributes getFmi() {
		return fmi;
	}

	public Attributes parse(String content) throws Exception {
      
    	Attributes dataset = new Attributes();
    	JSONReader reader = parseJSON(content, dataset);
    	Attributes fmi2 = reader.getFileMetaInformation();
        if (fmi2 != null)
            fmi = fmi2;
        return dataset;
    }

    private static JSONReader parseJSON(String content, Attributes attrs)
            throws IOException {
        InputStream in = IOUtils.toInputStream(content);
        try {
            JSONReader reader = new JSONReader(
                    Json.createParser(new InputStreamReader(in, "UTF-8")));
            reader.readDataset(attrs);
            return reader;
        } finally {
            if (in != System.in)
                SafeClose.close(in);
        }
    }
}

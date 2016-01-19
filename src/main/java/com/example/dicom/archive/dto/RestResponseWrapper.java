package com.example.dicom.archive.dto;

import java.io.Serializable;

public class RestResponseWrapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1689965671531471237L;
	private String status = null;
	private Object data = null;
	private String error = null;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public static RestResponseWrapper ok(Object obj){
		RestResponseWrapper newRestResponseWrapper = new RestResponseWrapper();
		newRestResponseWrapper.setStatus("success");
		newRestResponseWrapper.setData(obj);
		return newRestResponseWrapper;
	}
	
	public static RestResponseWrapper error(String err){
		RestResponseWrapper newRestResponseWrapper = new RestResponseWrapper();
		newRestResponseWrapper.setStatus("error");
		newRestResponseWrapper.setError(err);
		return newRestResponseWrapper;
	}
	
	public static RestResponseWrapper timeout(){
		RestResponseWrapper newRestResponseWrapper = new RestResponseWrapper();
		newRestResponseWrapper.setStatus("timeout");
		return newRestResponseWrapper;
	}
}

package com.example.dicom.archive.dto;

import java.util.List;

public class DataTable <T>{

    private List<T> data;//数据
    private int recordsFiltered;//得到的记录数
    private int recordsTotal;//数据库中记录数
    private int draw; //请求服务器端次数
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> aaData) {
		this.data = aaData;
	}
	public int getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	
    
}

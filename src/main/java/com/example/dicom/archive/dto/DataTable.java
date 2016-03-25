package com.example.dicom.archive.dto;

import java.util.Collection;

public class DataTable <T>{

    private Collection<T> data;//数据
    private long recordsFiltered;//得到的记录数
    private long recordsTotal;//数据库中记录数
    private int draw; //请求服务器端次数
	public Collection<T> getData() {
		return data;
	}
	public void setData(Collection<T> aaData) {
		this.data = aaData;
	}
	public long getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public long getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	
    
}

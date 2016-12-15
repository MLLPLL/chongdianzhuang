package com.niuniu.superadapter.platform.params;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class StationsListResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5519526988743756743L;
	
	@XmlElement(name = "pageNo")
	private String pageNo;
	
	@XmlElement(name = "pageCount")
	private String pageCount;
	
	@XmlElement(name = "itemSize")
	private String itemSize;
	
	@XmlElement(name = "stationInfo")
	private List<StationInfo> stationInfo;

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getPageCount() {
		return pageCount;
	}

	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}

	public String getItemSize() {
		return itemSize;
	}

	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}

	public List<StationInfo> getStationInfo() {
		return stationInfo;
	}

	public void setStationInfo(List<StationInfo> stationInfo) {
		this.stationInfo = stationInfo;
	}
	
	
	
}

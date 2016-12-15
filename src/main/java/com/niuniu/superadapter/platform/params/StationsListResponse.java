package com.niuniu.superadapter.platform.params;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.niuniu.superadapter.operator.hlht.params.HlhtStationInfo;

public class StationsListResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5519526988743756743L;
	
	@XmlElement(name = "pageNo")
	@JsonProperty(value = "PageNo")
	private String pageNo;
	
	@XmlElement(name = "pageCount")
	@JsonProperty(value = "PageCount")
	private String pageCount;
	
	@XmlElement(name = "itemSize")
	@JsonProperty(value = "ItemSize")
	private String itemSize;
	
	@XmlElement(name = "stationInfo")
	@JsonProperty(value = "StationInfos")
	private List<StationInfo> stationInfos;

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

	public List<StationInfo> getStationInfos() {
		return stationInfos;
	}

	public void setStationInfos(List<StationInfo> stationInfo) {
		this.stationInfos = stationInfo;
	}
	
	
	
}

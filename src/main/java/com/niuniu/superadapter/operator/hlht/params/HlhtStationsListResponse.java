package com.niuniu.superadapter.operator.hlht.params;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class HlhtStationsListResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1584496651949877422L;

	@XmlElement(name = "pageNo")
	private String pageNo;
	
	@XmlElement(name = "pageCount")
	private String pageCount;
	
	@XmlElement(name = "itemSize")
	private String itemSize;
	
	@XmlElement(name = "stationInfo")
	private List<HlhtStationInfo> stationInfo;

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

	public List<HlhtStationInfo> getStationInfo() {
		return stationInfo;
	}

	public void setStationInfo(List<HlhtStationInfo> stationInfo) {
		this.stationInfo = stationInfo;
	}
}

package com.niuniu.superadapter.platform.params;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class StationsListRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4505930238256120481L;
	
	@XmlElement(name = "stationID")
	@JsonProperty(value = "LastQueryTime")
	private String lastQueryTime;
	
	@XmlElement(name = "pageNo")
	@JsonProperty(value = "PageNo")
	private String pageNo;
	
	@XmlElement(name = "pageSize")
	@JsonProperty(value = "PageSize")
	private String pageSize;

	public String getLastQueryTime() {
		return lastQueryTime;
	}

	public void setLastQueryTime(String lastQueryTime) {
		this.lastQueryTime = lastQueryTime;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
}

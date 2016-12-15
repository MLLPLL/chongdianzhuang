package com.niuniu.superadapter.operator.hlht.params;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class HlhtStationsListRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9113327843875109325L;

	@XmlElement(name = "stationID")
	private String lastQueryTime;
	
	@XmlElement(name = "pageNo")
	private String pageNo;
	
	@XmlElement(name = "pageSize")
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

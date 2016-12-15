package com.niuniu.superadapter.platform.params;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class StationInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7349848729691274028L;
	
	@XmlElement(name = "stationID")
	private String stationID;
	
	@XmlElement(name = "operatorID")
	private String operatorID;
	
	@XmlElement(name = "equipmentOwnerID")
	private String equipmentOwnerID;
	
	@XmlElement(name = "stationName")
	private String stationName;
	
	@XmlElement(name = "countryCode")
	private String countryCode;
	
	@XmlElement(name = "areaCode")
	private String areaCode;
	
	@XmlElement(name = "adress")
	private String adress;
	
	@XmlElement(name = "stationTel")
	private String stationTel;
	
	@XmlElement(name = "serviceTel")
	private String serviceTel;
	
	@XmlElement(name = "stationType")
	private String stationType;
	
	@XmlElement(name = "statusStatus")
	private String statusStatus;
	
	@XmlElement(name = "parkNums")
	private String parkNums;
	
	@XmlElement(name = "stationLng")
	private String stationLng;
	
	@XmlElement(name = "stationLat")
	private String stationLat;
	
	@XmlElement(name = "siteGuide")
	private String siteGuide;
	
	@XmlElement(name = "construction")
	private String construction;
	
	@XmlElement(name = "picture")
	private String[] picture;
	
	@XmlElement(name = "matchCars")
	private String matchCars;
	
	@XmlElement(name = "parkInfo")
	private String parkInfo;
	
	@XmlElement(name = "busineHours")
	private String busineHours;
	
	@XmlElement(name = "electricityFee")
	private String electricityFee;
	
	@XmlElement(name = "serviceFee")
	private String serviceFee;
	
	@XmlElement(name = "parkFee")
	private String parkFee;
	
	@XmlElement(name = "payment")
	private String payment;
	
	@XmlElement(name = "supportOrder")
	private String supportOrder;
	
	@XmlElement(name = "remark")
	private String remark;

	public String getStationID() {
		return stationID;
	}

	public void setStationID(String stationID) {
		this.stationID = stationID;
	}

	public String getOperatorID() {
		return operatorID;
	}

	public void setOperatorID(String operatorID) {
		this.operatorID = operatorID;
	}

	public String getEquipmentOwnerID() {
		return equipmentOwnerID;
	}

	public void setEquipmentOwnerID(String equipmentOwnerID) {
		this.equipmentOwnerID = equipmentOwnerID;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getStationTel() {
		return stationTel;
	}

	public void setStationTel(String stationTel) {
		this.stationTel = stationTel;
	}

	public String getServiceTel() {
		return serviceTel;
	}

	public void setServiceTel(String serviceTel) {
		this.serviceTel = serviceTel;
	}

	public String getStationType() {
		return stationType;
	}

	public void setStationType(String stationType) {
		this.stationType = stationType;
	}

	public String getStatusStatus() {
		return statusStatus;
	}

	public void setStatusStatus(String statusStatus) {
		this.statusStatus = statusStatus;
	}

	public String getParkNums() {
		return parkNums;
	}

	public void setParkNums(String parkNums) {
		this.parkNums = parkNums;
	}

	public String getStationLng() {
		return stationLng;
	}

	public void setStationLng(String stationLng) {
		this.stationLng = stationLng;
	}

	public String getStationLat() {
		return stationLat;
	}

	public void setStationLat(String stationLat) {
		this.stationLat = stationLat;
	}

	public String getSiteGuide() {
		return siteGuide;
	}

	public void setSiteGuide(String siteGuide) {
		this.siteGuide = siteGuide;
	}

	public String getConstruction() {
		return construction;
	}

	public void setConstruction(String construction) {
		this.construction = construction;
	}

	public String[] getPicture() {
		return picture;
	}

	public void setPicture(String[] picture) {
		this.picture = picture;
	}

	public String getMatchCars() {
		return matchCars;
	}

	public void setMatchCars(String matchCars) {
		this.matchCars = matchCars;
	}

	public String getParkInfo() {
		return parkInfo;
	}

	public void setParkInfo(String parkInfo) {
		this.parkInfo = parkInfo;
	}

	public String getBusineHours() {
		return busineHours;
	}

	public void setBusineHours(String busineHours) {
		this.busineHours = busineHours;
	}

	public String getElectricityFee() {
		return electricityFee;
	}

	public void setElectricityFee(String electricityFee) {
		this.electricityFee = electricityFee;
	}

	public String getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(String serviceFee) {
		this.serviceFee = serviceFee;
	}

	public String getParkFee() {
		return parkFee;
	}

	public void setParkFee(String parkFee) {
		this.parkFee = parkFee;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getSupportOrder() {
		return supportOrder;
	}

	public void setSupportOrder(String supportOrder) {
		this.supportOrder = supportOrder;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	
}

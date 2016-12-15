package com.niuniu.superadapter.operator.hlht.params;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class HlhtStationInfo implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8645830152864638802L;

	@XmlElement(name = "stationID")
	@JsonProperty(value = "StationID")
	private String stationID;
	
	@XmlElement(name = "operatorID")
	@JsonProperty(value = "OperatorID")
	private String operatorID;
	
	@XmlElement(name = "equipmentOwnerID")
	@JsonProperty(value = "EquipmentOwnerID")
	private String equipmentOwnerID;
	
	@XmlElement(name = "stationName")
	@JsonProperty(value = "StationName")
	private String stationName;
	
	@XmlElement(name = "countryCode")
	@JsonProperty(value = "CountryCode")
	private String countryCode;
	
	@XmlElement(name = "areaCode")
	@JsonProperty(value = "AreaCode")
	private String areaCode;
	
	@XmlElement(name = "address")
	@JsonProperty(value = "Address")
	private String address;
	
	@XmlElement(name = "stationTel")
	@JsonProperty(value = "StationTel")
	private String stationTel;
	
	@XmlElement(name = "serviceTel")
	@JsonProperty(value = "ServiceTel")
	private String serviceTel;
	
	@XmlElement(name = "stationType")
	@JsonProperty(value = "StationType")
	private String stationType;
	
	@XmlElement(name = "stationStatus")
	@JsonProperty(value = "StationStatus")
	private String stationStatus;
	
	@XmlElement(name = "parkNums")
	@JsonProperty(value = "ParkNums")
	private String parkNums;
	
	@XmlElement(name = "stationLng")
	@JsonProperty(value = "StationLng")
	private String stationLng;
	
	@XmlElement(name = "stationLat")
	@JsonProperty(value = "StationLat")
	private String stationLat;
	
	@XmlElement(name = "siteGuide")
	@JsonProperty(value = "SiteGuide")
	private String siteGuide;
	
	@XmlElement(name = "construction")
	@JsonProperty(value = "Construction")
	private String construction;
	
	@XmlElement(name = "picture")
	@JsonProperty(value = "Picture")
	private String[] picture;
	
	@XmlElement(name = "matchCars")
	@JsonProperty(value = "MatchCars")
	private String matchCars;
	
	@XmlElement(name = "parkInfo")
	@JsonProperty(value = "ParkInfo")
	private String parkInfo;
	
	@XmlElement(name = "busineHours")
	@JsonProperty(value = "BusineHours")
	private String busineHours;
	
	@XmlElement(name = "electricityFee")
	@JsonProperty(value = "ElectricityFee")
	private String electricityFee;
	
	@XmlElement(name = "serviceFee")
	@JsonProperty(value = "ServiceFee")
	private String serviceFee;
	
	@XmlElement(name = "parkFee")
	@JsonProperty(value = "ParkFee")
	private String parkFee;
	
	@XmlElement(name = "payment")
	@JsonProperty(value = "Payment")
	private String payment;
	
	@XmlElement(name = "supportOrder")
	@JsonProperty(value = "SupportOrder")
	private String supportOrder;
	
	@XmlElement(name = "remark")
	@JsonProperty(value = "Remark")
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
		return address;
	}

	public void setAdress(String adress) {
		this.address = adress;
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
		return stationStatus;
	}

	public void setStatusStatus(String statusStatus) {
		this.stationStatus = statusStatus;
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

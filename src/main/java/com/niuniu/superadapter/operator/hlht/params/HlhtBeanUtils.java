package com.niuniu.superadapter.operator.hlht.params;

import java.util.ArrayList;
import java.util.List;

import com.niuniu.superadapter.platform.params.StationInfo;
import com.niuniu.superadapter.platform.params.StationsListRequest;
import com.niuniu.superadapter.platform.params.StationsListResponse;

public class HlhtBeanUtils {
	private HlhtBeanUtils(){
		
	}
	
	public static StationInfo getPFBean(HlhtStationInfo bean){
		StationInfo pfBean = new StationInfo();
		pfBean.setAddress(bean.getAdress());
		pfBean.setAreaCode(bean.getAreaCode());
		pfBean.setBusineHours(bean.getBusineHours());
		pfBean.setConstruction(bean.getConstruction());
		pfBean.setCountryCode(bean.getCountryCode());
		pfBean.setElectricityFee(bean.getElectricityFee());
		pfBean.setEquipmentOwnerID(bean.getEquipmentOwnerID());
		pfBean.setMatchCars(bean.getMatchCars());
		pfBean.setOperatorID(bean.getOperatorID());
		pfBean.setParkFee(bean.getParkFee());
		pfBean.setParkInfo(bean.getParkInfo());
		pfBean.setParkNums(bean.getParkNums());
		pfBean.setPayment(bean.getPayment());
		pfBean.setPicture(bean.getPicture());
		pfBean.setRemark(bean.getRemark());
		pfBean.setServiceFee(bean.getServiceFee());
		pfBean.setServiceTel(bean.getServiceTel());
		pfBean.setSiteGuide(bean.getSiteGuide());
		pfBean.setStationID(bean.getStationID());
		pfBean.setStationLat(bean.getStationLat());
		pfBean.setStationLng(bean.getStationLng());
		pfBean.setStationName(bean.getStationName());
		pfBean.setStationTel(bean.getStationTel());
		pfBean.setStationType(bean.getStationType());
		pfBean.setStationStatus(bean.getStatusStatus());
		pfBean.setSupportOrder(bean.getSupportOrder());
		return pfBean;
	}
	
	public static HlhtStationInfo getOperatorBean(StationInfo bean){
		HlhtStationInfo operatorBean = new HlhtStationInfo();
		operatorBean.setAdress(bean.getAddress());
		operatorBean.setAreaCode(bean.getAreaCode());
		operatorBean.setBusineHours(bean.getBusineHours());
		operatorBean.setConstruction(bean.getConstruction());
		operatorBean.setCountryCode(bean.getCountryCode());
		operatorBean.setElectricityFee(bean.getElectricityFee());
		operatorBean.setEquipmentOwnerID(bean.getEquipmentOwnerID());
		operatorBean.setMatchCars(bean.getMatchCars());
		operatorBean.setOperatorID(bean.getOperatorID());
		operatorBean.setParkFee(bean.getParkFee());
		operatorBean.setParkInfo(bean.getParkInfo());
		operatorBean.setParkNums(bean.getParkNums());
		operatorBean.setPayment(bean.getPayment());
		operatorBean.setPicture(bean.getPicture());
		operatorBean.setRemark(bean.getRemark());
		operatorBean.setServiceFee(bean.getServiceFee());
		operatorBean.setServiceTel(bean.getServiceTel());
		operatorBean.setSiteGuide(bean.getSiteGuide());
		operatorBean.setStationID(bean.getStationID());
		operatorBean.setStationLat(bean.getStationLat());
		operatorBean.setStationLng(bean.getStationLng());
		operatorBean.setStationName(bean.getStationName());
		operatorBean.setStationTel(bean.getStationTel());
		operatorBean.setStationType(bean.getStationType());
		operatorBean.setStatusStatus(bean.getStationStatus());
		operatorBean.setSupportOrder(bean.getSupportOrder());
		return operatorBean;
	}
	
	public static StationsListRequest getPFBean(HlhtStationsListRequest bean){
		StationsListRequest pfBean = new StationsListRequest();
		pfBean.setLastQueryTime(bean.getLastQueryTime());
		pfBean.setPageNo(bean.getPageNo());
		pfBean.setPageSize(bean.getPageSize());
		return pfBean;
	}
	
	public static HlhtStationsListRequest getOperatorBean(StationsListRequest bean){
		HlhtStationsListRequest operatorBean = new HlhtStationsListRequest();
		operatorBean.setLastQueryTime(bean.getLastQueryTime());
		operatorBean.setPageNo(bean.getPageNo());
		operatorBean.setPageSize(bean.getPageSize());
		return operatorBean;
	}
	
	public static StationsListResponse getPFBean(HlhtStationsListResponse bean){
		StationsListResponse pfBean = new StationsListResponse();
		pfBean.setPageCount(bean.getPageCount());
		pfBean.setPageNo(bean.getPageNo());
		
		List list = new ArrayList();
		List list1 = bean.getStationInfo();
		for(int i=0; i<list.size(); i++){
			list.add(HlhtBeanUtils.getPFBean((HlhtStationInfo)list1.get(i)));
		}
		pfBean.setStationInfo(list);
		return pfBean;
	}
	
	public static HlhtStationsListResponse getOperatorBean(StationsListResponse bean){
		HlhtStationsListResponse operatorBean = new HlhtStationsListResponse();
		operatorBean.setPageCount(bean.getPageCount());
		operatorBean.setPageNo(bean.getPageNo());
		
		List list = new ArrayList();
		List list1 = bean.getStationInfo();
		for(int i=0; i<list.size(); i++){
			list.add(HlhtBeanUtils.getOperatorBean((StationInfo)list1.get(i)));
		}
		operatorBean.setStationInfo(list);
		return operatorBean;
	}
}

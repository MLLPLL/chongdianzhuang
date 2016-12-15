package com.niuniu.superadapter.operator.hlht.params;

import com.niuniu.superadapter.platform.params.StationInfo;
import com.niuniu.superadapter.platform.params.StationsListRequest;
import com.niuniu.superadapter.platform.params.StationsListResponse;

public class HlhtBeanUtils {
	private HlhtBeanUtils(){
		
	}
	
	public StationInfo getPFBean(HlhtStationInfo bean){
		StationInfo pfBean = new StationInfo();
		return pfBean;
	}
	
	public HlhtStationInfo getOperatorBean(StationInfo bean){
		HlhtStationInfo operatorBean = new HlhtStationInfo();
		return operatorBean;
	}
	
	public StationsListRequest getPFBean(HlhtStationsListRequest bean){
		StationsListRequest pfBean = new StationsListRequest();
		return pfBean;
	}
	
	public HlhtStationsListRequest getOperatorBean(StationsListRequest bean){
		HlhtStationsListRequest operatorBean = new HlhtStationsListRequest();
		return operatorBean;
	}
	
	public StationsListResponse getPFBean(HlhtStationsListResponse bean){
		StationsListResponse pfBean = new StationsListResponse();
		return pfBean;
	}
	
	public HlhtStationsListResponse getOperatorBean(StationsListResponse bean){
		HlhtStationsListResponse operatorBean = new HlhtStationsListResponse();
		return operatorBean;
	}
}

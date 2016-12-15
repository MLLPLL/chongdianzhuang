package com.niuniu.superadapter.operator;

import java.util.ArrayList;
import java.util.List;

import com.niuniu.superadapter.platform.StandardIcomm;
import com.niuniu.superadapter.platform.StandardIserv;
import com.niuniu.superadapter.platform.params.StationListRequest;
import com.niuniu.superadapter.platform.params.StationListResponse;

public class OperatorAdapter implements StandardIcomm,StandardIserv{
	public StationListResponse queryStationsInfo(StationListRequest request){
		StationListResponse response = null; 
		response.setPageNo("1");
		response.setPageCount("1");//有待商定
		int itemsize = 0;
		List itemList = new ArrayList();
		try{
			List<NiuniuOperator> operators =  OperatorFactory.getAllOperators();
			for(int i=0 ; i< operators.size(); i++){
				StationListResponse res = ((NiuniuOperator)operators.get(i)).queryStationsInfo(request);
				itemsize = itemsize + Integer.valueOf(res.getItemSize()).intValue();
				itemList.addAll(res.getStationInfo());
			}
		}catch(Exception e){
			
		}		
		response.setItemSize(String.valueOf(itemsize));
		response.setStationInfo(itemList);
		return response;
	}
}

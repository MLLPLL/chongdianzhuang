package com.niuniu.superadapter.operator.hlht;

import com.niuniu.superadapter.operator.StandardOperator;
import com.niuniu.superadapter.platform.StandardIcomm;
import com.niuniu.superadapter.platform.StandardIserv;
import com.niuniu.superadapter.platform.params.StationsListRequest;
import com.niuniu.superadapter.platform.params.StationsListResponse;

public class HlhtOperator extends StandardOperator implements StandardIcomm,StandardIserv{
	
	@Override
	public StationsListResponse queryStationsInfo(StationsListRequest request){
		return null;
	}
}

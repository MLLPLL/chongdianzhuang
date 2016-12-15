package com.niuniu.superadapter.operator.hlht;

import com.niuniu.superadapter.operator.OperatorStub;
import com.niuniu.superadapter.platform.StandardIcomm;
import com.niuniu.superadapter.platform.params.StationsListRequest;
import com.niuniu.superadapter.platform.params.StationsListResponse;

public class HlhtOperator extends OperatorStub implements StandardIcomm{
	
	@Override
	public StationsListResponse queryStationsInfo(StationsListRequest request){
		return null;
	}
}

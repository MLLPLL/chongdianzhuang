package com.niuniu.superadapter.operator;

import com.niuniu.superadapter.platform.StandardIcomm;
import com.niuniu.superadapter.platform.StandardIserv;
import com.niuniu.superadapter.platform.params.StationsListRequest;
import com.niuniu.superadapter.platform.params.StationsListResponse;

public class OperatorStub implements StandardIcomm,StandardIserv{
	public StationsListResponse queryStationsInfo(StationsListRequest request){return null;}
}
package com.niuniu.superadapter.operator;

import com.niuniu.superadapter.platform.StandardIcomm;
import com.niuniu.superadapter.platform.StandardIserv;
import com.niuniu.superadapter.platform.params.StationListRequest;
import com.niuniu.superadapter.platform.params.StationListResponse;

public class NiuniuOperator implements StandardIcomm,StandardIserv{
	public StationListResponse queryStationsInfo(StationListRequest request){return null;}
}
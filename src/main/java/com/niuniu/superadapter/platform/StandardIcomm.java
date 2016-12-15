package com.niuniu.superadapter.platform;

import com.niuniu.superadapter.platform.params.StationsListRequest;
import com.niuniu.superadapter.platform.params.StationsListResponse;

public interface StandardIcomm {
	//得到所有充电站的信息
	public StationsListResponse queryStationsInfo(StationsListRequest request);
	
}

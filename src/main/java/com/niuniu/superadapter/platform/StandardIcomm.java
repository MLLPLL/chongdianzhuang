package com.niuniu.superadapter.platform;

import com.niuniu.superadapter.platform.params.StationListRequest;
import com.niuniu.superadapter.platform.params.StationListResponse;

public interface StandardIcomm {
	//得到所有充电站的信息
	public StationListResponse queryStationsInfo(StationListRequest request);
	
}

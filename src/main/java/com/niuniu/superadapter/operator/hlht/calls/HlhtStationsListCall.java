package com.niuniu.superadapter.operator.hlht.calls;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niuniu.superadapter.operator.hlht.HlhtConfig;
import com.niuniu.superadapter.operator.hlht.params.HlhtStationsListRequest;
import com.niuniu.superadapter.operator.hlht.params.HlhtStationsListResponse;
import org.gof.rest.utils.JsonUtils;


/**
 * Created by Alex.Chen on 2016/12/15.
 */
public class HlhtStationsListCall extends HlhtBaseCall {

    public static HlhtStationsListResponse call(HlhtStationsListRequest request) throws Exception {
        ObjectMapper objectMapper = JsonUtils.getObjectMapper();
        String data = objectMapper.writeValueAsString(request);
        String responseJson = getResponseJson(data);
        HlhtStationsListResponse hlhtStationsListResponse = objectMapper.readValue(responseJson, HlhtStationsListResponse.class);
        return hlhtStationsListResponse;
    }

    public static void main(String[] strs) throws Exception {
        HlhtStationsListRequest request = new HlhtStationsListRequest();
        request.setLastQueryTime("");
        request.setPageNo("1");
        request.setPageSize("10");
        HlhtStationsListResponse hlhtStationsListResponse = HlhtStationsListCall.call(request);
        System.out.println(hlhtStationsListResponse.getItemSize());
    }
}

package com.niuniu.superadapter.operator.hlht.calls;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niuniu.superadapter.operator.hlht.HlhtConfig;
import com.niuniu.superadapter.operator.hlht.params.HlhtNormalRequest;
import com.niuniu.superadapter.operator.hlht.params.HlhtStationsListRequest;
import com.niuniu.superadapter.operator.hlht.params.HlhtStationsListResponse;
import org.gof.rest.utils.AESUtil;
import org.gof.rest.utils.HMacMD5;
import org.gof.rest.utils.HttpClientUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex.Chen on 2016/12/15.
 */
public class HlhtStationsListCall {

    public static HlhtStationsListResponse call(HlhtStationsListRequest request) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssSSS");
        String auth = "Bearer "+HlhtTokenCall.getToken();
        String timeStemp = sdf.format(new Date());
        String data = objectMapper.writeValueAsString(request);
        String enString = AESUtil.Encrypt(data, HlhtConfig.SECURITY_KEY,HlhtConfig.AES_SECURITY);
        String sig = HMacMD5.getHmacMd5Str(HlhtConfig.SECURITY_KEY,HlhtConfig.OperatorID+enString+timeStemp+timeStemp);
        HlhtNormalRequest hlhtNormalRequest = new HlhtNormalRequest();
        hlhtNormalRequest.setOperatorID(HlhtConfig.OperatorID);
        hlhtNormalRequest.setData(enString);
        hlhtNormalRequest.setSig(sig);
        hlhtNormalRequest.setTimeStamp(timeStemp);
        hlhtNormalRequest.setSeq(timeStemp);
        String body = objectMapper.writeValueAsString(hlhtNormalRequest);
        String response = HttpClientUtil.doPostJson(HlhtConfig.STATIONS_URL,body,auth);
        Map map = objectMapper.readValue(response, HashMap.class);
        String deString = AESUtil.Decrypt((String)map.get("Data"),HlhtConfig.SECURITY_KEY);
        HlhtStationsListResponse hlhtStationsListResponse = objectMapper.readValue(deString, HlhtStationsListResponse.class);
        return hlhtStationsListResponse;
    }

    public static void main(String[] strs) throws Exception {
        HlhtStationsListRequest request = new HlhtStationsListRequest();
        request.setLastQueryTime("");
        request.setPageNo("1");
        request.setPageSize("10");
        HlhtStationsListResponse hlhtStationsListResponse = HlhtStationsListCall.call(request);
        System.out.println("aaaa");
    }
}

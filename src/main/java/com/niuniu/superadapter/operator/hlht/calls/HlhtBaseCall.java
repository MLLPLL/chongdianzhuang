package com.niuniu.superadapter.operator.hlht.calls;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niuniu.superadapter.operator.hlht.HlhtConfig;
import com.niuniu.superadapter.operator.hlht.params.HlhtNormalRequest;
import com.niuniu.superadapter.operator.hlht.params.HlhtStationsListResponse;
import org.gof.rest.utils.AESUtil;
import org.gof.rest.utils.HMacMD5;
import org.gof.rest.utils.HttpClientUtil;
import org.gof.rest.utils.JsonUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex.Chen on 2016/12/16.
 */
public class HlhtBaseCall {

    public static Object getResponseJson(Object request, Class clazz) throws Exception {
        ObjectMapper objectMapper = JsonUtils.getObjectMapper();
        String timeStemp = createTimeStemp();
        String data = objectMapper.writeValueAsString(request);
        String encryptData = encryptData(data);
        String sig = createSig(encryptData,timeStemp);
        String body = createBody(encryptData,sig,timeStemp,objectMapper);
        String responseJson = getResponseDataWhitAuth(body, HlhtConfig.STATIONS_URL ,objectMapper);
        Object object = objectMapper.readValue(responseJson, HlhtStationsListResponse.class);
        return object;
    }

    private static String encryptData(String data) throws Exception {
        return AESUtil.Encrypt(data, HlhtConfig.SECURITY_KEY, HlhtConfig.AES_SECURITY);
    }

    private static String createTimeStemp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
        String timeStemp = sdf.format(new Date());
        return timeStemp;
    }

    private static String createSig(String encryptData, String timeStemp) {
        return HMacMD5.getHmacMd5Str(HlhtConfig.SECURITY_KEY,
                HlhtConfig.OperatorID + encryptData + timeStemp + timeStemp);
    }

    private static String createBody(String encryptData, String sig,
                                    String timeStemp, ObjectMapper objectMapper) throws JsonProcessingException {
        HlhtNormalRequest hlhtNormalRequest = new HlhtNormalRequest();
        hlhtNormalRequest.setOperatorID(HlhtConfig.OperatorID);
        hlhtNormalRequest.setData(encryptData);
        hlhtNormalRequest.setSig(sig);
        hlhtNormalRequest.setTimeStamp(timeStemp);
        hlhtNormalRequest.setSeq(timeStemp);
        String body = objectMapper.writeValueAsString(hlhtNormalRequest);
        return body;
    }

    private static String getTokenResponseDataString(String body, ObjectMapper objectMapper) throws Exception {
        String response = HttpClientUtil.doPostJson(HlhtConfig.TOKEN_URL, body);
        Map map = objectMapper.readValue(response, HashMap.class);
        String data = AESUtil.Decrypt((String) map.get("Data"), HlhtConfig.SECURITY_KEY);
        return data;
    }

    private static String getResponseDataWhitAuth(String body, String url,
                                               ObjectMapper objectMapper) throws Exception {
        String token = getToken();
        String auth = "Bearer " + token;
        String response = HttpClientUtil.doPostJson(url, body, auth);
        Map map = objectMapper.readValue(response, HashMap.class);
        String data = AESUtil.Decrypt((String) map.get("Data"), HlhtConfig.SECURITY_KEY);
        return data;
    }

    private static String getToken() throws Exception {
        ObjectMapper objectMapper = JsonUtils.getObjectMapper();
        String data = createTokenData();
        String timeStemp = createTimeStemp();
        String encryptData = encryptData(data);
        String sig = createSig(encryptData, timeStemp);
        String body = createBody(encryptData, sig, timeStemp, objectMapper);
        String responseDataString = getTokenResponseDataString(body, objectMapper);
        Map map = objectMapper.readValue(responseDataString, HashMap.class);
        String token = (String) map.get("AccessToken");
        return token;
    }

    private static String createTokenData() {
        String data = "{\"OperatorID\":\"" + HlhtConfig.OperatorID + "\"," +
                "\"OperatorSecret\":\"" + HlhtConfig.OperatorSecret + "\"}";
        return data;
    }
}

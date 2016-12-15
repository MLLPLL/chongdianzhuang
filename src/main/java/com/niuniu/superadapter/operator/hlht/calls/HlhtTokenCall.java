package com.niuniu.superadapter.operator.hlht.calls;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niuniu.superadapter.operator.hlht.HlhtConfig;
import com.niuniu.superadapter.operator.hlht.beans.HlhtResponse;
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
public class HlhtTokenCall {

    public static void main(String[] strs) throws Exception {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssSSS");
        String url = "http://api.wyqcd.cn:9101/evcs/v20161110/query_token";
        String data = "{\"OperatorID\":\""+ HlhtConfig.OperatorID +"\"," +
                "\"OperatorSecret\":\""+HlhtConfig.OperatorSecret+"\"}";
        String timeStemp = sdf.format(new Date());
        String enString = AESUtil.Encrypt(data, HlhtConfig.SECURITY_KEY,HlhtConfig.AES_SECURITY);
        System.out.println(timeStemp);
        System.out.println(enString);
        String sig = HMacMD5.getHmacMd5Str(HlhtConfig.SECURITY_KEY,HlhtConfig.OperatorID+enString+timeStemp+timeStemp);
        String body = "{\"OperatorID\":\""+HlhtConfig.OperatorID+"\"," +
                "\"Data\":\""+enString+"\"," +
                "\"Sig\":\""+sig+"\"," +
                "\"TimeStamp\":\""+timeStemp+"\"," +
                "\"Seq\":\""+timeStemp+"\"}";
        System.out.println(body);
        String response = HttpClientUtil.doPostJson(url,body);
        System.out.println(response);
        ObjectMapper objectMapper = new ObjectMapper();
        Map map = objectMapper.readValue(response, HashMap.class);
        System.out.println(map.get("Data"));
        String DeString = AESUtil.Decrypt((String)map.get("Data"),HlhtConfig.SECURITY_KEY);
        System.out.println(DeString);
        Map map2 = objectMapper.readValue(DeString, HashMap.class);
        String token = (String)map2.get("AccessToken");
        System.out.println(token);


        String auth = "Bearer "+token;
        timeStemp = sdf.format(new Date());
        data = "{\"LastQueryTime\":\"\",\"PageNo\":\"20\",\"PageSize\":\"1\"}";
        enString = AESUtil.Encrypt(data, HlhtConfig.SECURITY_KEY,HlhtConfig.AES_SECURITY);
        sig = HMacMD5.getHmacMd5Str(HlhtConfig.SECURITY_KEY,HlhtConfig.OperatorID+enString+timeStemp+timeStemp);
        body = "{\"OperatorID\":\""+HlhtConfig.OperatorID+"\"," +
                "\"Data\":\""+enString+"\"," +
                "\"Sig\":\""+sig+"\"," +
                "\"TimeStamp\":\""+timeStemp+"\"," +
                "\"Seq\":\""+timeStemp+"\"}";
        System.out.println(body);
        response = HttpClientUtil.doPostJson("http://api.wyqcd.cn:9101/evcs/v20161110/query_stations_info",body,auth);
        System.out.println(response);
        map = objectMapper.readValue(response, HashMap.class);
        DeString = AESUtil.Decrypt((String)map.get("Data"),HlhtConfig.SECURITY_KEY);
        System.out.println(DeString);

//        ObjectMapper mapper = new ObjectMapper().setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        objectMapper.configure(DeserializationConfig.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        HlhtResponse hlhtResponse = objectMapper.readValue(DeString, HlhtResponse.class);
        System.out.println("AAAA");
    }
}

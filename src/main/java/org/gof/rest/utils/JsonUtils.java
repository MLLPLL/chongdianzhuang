package org.gof.rest.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Alex.Chen on 2016/12/16.
 */
public class JsonUtils {

    private static ObjectMapper init(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        return objectMapper;
    }

    public static ObjectMapper getObjectMapper(){
        return init();
    }
}

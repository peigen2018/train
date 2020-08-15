package com.dbapp.analyse.stream.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;

@Slf4j
public class JacksonJsonUtils {
    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        //jackson 忽略不认识的属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static String toJson(Object o) {
        try {
            return jackson().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            log.error("toJson error" + o, e);
            throw new ServiceException("服务器异常");
        }
    }


    public static Set<String> toSet(String json) {
        try {
            return jackson().readValue(json, new TypeReference<Set<String>>() {
            });
        } catch (JsonProcessingException e) {
            log.error("toSet error" + json, e);
            throw new ServiceException("服务器异常");
        }
    }

    public static Map<String, String> toMap(String json) {
        try {
            return jackson().readValue(json, new TypeReference<Map<String, String>>() {
            });
        } catch (JsonProcessingException e) {
            log.error("toMap error" + json, e);
            throw new ServiceException("服务器异常", e);
        }
    }


    public static ObjectMapper jackson() {
        return mapper;
    }

    public static <T> T fromJson(String jsonStr, Class<T> clazz) {
        try {
            return jackson().readValue(jsonStr, clazz);
        } catch (JsonProcessingException e) {
            log.error("from Json error + json: " + jsonStr, e);
            throw new ServiceException("服务器异常", e);
        }
    }
}

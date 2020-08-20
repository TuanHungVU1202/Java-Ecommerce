package com.hv.ecommerce.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;

public class Utils {

    public static Timestamp getCurrentTimestamp() {
        ZonedDateTime nowAsiaSingapore = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("Asia/Saigon"));
        Timestamp createdDate = Timestamp.valueOf(nowAsiaSingapore.toLocalDateTime());
        return createdDate;
    }

    public static String checkNullVal(String val) {
        if (val == null || val.equals("null")) {
            return null;
        }
        return val;
    }

    public static String customMessageObj(String key, Object value) throws JsonProcessingException {
        HashMap<String, Object> map = new HashMap<>();
        map.put(key, value);
        return mapToJsonString(map);
    }

    public static <K, V> String mapToJsonString(HashMap<K, V> map) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String ret = mapper.writeValueAsString(map);
        return ret;
    }
}

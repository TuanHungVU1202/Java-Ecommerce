package com.hv.ecommerce.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
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

    public static byte[] objectToByte(Object object) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(object);
            out.flush();
            byte[] yourBytes = bos.toByteArray();
            return yourBytes;
        } finally {
            try {
                bos.close();
            } catch (IOException ex) {
                // ignore
            }
        }
    }

    public static Object byteToObject(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        ObjectInput in = null;
        try {
            in = new ObjectInputStream(bis);
            Object obj = in.readObject();
            return obj;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                // ignore close exception
            }
        }
    }
}

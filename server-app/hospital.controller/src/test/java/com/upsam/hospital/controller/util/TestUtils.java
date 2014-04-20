package com.upsam.hospital.controller.util;

import java.io.IOException;
import java.nio.charset.Charset;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.MediaType;

public class TestUtils {

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), 
    																		MediaType.APPLICATION_JSON.getSubtype(), 
    																		Charset.forName("utf8"));

    public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsBytes(object);
    }

    public static String createStringWithLength(int length) {
        StringBuilder builder = new StringBuilder();

        for (int index = 0; index < length; index++) {
            builder.append("a");
        }

        return builder.toString();
    }
}

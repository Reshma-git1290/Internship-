package com.epam.framework.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static Map<String, Object> readJsonAsMap(String filePath) throws IOException {
        return mapper.readValue(new File(filePath), Map.class);
    }

    public static <T> T readJsonAsObject(String filePath, Class<T> clazz) throws IOException {
        return mapper.readValue(new File(filePath), clazz);
    }
}

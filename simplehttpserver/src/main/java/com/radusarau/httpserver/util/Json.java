package com.radusarau.httpserver.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;

public class Json {

    private static ObjectMapper myObjectMapper = defaultObjectMapper();

    private static ObjectMapper defaultObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        // makes the passing not crash if a property is missing
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return objectMapper;
    }

    public static JsonNode parse(String jsonSrc) throws IOException {
        return myObjectMapper.readTree(jsonSrc);
    }

    public static <A> A fromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException {
        return myObjectMapper.treeToValue(node, clazz);
    }

    public static JsonNode toJson(Object obj) {
        return myObjectMapper.valueToTree(obj);
    }

    public static String stringify(JsonNode node) throws JsonProcessingException {
        return generateJson(node, false);
    }

    public static String stringifyPretty(JsonNode node) throws JsonProcessingException {
        return generateJson(node, true);
    }

    private static String generateJson(Object obj, boolean pretty) throws JsonProcessingException {
        ObjectWriter objectWriter = myObjectMapper.writer();
        if (pretty) {
            objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
        }
        return objectWriter.writeValueAsString(obj);
    }
}
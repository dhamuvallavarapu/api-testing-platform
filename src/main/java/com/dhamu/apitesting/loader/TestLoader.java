package com.dhamu.apitesting.loader;

import com.dhamu.apitesting.model.TestCase;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestLoader {

    public List<TestCase> loadTests(String filePath) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(
                    new File(filePath),
                    new TypeReference<List<TestCase>>() {}
            );
        } catch (IOException e) {
            throw new RuntimeException("Failed to load test cases: " + filePath, e);
        }
    }
}
package com.dhamu.apitesting.model;

import java.util.Map;
import lombok.*;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
public class TestCase {

    private String name;
    private String method;
    private String url;
    private Map<String, String> headers;   
    private String body;
    private int expectedStatus;
    private Map<String, Object> expectedJsonPath;
    
}
   
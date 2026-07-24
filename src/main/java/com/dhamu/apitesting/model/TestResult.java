package com.dhamu.apitesting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestResult {

    private String testName;
    private boolean passed;
    private int expectedStatus;
    private int actualStatus;
    private long executionTime;
    private String errorMessage;
}
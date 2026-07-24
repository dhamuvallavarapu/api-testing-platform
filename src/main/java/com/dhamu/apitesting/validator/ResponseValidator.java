package com.dhamu.apitesting.validator;

import com.dhamu.apitesting.model.TestCase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Map;

public class ResponseValidator {

    public boolean validate(TestCase testCase, Response response) {

        boolean isPassed = true;

        // Validate Status Code
        if (response.getStatusCode() != testCase.getExpectedStatus()) {

            System.out.println("❌ Status Code Validation Failed");
            System.out.println("Expected : " + testCase.getExpectedStatus());
            System.out.println("Actual   : " + response.getStatusCode());

            isPassed = false;
        }

        // Validate JSON Fields
        JsonPath jsonPath = response.jsonPath();

        for (Map.Entry<String, Object> entry : testCase.getExpectedJsonPath().entrySet()) {

            String jsonKey = entry.getKey();
            Object expectedValue = entry.getValue();

            Object actualValue = jsonPath.get(jsonKey);

            if (!expectedValue.equals(actualValue)) {

                System.out.println("❌ Validation Failed -> " + jsonKey);
                System.out.println("Expected : " + expectedValue);
                System.out.println("Actual   : " + actualValue);

                isPassed = false;
            }
        }

        return isPassed;
    }
}
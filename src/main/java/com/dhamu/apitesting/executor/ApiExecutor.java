package com.dhamu.apitesting.executor;

import com.dhamu.apitesting.model.TestCase;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiExecutor {

    public Response execute(TestCase testCase) {

    if (testCase.getMethod().equalsIgnoreCase("GET")) {

        return RestAssured
                .given()
                .headers(testCase.getHeaders())
                .request(testCase.getMethod(), testCase.getUrl());
    }

    return RestAssured
            .given()
            .headers(testCase.getHeaders())
            .body(testCase.getBody())
            .request(testCase.getMethod(), testCase.getUrl());
}

}


   
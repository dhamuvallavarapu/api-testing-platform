package com.dhamu.apitesting.runner;

import com.dhamu.apitesting.executor.ApiExecutor;
import com.dhamu.apitesting.loader.TestLoader;
import com.dhamu.apitesting.model.TestCase;
import io.restassured.response.Response;
import com.dhamu.apitesting.validator.ResponseValidator;
import com.dhamu.apitesting.model.TestResult;
import java.util.List;

public class TestRunner {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("   API Testing Platform Started");
        System.out.println("====================================");

        TestLoader loader = new TestLoader();

        List<TestCase> tests = loader.loadAllTests("src/main/resources/tests");

        System.out.println("\nLoaded Tests : " + tests.size());

        ApiExecutor executor = new ApiExecutor();
        ResponseValidator validator = new ResponseValidator();

        for (TestCase test : tests) {

            System.out.println("\n====================================");
            System.out.println("Executing : " + test.getName());
            System.out.println("====================================");

            long startTime = System.currentTimeMillis();

            Response response = executor.execute(test);

            long endTime = System.currentTimeMillis();

            long executionTime = endTime - startTime;

            System.out.println("Status Code : " + response.getStatusCode());

            System.out.println("\nResponse Body:");
            System.out.println(response.getBody().asPrettyString());

            boolean passed = validator.validate(test, response);
            TestResult result = new TestResult(
                    test.getName(),
                    passed,
                    test.getExpectedStatus(),
                    response.getStatusCode(),
                    executionTime,
                    passed ? null : "Validation Failed");

            System.out.println("\n========== Test Result ==========");
            System.out.println("Test Name      : " + result.getTestName());
            System.out.println("Status         : " + (result.isPassed() ? "PASS" : "FAIL"));
            System.out.println("Expected Status: " + result.getExpectedStatus());
            System.out.println("Actual Status  : " + result.getActualStatus());
            System.out.println("Execution Time : " + result.getExecutionTime() + " ms");

            if (!result.isPassed()) {
                System.out.println("Error          : " + result.getErrorMessage());
            }

            System.out.println("=================================");
        }

    }
}
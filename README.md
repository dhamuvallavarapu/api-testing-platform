# API Testing Platform 🚀

A Java-based API Testing Framework built from scratch using **Rest Assured** and **Jackson**, designed to execute API tests from JSON files instead of hardcoded Java test classes.

The goal of this project is to gradually evolve it into a production-style API testing platform with reporting, CI/CD, Docker, AI-assisted debugging, and database validation.

---

## ✨ Current Features

* JSON-driven API test execution
* Automatic discovery of multiple test suites
* REST Assured API execution
* Response status validation
* Execution time measurement
* Test execution summary
* Modular architecture following Single Responsibility Principle (SRP)

---

## 🏗️ Architecture

```text
JSON Test Files
        │
        ▼
   TestLoader
        │
        ▼
 List<TestCase>
        │
        ▼
  ApiExecutor
        │
        ▼
 HTTP Response
        │
        ▼
ResponseValidator
        │
        ▼
  TestResult
        │
        ▼
Execution Summary
```

---

## 📂 Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.dhamu.apitesting
│   │       ├── executor
│   │       ├── loader
│   │       ├── model
│   │       ├── runner
│   │       └── validator
│   │
│   └── resources
│       └── tests
│           ├── users.json
│           └── posts.json
```

---

## 🛠️ Tech Stack

* Java 21
* Maven
* Rest Assured
* Jackson
* IntelliJ IDEA

---

## ▶️ Run the Project

Clone the repository:

```bash
git clone https://github.com/dhamuvallavarapu/api-testing-platform.git
```

Navigate to the project:

```bash
cd api-testing-platform
```

Compile:

```bash
mvn clean compile
```

Run the application:

```bash
mvn exec:java -Dexec.mainClass="com.dhamu.apitesting.runner.TestRunner"
```

---

## 📌 Current Workflow

```text
Load JSON Test Files
        │
        ▼
Create TestCase Objects
        │
        ▼
Execute API Requests
        │
        ▼
Validate Responses
        │
        ▼
Store Test Results
        │
        ▼
Display Execution Summary
```

---

## 🚧 Upcoming Features

* HTML Report Generation
* Allure Reports
* Docker Support
* GitHub Actions CI/CD
* Slack Notifications
* SQL Database Validation
* Test Data Generator
* Parallel Execution
* Environment Configuration
* Logging
* AI Bug Analyzer

---

## 🎯 Learning Objectives

This project is focused on understanding how a professional API automation framework is designed rather than only writing API test scripts.

Topics explored include:

* Framework Design
* Clean Code
* Object-Oriented Design
* JSON Serialization & Deserialization
* API Automation
* Reporting
* CI/CD Integration
* AI-assisted Test Analysis

---

## 🤝 Contributing

Suggestions and improvements are always welcome. Feel free to fork the repository or raise an issue.

---

## 📄 License

This project is created for learning and portfolio purposes.

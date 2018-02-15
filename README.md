# TDD Workshop using Java [![Build Status](https://travis-ci.org/rafaelspinto/workshop-tdd-java.svg?branch=master)](https://travis-ci.org/rafaelspinto/workshop-tdd-java) [![Quality Gate](https://sonarcloud.io/api/badges/gate?key=workshop:tdd-java)](https://sonarcloud.io/dashboard?id=workshop%3Atdd-java)
This workshop is designed to help you start or improve your [Test Driven Development](https://en.wikipedia.org/wiki/Test-driven_development) skills.


## What is TDD

[Test Driven Development](https://en.wikipedia.org/wiki/Test-driven_development) or Test First Development is a process that consists of turning the requirements of the software application into specific test cases (acceptance criteria) and then implement the source code.

This process uses the **red/green/refactor** pattern and consists of the following steps:

1. Create Test
2. Run Tests (should fail - Red)
3. Write Code
4. Run Tests (should pass - Green)  
5. Refactor

Repeat  

## Table of contents

* [Quick start](#quick-start)
* [Tools/Frameworks](#tools/frameworks)
* [Naming conventions](#naming-conventions)
* [AAA Pattern](#aaa-pattern)

## Quick start

Prerequisites

* You have an IDE or a text editor
* You have [Maven](https://maven.apache.org/) installed


## Tools/Frameworks

We will be using a few tools/frameworks to facilitate our job.

* [JUnit](https://junit.org/junit4/) - Unit Testing Framework
* [mockito](http://site.mockito.org/) - Mocking Framework for Unit Tests
* [junit-dataprovider](https://github.com/TNG/junit-dataprovider) - Data Provider Runner for JUnit


## Naming conventions

Tests serve 3 purposes:

* [Acceptance Criteria](https://en.wikipedia.org/wiki/Acceptance_testing) - Ensures developed code meets specification
* [Regression Testing](https://en.wikipedia.org/wiki/Regression_testing) - Ensures new changes don't impact previous developed code
* **Documentation** - Demonstrates how the application behaves

To achieve proper documentation, a good starting point is to create naming conventions for the tests.

You can define your own conventions keeping in mind that the test methods should clearly identify:

* What is being tested
* What is the Scenario (Input)
* What should be the outcome (Output)

Example:

```java
@Test
public void testSum_BothNumbersArePositive_ShouldReturnPositiveNumber() {
...
}
```

The method name should be read as :

Test sum **IF** both numbers are positive **THEN** should return positive number.


### AAA Pattern

Tests typically follow the AAA pattern:

* **A**rrange - Setup of the Scenario, e.g.: creating the input data
* **A**ct - Executing the action/method
* **A**ssert - Validation of the outcome

Example:


```java
@Test
public void testSum_BothNumbersArePositive_ShouldReturnPositiveNumber() {
    // Arrange
    int a = 10;
    int b = 20;
    Calculator calc = new Calculator();

    // Act
    int result = calc.sum(a, b);

    // Assert
    Assert.assertTrue(result > 0);
}
```
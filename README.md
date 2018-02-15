# TDD Workshop using Java [![Build Status](https://travis-ci.org/rafaelspinto/workshop-tdd-java.svg?branch=master)](https://travis-ci.org/rafaelspinto/workshop-tdd-java) [![Quality Gate](https://sonarcloud.io/api/badges/gate?key=workshop:tdd-java)](https://sonarcloud.io/dashboard?id=workshop%3Atdd-java)
This workshop is designed to help you start or improve your [Test Driven Development](https://en.wikipedia.org/wiki/Test-driven_development) skills.

The examples you will see in this workshop are designed to demonstrate the advantages and technicalities of TDD. The intention is to represent real-world scenarios, however sometimes that will not be possible in favour of simplicity.


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
* [Testing Tools/Frameworks](#testing-toolsframeworks)
* [Naming conventions](#naming-conventions)
* [AAA Pattern](#aaa-pattern)
* [Mocks & Stubs](#mocks--stubs)
* [Instant Feedback Tools](#instant-feedback-tools)
* [Examples](#examples)

## Quick start

Prerequisites

* You have an IDE or a text editor
* You have [Maven](https://maven.apache.org/) installed


## Testing Tools/Frameworks

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

## Mocks & Stubs

[Mocks](https://en.wikipedia.org/wiki/Mock_object) and [Stubs](https://en.wikipedia.org/wiki/Method_stub) are used to facilitate testing by solving the problem of dependencies.

When the code you are implementing has a dependency, using this technique, you create a fake object that emulates that dependency. If you are required to define specific return values to emulate a certain scenario then you'll need to use a **stub** otherwise you'll simply use a **mock**.


Example:


* **Mock**

```java
provider = mock(PaymentProviderInterface.class);
broker = new PaymentBroker(provider);
```

* **Stub**
```java
provider = mock(PaymentProviderInterface.class);
broker = new PaymentBroker(provider);
when(provider.isAvailable()).thenReturn(false);
```

## Instant Feedback Tools

Feedback is one of the most important things in the development world, the sooner you get it the better.

Typically most of the feedback comes from the user/client of your software, but you should be getting it before you ship it.

There are plenty of tools out there that can help you with this. In this workshop we will be using the following:

* **Automation Server** - Allows you to automate the test execution ([Continuous Integration](https://www.thoughtworks.com/continuous-integration)) and other routines associated with it ([Continuous Delivery](https://martinfowler.com/bliki/ContinuousDelivery.html)/[Continuous Deployment](https://www.agilealliance.org/glossary/continuous-deployment/)). In this particular case we are using [Travis CI](https://travis-ci.org/).

    You can check the current status of the workshop project by clicking the following badge:

   [![Build Status](https://travis-ci.org/rafaelspinto/workshop-tdd-java.svg?branch=master)](https://travis-ci.org/rafaelspinto/workshop-tdd-java)

* **Static Code Analyzer** - Allows you to continuously inspect the quality of the code by detecting issues and providing suggestions to solve them. In this project we are using [SonarCloud](http://sonarcloud.io).

    You can check the current status of the workshop project by clicking the following badge:

    [![Quality Gate](https://sonarcloud.io/api/badges/gate?key=workshop:tdd-java)](https://sonarcloud.io/dashboard?id=workshop%3Atdd-java)

## Examples

* [Calculator](/src/test/java/workshop/calculator) - Simple example to get you started
* [LoginManager](/src/test/java/workshop/login) - Working with exceptions
* [PaymentBroker](/src/test/java/workshop/payment) - Working with dependencies, mocks and stubs
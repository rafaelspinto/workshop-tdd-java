package workshop.calculator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CalculatorBddSteps {

  private Calculator calculator;
  private int result;

  @Given("^I use a calculator$")
  public void iUseACalculator() throws Throwable {
    calculator = new Calculator();
  }

  @When("^I add positive numbers$")
  public void iAddPositiveNumbers() throws Throwable {
    result = calculator.sum(10, 20);
  }

  @Then("^The result should be positive$")
  public void theResultShouldBePositive() throws Throwable {
    Assert.assertTrue(result > 0);
  }

  @When("^I add negative numbers$")
  public void iAddNegativeNumbers() throws Throwable {
    result = calculator.sum(-10, -20);
  }

  @Then("^The result should be negative$")
  public void theResultShouldBeNegative() throws Throwable {
    Assert.assertTrue(result < 0);
  }

  @When("^I add opposite numbers$")
  public void iAddOppositeNumbers() throws Throwable {
    result = calculator.sum(10, -10);
  }

  @Then("^The result should be zero$")
  public void theResultShouldBeZero() throws Throwable {
    Assert.assertTrue(result == 0);
  }
}

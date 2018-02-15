package workshop.calculator;

import junit.framework.Assert;
import org.junit.Test;

public class CalculatorTest {

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

  @Test
  public void testSum_BothNumbersAreNegative_ShouldReturnNegativeNumber() {
    // Arrange
    int a = -10;
    int b = -20;
    Calculator calc = new Calculator();

    // Act
    int result = calc.sum(a, b);

    // Assert
    Assert.assertTrue(result < 0);
  }

  @Test
  public void testSum_NumbersAreOpposite_ShouldReturnZero() {
    // Arrange
    int a = 10;
    int b = -10;
    Calculator calc = new Calculator();

    // Act
    int result = calc.sum(a, b);

    // Assert
    Assert.assertTrue(result == 0);
  }
}

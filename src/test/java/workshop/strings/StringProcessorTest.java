package workshop.strings;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class StringProcessorTest {

  private StringProcessor stringProcessor;

  @DataProvider
  public static Object[][] dataProviderStringsWithVowels() {
    return new Object[][] {
        { "ahahah", 3},
        { "aeiou", 5},
        { "blahblah", 2},
        { "aAAAAA", 6},
        { "aEiOu", 5}
    };
  }

  @DataProvider
  public static Object[][] dataProviderStringsWithoutVowels() {
    return new Object[][] {
        { "bcdfgh"},
        { "mmmm"},
        { "zzzzzzzzzz"}
    };
  }

  @Before
  public void setUp() {
    this.stringProcessor = new StringProcessor();
  }

  @Test
  @UseDataProvider("dataProviderStringsWithVowels")
  public void testCountVowels_VowelsExist_ShouldReturnNumberOfVowels(String word, int expected) throws EmptyStringException {
    Assert.assertEquals(expected, stringProcessor.countVowels(word));
  }

  @Test
  @UseDataProvider("dataProviderStringsWithoutVowels")
  public void testCountVowels_VowelsDontExist_ShouldReturnZero(String word) throws EmptyStringException {
    Assert.assertEquals(0, stringProcessor.countVowels(word));
  }

  @Test(expected = EmptyStringException.class)
  public void testCountVowels_StringIsEmpty_ShouldThrowEmptyStringException() throws EmptyStringException {
    stringProcessor.countVowels("");
  }
}

package workshop.strings;

public class StringProcessor {
  public int countVowels(String word) throws EmptyStringException {
    if (word.isEmpty()) {
      throw new EmptyStringException();
    }

    char[] chars = word.toCharArray();
    int counter = 0;
    String vowels = "aeiouAEIOU";

    for (int i = 0; i < chars.length; i++) {
      if (vowels.contains(chars[i] + "")) {
        counter++;
      }
    }

    return counter;
  }
}

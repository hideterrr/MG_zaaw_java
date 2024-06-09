// Zadania: 3, 4, 5, 6, 7, 10, 11, 12, 16

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) {
    // Dane do testowania
    String[] testStrings = {
        "a", "ab", "abb", "abbb", "a123b", "abc", "aBb", "abbbb", "WordpRESS", "end.", "1start"
    };

    // Wywołanie funkcji dla każdego zadania
    System.out.println("Zadanie 3:");
    for (String s : testStrings) {
      System.out.println(s + ": " + onlyCertainCharacters(s));
    }

    System.out.println("\nZadanie 4:");
    for (String s : testStrings) {
      System.out.println(s + ": " + startsWithAAndZeroOrMoreB(s));
    }

    System.out.println("\nZadanie 5:");
    for (String s : testStrings) {
      System.out.println(s + ": " + startsWithAAndAtLeastOneB(s));
    }

    System.out.println("\nZadanie 6:");
    for (String s : testStrings) {
      System.out.println(s + ": " + startsWithAAndThreeB(s));
    }

    System.out.println("\nZadanie 7:");
    for (String s : testStrings) {
      System.out.println(s + ": " + startsWithAAndTwoToThreeB(s));
    }

    System.out.println("\nZadanie 10:");
    for (String s : testStrings) {
      System.out.println(s + ": " + startsWithAAndEndsWithB(s));
    }

    System.out.println("\nZadanie 11:");
    for (String s : testStrings) {
      System.out.println(s + ": " + matchesWordAtStart(s));
    }

    System.out.println("\nZadanie 12:");
    for (String s : testStrings) {
      System.out.println(s + ": " + matchesWordAtEnd(s));
    }

    System.out.println("\nZadanie 16:");
    for (String s : testStrings) {
      System.out.println(s + ": " + startsWithSpecificDigit(s));
    }
  }

  // Funkcje
  public static boolean onlyCertainCharacters(String text) {
    return text.matches("[a-zA-Z0-9]+");
  }

  public static boolean startsWithAAndZeroOrMoreB(String text) {
    return text.matches("ab*");
  }

  public static boolean startsWithAAndAtLeastOneB(String text) {
    return text.matches("ab+");
  }

  public static boolean startsWithAAndThreeB(String text) {
    return text.matches("ab{3}");
  }

  public static boolean startsWithAAndTwoToThreeB(String text) {
    return text.matches("ab{2,3}");
  }

  public static boolean startsWithAAndEndsWithB(String text) {
    return text.matches("a.*b");
  }

  public static boolean matchesWordAtStart(String text) {
    return text.matches("\\b\\w+.*");
  }

  public static boolean matchesWordAtEnd(String text) {
    return text.matches(".*\\w+\\b");
  }

  public static boolean startsWithSpecificDigit(String text) {
    return text.matches("[1-9].*");
  }
}
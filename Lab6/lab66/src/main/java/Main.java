// 6. Korzystaj ˛ac z metody codePoints z klasy String, zaimplementuj metod˛e testuj ˛ac ˛a, czy ci ˛ag
// znaków jest słowem zło˙zonym jedynie z liter. (Podpowied´z: Character.isAlphabetic). Ko-
// rzystaj ˛ac z tego samego podej´scia, zaimplementuj metod˛e sprawdzaj ˛ac ˛a, czy ci ˛ag znaków jest po-
// prawnym identyfikatorem j˛ezyka Java.

import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    String str = "TekstJava"; // tekst

    boolean isWordOfLetters = isWordOfLetters(str);
    System.out.println("Ciąg znaków jest słowem złożonym jedynie z liter - " + isWordOfLetters);

    boolean isJavaIdentifier = isJavaIdentifier(str);
    System.out.println("Ciąg znaków jest poprawnym identyfikatorem języka Java - " + isJavaIdentifier);
  }

  public static boolean isWordOfLetters(String str) {
    return str.codePoints().allMatch(Character::isAlphabetic);
  }

  public static boolean isJavaIdentifier(String str) {
    if (str == null || str.isEmpty()) {
      return false;
    }
    if (!Character.isJavaIdentifierStart(str.codePointAt(0))) {
      return false;
    }

    return IntStream.range(1, str.length()).allMatch(i -> Character.isJavaIdentifierPart(str.codePointAt(i)));
  }
}

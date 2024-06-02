// 7a. Przekształcaj ˛ac plik w strumie´n tokenów, wypisz 100 pierwszych tokenów, które s ˛a słowami według
// kryteriów z poprzedniego ´cwiczenia.

import java.util.stream.IntStream;
import java.nio.file.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {

    String filePath = "src/main/java/plik.txt";

    try (Stream<String> lines = Files.lines(Paths.get(filePath))) {

      Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split("\\W+")));
      words.filter(Main::isWordOfLetters)
          .limit(100)
          .forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static boolean isWordOfLetters(String str) {

    return str.codePoints().allMatch(Character::isAlphabetic);
  }
}

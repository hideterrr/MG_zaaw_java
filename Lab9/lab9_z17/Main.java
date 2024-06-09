import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

  private static final String BOOK_PATH = "src/main/java/Wojna_i_Pokoj.txt";

  public static void main(String[] args) {
    try (Stream<String> lines = Files.lines(Paths.get(BOOK_PATH))) {
      AtomicInteger count = new AtomicInteger();
      List<String> longestWords = lines.parallel()
          .flatMap(line -> Stream.of(line.split("\\s+"))) // Linie na słowa
          .distinct() // bez powtarzania
          .sorted((word1, word2) -> Integer.compare(word2.length(), word1.length()))
          .limit(500)
          .collect(Collectors.toList());

      System.out.println("Najdłuższe słowa top500:");
      longestWords.forEach(System.out::println);
    } catch (IOException e) {
      System.err.println("Błąd podczas odczytu pliku: " + e.getMessage());
    }
  }
}

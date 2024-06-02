// 2. Zmierz róznicę pomiędzy zliczaniem długich słów za pomocą parallelStream i stream. Wywołaj System.currentTimeMillis przed wywołaniem i po nim, a następnie wyswietl róznice
// Wykorzystaj dłuzszy tekst (na przykład War and Peace), jeżeli masz szybki komputer.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws IOException {
    String filename = "war_and_peace.txt"; // Replace with the actual filename

    // Read the file content
    String content = "";
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        content += line + "\n";
      }
    }

    // Measure the time for parallelStream
    long startTimeParallel = System.currentTimeMillis();
    long countParallel = Stream.of(content.split("\\s+"))
        .parallel()
        .filter(word -> word.length() > 5)
        .count();
    long endTimeParallel = System.currentTimeMillis();

    // Measure the time for stream
    long startTimeStream = System.currentTimeMillis();
    long countStream = Stream.of(content.split("\\s+"))
        .filter(word -> word.length() > 5)
        .count();
    long endTimeStream = System.currentTimeMillis();

    // Calculate and display the differences
    System.out.println("ParallelStream: " + (endTimeParallel - startTimeParallel));
    System.out.println("Stream: " + (endTimeStream - startTimeStream));
    System.out.println("Count (parallel): " + countParallel);
    System.out.println("Count (stream): " + countStream);
  }
}
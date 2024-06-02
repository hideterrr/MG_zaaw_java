// 3. Załózmy, że mamy tablicę int[] wartości = { 1, 4, 9, 16 }. Czym będzie
// Stream.of(wartości)? Jak otrzymac strumień wartości typu  'int'?

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    int[] values = { 1, 4, 9, 16 };
    Stream<Integer> intStream = Arrays.stream(values).mapToObj(Integer::valueOf);

    intStream.forEach(System.out::println);
  }
}

// Stream.of(wartości).mapToInt(Integer::intValue):
// tworzymy strumień Stream<Integer> za pomocą Stream.of(wartości), a następnie
// mapujemy każdy element Integer na jego wartość int za pomocą
// mapToInt(Integer::intValue).

// lub int:
// int[] wartości = {1, 4, 9, 16};
// IntStream strumień = Arrays.stream(wartości);
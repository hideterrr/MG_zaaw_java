// 1. Sprawd´z, czy zapytanie o pi˛ec długich słów spowoduje wywołanie metody ´ filter po //znalezieniu  piątego długiego słowa. Po prostu rejestruj kazde wywołanie metody. 

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    String[] slowa = { "dlugie_slowo1", "kot", "pies", "dlugie_slowo2", "pieczarka3" };
    long count = Stream.of(slowa)
        .peek(e -> System.out.println("Sprawdzanie słowa: " + e))
        .filter(w -> w.length() > 5)
        .limit(5)
        .collect(Collectors.counting());
    System.out.println("Liczba długich słów: " + count);
  }
}
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

class Pracownik {
  String nazwisko;
  double wynagrodzenie;

  // Konstruktor, gettery i settery
}

public class Main {
  public static void main(String[] args) {
    Pracownik[] pracownicy = // tablica pracowników

        // 15
        Arrays.sort(pracownicy, Comparator.comparing(Pracownik::getWynagrodzenie)
            .thenComparing(Pracownik::getNazwisko));

    // Odwrotna kolejność
    Arrays.sort(pracownicy, Comparator.comparing(Pracownik::getWynagrodzenie)
        .thenComparing(Pracownik::getNazwisko).reversed());

    // 26
    RandomSequence.randomInts(10, 1, 100).forEach(System.out::println);
  }
}

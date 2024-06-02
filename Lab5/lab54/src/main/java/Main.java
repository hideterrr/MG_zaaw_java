// 4. Korzystając ze Stream.iterate, utwórz nieskonczony strumień losowych liczb – nie poprzez 
// wywołanie Math.random, ale bezposrednio implementując liniowy generator kongruentny (LCG, 
// ang. Linear Congruential Generator). W takim generatorze zaczynamy od x0 = ziarno, a następnie generujemy xn+1 = (a * xn + c) % m dla odpowiednich wartosci a, c i m. Nalezy˙
// zaimplementowac metod˛e z parametrami: a, c, m oraz ziarno, która zwraca Stream<Long>.
// Wypróbuj a = 25214903917, c = 11 oraz m = 248.

import java.util.stream.Stream;

public class Main {

  private long a;
  private long c;
  private long m;
  private long seed;

  public Main(long a, long c, long m, long seed) {
    this.a = a;
    this.c = c;
    this.m = m;
    this.seed = seed % m; // Ensure seed is within [0, m)
  }

  public Stream<Long> generateStream() {
    return Stream.iterate(seed, n -> (a * n + c) % m);
  }

  public static void main(String[] args) {
    // Example with a=25214903917, c=11, m=248
    Main stream = new Main(25214903917L, 11, 248, 0);

    // Print the first 10 random numbers
    stream.generateStream().limit(10).forEach(System.out::println);
  }
}
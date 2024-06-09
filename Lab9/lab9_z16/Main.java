import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    BigInteger start = new BigInteger("10").pow(49).add(BigInteger.ONE);

    long startTimeParallel = System.currentTimeMillis();
    List<BigInteger> primesParallel = Stream.iterate(start, BigInteger::nextProbablePrime)
        .parallel()
        .limit(500)
        .collect(Collectors.toList());
    primesParallel.forEach(System.out::println); // Wyświetlenie liczb

    long endTimeParallel = System.currentTimeMillis();

    long startTimeSerial = System.currentTimeMillis();
    List<BigInteger> primesSerial = Stream.iterate(start, BigInteger::nextProbablePrime)
        .limit(500)
        .collect(Collectors.toList());
    long endTimeSerial = System.currentTimeMillis();

    System.out.println("Czas równoległy: " + (endTimeParallel - startTimeParallel) + " ms");
    System.out.println("Czas szeregowy: " + (endTimeSerial - startTimeSerial) + " ms");
  }
}
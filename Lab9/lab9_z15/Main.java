import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Double> numbers = Stream.of(1.0, 2.0, 3.0, 4.0, 5.0); // 15/5 = 3

        double[] result = numbers
                .reduce(new double[2], (a, b) -> {
                    a[0] += b;
                    a[1] += 1;
                    return a;
                }, (a, b) -> {
                    a[0] += b[0];
                    a[1] += b[1];
                    return a;
                });

        double average = result[0] / (double) result[1];

        System.out.println("Średnia: " + average);
        System.out.println("Dlaczego nie można po prostu obliczyć sumy i podzielić przez count()?");
        System.out.println();
        System.out.println("Średnia wymagałaby dwóch przejść przez strumień: jednego do sumowania i drugiego do zliczania elementów.");
    }
}

// Odp: średnia wymagałaby dwóch przejść przez strumień: jednego do sumowania i drugiego do zliczania elementów.
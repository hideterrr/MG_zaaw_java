package zad6;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Sequence<BigInteger> squareSequence = new SquareSequence();

        // Print the first 10 square numbers
        for (int i = 0; i < 10; i++) {
            System.out.print(squareSequence.nextValue() + ", ");
        }
    }
}

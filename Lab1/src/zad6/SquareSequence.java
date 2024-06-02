package zad6;

/* Klasa SquareSequence nie dostarcza w rzeczywistości nieskończonej sekwencji kwadratów z
powodu przepełnienia całkowitego. Jak konkretnie się zachowuje? Napraw problem poprzez zde-
finiowanie interfejsu Sequence<T> oraz klasy SquareSequence, która implementuje klasę
Sequence<BigInteger>. */

import java.math.BigInteger;

public class SquareSequence implements Sequence<BigInteger>{
    private BigInteger current = BigInteger.ONE;

    @Override
    public BigInteger nextValue(){
        // Calculate the next square number
        BigInteger next = current.multiply(current);

        // Update the current value to the next square number
        current = current.add(BigInteger.ONE);

        // Return the next square number
        return next;
    }
}

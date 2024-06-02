package zad4b;

import java.util.NoSuchElementException;

/* (b) Zaimplementuj statyczną metodę
public static of(int...)
w interfejsie IntSequence, która zwraca instancję wewnętrznej klasy anonimowej Kolejne wy-
wołania metody next zwracają kolejne liczby przechowywane w tej instancji. */

public interface IntSequence {
    int next();
    boolean hasNext();


    // Statyczna metoda 'of w interfejsie IntSequence'
    public static IntSequence of(int ... values) {
        return new IntSequence() {
            private int idx = 0;
            private final int[] arr = values;

            @Override
            public boolean hasNext() {
                return idx < arr.length;
            }

            @Override
            public int next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return arr[idx++];            
            }
        };
    }
}
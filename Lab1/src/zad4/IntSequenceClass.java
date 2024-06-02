package zad4;

/* Napisz programy w odpowiednich plikach: (a) W klasie IntSequenceiClass, która implementuje interfejs IntSequence 
zaimplementuj statyczną metodę
public static of(int...),
która zwraca ciąg argumentów. Przykładowo, wywołanie IntSequenceClass.of(3, 1,
4, 1, 5, 9) zwraca instancję klasy IntSequenceClass przechowującą ciąg sześciu war-
tości. Kolejne wywołania metody next zwracają kolejne liczby przechowywane w tej instancji.
(b) Zaimplementuj statyczną metodę
public static of(int...)
w interfejsie IntSequence, która zwraca instancję wewn˛etrznej klasy anonimowej Kolejne wy-
wołania metody next zwracają kolejne liczby przechowywane w tej instancji. */


class IntSequenceClass implements IntSequence {
    private final int[] sequence;
    private int currentIndex;

    private IntSequenceClass(int ... values) {
        this.sequence = values;
        this.currentIndex = 0;
    }
    
    public static IntSequenceClass  of(int ... values) {
        return new IntSequenceClass(values);
    }

    @Override
    public int next() {
        if (currentIndex < sequence.length) {
            return sequence[currentIndex++];
        }
        else {
            throw new IllegalStateException("No more elements in sequence.");
        }
    }

    // Main
    public static void main(String[] args) {
        IntSequence sequenceInstance = IntSequenceClass.of(3,1,4,1,5,9);

        System.out.println("Sequence values:");
        for (int i=0; i < 6; i++ ) {
            System.out.println(sequenceInstance.next());
        }
    }
}
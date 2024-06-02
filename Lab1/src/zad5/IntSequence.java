package zad5;

/* Zaimplementuj metodę statyczną constant w klasie IntSequence, która zwraca nieskończony ciąg
stałych. Na przykład IntSequence.constant(1) zwraca wartości 1 1 1 ..., w nieskończoność. */

interface IntSequence {
    int next();
    boolean hasNext();

    // Statyczna metoda constant w klasie IntSequence:

   public static IntSequence constant(int value) {
        return new IntSequence() {
            @Override
            public int next(){
                return value; 
            }

            @Override
            public boolean hasNext() {
                return true; // Nieskończony ciąg
            }
        };
    }
}

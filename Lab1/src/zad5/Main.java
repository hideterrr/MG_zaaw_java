package zad5;

public class Main {
    public static void main(String[] args) {
        IntSequence constantSeq = IntSequence.constant(1);
        for (int i = 0; i < 10; i++) {
            System.out.print(constantSeq.next() + " ");
        }

        }
        // while (seq.hasNext()) {
        //     int num = seq.next();
        //     System.out.println(num);
        // }
    }


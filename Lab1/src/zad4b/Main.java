package zad4b;

public class Main {
    public static void main(String[] args) {
        IntSequence seq = IntSequence.of(3,1,4,1,5,9);
        while (seq.hasNext()) {
            int num = seq.next();
            System.out.println(num);
        }
    }
}
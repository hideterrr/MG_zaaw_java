// Zaimplementuj klasę RandomSequence ze slajdu nr 28 jako klasę zagniezdżona poza metodą
//randomInts.

//slajd 28: 
import java.util.Random;

public class LocalClassDemo {
  public static void main(String[] args) {
    IntSequence dieTosses = randomInts(1, 6);
    for (int i = 0; i < 10; i++) {
      System.out.println(dieTosses.next());
    }
  }

  private static Random generator = new Random();

  public static IntSequence randomInts(int low, int high) {
    class RandomSequence implements IntSequence {
      public int next() {
        return low + generator.nextInt(high - low + 1);
      }

      public boolean hasNext() {
        return true;
      }
    }

    return new RandomSequence();
  }
}

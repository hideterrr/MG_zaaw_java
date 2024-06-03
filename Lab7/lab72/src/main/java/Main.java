// vTwój menedżer poprosił o napisanie metody
//   public static <T> boolean isFinite(Stream<T> stream).
//   Dlaczego nie jest to dobry pomysł? Pomimo tego napisz j a.  ̨

import java.util.stream.Stream;
import java.util.Iterator;

public class Main {
    public static <T> boolean isFinite(Stream<T> stream) {
        Iterator<T> iterator = stream.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        return true;
    }

    public static void main(String[] args) {
        Stream<Integer> finiteStream = Stream.of(1, 2, 3, 4, 5);
        System.out.println(isFinite(finiteStream)); // true

        Stream<Integer> infiniteStream = Stream.iterate(0, i -> i + 1);
        System.out.println("Wywołanie isFinite(infiniteStream) spowoduje nieskończoną pętlę."); 
        //System.out.println(isFinite(infiniteStream));  // niekonczy sie
    }
}

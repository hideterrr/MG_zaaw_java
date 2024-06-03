// Napisz metodę public static <T> Stream<T>
//   zip(Stream<T> pierwszy, Stream<T> drugi),
// zwracajacą, na przemian elementy ze strumieni pierwszy i drugi (lub null, jeśli w strumieniu skończą si e elementy).

import java.util.*;
import java.util.stream.*;

public class Main {
  public static <T> Stream<T> zip(Stream<T> pierwszy, Stream<T> drugi) {
    Spliterator<T> spliterator1 = pierwszy.spliterator();
    Spliterator<T> spliterator2 = drugi.spliterator();

    Iterator<T> iterator1 = Spliterators.iterator(spliterator1);
    Iterator<T> iterator2 = Spliterators.iterator(spliterator2);

    Iterator<T> iterator = new Iterator<T>() {
      private boolean turn = false;

      @Override
      public boolean hasNext() {
        return iterator1.hasNext() || iterator2.hasNext();
      }

      @Override
      public T next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        turn = !turn;
        if (turn && iterator1.hasNext()) {
          return iterator1.next();
        } else if (!turn && iterator2.hasNext()) {
          return iterator2.next();
        } else {
          return null;
        }
      }
    };

    return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false);

  }

  public static void main(String[] args) {
    Stream<Integer> stream1 = Stream.of(1, 2, 3);
    Stream<Integer> stream2 = Stream.of(4, 5, 6, 7, 8);
    zip(stream1, stream2).forEach(System.out::println);
  }
}

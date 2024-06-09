import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Stream<ArrayList<Integer>> streamOfLists = Stream.of(
        new ArrayList<>(Arrays.asList(1, 2, 3)),
        new ArrayList<>(Arrays.asList(4, 5, 6)),
        new ArrayList<>(Arrays.asList(7, 8, 9)));

    ArrayList<Integer> combined = streamOfLists.reduce(
        new ArrayList<>(), (list1, list2) -> {
          list1.addAll(list2);
          return list1;
        });

    System.out.println("Połączona lista: " + combined);
  }
}
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    List<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");

    // Strumień równoległy z operacją distinct()
    List<String> distinctItems = list.parallelStream()
        .distinct()
        .collect(Collectors.toList());

    System.out.println(distinctItems); // Powinno wyjść: ["A", "B", "C", "D"]
  }
}

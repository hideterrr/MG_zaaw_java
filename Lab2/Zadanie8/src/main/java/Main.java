// Zaimplementuj metod˛e
// void luckySort(ArrayList<String> strings, Comparator<String> comp),
// która wywołuje Collections.shuffle na tablicy typu ArrayList do chwili, gdy elementy b˛ed ˛a
// uporz ˛adkowane rosn ˛aco w sposób okre´slony przez komparator.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.runner.Result;

public class Main {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<>();
    strings.add("Zebra");
    strings.add("Monkey");
    strings.add("Giraffe");
    strings.add("Lion");

    luckySort(strings, String::compareTo); // lub (s1, s2) -> s1.compareTo(s2))

    for (String string : strings) {
      System.out.println(string);
    }
  }

  public static void luckySort(ArrayList<String> strings, Comparator<String> comp) {
    while (!isSorted(strings, comp)) {
      Collections.shuffle(strings);
    }
  }

  // Metoda`list.length` dla ArrayList
  private static boolean isSorted(ArrayList<String> strings, Comparator<String> comp) {
    for (int i = 0; i < strings.size() - 1; i++) {
      if (comp.compare(strings.get(i), strings.get(i + 1)) > 0) {
        return false;
      }
    }
    return true;
  }
}
// Ten program tworzy listę ArrayList o nazwie strings, dodaje do niej kilka
// ciągów, a następnie wywołuje metodę luckySort, aby posortować listę. Metoda
// luckySort wywołuje Collections.shuffle na liście, dopóki elementy nie są
// uporządkowane rosnąco, jak określa to komparator. Po posortowaniu listy,
// program wyświetla posortowane ciągi.
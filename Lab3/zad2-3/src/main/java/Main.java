// Korzystaj ˛ac z metody list(FilenameFilter) klasy java.io.File, napisz metod˛e
// zwracaj ˛ac ˛a wszystkie pliki ze wskazanego katalogu ze wskazanym rozszerzeniem. Uzyj wyra- // zenia lambda, a nie ˙ FilenameFilter. Jakie zmienne zewn˛etrzne wykorzystasz?

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    File folder = new File("src/main/java");
    FilenameFilter filter = (dir, name) -> name.endsWith(".txt");
    String[] files = folder.list(filter); // Call list on the folder object

    System.out.println("Pliki z rozszerzeniem.txt to: ");
    for (String file : files) {
      System.out.println(file);
    }
  }
}
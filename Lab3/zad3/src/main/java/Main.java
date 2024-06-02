// Maj ˛ac tablic˛e obiektów File, posortuj je w taki sposób, by katalogi znalazły si˛e przed //plikami, a w kazdej grupie elementy zostały posortowane według nazwy. Uzyj wyrazenia lambda //przy implementowaniu interfejsu Comparator

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) {
    File directory = new File(".");
    File[] files = directory.listFiles();

    // sortowanie
    Arrays.sort(files, Comparator.comparing(File::isFile)
        .thenComparing(File::getName));

    for (File file : files) {
      System.out.println((file.isDirectory() ? "Katalog: " : "Plik: ") + file.getName());
    }
  }
}
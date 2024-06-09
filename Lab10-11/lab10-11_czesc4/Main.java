// Zadania: 26, 27, 28

import java.io.*;
import java.util.regex.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {

    String input2 = "/home/student/mójplik.txt";
    Pattern pattern2 = Pattern.compile("(/[^/]+)+/([^/]+)\\.([^/]+)$");
    Matcher matcher2 = pattern2.matcher(input2);
    if (matcher2.find()) {
      String[] directories = matcher2.group(1).split("/");
      String fileName = matcher2.group(2);
      String fileExtension = matcher2.group(3);

      System.out.println("Katalogi: " + Arrays.toString(directories));
      System.out.println("Nazwa pliku: " + fileName);
      System.out.println("Rozszerzenie pliku: " + fileExtension);
    }

    System.out.println();

    String r = "\\b((\\d{3})(\\d{3})(\\d{4}))|((\\d{3})(\\d{4}))\\b";
    System.out.println("Liczba grup w wyrażeniu regularnym: " + Pattern.compile(r).matcher("").groupCount());

    System.out.println();

    String input3 = "Today's date is 2023-10-05.";
    String result = input3.replaceAll("(\\d{4})-(\\d{2})-(\\d{2})", "$3/$2/$1");
    System.out.println(result); // wynik: Today's date is 05/10/2023.
  }
}
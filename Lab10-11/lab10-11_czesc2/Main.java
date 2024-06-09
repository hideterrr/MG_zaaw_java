// Zadania: 8, 9, 13, 14, 15, 20, 23

import java.util.regex.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {

    String input1 = "example_test_case";
    Pattern pattern1 = Pattern.compile("[a-z]+_[a-z]+");
    Matcher matcher1 = pattern1.matcher(input1);
    while (matcher1.find()) {
      System.out.println("Znaleziono: " + matcher1.group());
    }

    String input2 = "Example TestCase";
    Pattern pattern2 = Pattern.compile("[A-Z][a-z]+");
    Matcher matcher2 = pattern2.matcher(input2);
    while (matcher2.find()) {
      System.out.println("Znaleziono: " + matcher2.group());
    }

    String input3 = "This is a crazy test.";
    Pattern pattern3 = Pattern.compile("\\b\\w*z\\w*\\b");
    Matcher matcher3 = pattern3.matcher(input3);
    while (matcher3.find()) {
      System.out.println("Znaleziono: " + matcher3.group());
    }

    Pattern pattern4 = Pattern.compile("\\b\\w+z\\w+\\b");
    Matcher matcher4 = pattern4.matcher(input3);
    while (matcher4.find()) {
      System.out.println("Znaleziono: " + matcher4.group());
    }

    String input4 = "This_is_a_test123";
    Pattern pattern5 = Pattern.compile("[a-zA-Z0-9_]+");
    Matcher matcher5 = pattern5.matcher(input4);
    while (matcher5.find()) {
      System.out.println("Znaleziono: " + matcher5.group());
    }

    String input5 = "I saw a terrible rat running through the forest.";
    Pattern pattern6 = Pattern.compile("\\br[a-zA-Z]{2}\\b");
    Matcher matcher6 = pattern6.matcher(input5);
    while (matcher6.find()) {
      System.out.println("Znaleziono: " + matcher6.group());
    }

    String input6 = "cat camera can pen cow cab cot";
    Pattern pattern7 = Pattern.compile("\\bc[a-zA-Z]{2}\\b");
    Matcher matcher7 = pattern7.matcher(input6);
    StringBuffer resultBuffer = new StringBuffer();

    while (matcher7.find()) {
      matcher7.appendReplacement(resultBuffer, matcher7.group().toUpperCase());
    }
    matcher7.appendTail(resultBuffer);

    System.out.println("Zmodyfikowany łańcuch znaków:");
    System.out.println(resultBuffer.toString());
  }

}
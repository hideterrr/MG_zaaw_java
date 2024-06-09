// Zadania 17, 18, 19, 21, 22, 25

import java.util.regex.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String input1 = "123.456";
        boolean matches17 = input1.matches("^-?\\d+(\\.\\d+)?$");
        System.out.println("Czy liczba zmiennoprzecinkowa ma poprawny format? " + matches17);

        String input2 = "123\\2A";
        boolean matches18 = input2.matches("^\\d+[A-Za-z]?\\\\\\d+[A-Za-z]?$");
        System.out.println("Czy numer domu ma poprawny format? " + matches18);

        String input3 = "Częstochowa";
        boolean matches19 = input3.matches("^[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+(?:[\\s-][A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+)*$");
        System.out.println("Czy nazwa miasta jest poprawna? " + matches19);

        String input4 = "123.456";
        boolean matches21 = input4.matches("^-?\\d+(\\.\\d+)?$");
        System.out.println("Czy liczba zmiennoprzecinkowa ma poprawny format? " + matches21);

        String input5 = "123\\2A";
        boolean matches22 = input5.matches("^\\d+[A-Za-z]?\\\\\\d+[A-Za-z]?$");
        System.out.println("Czy numer domu ma poprawny format? " + matches22);

        String input6 = "123 -456 789 -10 20";
        ArrayList<Integer> numbersFind = new ArrayList<>();
        Pattern pattern1 = Pattern.compile("-?\\d+");
        Matcher matcher1 = pattern1.matcher(input6);
        while (matcher1.find()) {
            numbersFind.add(Integer.parseInt(matcher1.group()));
        }
        System.out.println("Liczby (find): " + numbersFind);

        ArrayList<Integer> numbersSplit = new ArrayList<>();
        String[] parts = input6.split("\\s+");
        for (String part : parts) {
            if (part.matches("-?\\d+")) {
                numbersSplit.add(Integer.parseInt(part));
            }
        }
        System.out.println("Liczby (split): " + numbersSplit);
    }
}
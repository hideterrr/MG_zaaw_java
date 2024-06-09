import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        int year = 2024; 
        LocalDate dayOfTheProgrammer;

      // Czy rok jest przystępny
        if (isLeapYear(year)) {
            dayOfTheProgrammer = LocalDate.of(year, Month.SEPTEMBER, 13);
        } else {
            dayOfTheProgrammer = LocalDate.of(year, Month.SEPTEMBER, 12);
        }

        System.out.println("Dzień Programisty: " + dayOfTheProgrammer);
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}

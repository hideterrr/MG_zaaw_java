import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate leapDay = LocalDate.of(2000, 2, 29);
        LocalDate nextYear = leapDay.plusYears(1);
        LocalDate nextFourYears = leapDay.plusYears(4);

        System.out.println(leapDay);
        System.out.println("2000-02-29 + 1 year: " + nextYear);
        System.out.println("2000-02-29 + 4 years: " + nextFourYears);
    }
}
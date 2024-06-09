import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        // Początek i koniec XX wieku
        LocalDate startDate = LocalDate.of(1901, Month.JANUARY, 1);
        LocalDate endDate = LocalDate.of(2000, Month.DECEMBER, 31);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        for (int year = startDate.getYear(); year <= endDate.getYear(); year++) {
            for (Month month : Month.values()) {
                LocalDate date = LocalDate.of(year, month, 13);
                if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                    System.out.println(date.format(formatter));
                }
            }
        }
    }
}
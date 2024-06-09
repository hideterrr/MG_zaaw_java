import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        LocalDate birthDate = LocalDate.of(2001, 10, 11);
        LocalDate currentDate = LocalDate.now();
        long daysLived = ChronoUnit.DAYS.between(birthDate, currentDate);

        System.out.println("Ilość dni, które żyjesz: " + daysLived);
    }
}

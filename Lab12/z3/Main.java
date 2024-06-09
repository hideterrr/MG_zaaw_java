import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate nextWorkingDay = today.with(następny(w -> w.getDayOfWeek().getValue() < 6));
        System.out.println("Kolejny dzień roboczy: " + nextWorkingDay);
    }

    public static TemporalAdjuster następny(Predicate<LocalDate> predicate) {
        return TemporalAdjusters.ofDateAdjuster(date -> {
            LocalDate nextDate = date;
            do {
                nextDate = nextDate.plusDays(1);
            } while (!predicate.test(nextDate));
            return nextDate;
        });
    }
}

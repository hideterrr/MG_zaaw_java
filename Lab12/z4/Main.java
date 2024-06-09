import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

public class Main {
  public static void main(String[] args) {
    int month = 3; // marzec
    int year = 2013;
    printCalendar(year, month);
  }

  public static void printCalendar(int year, int month) {
    YearMonth yearMonth = YearMonth.of(year, month);
    LocalDate firstOfMonth = yearMonth.atDay(1);
    int daysInMonth = yearMonth.lengthOfMonth();

    System.out.println(" Pn Wt Sr Cz Pt So Nd");
    for (int i = 1; i < firstOfMonth.getDayOfWeek().getValue(); i++) {
      System.out.print("   ");
    }

    for (int day = 1; day <= daysInMonth; day++) {
      System.out.printf("%2d ", day);
      if ((day + firstOfMonth.getDayOfWeek().getValue() - 1) % 7 == 0) {
        System.out.println();
      }
    }
  }
}

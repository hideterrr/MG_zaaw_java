import java.nio.charset.Charset;
import java.text.Normalizer;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    // // Zadanie 8
    // System.out.println("=== Zadanie 8: Unicode rozszerzane do dwóch lub więcej
    // znaków ASCII ===");
    // showExtendedUnicodeCharacters();

    // // Zadanie 9
    // System.out.println("\n=== Zadanie 9: Internacjonalizacja komunikatów ===");
    // internationalizedMessages();

    // Zadanie 10
    System.out.println("\n=== Zadanie 10: Dostępne kodowania znaków ===");
    showAvailableCharsets();

    // Zadanie 11
    System.out.println("\n=== Zadanie 11: Rozmiary papieru w preferowanych jednostkach ===");
    showPaperSizes();
  }

  // Zadanie 8 wypisuje bardzo dużo danych i dla przejrzystości jest zakomentowane
  // !!!

  // // Zadanie 8
  // private static void showExtendedUnicodeCharacters() {
  // for (char c = 0; c <= Character.MAX_VALUE; c++) {
  // String normalizedKC = Normalizer.normalize(String.valueOf(c),
  // Normalizer.Form.NFKC);
  // String normalizedKD = Normalizer.normalize(String.valueOf(c),
  // Normalizer.Form.NFKD);
  // if (normalizedKC.length() > 1 || normalizedKD.length() > 1) {
  // System.out.printf("Character: %c (U+%04X) - NFKC: %s, NFKD: %s%n", c, (int)
  // c, normalizedKC, normalizedKD);
  // }
  // }
  // }

  // // Zadanie 9
  // private static void internationalizedMessages() {
  // Locale[] supportedLocales = { Locale.ENGLISH, Locale.FRENCH };

  // for (Locale locale : supportedLocales) {
  // ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
  // System.out.println("Locale: " + locale.getDisplayName());
  // System.out.println(messages.getString("greeting"));
  // System.out.println(messages.getString("farewell"));
  // }
  // }

  // Zadanie 10
  private static void showAvailableCharsets() {
    Map<String, Charset> charsets = Charset.availableCharsets();
    for (Map.Entry<String, Charset> entry : charsets.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue().displayName());
    }
  }

  // Zadanie 11
  private static void showPaperSizes() {
    Locale[] locales = { Locale.US, Locale.CANADA, Locale.FRANCE, Locale.GERMANY, new Locale("en", "GB") };

    for (Locale locale : locales) {
      String country = locale.getDisplayCountry();
      if (country.isEmpty()) {
        continue;
      }
      String paperSize = getDefaultPaperSize(locale);
      System.out.printf("Default paper size in %s (%s): %s%n", country, locale.getDisplayLanguage(), paperSize);
    }
  }

  private static String getDefaultPaperSize(Locale locale) {
    if (locale.equals(Locale.US) || locale.equals(Locale.CANADA)) {
      return "Letter (8.5 x 11 inches)";
    } else {
      return "A4 (210 x 297 mm)";
    }
  }
}

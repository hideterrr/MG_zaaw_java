import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        // Zadanie 1
        System.out.println("=== Zadanie 1: Formatowanie daty i czasu ===");
        showDateTimeStyles();

        // Zadanie 2
        System.out.println("\n=== Zadanie 2: Lokalizacje nie korzystające z zachodnich cyfr ===");
        showNonWesternDigitLocales();

        // Zadanie 3
        System.out.println("\n=== Zadanie 3: Lokalizacje z takim samym formatem daty jak USA ===");
        showUSDatePatternLocales();

        // Zadanie 4
        System.out.println("\n=== Zadanie 4: Nazwy języków we wszystkich dostępnych językach ===");
        showLanguageNamesInAllLocales();

        // Zadanie 5
        System.out.println("\n=== Zadanie 5: Nazwy walut we wszystkich dostępnych językach ===");
        showCurrencyNamesInAllLocales();

        // Zadanie 6
        System.out.println("\n=== Zadanie 6: Waluty z różnymi symbolami w różnych lokalizacjach ===");
        showCurrenciesWithDifferentSymbols();

        // Zadanie 7
        System.out.println("\n=== Zadanie 7: Nazwy miesięcy w datach i osobno ===");
        showMonthNamesDifferences();
    }

    // Zadanie 1
    private static void showDateTimeStyles() {
        Locale[] locales = {
                Locale.FRANCE,
                Locale.CHINA,
                new Locale("th", "TH", "TH")
        };

        for (Locale locale : locales) {
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
            DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.FULL, locale);
            System.out.println(locale.getDisplayName() + ":");
            System.out.println("  Date: " + dateFormat.format(new java.util.Date()));
            System.out.println("  Time: " + timeFormat.format(new java.util.Date()));
        }
    }

    // Zadanie 2
    private static void showNonWesternDigitLocales() {
        Locale[] availableLocales = NumberFormat.getAvailableLocales();
        for (Locale locale : availableLocales) {
            NumberFormat numberFormat = NumberFormat.getInstance(locale);
            String formattedNumber = numberFormat.format(123456789);
            if (!formattedNumber.contains("1") && !formattedNumber.contains("2") && !formattedNumber.contains("3")) {
                System.out.println(locale.getDisplayName() + ": " + formattedNumber);
            }
        }
    }

    // Zadanie 3
    private static void showUSDatePatternLocales() {
        Locale[] availableLocales = DateFormat.getAvailableLocales();
        for (Locale locale : availableLocales) {
            SimpleDateFormat dateFormat = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT, locale);
            String pattern = dateFormat.toPattern();
            if (pattern.equals("M/d/yy") || pattern.equals("MM/dd/yy")) {
                System.out.println(locale.getDisplayName() + ": " + pattern);
            }
        }
    }

    // Zadanie 4
    private static void showLanguageNamesInAllLocales() {
        Locale[] availableLocales = Locale.getAvailableLocales();
        Set<String> uniqueLanguageNames = new TreeSet<>();

        for (Locale displayLocale : availableLocales) {
            for (Locale locale : availableLocales) {
                String languageName = locale.getDisplayLanguage(displayLocale);
                if (!languageName.isEmpty()) {
                    uniqueLanguageNames.add(languageName);
                }
            }
        }

        uniqueLanguageNames.forEach(System.out::println);
    }

    // Zadanie 5
    private static void showCurrencyNamesInAllLocales() {
        Locale[] availableLocales = Locale.getAvailableLocales();
        Set<String> uniqueCurrencyNames = new TreeSet<>();

        for (Locale displayLocale : availableLocales) {
            for (Currency currency : Currency.getAvailableCurrencies()) {
                try {
                    String currencyName = currency.getDisplayName(displayLocale);
                    if (!currencyName.isEmpty()) {
                        uniqueCurrencyNames.add(currencyName);
                    }
                } catch (Exception e) {
                    // ignore exceptions
                }
            }
        }

        uniqueCurrencyNames.forEach(System.out::println);
    }

    // Zadanie 6
    private static void showCurrenciesWithDifferentSymbols() {
        Set<Currency> currencies = Currency.getAvailableCurrencies();
        for (Currency currency : currencies) {
            Set<String> symbols = new TreeSet<>();
            for (Locale locale : Locale.getAvailableLocales()) {
                try {
                    String symbol = currency.getSymbol(locale);
                    symbols.add(symbol);
                } catch (Exception e) {
                    // ignore exceptions
                }
            }
            if (symbols.size() > 1) {
                System.out.println(currency.getCurrencyCode() + ": " + symbols);
            }
        }
    }

    // Zadanie 7
    private static void showMonthNamesDifferences() {
        Locale[] availableLocales = Locale.getAvailableLocales();
        for (Locale locale : availableLocales) {
            DateFormatSymbols symbols = new DateFormatSymbols(locale); // Fixed: Now uses the imported DateFormatSymbols
            String[] months = symbols.getMonths();
            Set<String> uniqueMonths = new HashSet<>(Arrays.asList(months)); // Fixed: Uses imported HashSet and Arrays
            if (uniqueMonths.size() > 12) {
                System.out.println(locale.getDisplayName() + ": " + uniqueMonths);
            }
        }
    }
}
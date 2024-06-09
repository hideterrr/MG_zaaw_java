import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Dane przykladowe
        List<Integer> liczby = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> lancuchy = Arrays.asList("Ala", "ma", "kota", "Ola", "ma", "Rysia");

        // (a) Obliczanie średniej z listy liczb całkowitych
        double srednia = liczby.stream().mapToInt(i -> i).average().orElse(0);
        System.out.println("Średnia: " + srednia);

        // (b) Konwersja listy łańcuchów znaków na listę wielkimi i małymi literami
        List<String> upperCase = lancuchy.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        List<String> lowerCase = lancuchy.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        System.out.println("Wielkie litery: " + upperCase);
        System.out.println("Małe litery: " + lowerCase);

        // (c) Suma wszystkich wartości parzystych i nieparzystych
        int sumaParzystych = liczby.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
        int sumaNieparzystych = liczby.stream().filter(n -> n % 2 != 0).mapToInt(Integer::intValue).sum();
        System.out.println("Suma parzystych: " + sumaParzystych);
        System.out.println("Suma nieparzystych: " + sumaNieparzystych);

        // (d) Usuwanie duplikatów
        List<String> bezDuplikatow = lancuchy.stream().distinct().collect(Collectors.toList());
        System.out.println("Bez duplikatów: " + bezDuplikatow);

        // (e) Zliczanie łańcuchów zaczynających się od określonej litery
        char litera = 'm';
        long licznik = lancuchy.stream().filter(s -> s.toLowerCase().startsWith(String.valueOf(litera))).count();
        System.out.println("Słowa zaczynające się na literę '" + litera + "': " + licznik);

        // (f) Sortowanie listy łańcuchów znaków
        List<String> sortedAsc = lancuchy.stream().sorted().collect(Collectors.toList());
        List<String> sortedDesc = lancuchy.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Posortowane rosnąco: " + sortedAsc);
        System.out.println("Posortowane malejąco: " + sortedDesc);

        // (g) Maksymalna i minimalna wartość na liście
        int max = liczby.stream().mapToInt(Integer::intValue).max().orElse(Integer.MIN_VALUE);
        int min = liczby.stream().mapToInt(Integer::intValue).min().orElse(Integer.MAX_VALUE);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

        // (h) Drugi najmniejszy i drugi największy element na liście
        List<Integer> sortedList = liczby.stream().sorted().collect(Collectors.toList());
        Integer drugiNajmniejszy = sortedList.size() > 1 ? sortedList.get(1) : null;
        Integer drugiNajwiekszy = sortedList.size() > 1 ? sortedList.get(sortedList.size() - 2) : null;
        System.out.println("Drugi najmniejszy: " + drugiNajmniejszy);
        System.out.println("Drugi największy: " + drugiNajwiekszy);
    }
}
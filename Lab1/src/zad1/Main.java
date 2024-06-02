package zad1;

// Utwórz programy do zadania: Utwórz interfejs Measurable z metodą double getMeasure(), która 
// dostarcza jakąś metrykę obiektu. Zaimplementuj interfejs Measurable w klasie Employee. 
// Utwórz metodę double average(Measurable[] objects), która oblicza średnią metryk. 
// Wykorzystaj ją do obliczenia średniego wynagrodzenia pracowników, których dane są zapisane w tablicy.

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("Anna", 5000),
            new Employee("Bob", 7000),
            new Employee("Charlie", 6000)
        };

        double averageSalary = average(employees);
        System.out.println("Średnie wynagrodzenie pracowników w firmie wynosi: " + averageSalary);
    }
    
    public static double average(Measurable[] objects) {
        if (objects.length == 0 ) {
            return 0; // Zabezpieczenie przed dzieleniem przez 0 osób
        }

        double sum = 0;
        for (Measurable obj : objects) {
            sum += obj.getMeasure();
        }

        return sum / objects.length;
    }
}

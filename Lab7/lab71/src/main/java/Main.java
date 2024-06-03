// Znajdź realistyczne zastosowanie dla metody Collectors.flatMapping. Rozważmy pewną
// klase z metodą zwracającą wartość typu Optional. Pogrupuj obiekty tej klasy według //pewnej cechy i dla każdej grupy zbierz niepuste wartości opcjonalne za pomocą flatMapping //oraz Optional.stream.
  
import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private Optional<String> hobby;

    public Student(String name, Optional<String> hobby) {
        this.name = name;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getHobby() {
        return hobby;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Adam", Optional.of("Piłka nożna")),
            new Student("Ewa", Optional.empty()),
            new Student("Jan", Optional.of("Piłka nożna")),
            new Student("Anna", Optional.of("Tenis")),
            new Student("Tomasz", Optional.empty())
        );

        Map<String, List<String>> hobbiesByNames = students.stream()
            .collect(Collectors.groupingBy(
                Student::getName,
                Collectors.flatMapping(
                    student -> student.getHobby().stream(),
                    Collectors.toList()
                )
            ));

        System.out.println(hobbiesByNames);
    }
}

package zad2;

/* Kontynuuj ˛ac poprzednie ´cwiczenie, utwórz metod˛e
Measurable largest(Measurable[] objects).
Wykorzystaj j ˛a do ustalenia nazwiska pracownika z najwy˙zszym wynagrodzeniem. Do czego zostanie
u˙zyte rzutowanie? */

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("Anna",5000),
            new Employee("Bob",6000),
            new Employee("Charlotte",10000)
        };

        // double averageSalary = average(employees);
        // System.out.println("Średnie wynagrodzenie : " + averageSalary);

        Employee highestPaidEmployee = (Employee) largest(employees);
        System.out.println("Najwięcej zarabia pracownik: " + highestPaidEmployee.getName());
    }

    public static Measurable largest(Measurable[] objects) {
        if  (objects.length == 0 ) {
            return null;
        }

        Measurable largest = objects[0];
        for (Measurable obj : objects) {
            if (obj.getMeasure() > largest.getMeasure()) {
                largest = obj;
            }
        }

        return largest;
    }
}

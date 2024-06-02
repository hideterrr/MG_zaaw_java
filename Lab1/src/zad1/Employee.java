package zad1;

public class Employee implements Measurable {
    private double salary;

    public Employee(String name, double salary) {
        this.salary = salary;    
    }

    @Override
    public double getMeasure() {
        return salary;
    }
}

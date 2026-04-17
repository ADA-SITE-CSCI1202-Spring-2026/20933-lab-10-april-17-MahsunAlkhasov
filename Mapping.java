import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class Employee {
    String firstName;
    String lastName;
    double salary;

    Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    double getSalary() {
        return salary;
    }
}

public class Mapping {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Charles", "Oliveira", 55000.20));
        employees.add(new Employee("Khabib", "Nurmadorkidorki", 67000.50));
        employees.add(new Employee("Ilia", "Topuria", 52000.75));

        Function<Employee, String> formatCard = e -> "Name: " + e.getLastName() + ", " + e.getFirstName()
                + " | Salary: $" + e.getSalary();
        Function<Employee, Double> salaryPicker = Employee::getSalary;

        for (Employee e : employees) {
            System.out.println(formatCard.apply(e));
            System.out.println(salaryPicker.apply(e));
        }
    }
}
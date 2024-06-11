import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", LocalDate.of(1990, 10, 15), BigDecimal.valueOf(2500.00), "Analyst"));
        employees.add(new Employee("Mary", LocalDate.of(1985, 5, 20), BigDecimal.valueOf(3500.00), "Manager"));

        employees.removeIf(employee -> employee.getName().equals("John"));

        employees.forEach(employee -> System.out.println(employee.getName() + ", " +
                employee.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", " +
                employee.getSalary().toString()));

        employees.forEach(employee -> employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1.10))));

        Map<String, List<Employee>> employeesByPosition = employees.stream()
                .collect(Collectors.groupingBy(Employee::getPosition));

        employeesByPosition.forEach((position, list) -> {
            System.out.println("Position: " + position);
            list.forEach(employee -> System.out.println(employee.getName()));
        });

    }
}

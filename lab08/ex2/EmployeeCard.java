import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EmployeeCard {

    private static Map<Employee_ex2, Integer> employees = new HashMap<>();

    public static void createCard(Employee_ex2 employee) {

        if (employees.containsKey(employee)) {
            System.out.println(employee.getPerson().getName() + " - Employee number: " + employees.get(employee));
        } else {
            Random random = new Random();
            int empNumber = random.nextInt(99999 - 10000 + 1) + 10000;

            employees.put(employee, empNumber);
            System.out.println(employee.getPerson().getName()  + " - Employee number: " + empNumber);
        }
    }

}

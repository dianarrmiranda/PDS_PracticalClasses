import java.util.HashMap;
import java.util.Map;

public class Parking {

    private static Map<Employee_ex2, Boolean> employees = new HashMap<>();

    public static void allow(Employee_ex2 employee) {

        if (employees.containsKey(employee)) {
            System.out.println(employee.getPerson().getName() + " - Parking Allow: " + employees.get(employee));
        } else {

            if (employee.getSalary() > Company_ex2.getAvgSalary())
                employees.put(employee, true);
            else
                employees.put(employee, false);

            System.out.println(employee.getPerson().getName()  + " - Parking Allow: "  + employees.get(employee));
        }
    }
    
}

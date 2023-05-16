public class NullDemo {
    public static void main(String[] args) {

		EmployeeEx10 emp = EmployeeFactory.getEmployee("Mac");
		EmployeeEx10 emp2 = EmployeeFactory.getEmployee("Janela");
		EmployeeEx10 emp3 = EmployeeFactory.getEmployee("Linux");
		EmployeeEx10 emp4 = EmployeeFactory.getEmployee("Mack");

		System.out.println(emp.getName());
		System.out.println(emp2.getName());
		System.out.println(emp3.getName());
		System.out.println(emp4.getName());
	}
    
}

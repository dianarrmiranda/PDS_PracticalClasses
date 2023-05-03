import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Company_ex2 {

public static User user;
private static List<Employee_ex2> emps = new ArrayList<>();

public void admitEmployee(Person_ex2 person, double salary) {
	Employee_ex2 e = new Employee_ex2(person, salary);
	SocialSecurity.regist(person);
	Insurance.regist(person);
	EmployeeCard.createCard(e);
	Parking.allow(e);
	emps.add(e);
}

public void paySalaries(int month) {
	for (Employee_ex2 e : emps) {
		BankAccount ba = e.getBankAccount();
		ba.deposit(e.getSalary());
	}
}

public static double getAvgSalary() {
	double sum = 0;
	for (Employee_ex2 e : emps) {
		sum += e.getSalary();
	}
	return sum / emps.size();
}

public List<Employee_ex2> employees() {
	return Collections.unmodifiableList(emps);
}

	
}

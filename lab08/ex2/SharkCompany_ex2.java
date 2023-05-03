import java.util.List;
public class SharkCompany_ex2 {
	public static void main(String[] args) {
		Person_ex2[] persons = { new Person_ex2("Maria Silva"),
				new Person_ex2("Manuel Pereira"),
				new Person_ex2("Aurora Machado"),
				new Person_ex2("Augusto Lima")
		};
		Company_ex2 shark = new Company_ex2();
		Company_ex2.user = User.COMPANY;
		shark.admitEmployee(persons[0], 1000);
		shark.admitEmployee(persons[1], 900);
		shark.admitEmployee(persons[2], 1200);
		shark.admitEmployee(persons[3], 1100);
		List<Employee_ex2> sharkEmps = shark.employees();
		for (Employee_ex2 e : sharkEmps)
			System.out.println(e.getSalary());
		shark.paySalaries(1);
	}

}
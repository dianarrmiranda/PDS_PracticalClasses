
class Employee extends Person2 {

private double salary;
	
	public Employee(String n, double s) {
		super(n);
		salary = s;
	}

	public double getSalary() {
		return salary;
	}
}
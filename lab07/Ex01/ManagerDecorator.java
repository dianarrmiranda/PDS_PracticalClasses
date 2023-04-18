package lab07.Ex01;

public class ManagerDecorator extends EmployeeDecorator{
    public ManagerDecorator(EmployeeInterface employee) {
        super(employee);
    }

    public void manage() {
        System.out.println("Manager managing...");
    }
}

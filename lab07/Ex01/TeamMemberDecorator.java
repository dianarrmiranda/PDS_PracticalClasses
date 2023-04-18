package lab07.Ex01;

public class TeamMemberDecorator extends EmployeeDecorator{
    public TeamMemberDecorator(EmployeeInterface employee) {
        super(employee);
    }

    public void collaborate() {
        System.out.println("Team member collaborating...");
    }
}

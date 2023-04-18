package lab07.Ex01;

public class TeamLeaderDecorator extends EmployeeDecorator{
    public TeamLeaderDecorator(EmployeeInterface employee) {
        super(employee);
    }

    public void plan() {
        System.out.println("Team leader planning...");
    }
}

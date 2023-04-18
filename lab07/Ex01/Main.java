package lab07.Ex01;

public class Main {
    public static void main(String[] args) {

        System.out.println("Start the program ...");

        PDSDate startDate = new PDSDate(1, 1, 2019, "9:00");
        PDSDate EndDate = new PDSDate(1, 1, 2020, "18:00");

        EmployeeInterface basicEmployee = new Employee(startDate, EndDate);
        basicEmployee.work(); // Calls Employee.work()

        EmployeeDecorator teamMemberAndLeader = new TeamLeaderDecorator(new TeamMemberDecorator(basicEmployee));

        teamMemberAndLeader.start(startDate); // Calls TeamMemberDecorator.collaborate()
        teamMemberAndLeader.work(); // Calls basicEmployee.work(), TeamMemberDecorator.work(), and TeamLeaderDecorator.work() // faz com que repita 2 vezes os print's (correto no entanto)
        teamMemberAndLeader.terminate(EndDate); // Calls TeamLeaderDecorator.plan()


        System.out.println("End the program ...");
}
}
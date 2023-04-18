package lab07.Ex01;

public class Employee implements EmployeeInterface {
    private PDSDate startDate;
    private PDSDate terminationDate;

    public Employee() {
    }

    public Employee(PDSDate startDate, PDSDate terminationDate) {
        this.startDate = startDate;
        this.terminationDate = terminationDate;
    }

    @Override
    public void start(PDSDate Date) {
        startDate= Date;
        System.out.println("Basic Employee start working");

    }

    @Override
    public void terminate(PDSDate Date) {
        terminationDate= Date;
        System.out.println("Basic Employee end working");
    }

    @Override
    public void work() {
        System.out.println("Basic employee working...");
    }
}
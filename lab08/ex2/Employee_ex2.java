public class Employee_ex2 {
    private Person_ex2 person;
    private double salary;
    private BankAccount bankAccount;

    public Employee_ex2(Person_ex2 person, double salary) {
        this.person = person;
        this.salary = salary;
        bankAccount = new BankAccountProxy(new BankAccountImpl("money", 0));        
    }


    public Person_ex2 getPerson() {
        return person;
    }

    public double getSalary() {
        return salary;
    }

    public BankAccount getBankAccount() {
        return new BankAccountProxy(bankAccount);
    }
}
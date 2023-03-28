package lab06.Ex01;

public class Worker {

    private String fname,lname ;
    private long code;
    private double salary;

    public Worker(String fname, long code, double salary) {
        this.fname = fname;
        this.code = code;
        this.salary = salary;
    }

    public Worker(String fname, String lname, long code, double salary) {
        this.fname = fname;
        this.lname = lname;
        this.code = code;
        this.salary = salary;
    }

    public String getfName() {
        return fname;
    }

    public String getlName() {
        return lname;
    }

    public long getCode() {
        return code;
    }

    public double getSalary() {
        return salary;
    }

    public String toString() {
        String s;
        if (lname != null) {
            s = " Worker " + fname + " " + lname + " (" + code + ") Salary: " + salary;
        } else {
            s = " Worker " + fname + " (" + code + ") Salary: " + salary;
        }
        return s;
    }
    
}

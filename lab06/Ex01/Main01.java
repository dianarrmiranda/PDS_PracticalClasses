package lab06.Ex01;
import static java.lang.System.*;
public class Main01 {

    public static void main(String[] args) {

        // Create a new database
        Database db = new Database();

        out.println("");
        out.println("========================================== Employee/Database System ==========================================");
        out.println("Before adding employees:");
        out.println(db);

        // Add some employees
        db.addEmployee(new Employee("John", 123, 1000));
        db.addEmployee(new Employee("Mary", 456, 2000));
        db.addEmployee(new Employee("Peter", 789, 3000));

        out.println();
        out.println("After adding employees:");
        out.println(db);

        out.println();
        out.println("After deleting employee 456:");
        // Delete an employee
        db.deleteEmployee(456);
        // Print the database
        out.println(db);

        out.println();

        Registos reg = new Registos();

        out.println("========================================== Empregado/Database System ==========================================");
        out.println("Before adding employees:");
        out.println(reg);

        // Add some employees
        reg.insere(new Empregado("João", "Silva", 1, 1000));
        reg.insere(new Empregado("Maria", "Santos", 2, 2000));
        reg.insere(new Empregado("Pedro", "Pereira", 3, 3000));

        out.println();
        out.println("After adding employees:");
        out.println(reg);
        
        out.println();
        out.println("After deleting employee Maria:");
        // Delete an employee
        reg.remove(2);
        // Print the database
        out.println(reg);
        
        out.println();





    }

}

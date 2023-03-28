package lab06.Ex01;

public class Adapter {

    private Database database;
    private Registos registos;

    public Adapter(Database database, Registos registos) {
        this.database = database;
        this.registos = registos;
    }

    public void addEmployee(Empregado emp) {

        if (this.isInDatabase(emp.codigo())) {
            System.out.println("Empregado já existe na base de dados");
            return;
        }

        this.registos.insere(emp);
    }

    public void removeEmployee(int code) {
        registos.remove(code);
        database.deleteEmployee(code);
    }

    public boolean isInDatabase(int code) {
        for (Empregado emp : this.registos.listaDeEmpregados()) {
            if (emp.codigo() == code) {
                return true;
            }
        }

        return false;
    }

    public String toString() {
        String result = "Registos: \n";

        for (Empregado emp : this.registos.listaDeEmpregados()) {
            result += "Nome: " + emp.nome() + " " + emp.apelido() + " Código: " + emp.codigo() + " Salário: " + emp.salario() + " \n";
        }

        result += "\nDatabase: \n";

        for (Employee emp : this.database.getAllEmployees()) {
            result += "Nome: " + emp.getName() + " Código: " + emp.getEmpNum() + " Salário: " + emp.getSalary() + " \n";
        }

        return result;
    }

}

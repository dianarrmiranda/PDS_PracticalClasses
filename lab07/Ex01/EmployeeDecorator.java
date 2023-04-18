package lab07.Ex01;

public class EmployeeDecorator implements EmployeeInterface{
    protected EmployeeInterface tf;

    public EmployeeDecorator(EmployeeInterface tf) {
        this.tf = tf;
    }
    
    public void start(PDSDate data){
        tf.start(data);
        System.out.println("Employee start working");
    }
    public void terminate(PDSDate data){
        tf.terminate(data);
        System.out.println("Employee end working");
    }
    public void work(){
        tf.work();
    }

}

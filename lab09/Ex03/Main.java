package lab09.Ex03;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args){
        RemoteControl control = new RemoteControl();
        Collection collection = new ArrayList<>();

        Command add = new AddCommand(collection);
        Command remove = new RemoveCommand(collection);

        control.setCommand(add);
        control.execute("PDS");
        control.execute("CD");
        control.execute("IHC");
        control.execute("POO");
        System.out.println(collection);
        
        control.undo();
        System.out.println(collection);


        control.setCommand(remove);
        control.execute("PDS");
        control.undo();
        control.execute("IHC");
        control.undo();
        System.out.println(collection);

        control.execute("PDS");
        control.execute("IHC");
        System.out.println(collection);
    }    
}

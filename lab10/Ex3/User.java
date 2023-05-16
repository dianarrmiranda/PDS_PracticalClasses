package lab10.Ex3;

import java.util.List;

abstract class User {

    protected Mediator mediator;

    public User(Mediator mediator) {
        this.mediator = mediator;
        this.mediator.addUser(this);
    }

    public abstract void updateTarefa(Tarefa tarefa);

    public abstract List<Tarefa> getTarefasAtribuidas();

    public abstract String getNome();

    
}

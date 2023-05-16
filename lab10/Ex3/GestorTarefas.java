package lab10.Ex3;

import java.util.List;
import java.util.ArrayList;

public class GestorTarefas implements Mediator {

    private List<User> users;
    private List<Tarefa> tarefas;

    public GestorTarefas() {
        this.users = new ArrayList<>();
        this.tarefas = new ArrayList<>();
    }

    @Override
    public void addTarefa(Tarefa tarefa) {
        this.tarefas.add(tarefa);
    }

    @Override
    public void addUser(User usuario) {
        this.users.add(usuario);
    }

    @Override
    public void updateTarefa(Tarefa tarefa) {
        for (User user : this.users) {
            user.updateTarefa(tarefa);
        }
    }
    
}

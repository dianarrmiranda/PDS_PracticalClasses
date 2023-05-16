package lab10.Ex3;

import java.util.ArrayList;
import java.util.List;

public class UserImpl extends User{

    private String nome;
    private List<Tarefa> tarefas;
    public UserImpl(String nome, Mediator mediator) {
        super(mediator);
        this.nome = nome;
        this.tarefas = new ArrayList<>();
    }

    @Override
    public void updateTarefa(Tarefa tarefa) {
        if (tarefas.contains(tarefa)) {
            System.out.println("Tarefa atualizada " + tarefa.titulo + " - " + tarefa.descricao);
        } else {
            tarefas.add(tarefa);
            System.out.println("Nova tarefa atribuida " + tarefa.titulo + " - " + tarefa.descricao);
        }
    }

    @Override
    public List<Tarefa> getTarefasAtribuidas() {
        return this.tarefas;
    }


    public String getNome(){
        return this.nome;
    }

}

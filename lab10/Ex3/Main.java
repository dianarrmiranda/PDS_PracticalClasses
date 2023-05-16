package lab10.Ex3;

import java.util.List;

public class Main {

    public static void main(String[] args){
        Mediator mediator = new GestorTarefas();

        // Criação dos users
        User User1 = new UserImpl("João", mediator);
        User User2 = new UserImpl("Maria", mediator);

        // Criação das tarefas
        Tarefa tarefa1 = new TarefaImpl(mediator, "Descrição da tarefa 1", "Tarefa 1");
        Tarefa tarefa2 = new TarefaImpl(mediator, "Descrição da tarefa 2", "Tarefa 2");
        Tarefa tarefa3 = new TarefaImpl(mediator, "Descrição da tarefa 3", "Tarefa 3");

        // Atribuição de tarefas
        tarefa1.atribuirTarefa(User1);
        tarefa2.atribuirTarefa(User2);
        tarefa3.atribuirTarefa(User1);

        // Verificação das listas de tarefas atribuídas
        List<Tarefa> tarefasUser1 = User1.getTarefasAtribuidas();
        List<Tarefa> tarefasUser2 = User2.getTarefasAtribuidas();

        System.out.println("Tarefas atribuídas ao user 1 (" + User1.getNome() + "):");
        for (Tarefa tarefa : tarefasUser1) {
            System.out.println(tarefa.getTitulo() + " - " + tarefa.getDescricao());
        }

        System.out.println("Tarefas atribuídas ao user 2 (" + User2.getNome() + "):");
        for (Tarefa tarefa : tarefasUser2) {
            System.out.println(tarefa.getTitulo() + " - " + tarefa.getDescricao());
        }
    }
    
}

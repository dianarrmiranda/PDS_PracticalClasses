package lab10.Ex3;

public class TarefaImpl extends Tarefa {

    private User responsavel;

    public TarefaImpl(Mediator mediator, String titulo, String descricao) {
        super(mediator, titulo, descricao);
    }

    @Override
    public void atribuirTarefa(User user) {
        this.responsavel = user;
        this.mediator.updateTarefa(this);
    }

}

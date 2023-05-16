package lab10.Ex3;

abstract class Tarefa {
    protected Mediator mediator;
    protected String descricao;
    protected String titulo;

    public Tarefa(Mediator mediator, String titulo, String descricao) {
        this.mediator = mediator;
        this.titulo = titulo;
        this.descricao = descricao;
        this.mediator.addTarefa(this);
    }

    public abstract void atribuirTarefa(User user);

    public String getTitulo() {
        return this.titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }
}

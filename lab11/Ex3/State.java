package lab11.Ex3;

public interface State {
    public void regista(Livro livro);
    public void requesita(Livro livro);
    public void devolve(Livro livro);
    public void cancelaReserva(Livro livro);
    public void reserva(Livro livro);
}

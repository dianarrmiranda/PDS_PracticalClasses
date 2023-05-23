package lab11.Ex3;

public class Disponivel implements State {

    @Override
    public void regista(Livro livro) {
        System.out.println("Operação não disponível");
    }

    @Override
    public void requesita(Livro livro) {
        livro.setEstado(new Emprestado());
    }

    @Override
    public void devolve(Livro livro) {
        System.out.println("Operação não disponível");
    }

    @Override
    public void cancelaReserva(Livro livro) {
        System.out.println("Operação não disponível");
    }

    @Override
    public void reserva(Livro livro) {
        livro.setEstado(new Reservado());
    }

    @Override
    public String toString() {
        return "[Disponivel]";
    }

}

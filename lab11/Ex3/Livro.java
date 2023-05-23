package lab11.Ex3;

public class Livro {

    private String titulo, autor;
    private int ano, ISBN;
    private State estado;

    public Livro(String titulo, String autor, int ano, int ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    public int getISBN() {
        return ISBN;
    }

    public State getEstado() {
        return estado;
    }

    public void setEstado(State estado) {
        this.estado = estado;
    }

    public void regista(){
        this.estado.regista(this);
    }

    public void requesita(){
        this.estado.requesita(this);
    }

    public void devolve(){
        this.estado.devolve(this);
    }

    public void cancelaReserva(){
        this.estado.cancelaReserva(this);
    }

    public void reserva(){
        this.estado.reserva(this);
    }
    
}

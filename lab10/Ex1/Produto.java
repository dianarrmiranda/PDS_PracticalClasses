package lab10.Ex1;
import java.util.ArrayList;

public class Produto {
    private int ID;
    private static int counter=1;
    public String Descricao;
    public double PrecoInicial;
    private Estado estado;
    private Cliente ClienteAtual;
    private ArrayList<Observer> observadores;
    
    public Produto(String Descricao, double PrecoInicial) {
        this.ID = counter++;
        this.Descricao = Descricao;
        this.PrecoInicial = PrecoInicial;
        this.estado = Estado.STOCK;
        this.ClienteAtual = null;
        this.observadores = new ArrayList<Observer>();
    }

    public void attach(Observer o) {
        observadores.add(o);
    }

    public void notifyObservers(boolean novaLicitacao) {
        for (Observer ob : observadores) {
            ob.update(this,novaLicitacao);
        }
    }

    public Cliente getClienteAtual() {
        return ClienteAtual;
    }

    public void setClienteAtual(Cliente ClienteAtual){
        this.ClienteAtual = ClienteAtual;
    }

    public int getID() {
        return ID;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
        this.notifyObservers(false);
    }

    public double getPreco() {
        return PrecoInicial;
    }

    public void setPreco(double preco) {
        this.PrecoInicial = preco;
    }
    
    @Override
    public String toString() {
        return "[" + ID + "] " + Descricao;
    }
}

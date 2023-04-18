package lab07.Ex03;

public class Bebida {
    private String nome;
    private double preco;
    

    public Bebida(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Bebida{" + "nome=" + getNome() + ", preco=" + getPeso() + '}';
    }
}
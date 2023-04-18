package lab07.Ex03;

public abstract class Produto {
    private String nome;
    private double peso;

    public Produto(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    public Double getPesoTotal(){
        return 0.0;
    }

    public void draw() {
        
    }


    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", peso='" + getPeso() + "'" +
            "}";
    }

}
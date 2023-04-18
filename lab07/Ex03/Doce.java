package lab07.Ex03;

public class Doce implements ProdutoInterface{
    private String nome;
    private Double peso;

    Doce(String nome, int peso){
        this.nome = nome;
        this.peso = Double.valueOf(peso);
    }

    public void draw() {
        System.out.println("Doce '" + this.nome + "' - Weight: " + this.peso);
    }

    public Double getPesoTotal() {
        return this.peso;
    }
}

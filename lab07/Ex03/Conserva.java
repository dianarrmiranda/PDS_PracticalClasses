package lab07.Ex03;

public class Conserva implements ProdutoInterface {
 
    private String nome;
    private Double peso;

    Conserva(String nome, int peso){
        this.nome = nome;
        this.peso = Double.valueOf(peso);
    }

    public void draw() {
        System.out.println("Conserva '" + this.nome + "' - Weight: " + this.peso);
    }

    public Double getPesoTotal() {
        return this.peso;
    }

}

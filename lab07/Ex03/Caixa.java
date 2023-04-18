package lab07.Ex03;

import java.util.ArrayList;

public class Caixa implements ProdutoInterface{

    private String nome;
    private Double peso;
    private ArrayList<ProdutoInterface> produtos;
    static  int ident = 0;

    Caixa(String nome, int peso) {
        this.nome = nome;
        this.peso = Double.valueOf(peso);
        this.produtos = new ArrayList<ProdutoInterface>();
    }

    void add(ProdutoInterface produto) {
        this.produtos.add(produto);
    }


    public void draw() {
        System.out.println("* Caixa '" + this.nome + "' [ Weight: " + this.peso + " ; Total: " + this.getPesoTotal() + "]");
        ident++;
        for (ProdutoInterface p : produtos) {
            for (int i = 0; i < ident; i++) {
                System.out.print("\t");
            }
            p.draw();
        }
        ident--;   
    }

    public Double getPesoTotal() {
        Double pesoTotal = this.peso;
        for (ProdutoInterface p : produtos) {
            pesoTotal += p.getPesoTotal();
        }
        return pesoTotal;
    }

}
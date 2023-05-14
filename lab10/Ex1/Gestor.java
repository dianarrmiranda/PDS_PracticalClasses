package lab10.Ex1;
import java.util.ArrayList;

public class Gestor extends Observer{
    private ArrayList<Produto> produtosStock;
    private ArrayList<Produto> produtosVendidos; 

    public Gestor(String nome) {
        super(nome);
        this.produtosStock = new ArrayList<Produto>();
        this.produtosVendidos = new ArrayList<Produto>();
    }

    public void update(Produto p, boolean novaLicitacao) {
        if(novaLicitacao){
            System.out.println("[Gestor: " + this + "] | " + p + " | " + p.getClienteAtual() + " licitou " + String.valueOf(p.getPreco()) + "€.");
        }
        else{
            switch(p.getEstado()){
                case STOCK:
                    System.out.println("[Gestor " + this + "] O produto " + p + " não recebeu nenhuma licitação e vai para o stock.");
                    this.produtosLeilao.remove(p); // vem do observer
                    this.produtosStock.add(p);
                    System.out.println();
                    break;
                case LEILAO:
                    System.out.println("[Gestor: " + this + "] | " + p + " | " + " vai ser licitado. Preço inicial: " + String.valueOf(p.getPreco()) + "€.");
                    this.produtosLeilao.add(p); // vem do observer
                    this.produtosStock.remove(p);
                    System.out.println();
                    break;
                case VENDIDO:
                    System.out.println("[Gestor: " + this + "] Vendido ao " + p.getClienteAtual() + " por " + String.valueOf(p.getPreco()) + "€.");
                    this.produtosLeilao.remove(p); // vem do observer
                    this.produtosVendidos.add(p);
                    System.out.println();
                    break;
            }
        }
    }

    // O gestor é o responsável por colocar os produtos em leilão
    public void atualizarEstado(Produto p, Estado e) {
        p.setEstado(e);
        System.out.println();
    }
}

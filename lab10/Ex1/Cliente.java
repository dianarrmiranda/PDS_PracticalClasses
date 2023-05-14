package lab10.Ex1;

public class Cliente extends Observer{
    public Cliente(String nome) {
        super(nome);
    }

    public void update(Produto p, boolean novaLicitacao) {
        if(novaLicitacao){
            System.out.println("[Cliente: " + this + "] | " + p + " | " + p.getClienteAtual() + " licitou " + String.valueOf(p.getPreco()) + "€.");
        }
        else{
            switch(p.getEstado()){
                case STOCK:
                    System.out.println("[Cliente " + this + "] O produto '" + p + "' não recebeu nenhuma licitação, pelo que não pode ser leiloado agora.");
                    this.produtosLeilao.remove(p); // vem do observer
                    System.out.println();
                    break;
                case LEILAO:
                    System.out.println("[Cliente: " + this + "] O produto '" + p + "' vai licitar. Preço inicial: " + String.valueOf(p.getPreco()) + "€.");
                    this.produtosLeilao.add(p); // vem do observer
                    System.out.println();
                    break;
                case VENDIDO:
                    System.out.println("[Cliente: " + this + "] O produto '" + p + "' | " + p.getClienteAtual() + " comprou por " + String.valueOf(p.getPreco()) + "€.");
                    this.produtosLeilao.remove(p); // vem do observer
                    System.out.println();
                    break;
            }
        }
    }

    public void licitar(Produto p, double preco) {
        if (produtosLeilao.contains(p)) {
            if (preco > p.getPreco()) {
                System.out.println("Nova licitação:");
                p.setClienteAtual(this);
                p.setPreco(preco);
            } else {
                System.out.println("[" + this + "] Tem de fazer uma licitação maior que " + p.getPreco() + "€ para ser a oferta mais elevada.");
            }
        } else {
            System.out.println("[" + this + "] O produto " + p + " não está disponível para leilão neste momento.");
        }
        System.out.println();
    }

    public void receberNotificacoes(Produto p) {  // Para ver produtos em leilão?????
        p.attach(this);
    }

}

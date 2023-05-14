package lab10.Ex1;

public class Main {
    public static void main(String[] args){
        Produto p1 = new Produto("Produto 1", 10);
        Produto p2 = new Produto("Produto 2", 200);
        Produto p3 = new Produto("Produto 3", 310);
        Produto p4 = new Produto("Produto 4", 420);
        Produto p5 = new Produto("Produto 5", 500);

        Cliente c1 = new Cliente("Manuel");
        Cliente c2 = new Cliente("José");
        Cliente c3 = new Cliente("Clemente");

        Gestor g1 = new Gestor("Bonifácio"); // Faria sentido o gestor poder atualizar um estado de um produto?

        // Gestor à escuta de todos os produtos
        g1.receberNotificacoes(p1);
        g1.receberNotificacoes(p2);
        g1.receberNotificacoes(p3);
        g1.receberNotificacoes(p4);
        g1.receberNotificacoes(p5);

        c1.receberNotificacoes(p1);
        c1.receberNotificacoes(p2);
        c1.receberNotificacoes(p3);
        c1.receberNotificacoes(p4);
        c1.receberNotificacoes(p5);

        c2.receberNotificacoes(p1);
        c2.receberNotificacoes(p2);
        c2.receberNotificacoes(p3);
        c2.receberNotificacoes(p4);
        c2.receberNotificacoes(p5);

        c3.receberNotificacoes(p1);
        c3.receberNotificacoes(p2);
        c3.receberNotificacoes(p3);
        c3.receberNotificacoes(p4);
        c3.receberNotificacoes(p5);

        //O gestor vai colocar os produtos em LEILAO:
        g1.atualizarEstado(p1, Estado.LEILAO);
        g1.atualizarEstado(p2, Estado.LEILAO);
        g1.atualizarEstado(p5, Estado.LEILAO); 
        g1.atualizarEstado(p4, Estado.LEILAO);       //não vai ter licitações de nenhum cliente

        System.out.printf("\n-------------------------------------------------------------------------------------\n");

        c1.licitar(p3, 50); // não é suposto dar porque não está em leilão

        System.out.printf("\n-------------------------------------------------------------------------------------\n");

        c1.licitar(p1, 12000.0);
        c3.licitar(p1, 11000.0);    //tem um valor inferior à primeira, tem de dar erro
        c3.licitar(p1, 13000.0);    // agora licita mais e ganha o produto
        g1.atualizarEstado(p1, Estado.VENDIDO);

        System.out.printf("\n-------------------------------------------------------------------------------------\n");

        c1.licitar(p2, 2000.0); // apenas outro leilão random
        c3.licitar(p2, 1000.0);   
        g1.atualizarEstado(p2, Estado.VENDIDO);

        System.out.printf("\n-------------------------------------------------------------------------------------\n");

        g1.atualizarEstado(p4, Estado.STOCK); // volta para o stock porque ningém licitou
    
        System.out.printf("\n-------------------------------------------------------------------------------------\n");
        // Atualizar um a meio do leilão, e só um licitar

        g1.atualizarEstado(p3, Estado.LEILAO);
        c1.licitar(p3, 315.5);
        g1.atualizarEstado(p3, Estado.VENDIDO);
    }
}

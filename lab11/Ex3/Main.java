package lab11.Ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Livro> livros = new ArrayList<>();

        Livro l1 = new Livro("Java Anti-Stress", "Omodionah", 2010, 123);
        Livro l2 = new Livro("A Guerra da Luz", "Jorge Omel", 2011, 124);
        Livro l3 = new Livro("A Procura da Luz", "Khumatkli", 2011, 125);

        livros.add(l1);
        livros.add(l2);
        livros.add(l3);  

        l1.setEstado(new Inventario());
        l2.setEstado(new Inventario());
        l3.setEstado(new Inventario());

        Scanner scanner = new Scanner(System.in);
        String input = "";

        while(true){
            System.out.println("*** Biblioteca ***");

            for(int i=1; i<= livros.size(); i++){
                System.out.printf("%2d %25s  %20s  %20s%n", i, livros.get(i-1).getTitulo(), livros.get(i-1).getAutor(), livros.get(i-1).getEstado());
            }
            System.out.print("0 -> Sair");
            System.out.println("\n<livro>, <operação>: (1) regista; (2) requisita; (3) devolve; (4) reserva; (5) cancela");
    
            input = scanner.nextLine();
            if(input.equals("0")){
                scanner.close();
                System.exit(0);  
            } 
            String[] parts = input.split(",");
            
            Livro newLivro = livros.get(Integer.parseInt(parts[0])-1);
    
            switch (Integer.parseInt(parts[1])) {
                case 1:
                    newLivro.regista();
                    break;
                case 2:
                    newLivro.requesita();
                    break;
                case 3:
                    newLivro.devolve();
                    break;
                case 4:
                    newLivro.reserva();
                    break;
                case 5:
                    newLivro.cancelaReserva();
                    break;
                default:
                    break;
            }

            System.out.println();
            
        }

       
    } 
    
}

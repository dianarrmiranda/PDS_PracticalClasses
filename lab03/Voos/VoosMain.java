package lab03.Voos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.*; // Para não ter de escrever sempre System.out.println

import java.io.FileWriter;
import java.io.File;

public class VoosMain {
    public static void main(String[] args) throws IOException {
        String[] op;
        Scanner sc = new Scanner(in);
        do {
            out.println("Escolha uma opção: (H para ajuda)");
            op = sc.nextLine().split(" ");
            menu(op,args);
            
        } while (!op[0].equals("Q")); // O ops 0 vai ser a letra
        sc.close();
    }

    public static void menu(String[] op, String[] args) {
        switch (op[0]) { 
            case "H":
                out.println("--------------------------------------------------------------------------------------------------------------------------------");
                out.println("Selecionou a opção H-> Ajuda");
                out.println("<> Opção I filename");
                out.println("                 Lê um ficheiro de texto contento informação sobre um voo.");
                out.println("");
                out.println("<> Opção M flight_code");
                out.println("                 Exibe o mapa das reservas de um voo.");
                out.println("");
                out.println("<> Opção F flight_code num_seats_executive num_seats_tourist");
                out.println("                 Acrescenta um novo voo, com código, lugares em executiva (opcionais) e lugares em turística.");
                out.println("");
                out.println("<> Opção R flight_code class number_seats");
                out.println("                 Acrescenta uma nova reserva a um voo, com indicação do código do voo, da classe (T / E), e do número de lugares");
                out.println("");
                out.println("<> Opção C reservation_code");
                out.println("                 Cancela uma reserva. O código de reserva tem o formato: flight_code:sequential_reservation_number");
                out.println("--------------------------------------------------------------------------------------------------------------------------------");
                out.println("");
                break;
            case "I": 
                LerFicheiro(op[1]);
                break;
            case "M":break;
            case "F":break;
            case "R":break;
            case "C":break;
            case "Q": // terminar o programa
                out.println("Terminou a execução do programa.");
                break;
            default:
                out.println("Opção inválida. As opções devem ser passadas em letra maiúscula.");
        }

    }

    public static List<String> LerFicheiro(String file) {
        String linha = "";
        String CodVoo = "";
        List<String> words = new ArrayList<String>();

        try {
            FileReader arq = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(arq);
            linha = lerArq.readLine(); // Pode vir a levar .trim() para tirar os espaços em branco
            if (linha.charAt(0) != '>') { // O if tá fora do while, porque só queremos verificar a primeira linha uma vez
                out.println("O ficheiro não começa com o carater \">\"");
                exit(0); // sai do programa
            }
            CodVoo= linha.substring(1,7); // Vamos assumir que apesar dos codigos de voo variarem, têm este tamanho maximo
            out.println(CodVoo);    
            // Como ir buscar agora para quando há exec e turista? FAzer trim na linha e depois ver se tem mais alguma coisa??
            // Não queria fazer com String[]

            // Criar o objeto avião logo aqui???????????'?'
            while ((linha = lerArq.readLine()) != null) {
            }
            arq.close();
        } catch (IOException e) {
            err.printf("Erro na abertura do arquivo: %s.\n",
                e.getMessage()); // aqui também podia ser System.out.println("Erro na abertura do arquivo: ");
        }

        return words;
    }
}

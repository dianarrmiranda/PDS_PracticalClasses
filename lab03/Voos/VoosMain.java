package lab03.Voos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Scanner;
import static java.lang.System.*; // Para não ter de escrever sempre System.out.println

public class VoosMain {

    static HashMap<String, Voo> Info = new HashMap<>();
    public static void main(String[] args) throws IOException {
        String[] command;
        Scanner sc = new Scanner(in);
        Aviao aviao = null;
        Voo voo = null;
        do {
            out.println("Escolha uma opção: (H para ajuda)");
            command = sc.nextLine().split(" "); 
            menu(command,args,aviao,voo);
            
        } while (!command[0].equals("Q")); // O command 0 vai ser a letra
        sc.close();
    }

    public static void menu(String[] command, String[] args, Aviao aviao, Voo voo) {

        List<String> file = new ArrayList<String>();
        

        switch (command[0]) { 
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
                file = LerFicheiro(command[1]);
                
                if (file.get(2).contains("x"))
                {   
                    List <String> reserva = new ArrayList<String>();
                    
                    for (int i = 3; i<file.size(); i++){
                        reserva.add(file.get(i));
                    }
                    aviao = new Aviao(file.get(1),file.get(2));
                    voo = new Voo(file.get(0),aviao,reserva);
                }else{
                    List <String> reserva = new ArrayList<String>();
                    
                    for (int i = 2; i<file.size(); i++){
                        reserva.add(file.get(i));
                    }
                    aviao = new Aviao(file.get(1));
                    voo = new Voo(file.get(0),aviao,reserva);
                }
                out.println(voo.toString());
                Info.put(file.get(0),voo); // file.get(0) é o código do voo
                break;
                
            case "M":
                out.print("M "+ voo.FlightCodetoString());
            case "F":
               if (command.length == 3){ // Só lugares na turistica
                    Aviao aviaoF = new Aviao(command[2]);
                    Voo vooF = new Voo(command[1],aviaoF);
                    //aviao.getT_Seats(); // retorna o número de lugares na turistica
                    //voo.setCode(command[2]); // Set flight code
                    Info.put(command[1],vooF);
                    out.println("The flight was inserted with success\n");
                    out.printf("%s\n", Info.get(command[1]));
               }
               else if(command.length == 4){// executiva + turistica
                    Aviao aviaoF = new Aviao(command[2],command[3]);
                    Voo vooF = new Voo(command[1],aviaoF);
                    Info.put(command[1],vooF);
                    out.println("The flight was inserted with success\n");
                    out.printf("%s\n", Info.get(command[1]));
               }
               else{
                   out.println("Número de argumentos inválido");
               }
               break;
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
        String linha[];
        List<String> ContentFromFile = new ArrayList<String>();

        try {
            FileReader arq = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(arq);
            //split by > and by space
            linha = lerArq.readLine().split("[>, ]");

            if(linha.length>4 || linha.length<3){ // metemos 4 e 3 porque não nos apeteceu tratar da 1ª linha vazia
                System.err.println("ERROR: Invalid type of input file. ");
                arq.close();
                return null;  
            }

                    
            for (int i = 1; i < linha.length; i++) {
                ContentFromFile.add(linha[i]);
            }
            
            arq.close();
        } catch (IOException e) {
            err.printf("Erro na abertura do arquivo: %s.\n",
                e.getMessage()); // aqui também podia ser System.out.println("Erro na abertura do arquivo: ");
        }

        return ContentFromFile;
    }
}

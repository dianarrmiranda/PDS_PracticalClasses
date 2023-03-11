package lab03.voos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class voos {
    public static void main(String[] args) {
        Map<String, Aviao> mapAvioes = new HashMap<String, Aviao>();
        String[] input;
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        
        String flight_code = new String(); 
        Aviao aviao;
        while (running) {
            System.out.println("\nEscolha uma opção: (H para ajuda)");
            input = sc.nextLine().split(" ");

            switch (input[0].toUpperCase()) {
                case "I":
                    try {
                        File myObj = new File(input[1]);
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            String[] fileInput = data.split(" ");
                            if (fileInput[0].charAt(0) == '>'){
                                fileInput[0] = fileInput[0].substring(1);

                                flight_code = fileInput[0];

                                if (fileInput.length == 2){
                                    String[] num_seats_tourist = fileInput[1].split("x");
                                    int numTour = Integer.parseInt(num_seats_tourist[0]);
                                    int lenTour = Integer.parseInt(num_seats_tourist[1]);
                                    
                                    aviao = new Aviao(flight_code, numTour, lenTour);
                                    System.out.printf("Código de voo %s. Lugares disponíveis: %d lugares em classe Turística. Classe executiva não disponível neste voo.", flight_code, numTour*lenTour);
                                } else {
                                    String[] num_seats_tourist = fileInput[1].split("x");
                                    int numExec = Integer.parseInt(num_seats_tourist[0]);
                                    int lenExec = Integer.parseInt(num_seats_tourist[1]);

                                    String[] num_seats_executive = fileInput[2].split("x");
                                    int numTour = Integer.parseInt(num_seats_executive[0]);
                                    int lenTour = Integer.parseInt(num_seats_executive[1]);

                                    aviao = new Aviao(flight_code, numExec, lenExec, numTour, lenTour);
                                    System.out.printf("Código de voo %s. Lugares disponíveis: %d lugares em classe Executiva; %d lugares em classe Turística.", flight_code, numExec*lenExec,numTour*lenTour);
                                }
                                mapAvioes.put(flight_code, aviao);
                            }
                            else {
                                aviao = mapAvioes.get(flight_code);
                                if (aviao == null) {
                                    System.out.println("Voo não existe");
                                    break;
                                }
                                char classe = fileInput[0].charAt(0);
                                int lugares = Integer.parseInt(fileInput[1]);

                                aviao.reservePlaces(lugares, classe);
                            }
                        }
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                    break;
                case "M":
                    if (input.length != 2) {
                        System.out.println("Argumento inválido");
                        break;
                    }
                    flight_code = input[1];
                    //get aviao
                    aviao = mapAvioes.get(flight_code);
                    if (aviao == null) {
                        System.out.println("Voo não existe");
                        break;
                    }
                    //print aviao
                    System.out.println(aviao.toString());
                    break;
                case "F":
                    if (input.length < 3 || input.length > 4) {
                        System.out.println("Número de argumentos inválido");
                        break;
                    }
                    
                    flight_code = input[1];

                    if (input.length == 3){
                        String[] num_seats_tourist = input[2].split("x");
                        int numTour = Integer.parseInt(num_seats_tourist[0]);
                        int lenTour = Integer.parseInt(num_seats_tourist[1]);
                         
                        aviao = new Aviao(flight_code, numTour, lenTour);
                    } else {
                        String[] num_seats_tourist = input[2].split("x");
                        int numExec = Integer.parseInt(num_seats_tourist[0]);
                        int lenExe = Integer.parseInt(num_seats_tourist[1]);

                        String[] num_seats_executive = input[3].split("x");
                        int numTour = Integer.parseInt(num_seats_executive[0]);
                        int lenTour = Integer.parseInt(num_seats_executive[1]);

                        aviao = new Aviao(flight_code, numExec, lenExe, numTour, lenTour);
                        System.out.printf("Código de voo %s. Lugares disponíveis: %d lugares em classe Executiva; %d lugares em classe Turística.", flight_code, numExec*lenExe,numTour*lenTour);
                    }
                    mapAvioes.put(flight_code, aviao);
                    

                    //aviao.printTest();
                    break;
                case "R":
                    if (input.length != 4) {
                        System.out.println("Argumento inválido");
                        break;
                    }
                    flight_code = input[1];
                    aviao = mapAvioes.get(flight_code);
                    if (aviao == null) {
                        System.out.println("Voo não existe");
                        break;
                    }
                    char classe = input[2].charAt(0);
                    int lugares = Integer.parseInt(input[3]);

                    aviao.reservePlaces(lugares, classe);
                    // aviao.printTest();
                    break;
                case "C":
                    if (input.length != 2) {
                        System.out.println("Argumento inválido");
                        break;
                    }
                    String[] code_seqNum = input[1].split(":");
                    flight_code = code_seqNum[0];
                    aviao = mapAvioes.get(flight_code);
                    if (aviao == null) {
                        System.out.println("Voo não existe");
                        break;
                    }
                    int seqNum= Integer.parseInt(code_seqNum[1]);
                    aviao.cancelReservation(seqNum);
                    break;
                case "H":
                    System.out.println("[Opções disponíveis]");
                    System.out.println("");
                    System.out.println("H - lista as opções disponíveis");
                    System.out.println("I filename.txt - ler voo do ficheiro especificado");
                    System.out.println("M flight_code - mostrar o mapa de reservas do voo especificado");
                    System.out.println("F flight_code num_seats_executive num_seats_tourist - acrescenta um novo voo, comcódigo, lugares em executiva (p.ex. 4x3, representando 4 filas com 3 lugares por fila), e lugares em turística.\nOs lugares em classe executiva são opcionais, podendo existir apenas lugares em turística.");
                    System.out.println("R flight_code class number_seats - acrescenta uma nova reserva a um voo, com indicação do código do voo, da classe (T / E), e do número de lugares.\nO programa deve verificar se há lugares disponíveis na classe pretendida. \nCaso a reserva seja efetuada deve ser apresentado no ecrã o código da reserva no formato flight_code:sequential_reservation_numbere os lugares atribuídos");
                    System.out.println("C reservation_code - cancela uma reserva. O código de reserva tem o formato flight_code:sequential_reservation_number");
                    System.out.println("Q - termina o programa");
                    break;
                case "Q":
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }

        sc.close();
    } 
}
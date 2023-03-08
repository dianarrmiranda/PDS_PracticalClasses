package lab03.Voos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Voo {

    private String code;
    private Aviao plane;
    private List<String> reservas;
    private Integer tReserved = 0, eReserved = 0;

    public Voo(String code, Aviao plane, List<String> reservas) {
        this.code = code;
        this.plane = plane;
        this.reservas = reservas;
    }

    public Voo(String code, Aviao plane) { // Para a op F, não é preciso saber as reservas
        this.code = code;
        this.plane = plane;
    }

    public String setCode(String code) {
        return this.code = code;
    }

    public void countReservas() {

        for (int i = 0; i < this.reservas.size(); i++) {
            if (reservas.get(i).contains("T")) {
                if (tReserved + Integer.parseInt(reservas.get(i).split(" ")[1]) <= plane.getT_Seats()) {
                    tReserved += Integer.parseInt(reservas.get(i).split(" ")[1]);
                } else {
                    System.out.println("Não foi possível obter lugares para a reserva: " + reservas.get(i));
                    reservas.remove(i);
                }
            } else if (reservas.get(i).contains("E")) {

                if (eReserved + Integer.parseInt(reservas.get(i).split(" ")[1]) <= plane.getE_Seats()) {
                    eReserved += Integer.parseInt(reservas.get(i).split(" ")[1]);
                } else {
                    System.out.println("Não foi possível obter lugares para a reserva: " + reservas.get(i));
                    reservas.remove(i);
                }
            }
        }

    }

    public void getBookingMap() {
        Map<Character, List<Integer>> bookingMap = new HashMap<>();
        for (int i = 65; i < 65 + plane.getNumFilas(); i++) {
            List<Integer> temp = new ArrayList<>();
            for(int col = 0; col < plane.getNumColunas(); col++)
            {
                temp.add(00);

            }

            bookingMap.put((char)i, temp);
        }
        stringBookingMap(bookingMap);
    }
    public void stringBookingMap(Map<Character, List<Integer>> bookingMap) {

        System.out.print(" ");
        for (int i = 1; i <= plane.getNumColunas(); i++) {
            System.out.printf("   %02d",i);
        }
        System.out.println();

        for(Character key: bookingMap.keySet()){
            System.out.print(key);
            for( Integer value: bookingMap.get(key)) {
                System.out.printf("   %02d",value);
            }
            System.out.println();
        }

    }
    

    public String toString(){
        return "Código de voo " + code+ ". " + plane.toString();
    }


   public String FlightCodetoString() {
        return "Código de voo " + code+ ". ";
    }
    
}

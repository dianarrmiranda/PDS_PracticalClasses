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
    private List<List<Integer>> seatsOcupied = new ArrayList<>();
    private Map<Character, List<Integer>> bookingMap = new HashMap<>();

    private Integer countT, countE, count = 0, count1 = 0, nOrder = 1;

    public Voo(String code, Aviao plane, List<String> reservas) {
        this.code = code;
        this.plane = plane;
        this.reservas = reservas;

        // inicializar seatsocupied com 0
        for (int i = 0; i < plane.getNumFilas(); i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < plane.getNumColunas(); j++) {
                row.add(0);
            }
            seatsOcupied.add(row);
        }

        countE = 0;
        this.countT = plane.getE_Columns();
    }

    public Voo(String code, Aviao plane) { // Para a op F, não é preciso saber as reservas
        this.code = code;
        this.plane = plane;
    }

    public String setCode(String code) {
        return this.code = code;
    }

    public int getCountT() {
        return this.countT;
    }

    public int getCountE() {
        return this.countE;
    }

    public int getCount() {
        return this.count;
    }

    public int getCount1() {
        return this.count1;
    }

    public int getNOrder() {
        return this.nOrder;
    }

    public void countReservas() {

        for (int i = 0; i < this.reservas.size(); i++) {
            if (reservas.get(i).contains("T")) {
                if (tReserved + Integer.parseInt(reservas.get(i).split(" ")[1]) <= plane.getT_TotalSeats()) {
                    tReserved += Integer.parseInt(reservas.get(i).split(" ")[1]);
                } else {
                    System.out.println("Não foi possível obter lugares para a reserva: " + reservas.get(i));
                    reservas.remove(i);
                }
            } else if (reservas.get(i).contains("E")) {

                if (eReserved + Integer.parseInt(reservas.get(i).split(" ")[1]) <= plane.getE_TotalSeats()) {
                    eReserved += Integer.parseInt(reservas.get(i).split(" ")[1]);
                } else {
                    System.out.println("Não foi possível obter lugares para a reserva: " + reservas.get(i));
                    reservas.remove(i);
                }
            }
        }

    }

    public void RmReserve(String[] flight_code_AND_sequential_reservation_number) {
        this.reservas.remove(Integer.parseInt(flight_code_AND_sequential_reservation_number[1]));
        this.plane.delReserve(Integer.parseInt(flight_code_AND_sequential_reservation_number[1].trim()));
    }

    public List<List<Integer>> addReserve(int numSeats, String type) {
        if (type.equals("E")) {
            for (int i = 0; i < numSeats; i++) {
                if (this.count1 < plane.getE_Seats().get(1)) {
                    while (seatsOcupied.get(this.count1).get(this.countE) != 0) {
                        if (this.count1 < plane.getE_Seats().get(1)) {
                            this.count1++;
                        } else {
                            this.countE++;
                            this.count1 = 0;
                        }

                    }
                    seatsOcupied.get(this.count1).set(this.countE, this.nOrder);
                    this.count1++;
                } else {
                    this.countE++;
                    this.count1 = 0;
                    seatsOcupied.get(this.count1).set(this.countE, this.nOrder);

                }
            }
        } else if (type.equals("T")) {
            for (int i = 0; i < numSeats; i++) {
                if (this.count < plane.getT_Seats().get(1)) {
                    while (seatsOcupied.get(this.count).get(countT) != 0) {
                        if (this.count < plane.getT_Seats().get(1)) {
                            this.count++;
                        } else {
                            countT++;
                            this.count = 0;
                        }
                    }
                    seatsOcupied.get(this.count).set(this.countT, this.nOrder);
                    this.count++;
                } else {
                    this.countT++;
                    this.count = 0;
                    seatsOcupied.get(this.count).set(this.countT, this.nOrder);
                    this.count++;

                }
            }
        }
        this.nOrder++;

        return this.seatsOcupied;

    }

    public void addReserves(int op, int nSeats, String type) {
        if (op == 1) {
            for (int i = 0; i < reservas.size(); i++) {
                if (reservas.get(i).contains("T")) {
                    this.seatsOcupied = addReserve(Integer.parseInt(reservas.get(i).split(" ")[1]), "T");
    
                } else if (reservas.get(i).contains("E")) {
                    this.seatsOcupied = addReserve(Integer.parseInt(reservas.get(i).split(" ")[1]), "E");
                }
            }
            this.reservas.clear();
        }else{
            this.seatsOcupied = addReserve(nSeats, type);
        }

    }

    public void getBookingMap() {
        for (int i = 65; i < 65 + plane.getNumFilas(); i++) {
            this.bookingMap.put((char) i, seatsOcupied.get(i - 65));
        }

        if (plane.getE_Filas() != 0 && plane.getT_Filas() > plane.getE_Filas()) {
            int dif = plane.getT_Filas() - plane.getE_Filas();
            for (int i = plane.getT_Filas() - dif; i < plane.getT_Filas(); i++) {
                for (int j = 0; j < plane.getE_Columns(); j++) {
                    this.bookingMap.get((char) (i + 65)).set(j, -1);
                }
            }
        }

    }

    public void stringBookingMap() {
        System.out.print(" ");
        for (int i = 1; i <= plane.getNumColunas(); i++) {
            System.out.printf("   %02d", i);
        }
        System.out.println();

        for (Character key : this.bookingMap.keySet()) {
            System.out.print(key);
            for (Integer value : this.bookingMap.get(key)) {
                System.out.printf("   %02d", value);
            }
            System.out.println();
        }

    }

    public void printReserve(int nOrder) {
        for (int i = 0; i<this.bookingMap.size(); i++){
            for (int j = 0; j<this.bookingMap.get((char)(i+65)).size(); j++){
                if (this.bookingMap.get((char)(i+65)).get(j) == nOrder){
                    System.out.print(nOrder + (char)(i+65) + " | ");
                }
            }
        }

    }

    public String toString() {
        return "Código de voo " + code + ". " + plane.toString();
    }

    public String FlightCodetoString() {
        return "Código de voo " + code + ". ";
    }

}

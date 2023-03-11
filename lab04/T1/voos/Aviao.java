package lab03.voos;

import java.util.ArrayList;

public class Aviao {
    private ArrayList<Fila> filas = new ArrayList<>();
    private String code;

    private int numExec; // num of rows
    private int lenExec; // lenght of rows
    private int emptyExecSpaces;
    
    private int numTur; // num of rows
    private int lenTur; // lenght of rows
    private int emptyTurSpaces;

    private int sequential_reservation_number; 
    

    public Aviao(String code, int numExec, int lenExec, int numTur, int lenTur){
        this.code = code;
        this.numExec = numExec;
        this.lenExec = lenExec;
        this.numTur = numTur;
        this.lenTur = lenTur;
        initializeRows('E', this.numExec, this.lenExec);
        initializeRows('T', this.numTur, this.lenTur);
    }
    
    public Aviao(String code, int numTur, int lenTur){
        this.code = code;
        this.numTur = numTur;
        this.lenTur = lenTur;     
        initializeRows('T', this.numTur, this.lenTur);   
    }

    public void printTest(){ // just for testing
        for (Fila row : this.filas){
            System.out.println(row);
        }
    }


    public String toString(){
        String s = "  ";
        //   1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18
        for (int i = 1; i <= this.filas.size(); i++){
            s += i + " ";
        }
        s += "\n";
        
        /* 
         * A 3 3 5 1 2 2 4 0 0  0  0  0  0  0  0  0  0  0
         * B 3 6 5 1 2 0 0 0 0  0  0  0  0  0  0  0  0  0
         * C       0 2 0 0 0 0  0  0  0  0  0  0  0  0  0
         */
        for (int i = 1; i <=Math.max(lenExec, lenTur); i++){
            s += (char) (i + 64) + " ";
            for (int j = 0; j < this.filas.size() ; j++){
                Fila fila = this.filas.get(j);
                //executive
                if (i > lenExec && fila.getType() == 'E'){
                    s += "  ";
                    continue;
                }
                //tourist
                if (i > lenTur && fila.getType() == 'T'){
                    s += "  ";
                    continue;
                }
                if (j >= 8){
                    s += fila.getLugares()[i-1] + "  ";
                } else {
                    s += fila.getLugares()[i-1] + " ";
                }
            }
            s += "\n";
        }

        return s;
    }

    private void initializeRows(char type, int num, int len){
        if (type == 'E'){
            for (int e = 0; e < num; e++){
                this.filas.add(new Fila(len, 'E')); 
                this.emptyExecSpaces += len;
            }
        }
        else if (type == 'T'){
            for (int t = 0; t < num; t++){
                this.filas.add(new Fila(len, 'T')); 
                this.emptyTurSpaces += len;
            }
        }
    }

    public void reservePlaces(int num, char type){
        // check if there are enough empty spaces
        if (type == 'E'){
            if (num > this.emptyExecSpaces){
                System.out.println("Nao foi possivel obter lugares para a reserva " + type + " " + num);
                return;
            }
        }else if (num > this.emptyTurSpaces){
            System.out.println("Nao foi possivel obter lugares para a reserva " + type + " " + num);
            return;
        }

        this.sequential_reservation_number++;
        
        // try empty lines
        int remaining = fillOnEmptyFilas(num, type);

        // if there are still places to fill
        if (remaining > 0){
            fillOnNonEmptyFilas(num, type);
        }
        
        System.out.println("Reserva " + type + " " + num + " efetuada com sucesso");
        if (type == 'E'){
            this.emptyExecSpaces -= num;
        }else{
            this.emptyTurSpaces -= num;
        }
    }

    public int fillOnEmptyFilas(int num, char type){
        for (int i = 0; i < this.filas.size(); i++){
            Fila f = this.filas.get(i);
            if (f.getType() == type && f.isEmpty()){
                // System.out.println("found empty fila" + i);
                if (num > f.getLength()) { 
                    f.occupy(f.getLength(), this.sequential_reservation_number);
                    num = num - f.getLength();
                }else{
                    f.occupy(num, this.sequential_reservation_number);
                    num = 0;
                    break;
                }
            }
        }
        return num; // remaining
    }

    public void fillOnNonEmptyFilas(int num, char type){
        for (int i = 0; i < this.filas.size(); i++){
            Fila f = this.filas.get(i);
            int emptySpaces = f.countEmptySpaces();
            if (f.getType() == type && emptySpaces > 0){
                if (num > emptySpaces) { 
                    f.occupyNonEmpty(emptySpaces, this.sequential_reservation_number);
                    num = num - emptySpaces;
                }else{
                    num = f.occupyNonEmpty(num, this.sequential_reservation_number);
                    // num = 0;
                }
            }
        }
    }

    public void cancelReservation(int num){
        for (int i = 0; i < this.filas.size(); i++){
            Fila f = this.filas.get(i);
            if (f.hasReservation(num)){
                int cancelledSpaces= f.cancelReservation(num);
                if (f.getType() == 'E'){
                    this.emptyExecSpaces += cancelledSpaces;
                }else{
                    this.emptyTurSpaces += cancelledSpaces;
                }
            }
        }
        System.out.println("Reserva " + num + " cancelada com sucesso");
    }
}

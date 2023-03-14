package lab04.T1.voos;

public class Fila {
    private int[] lugares = null;
    private char tipo;
    private int len;

    public Fila(int len, char tipo) {
        this.len= len;
        this.lugares = new int[this.len];
        this.tipo = tipo;
    }

    public int getLength() {
        return this.len;
    }
    public int[] getLugares() {
        return this.lugares;
    }

    public void occupy(int num, int ID) {
        for (int i=0; i<num; i++){
            // System.out.println("Lugar " + i + " ocupado por " + lugares[i]);
            if (this.lugares[i] == 0){
                this.lugares[i] = ID;
            }
        }
    }

    public int occupyNonEmpty(int num, int ID) {
        for (int i=0; i<getLength(); i++) {
            if (this.lugares[i] == 0) {
                this.lugares[i] = ID;
                num--;
            }
            if (num == 0) {break;}
        }
        return num;
    }

    public boolean isFilledWith(int ID) {
        for (int i=0; i<getLength(); i++) {
            if (this.lugares[i] != ID) {return false;}
        }
        return true;
    }

    public boolean hasReservation(int ID) {
        for (int i=0; i<getLength(); i++) {
            if (this.lugares[i] == ID) {return true;}
        }
        return false;
    }

    public int cancelReservation(int ID) {
        int count= 0;
        for (int i=0; i<getLength(); i++) {
            if (this.lugares[i] == ID) {
                this.lugares[i] = 0;
                count++;
            }
        }
        return count;
    }
    
    public boolean isEmpty(){
        if (isFilledWith(0)) {return true;}
        return false;
    }

    public int countEmptySpaces(){
        int count = 0;
        for (int i=0; i<getLength(); i++) {
            if (this.lugares[i] == 0) {count++;}
        }
        return count;
    }

    public char getType(){
        return this.tipo;
    }

    public void removeReserve(int ID) {
        for (int i=0; i<getLength(); i++) {
            if (this.lugares[i] == ID) {this.lugares[i] = 0;}
        }
    }


    public String toString() { // testing purposes
        String s = "";
        for (int i=0; i<getLength(); i++) {
            s += this.lugares[i] + " ";
        }
        return s;
    }
}

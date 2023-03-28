package lab06.Ex01;

import java.util.ArrayList;
import java.util.List;

public class PetiscosAdapter implements Adapter {

    private ArrayList<Worker> workers;

    public PetiscosAdapter() {
        workers = new ArrayList<>();
    }

    @Override
    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    @Override
    public void removeWorker(long code) {
        for (int i = 0; i < workers.size(); i++) {
            if (workers.get(i).getCode() == code) {
                workers.remove(i);
                break;
            }
        }
    }

    @Override
    public boolean isWorker(long code) {
        for (int i = 0; i < workers.size(); i++) {
            if (workers.get(i).getCode() == code) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Worker> listWorkers() {
        return workers;
    }

    public String toString() {
        return "Registos: " + workers;
    }


    
}

package lab06.Ex01;

import java.util.List;

public interface Adapter {

    public void addWorker(Worker worker);

    public void removeWorker(long code);

    public boolean isWorker(long code);

    public List<Worker> listWorkers();

    
}

package lab12.thermoMVC.view;

import javax.swing.JPanel;

import lab12.thermoMVC.model.Thermometer;
import lab12.thermoMVC.model.ThermometerListener;

public class NewDisplay extends JPanel implements ThermometerListener {

    private Thermometer thermometer;

    public NewDisplay(Thermometer thermometer) {
        this.thermometer = thermometer;
    }

    @Override
    public void temperatureChanged() {
        System.out.println("Temperature changed - " + thermometer.getTemperature());
    }
    
}

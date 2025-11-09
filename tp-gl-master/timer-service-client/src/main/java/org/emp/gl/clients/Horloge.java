package org.emp.gl.clients;

import java.beans.PropertyChangeEvent;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class Horloge implements TimerChangeListener {

    private final String name;
    private final TimerService timerService;

    public Horloge(String name, TimerService ts) {
        this.name = name;
        this.timerService = ts;
        timerService.addTimeChangeListener(this);
        System.out.println("Horloge " + name + " initialisée !");
    }

    private void afficherHeure() {
        System.out.println(name + " => " +
                timerService.getHeures() + ":" +
                timerService.getMinutes() + ":" +
                timerService.getSecondes());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (!SECONDE_PROP.equals(evt.getPropertyName())) return;
        afficherHeure();
    }
}

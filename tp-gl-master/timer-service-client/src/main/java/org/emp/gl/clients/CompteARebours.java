package org.emp.gl.clients;

import java.beans.PropertyChangeEvent;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class CompteARebours implements TimerChangeListener {

    private final String name;
    private int valeur;
    private final TimerService timerService;

    public CompteARebours(String name, int valeur, TimerService ts) {
        this.name = name;
        this.valeur = valeur;
        this.timerService = ts;
        timerService.addTimeChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (!SECONDE_PROP.equals(evt.getPropertyName())) return;

        int tick = (int) evt.getNewValue();
        System.out.println("Tick : " + tick);

        if (valeur > 0) {
            System.out.println(name + " -> " + --valeur);
        }

        if (valeur == 0) {
            System.out.println(name + " terminé  (désinscription)");
            timerService.removeTimeChangeListener(this);
        }
    }
}

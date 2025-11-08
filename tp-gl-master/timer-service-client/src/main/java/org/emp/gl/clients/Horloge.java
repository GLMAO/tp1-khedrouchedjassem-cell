package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.TimerChangeListener;

public class Horloge implements TimerChangeListener {

    private String name;
    public TimerService timerService;

    public Horloge(String name , TimerService tm) {
        this.name = name;
        this.timerService = tm;
        // S'inscrire comme observateur

        System.out.println("Horloge " + name + " initialized!");
    }

    public void afficherHeure() {
        if (timerService != null)
            System.out.println(name + " affiche " +
                    timerService.getHeures() + ":" +
                    timerService.getMinutes() + ":" +
                    timerService.getSecondes());
    }

    @Override
    public void propertyChange(String propertyName, Object oldValue, Object newValue) {
        afficherHeure();
    }
}

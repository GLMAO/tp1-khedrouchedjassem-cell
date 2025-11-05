package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.TimerChangeListener;

public class Horloge implements TimerChangeListener {

    private String name;
    public TimerService timerService ;

    public Horloge(String name, TimerService timerService) {
        this.name = name;
        this.timerService = timerService;

        // S'inscrire comme observateur
        this.timerService.addTimeChangeListener(this);

        System.out.println("Horloge " + name + " initialized!");
    }

    // Méthode appelée automatiquement chaque dixième de seconde

    public void afficherHeure() {
        if (timerService != null)
            System.out.println(name + " affiche " +
                    timerService.getHeures() + ":" +
                    timerService.getMinutes() + ":" +
                    timerService.getSecondes());
    }
}

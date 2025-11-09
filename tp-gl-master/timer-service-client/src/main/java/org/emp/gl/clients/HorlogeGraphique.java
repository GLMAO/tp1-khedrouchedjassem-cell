package org.emp.gl.clients;

import java.awt.Font;
import java.beans.PropertyChangeEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class HorlogeGraphique extends JFrame implements TimerChangeListener {

    private final TimerService timerService;
    private JLabel labelHeure;

    public HorlogeGraphique(TimerService ts) {
        this.timerService = ts;
        ts.addTimeChangeListener(this);

        setTitle("Horloge Graphique");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelHeure = new JLabel("", JLabel.CENTER);
        labelHeure.setFont(new Font("Arial", Font.BOLD, 32));

        JPanel panel = new JPanel();
        panel.add(labelHeure);

        add(panel);
        setVisible(true);

        afficherHeure();
    }

    private void afficherHeure() {
        labelHeure.setText(String.format("%02d:%02d:%02d",
                timerService.getHeures(),
                timerService.getMinutes(),
                timerService.getSecondes()
        ));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (!SECONDE_PROP.equals(evt.getPropertyName())) return;
        afficherHeure();
    }
}

package org.emp.gl.time.service.impl;

import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class DummyTimeServiceImpl implements TimerService {

    private int dixiemeDeSeconde;
    private int minutes;
    private int secondes;
    private int heures;

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public DummyTimeServiceImpl() {
        setTimeValues();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeChanged();
            }
        }, 100, 100);
    }

    private void setTimeValues() {
        LocalTime localTime = LocalTime.now();

        setSecondes(localTime.getSecond());
        setMinutes(localTime.getMinute());
        setHeures(localTime.getHour());
        setDixiemeDeSeconde(localTime.getNano() / 100_000_000);
    }

    @Override
    public void addTimeChangeListener(TimerChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }

    @Override
    public void removeTimeChangeListener(TimerChangeListener l) {
        pcs.removePropertyChangeListener(l);
    }

    private void timeChanged() {
        setTimeValues();
    }

    public void setDixiemeDeSeconde(int newValue) {
        if (dixiemeDeSeconde == newValue) return;

        int oldValue = dixiemeDeSeconde;
        dixiemeDeSeconde = newValue;

        pcs.firePropertyChange(TimerChangeListener.DIXEME_DE_SECONDE_PROP, oldValue, newValue);
    }

    public void setSecondes(int newValue) {
        if (secondes == newValue) return;

        int oldValue = secondes;
        secondes = newValue;

        pcs.firePropertyChange(TimerChangeListener.SECONDE_PROP, oldValue, newValue);
    }

    public void setMinutes(int newValue) {
        if (minutes == newValue) return;

        int oldValue = minutes;
        minutes = newValue;

        pcs.firePropertyChange(TimerChangeListener.MINUTE_PROP, oldValue, newValue);
    }

    public void setHeures(int newValue) {
        if (heures == newValue) return;

        int oldValue = heures;
        heures = newValue;

        pcs.firePropertyChange(TimerChangeListener.HEURE_PROP, oldValue, newValue);
    }

    @Override
    public int getDixiemeDeSeconde() {
        return dixiemeDeSeconde;
    }

    @Override
    public int getHeures() {
        return heures;
    }

    @Override
    public int getMinutes() {
        return minutes;
    }

    @Override
    public int getSecondes() {
        return secondes;
    }
}

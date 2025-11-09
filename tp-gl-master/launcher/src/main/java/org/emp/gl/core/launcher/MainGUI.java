package org.emp.gl.core.launcher;

import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.clients.HorlogeGraphique;
import org.emp.gl.timer.service.TimerService;

public class MainGUI {
    public static void main(String[] args) {
        TimerService ts = new DummyTimeServiceImpl();
        new HorlogeGraphique(ts);
    }
}


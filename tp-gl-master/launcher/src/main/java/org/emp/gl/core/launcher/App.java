package org.emp.gl.core.launcher;
import org.emp.gl.clients.Horloge ;import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;
/** * Hello world!
 * */
public class App {
    public static void main(String[] args) {
        TimerService timerService;
        timerService=new DummyTimeServiceImpl();
        Horloge horloge=new Horloge("Horloge1",timerService);
        Horloge horloge1=new Horloge("Horloge2",timerService);
        Horloge horloge2=new Horloge("Horloge3",timerService);
        horloge.afficherHeure();
        horloge1.afficherHeure();
        horloge2.afficherHeure();
    }
    public static void clearScreen() {        System.out.print("\033[H\033[2J");
        System.out.flush();    }
    }
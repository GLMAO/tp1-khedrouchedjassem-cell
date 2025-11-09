package org.emp.gl.core.launcher;
import org.emp.gl.clients.CompteARebours;
import org.emp.gl.clients.Horloge ;import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;
/** * Hello world!
 * */
public class App {

        public static void main(String[] args) {

            TimerService ts = new DummyTimeServiceImpl();

            new Horloge("H1", ts);
            new Horloge("H2", ts);

            new CompteARebours("CB-1", 5, ts);
            new CompteARebours("CB-2", 8, ts);
            new CompteARebours("CB-3", 12, ts);

            // Rien d'autre à faire, timer démarre automatiquement
        }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();    }
    }
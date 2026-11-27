package java.ejemplos._04EsperarConTiempoYTerminar;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class EsperarConTiempoYterminar {
    public static void main(String[] args) throws IOException, InterruptedException {
        Process hijo = new ProcessBuilder("sleep", "10").start();
        System.out.println("Lanzado 'sleep 10' con PID " + hijo.pid() + ". Le doy 3 segundos...");
        // waitFor con tiempo: devuelve true si terminó a tiempo, false si no
        boolean terminado = hijo.waitFor(3, TimeUnit.SECONDS);
        if (terminado) {
            System.out.println("Terminó a tiempo con código " + hijo.exitValue());
        } else {
            System.out.println("Se ha pasado de tiempo: lo termino (SIGTERM)");
            hijo.destroy(); // equivale a kill PID (señal 15)
            hijo.waitFor(); // esperamos a que muera de verdad
            System.out.println("¿Sigue vivo? " + hijo.isAlive() + " · código: " +

                    hijo.exitValue());
        }
    }
}

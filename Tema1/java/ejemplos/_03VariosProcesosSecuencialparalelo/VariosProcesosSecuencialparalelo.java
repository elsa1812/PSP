package java.ejemplos._03VariosProcesosSecuencialparalelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VariosProcesosSecuencialparalelo {
    public static void main(String[] args) throws IOException, InterruptedException {
        // ---- SECUENCIAL: lanzo uno y espero a que acabe antes de lanzar el siguiente
        long inicio = System.currentTimeMillis();
        for (int i = 1; i <= 3; i++) {
            Process p = new ProcessBuilder("sleep", "2").start();
            p.waitFor(); // espero AQUÍ, dentro del bucle
            System.out.println("Secuencial: terminado el hijo " + i);
        }
        System.out.println("Tiempo secuencial: " + (System.currentTimeMillis() - inicio) + "ms\n");
        // ---- PARALELO: primero lanzo todos, después espero a todos
        inicio = System.currentTimeMillis();
        List<Process> hijos = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            hijos.add(new ProcessBuilder("sleep", "2").start()); // no espero
        }
        for (int i = 0; i < hijos.size(); i++) {
            hijos.get(i).waitFor(); // ahora sí espero, fuera del bucle de lanzamiento
            System.out.println("Paralelo: terminado el hijo " + (i + 1));
        }
        System.out.println("Tiempo en paralelo: " + (System.currentTimeMillis() - inicio) + " ms");
    }
}

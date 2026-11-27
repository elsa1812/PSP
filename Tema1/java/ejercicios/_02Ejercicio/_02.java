package java.ejercicios._02Ejercicio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _02 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Process hijo = new ProcessBuilder("ps", "-ef").start();
        BufferedReader lector = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
        int java = 0;
        String linea;
        while ((linea = lector.readLine()) != null) {
            if (linea.contains("java")) {
                java++;
                System.out.println(linea);
            }
        }
        System.out.println("Procesos con 'java': " + java + " (código " + hijo.waitFor() + ")");
    }
}

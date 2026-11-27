package java.ejercicios._04Ejercicio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _04 {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("ls", "/etc/hostname", "/no/existe");
        pb.redirectErrorStream(true); // stderr se mezcla con stdout
        Process hijo = pb.start();
        BufferedReader lector = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
        String linea;
        while ((linea = lector.readLine()) != null) {
            System.out.println("El hijo dice: " + linea);
        }
        System.out.println("Código de salida: " + hijo.waitFor());
    }
}

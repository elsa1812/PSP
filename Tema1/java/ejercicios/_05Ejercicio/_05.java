package java.ejercicios._05Ejercicio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _05 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Process hijo = new ProcessBuilder("bash", "-c", "ps -ef | wc -l").start();
        BufferedReader lector = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
        System.out.println("Procesos (con cabecera): " + lector.readLine().trim());
        System.out.println("Código de salida: " + hijo.waitFor());
    }
}

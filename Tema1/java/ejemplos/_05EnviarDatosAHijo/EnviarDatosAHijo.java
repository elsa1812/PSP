package java.ejemplos._05EnviarDatosAHijo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class EnviarDatosAHijo {
    public static void main(String[] args) throws IOException, InterruptedException {
        Process hijo = new ProcessBuilder("sort").start();
        // Lo que el padre ESCRIBE le llega al hijo por su entrada estándar
        // (getOutputStream)
        PrintWriter escritor = new PrintWriter(hijo.getOutputStream());
        String[] alumnos = { "Marta", "Carlos", "Lucía", "Ana", "Pedro" };
        for (String nombre : alumnos) {
            escritor.println(nombre);
        }
        escritor.close(); // ¡IMPRESCINDIBLE! Cierra el canal: el hijo recibe EOF
        BufferedReader lector = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
        System.out.println("Lista ordenada por el proceso hijo:");
        String linea;
        while ((linea = lector.readLine()) != null) {
            System.out.println(" " + linea);
        }
        System.out.println("Código de salida de sort: " + hijo.waitFor());
    }
}

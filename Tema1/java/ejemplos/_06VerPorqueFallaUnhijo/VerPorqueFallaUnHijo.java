package java.ejemplos._06VerPorqueFallaUnhijo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VerPorqueFallaUnHijo {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Cambia la ruta por "/etc" para ver el caso en que todo va bien
        Process hijo = new ProcessBuilder("ls", "/no/existe").start();
        // 1. Leemos la salida normal del hijo (stdout)
        BufferedReader salida = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
        String linea;
        while ((linea = salida.readLine()) != null) {
            System.out.println("Salida: " + linea);
        }
        // 2. Esperamos y mostramos SIEMPRE el código de salida
        int codigo = hijo.waitFor();
        System.out.println("Código de salida: " + codigo);
        // 3. Si no es 0, leemos los errores del hijo (stderr): ahí está el motivo
        if (codigo != 0) {
            BufferedReader errores = new BufferedReader(new

            InputStreamReader(hijo.getErrorStream()));

            while ((linea = errores.readLine()) != null) {
                System.out.println("Motivo del error: " + linea);
            }
        }
    }
}

package java.ejercicios._01Ejercicio;

import java.io.IOException;

public class _01 {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("ls", "-l", "/no/existe");
        pb.inheritIO();
        Process hijo = pb.start();
        int codigo = hijo.waitFor();
        if (codigo == 0) {
            System.out.println("Listado correcto");
        } else {
            System.out.println("ls ha fallado con código " + codigo);
        }
    }
}

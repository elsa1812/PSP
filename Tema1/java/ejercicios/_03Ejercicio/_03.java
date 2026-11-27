package java.ejercicios._03Ejercicio;

import java.io.File;
import java.io.IOException;

public class _03 {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("ls");
        pb.directory(new File("/etc")); // carpeta de trabajo del hijo, como hacer "cd /etc"
        pb.inheritIO();
        int codigo = pb.start().waitFor();
        System.out.println("Código de salida: " + codigo);
    }
}

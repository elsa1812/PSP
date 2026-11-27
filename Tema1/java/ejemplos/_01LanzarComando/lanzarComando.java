package java.ejemplos._01LanzarComando;

import java.io.IOException;

public class lanzarComando {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 1. Preparamos el proceso: comando y argumentos, cada uno por separado
        ProcessBuilder pb = new ProcessBuilder("ls", "-l");
        // 2. El hijo usará la misma entrada/salida que el padre (nuestra terminal)
        pb.inheritIO();
        // 3. Lanzamos el proceso hijo
        Process hijo = pb.start();
        System.out.println("He lanzado un proceso hijo con PID " + hijo.pid());
        // 4. Esperamos a que termine y recogemos su código de salida
        int codigo = hijo.waitFor();
        System.out.println("El hijo ha terminado con código " + codigo + (codigo == 0 ? " (todo bien)" : " (error)"));
    }

}
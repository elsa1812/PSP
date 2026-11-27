package Tema2.ejemplos._15HIlosVirtualesJava21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class HilosVirtualesJava21 {
    public static void main(String[] args) {
        AtomicInteger hechas = new AtomicInteger();
        long inicio = System.currentTimeMillis();
        // try-with-resources: al salir del bloque se espera a que terminen todas las
        // tareas
        try (ExecutorService ex = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10_000; i++) {
                ex.submit(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    hechas.incrementAndGet();
                });
            }
        }
        System.out.println("Tareas terminadas: " + hechas.get());
        System.out.println("Tiempo: " + (System.currentTimeMillis() - inicio) + " ms");
    }
}

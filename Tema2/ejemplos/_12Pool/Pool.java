package Tema2.ejemplos._12Pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Pool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= 6; i++) {
            int n = i; // la lambda necesita una variable que no cambie
            pool.submit(() -> {
                System.out.println("Tarea " + n + " la ejecuta " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            });
        }

        pool.shutdown(); // no admite tareas nuevas
        pool.awaitTermination(1, TimeUnit.MINUTES); // espera a que acaben las enviadas
        System.out.println("Tiempo total: " + (System.currentTimeMillis() - inicio) + " ms");
    }
}

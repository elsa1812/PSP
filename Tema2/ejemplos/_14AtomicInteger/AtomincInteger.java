package Tema2.ejemplos._14AtomicInteger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomincInteger {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger contador = new AtomicInteger(0);
        ExecutorService pool = Executors.newFixedThreadPool(4);
        for (int t = 0; t < 4; t++) {
            pool.submit(() -> {
                for (int k = 0; k < 1_000_000; k++) {
                    contador.incrementAndGet(); // leer, sumar y escribir en una sola operación atómica
                }
            });
        }
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Valor final: " + contador.get() + " (esperado: 4000000)");
    }
}

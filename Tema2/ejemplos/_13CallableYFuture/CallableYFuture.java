package Tema2.ejemplos._13CallableYFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableYFuture {
    static class Consulta implements Callable<Integer> {
        private final String aerolinea;
        private final int segundos;
        private final int precio;

        Consulta(String aerolinea, int segundos, int precio) {
            this.aerolinea = aerolinea;
            this.segundos = segundos;
            this.precio = precio;
        }

        @Override
        public Integer call() throws InterruptedException { // call() puede devolver y lanzar
            System.out.println("Preguntando a " + aerolinea + " (" + Thread.currentThread().getName() +
                    ")");
            Thread.sleep(segundos * 1000L);
            return precio;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String[] aerolineas = { "Iberia", "Vueling", "Ryanair" };
        int[] segundos = { 2, 1, 3 };
        int[] precios = { 120, 95, 80 };
        ExecutorService pool = Executors.newFixedThreadPool(3);
        long inicio = System.currentTimeMillis();
        List<Future<Integer>> futuros = new ArrayList<>();
        for (int i = 0; i < aerolineas.length; i++) {
            futuros.add(pool.submit(new Consulta(aerolineas[i], segundos[i], precios[i])));
        }
        int mejor = Integer.MAX_VALUE;
        String donde = "";
        for (int i = 0; i < futuros.size(); i++) {
            int precio = futuros.get(i).get(); // get() espera a que ESA tarea termine
            System.out.println(aerolineas[i] + ": " + precio + " €");
            if (precio < mejor) {
                mejor = precio;
                donde = aerolineas[i];
            }
        }
        pool.shutdown();
        System.out.println("Más barato: " + donde + " (" + mejor + " €)");
        System.out.println("Tiempo: " + (System.currentTimeMillis() - inicio) + " ms");
    }
}

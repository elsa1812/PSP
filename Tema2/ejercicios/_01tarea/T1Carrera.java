package Tema2._01tarea.T1Carrera;

import java.util.ArrayList;
import java.util.List;

public class T1Carrera {
    static final String[] NOMBRES = {"Tortuga", "Liebre", "Caracol"};
    static final int[] PAUSAS = {300, 100, 500};
    static final int TRAMOS = 5;

    static class Corredor implements Runnable {
        private final String nombre;
        private final int pausa;

        Corredor(String nombre, int pausa) {
            this.nombre = nombre;
            this.pausa = pausa;
        }

        @Override
        public void run() {
            for (int tramo = 1; tramo <= TRAMOS; tramo++) {
            	try {
            	    Thread.sleep(pausa);
            	} catch (InterruptedException e) {
            	    return;
            	}                
                System.out.println(nombre + " · tramo " + tramo + " (hilo " + Thread.currentThread().getName() + ")");
            }
            System.out.println(">>> " + nombre + " llega a la meta");
        }
    }

    public static void main(String[] args) throws InterruptedException {
    	System.out.println("===== SIN HILOS =====");
        long inicio = System.currentTimeMillis();
        for (int i = 0; i < NOMBRES.length; i++) {
        	Corredor c = new Corredor(NOMBRES[i], PAUSAS[i]);
        	c.run();
        }
        long tSin = System.currentTimeMillis() - inicio;
        System.out.println("Tiempo sin hilos: " + tSin + " ms\n");

        System.out.println("===== CON HILOS =====");
        inicio = System.currentTimeMillis();
        List<Thread> hilos = new ArrayList<>();
        for (int i = 0; i < NOMBRES.length; i++) {
        	Thread h = new Thread(new Corredor(NOMBRES[i], PAUSAS[i]), "Hilo-" + NOMBRES[i]);
        	hilos.add(h);
        	h.start();

}
        for (Thread h : hilos) {
        	h.join();
        }
        long tCon = System.currentTimeMillis() - inicio;
        System.out.println("Tiempo con hilos: " + tCon + " ms\n");

        System.out.printf("Con hilos ha sido %.1f veces más rápido%n", (double) tSin / tCon);
        }
    
}
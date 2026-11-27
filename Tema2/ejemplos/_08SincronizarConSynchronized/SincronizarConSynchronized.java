package Tema2.ejemplos._08SincronizarConSynchronized;

public class SincronizarConSynchronized {
    static class Contador {
        private int valor = 0;

        // synchronized: solo un hilo a la vez puede ejecutar este método sobre el mismo
        // objeto
        public synchronized void incrementar() {
            valor++;
        }

        public synchronized int getValor() {
            return valor;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Contador c = new Contador();
        long inicio = System.currentTimeMillis();
        Thread[] hilos = new Thread[4];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(() -> {
                for (int k = 0; k < 1_000_000; k++) {
                    c.incrementar();
                }
            }, "Hilo-" + (i + 1));
            hilos[i].start();
        }
        for (Thread h : hilos) {
            h.join();
        }
        System.out.println("Valor final: " + c.getValor() + " (esperado: 4000000)");
        System.out.println("Tiempo: " + (System.currentTimeMillis() - inicio) + " ms");
    }
}

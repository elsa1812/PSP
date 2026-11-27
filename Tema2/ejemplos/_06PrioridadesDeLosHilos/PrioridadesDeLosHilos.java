package Tema2.ejemplos._06PrioridadesDeLosHilos;

public class PrioridadesDeLosHilos {
    /** Cuenta todo lo que puede durante 1 segundo y muestra el resultado. */
    static void contar() {
        long fin = System.currentTimeMillis() + 1000;
        long n = 0;
        while (System.currentTimeMillis() < fin) {
            n++;
        }
        Thread yo = Thread.currentThread();
        System.out.println(yo.getName() + " (prioridad " + yo.getPriority() + ") ha contado hasta " +
                n);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Prioridad de main: " + Thread.currentThread().getPriority());
        Thread lento = new Thread(PrioridadesDeLosHilos::contar, "Baja");
        Thread rapido = new Thread(PrioridadesDeLosHilos::contar, "Alta");
        lento.setPriority(Thread.MIN_PRIORITY); // 1
        rapido.setPriority(Thread.MAX_PRIORITY); // 10
        lento.start();
        rapido.start();
        lento.join();
        rapido.join();
    }
}

package Tema2.ejemplos._07CondicionDeCarrera;

public class CondicionDeCarrera {
    static class Contador {

        private int valor = 0;

        public void incrementar() {
            valor++; // parece una sola operación, pero son tres: leer, sumar y escribir
        }

        public int getValor() {
            return valor;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Contador c = new Contador(); // UN solo objeto, compartido por los 4 hilos
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

    }

}

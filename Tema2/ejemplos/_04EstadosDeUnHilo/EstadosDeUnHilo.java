package Tema2.ejemplos._04EstadosDeUnHilo;



public class EstadosDeUnHilo {
    public static void main(String[] args) throws InterruptedException {
        // Dormilon: dice su estado y se duerme 2 segundos
        Thread dormilon = new Thread(() -> {
            System.out.println(" (Dormilon) estoy en marcha: " + Thread.currentThread().getState());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(" (Dormilon) me han interrumpido");
            }
        }, "Dormilon");
        // Esperador: espera, sin límite de tiempo, a que Dormilon termine
        Thread esperador = new Thread(() -> {
            try {
                dormilon.join();
            } catch (InterruptedException e) {
                System.out.println(" (Esperador) me han interrumpido");
            }
        }, "Esperador");
        System.out.println("1) Dormilon recién creado: " + dormilon.getState()); // NEW
        dormilon.start();
        esperador.start();
        Thread.sleep(500); // main espera medio segundo para que los dos hilos ya estén esperando
        System.out.println("2) Dormilon mientras duerme: " + dormilon.getState()); // TIMED_WAITING
        System.out.println("3) Esperador mientras espera: " + esperador.getState()); // WAITING
        esperador.join(); // main espera a que terminen los dos
        System.out.println("4) Dormilon al terminar: " + dormilon.getState()); // TERMINATED
        System.out.println(" ¿Sigue vivo Dormilon? " + dormilon.isAlive());
    }
}
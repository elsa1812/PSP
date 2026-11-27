package Tema2.ejemplos._05TerminarHiloConInterrupt;

public class TerminarHiloConInterrupt {
    public static void main(String[] args) throws InterruptedException{
        Thread reloj = new Thread(() -> {
            int tic = 0;
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // Nos han interrumpido mientras dormíamos: terminamos ordenadamente
                    System.out.println("Reloj: me han interrumpido, termino");
                    return;
                }
                tic++;
                System.out.println("Reloj: tic " + tic);
            }
        }, "Reloj");
        reloj.start();
        Thread.sleep(2200); // dejamos que haga unos cuantos tic
        System.out.println("main: pido al reloj que pare");
        reloj.interrupt(); // no lo mata: le avisa
        reloj.join();
        System.out.println("main: el reloj ha terminado (estado " + reloj.getState() + ")");
    }
}

package Tema2.ejemplos._11Interbloqueo;

public class Interbloqueo {
    static final boolean MISMO_ORDEN = false;
    static final Object IMPRESORA = new Object();
    static final Object ESCANER = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread ana = new Thread(() -> {
            synchronized (IMPRESORA) {
                System.out.println("Ana tiene la impresora y quiere el escáner");
                dormir(100);
                synchronized (ESCANER) {
                    System.out.println("Ana tiene los dos: imprime y escanea");
                }
            }
        }, "Ana");
        Thread luis = new Thread(() -> {
            Object primero = MISMO_ORDEN ? IMPRESORA : ESCANER;
            Object segundo = MISMO_ORDEN ? ESCANER : IMPRESORA;
            synchronized (primero) {
                System.out.println("Luis tiene " + nombre(primero) + " y quiere " + nombre(segundo));
                dormir(100);
                synchronized (segundo) {
                    System.out.println("Luis tiene los dos: imprime y escanea");
                }
            }
        }, "Luis");
        ana.start();
        luis.start();
        ana.join(3000); // espera como mucho 3 s a cada uno
        luis.join(3000);
        if (ana.isAlive() || luis.isAlive()) {
            System.out.println("INTERBLOQUEO: estado de Ana " + ana.getState() + ", de Luis " +
                    luis.getState());
            System.exit(1); // terminamos el programa a la fuerza
        }
        System.out.println("Los dos han terminado: no hay interbloqueo");
    }

    static String nombre(Object recurso) {
        return recurso == IMPRESORA ? "la impresora" : "el escáner";
    }

    static void dormir(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }
}

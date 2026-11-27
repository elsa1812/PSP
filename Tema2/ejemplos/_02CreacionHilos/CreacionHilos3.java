package ut2.ejemplos._02CreacionHilos;

public class CreacionHilos3 {
	// Bloque general final (el main)
	public static void main(String[] args) throws InterruptedException {
		// Forma 3: el Runnable escrito como una lambda directamente en el Thread
		Thread h3 = new Thread(() -> {
			for (int i = 1; i <= 3; i++) {
				System.out.println(Thread.currentThread().getName() + " (lambda) · paso " + i);
			}
		}, "Hilo-C");

		// Arrancarlo
		h3.start();
		System.out.println("main: he lanzado el hilo");

		// Esperar a que termine
		h3.join();
		System.out.println("main: el hilo ha terminado");
	}
}

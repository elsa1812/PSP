package Tema2.ejemplos._02CreacionHilos;

public class CreacionHilos2 {
	// Forma 2: implementar Runnable y dárselo a un Thread
	static class Tarea implements Runnable {
		@Override
		public void run() {
			for (int i = 1; i <= 3; i++) {
				System.out.println(Thread.currentThread().getName() + " (Runnable) · paso " + i);
			}
		}
	}

	// Bloque general final (el main)
	public static void main(String[] args) throws InterruptedException {
		// 1. Crear el Thread pasándole la Tarea (Runnable) y su nombre
		Thread h2 = new Thread(new Tarea(), "Hilo-B");

		// 2. Arrancarlo
		h2.start();
		System.out.println("main: he lanzado el hilo");

		// 3. Esperar a que termine
		h2.join();
		System.out.println("main: el hilo ha terminado");
	}
}

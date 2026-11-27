package Tema2.ejemplos._02CreacionHilos;

public class CreacionHilos1 {
	// Forma 1: heredar de Thread y escribir lo que hace el hilo en run()
	static class HiloHeredado extends Thread {
		@Override
		public void run() {
			for (int i = 1; i <= 3; i++) {
				System.out.println(getName() + " (extends Thread) · paso " + i);
			}
		}
	}

	// Bloque general final (el main)
	public static void main(String[] args) throws InterruptedException {
		// 1. Crear el hilo y darle nombre
		Thread h1 = new HiloHeredado();
		h1.setName("Hilo-A");

		// 2. Arrancarlo
		h1.start();
		System.out.println("main: he lanzado el hilo");

		// 3. Esperar a que termine
		h1.join();
		System.out.println("main: el hilo ha terminado");
	}

}

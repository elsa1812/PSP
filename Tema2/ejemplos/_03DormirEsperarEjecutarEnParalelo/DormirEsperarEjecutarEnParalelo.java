package Tema2.ejemplos._03DormirEsperarEjecutarEnParalelo;

import java.util.ArrayList;
import java.util.List;

public class DormirEsperarEjecutarEnParalelo {
	/**
	 * Simula un trabajo que tarda 2 segundos (por ejemplo, descargar un fichero).
	 */
	static void trabajar(String nombre) {
		System.out.println(nombre + " empieza (hilo " + Thread.currentThread().getName() + ")");
		try {
			Thread.sleep(2000); // el hilo se duerme 2000 ms = 2 s
		} catch (InterruptedException e) {
			System.out.println(nombre + " interrumpida");
		}
		System.out.println(nombre + " termina");
	}

	public static void main(String[] args) throws InterruptedException {
// ---- SECUENCIAL (sin crear hilos): las tres tareas las hace el hilo main,
// que lo crea la JVM al arrancar el programa, una detrás de otra
		long inicio = System.currentTimeMillis();
		for (int i = 1; i <= 3; i++) {
			trabajar("Tarea " + i);
		}
		System.out.println("Tiempo secuencial: " + (System.currentTimeMillis() - inicio) + " ms\n");
// ---- PARALELO: un hilo por tarea; primero se arrancan todos y después se espera a todos
		inicio = System.currentTimeMillis();
		List<Thread> hilos = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			String nombre = "Tarea " + i;
			Thread h = new Thread(() -> trabajar(nombre), "Hilo-" + i);
			hilos.add(h);
			h.start(); // no espera: sigue con la siguiente vuelta
		}
		for (Thread h : hilos) {
			h.join(); // ahora sí espera, fuera del bucle de arranque
		}
		System.out.println("Tiempo en paralelo: " + (System.currentTimeMillis() - inicio) + " ms");
	}
}
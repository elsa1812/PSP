package ut2.ejemplos._03StartFrenteRun;

public class StartFrenteRun {
	public static void main(String[] args) throws InterruptedException {
		Runnable tarea = () -> System.out.println("Esta línea la ejecuta el hilo: " + Thread.currentThread().getName());
		Thread h = new Thread(tarea, "Trabajador");
		System.out.println("1) Llamo a run():");
		h.run(); // MAL: llamada normal, no se crea ningún hilo -> la ejecuta main
		System.out.println("2) Llamo a start():");
		h.start(); // BIEN: se crea el hilo "Trabajador" y él ejecuta run()
		h.join();
	}
}

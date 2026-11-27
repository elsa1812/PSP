package ut2.ejemplos._01PrimerProceso;

public class Hola {
	public static void main(String[] args) {
		System.out.println("Soy el proceso " + ProcessHandle.current().pid()+ " y esta línea la ejecuta el hilo " +Thread.currentThread().getName());
		
	}
}

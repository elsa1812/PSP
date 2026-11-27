package Tema2.ejemplos._09ProductorYConsumidorConBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProductorYConsumidorConBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> cola = new ArrayBlockingQueue<>(3); // caben 3 pedidos
        Thread cocina = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    String pedido = "pizza " + i;
                    System.out.println("Cocina prepara " + pedido);
                    cola.put(pedido); // si la cola está llena, espera aquí
                }
            } catch (InterruptedException e) {
            }
        }, "Cocina");
        Thread repartidor = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    String pedido = cola.take(); // si la cola está vacía, espera aquí
                    System.out.println(" Repartidor lleva " + pedido);
                    Thread.sleep(500); // repartir tarda más que cocinar
                }
            } catch (InterruptedException e) {
            }
        }, "Repartidor");
        cocina.start();
        repartidor.start();
        cocina.join();
        repartidor.join();
        System.out.println("Todos los pedidos entregados");
    }
}

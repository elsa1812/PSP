package java.ejemplos._00HolaPID;

public class HolaPID {
    public static void main(String[] args) {
        System.out.println("Hola, soy un programa Java y mi PID es " + ProcessHandle.current().pid());
    }
}

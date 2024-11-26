import java.util.Scanner;
public class RelojDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tiempo en segundos desde la medianoche: ");
        int segundosIniciales = scanner.nextInt();
        reloj1 reloj = new reloj1(segundosIniciales);
        System.out.println("Hora inicial: " + reloj);
        for (int i = 0; i < 10; i++) {
            reloj.tick();
            System.out.println("Hora después de tick " + (i + 1) + ": " + reloj);
        }
        reloj1 otroReloj = new reloj1(7200);
        int diferencia = reloj.restaReloj(otroReloj);
        System.out.println("La diferencia en segundos es: " + diferencia);
    }
}
import java.util.Scanner;
public class Ejercicio06 {
    public static void main(String[] args) {
        final double IVA = 0.10;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        double total = precio + (precio * IVA);
        System.out.printf("El total del precio con IVA es: %.2f/n", total);

        scanner.close();

    }
}

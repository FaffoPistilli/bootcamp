import java.util.Scanner;
public class Ejercicio05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un numero: ");
        int numero = scanner.nextInt();
        if (numero % 2 == 0) {
            System.out.println("El numero" + numero + " es divisible entre dos");
        } else {
            System.out.println("El numero" + numero + " NO es divisible entre dos");
            }
        scanner.close();
        }
    }

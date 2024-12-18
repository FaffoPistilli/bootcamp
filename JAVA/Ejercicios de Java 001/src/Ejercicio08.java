import java.util.Scanner;
public class Ejercicio08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Num;
        do {
            System.out.print("Ingrese un numero mayor o igual a 0: ");
            Num = scanner.nextInt();
        } while (Num < 0);

        System.out.println("El numero ingresado es: " + Num);
        scanner.close();
    }
}
import java.util.Scanner;
public class Ejercicio04 {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       System.out.println("Ingrese su nombre: ");
       String nombre = scanner.nextLine();
       System.out.println("Bienvenido: " + nombre);
       scanner.close();
   }
}

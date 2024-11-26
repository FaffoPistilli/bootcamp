import java.util.Scanner;
public class Ejercicio09 {
    public static void main(String[] args) {
        String ContraseñaCualquiera = "asboo22";
        Scanner scanner = new Scanner(System.in);
        String ContraseñaIngresada;
        int Intentos = 0;
        boolean aciertos = false;
        while (Intentos < 3 ) {
                System.out.print("Introduzca la contraseña: ");
                ContraseñaIngresada = scanner.nextLine();
                if (ContraseñaIngresada.equals(ContraseñaCualquiera)) {
                    aciertos = true;
                    break;
                } else {
                    Intentos++;
                    System.out.println("Contraseña incorrecta. Te quedan "+ (3 - Intentos) + "Intentos.");
                }
        }
        if (aciertos) {
            System.out.println("CORRECTO!");
        } else {
            System.out.println("FALLASTE JAJA!!");
        }

         scanner.close();}
}

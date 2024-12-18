import java.util.Scanner;
public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un dia de la semana: ");
        String dia = scanner.nextLine();
        if (dia.equals("lunes") || (dia.equals("martes") || (dia.equals("miercoles") || (dia.equals("jueves") || (dia.equals("viernes")))))) {
            System.out.println(dia + " Es un dia laboral");
        } else if (dia.equals("sabado") || (dia.equals("domingo"))) {
            System.out.println(dia + " NO es un dia laboral");
        } else {
            System.out.println("dia invalido, por favor ingrese un dia de la semana valido.");
    }
        scanner.close();
}
}

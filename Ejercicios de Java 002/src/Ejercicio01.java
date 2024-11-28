import java.util.Random;
public class Ejercicio01 {
    public static void main(String[] args) {
        Random rand = new Random();
        int capacidad = 10;
        int[] array = new int[capacidad];
        for (int i = 0; i < capacidad; i++) {
            array[i] = rand.nextInt(11) - 5;
            System.out.print("Array generado: ");
        }
        for (int Num : array) {
            System.out.print(Num + " ");
        }

        int Max = array[0];
        for (int i = 1; i < capacidad; i++) {
            if (Max < array[i]) {
                Max = array[i];
            }
        }
        System.out.println("\nEl elemento mayor del array es: " + Max);
    }
}

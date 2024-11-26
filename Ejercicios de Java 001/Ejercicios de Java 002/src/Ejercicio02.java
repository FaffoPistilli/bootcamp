import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
public class Ejercicio02 {
    public static void main(String[] args) {
        int capacidad = 100;
        int[] array = new int[capacidad];
        for (int i = 0; i < capacidad; i++) {
            array[i] = (int) (Math.random() * 61) - 30;
        }
        System.out.print("Array generado: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
        Map<Integer, Integer> contador = new HashMap<>();
        for (int num : array) {
            contador.put(num, contador.getOrDefault(num, 0) + 1);
        }
        int NumMasRepetido = array[0];
        int MaxRep = contador.get(NumMasRepetido);

        for (Map.Entry<Integer, Integer> entry : contador.entrySet()) {
            if (entry.getValue() > MaxRep) {
                NumMasRepetido = entry.getKey();
                MaxRep = entry.getValue();
            }
        }
        System.out.println("El numero que mas veces se repite es: " + NumMasRepetido + " con " + MaxRep + " repeticiones.");
        System.out.println("Los numeros que no estan presentes son:");
        boolean hayFaltantes = false;
        for (int i = -30; i <= 30; i++) {
            if (!contador.containsKey(i)) {
                System.out.print(i + " ");
                hayFaltantes = true;
            }
        }

        if (!hayFaltantes) {
            System.out.println("No hay numeros ausentes.");
        }
        Arrays.sort(array);
        System.out.print("\nArray ordenado: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}


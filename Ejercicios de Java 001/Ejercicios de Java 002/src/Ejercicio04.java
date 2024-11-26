public class Ejercicio04 {
    public static void main(String[] args) {
        String cadena = "1234567890";
        int[] arrayNros = Convertir_Cadena_a_Nros(cadena);
        System.out.print("El array de numeros es: ");
        for (int numero : arrayNros)
            System.out.print(numero + " ");
    }

    public static int[] Convertir_Cadena_a_Nros(String cadena) {
        int[] array = new int[cadena.length()];
        for (int i = 0; i < cadena.length(); i++) {
            array[i] = cadena.charAt(i) - '0';
        }
        return array;
    }
}

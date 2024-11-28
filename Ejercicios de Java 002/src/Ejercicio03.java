public class Ejercicio03 {
    public static void main(String[] args) {
        String[] Palabras_Frases = {
                "MADAM",
                "RACECAR",
                "AMORE, ROMA",
                "BORROW OR ROB",
                "WAS IT A CAR OR CAT I SAW?"
        };
        for (String palabra_frase : Palabras_Frases) {
            if (EsPalindromo(palabra_frase)) {
                System.out.println("\"" + palabra_frase + "\" es un palindromo");
            } else {
                System.out.println("\"" + palabra_frase + "\" no es un palindromo");
                }
            }
    }
        public static boolean EsPalindromo(String texto) {
            String limpio = texto.replaceAll ("[^a-zA-Z0-9]", "").toLowerCase();
            String reverso = new StringBuilder(limpio).reverse().toString();
            return limpio.equals(reverso);
        }
}



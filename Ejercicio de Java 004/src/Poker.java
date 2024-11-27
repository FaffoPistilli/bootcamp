import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class Poker {
    public static String identificarJugada(Carta[] mano) {
        Arrays.sort(mano, (a, b) -> Integer.compare(a.getValorNum(), b.getValorNum()));
        boolean mismoPalo = Arrays.stream(mano).allMatch(c -> c.getPalo() == mano[0].getPalo());
        boolean secuencia = esSecuencia(mano);
        Map<Character, Integer> contadorValores = new HashMap<>();
        for (Carta carta : mano) {
            contadorValores.put(carta.getValor(), contadorValores.getOrDefault(carta.getValor(), 0) + 1 );
        }
        if (mismoPalo && secuencia) {
            return "Escalera Color";
        } else if (contadorPares(contadorValores) == 1 && contadorValores.containsValue(4)) {
            return "Poker";
        } else if (contadorPares(contadorValores) == 2) {
            return "Full";
        } else if (mismoPalo) {
            return "Color";
        } else if (secuencia) {
            return "Escalera";
        } else if (contadorPares(contadorValores) == 1) {
            return "Trio";
        } else if (contadorPares(contadorValores) == 2) {
            return "Doble Par";
        } else if (contadorPares(contadorValores) == 1) {
            return "Par";
        } else {
            return "Carta Alta";
        }
    }
    private static boolean esSecuencia(Carta[] mano) {
        for (int i = 0; i < mano.length - 1; i++) {
            if (mano[i].getValorNum() != mano[i + 1].getValorNum() -1) {
                return false;
            }
        }
        return true;
    }
    private static int contadorPares(Map<Character, Integer> contadorValores) {
        int pares = 0;
        for (int count : contadorValores.values()) {
            if (count == 2) {
                pares++;
            }
        }
        return pares;
    }
    public static void main(String[] args) {
        Carta[] mano = {
                new Carta('2', 'S'),
                new Carta('3', 'S'),
                new Carta('4', 'S'),
                new Carta('5', 'S'),
                new Carta('6', 'S')
        };
        System.out.println("Jugada: " + identificarJugada(mano));
    }
}

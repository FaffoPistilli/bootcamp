import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class Poker {
    public static Mano identificarJugada(Carta[] mano) {
        Arrays.sort(mano, (a, b) -> Integer.compare(a.getValorNum(), b.getValorNum()));
        boolean mismoPalo = Arrays.stream(mano).allMatch(c -> c.getPalo() == mano[0].getPalo());
        boolean secuencia = esSecuencia(mano);
        Map<Character, Integer> contadorValores = new HashMap<>();
        for (Carta carta : mano) {
            contadorValores.put(carta.getValor(), contadorValores.getOrDefault(carta.getValor(), 0) + 1 );
        }
        if (mismoPalo && secuencia) {
            return Mano.ESCALERA_COLOR;
        } else if (contadorPares(contadorValores) == 1 && contadorValores.containsValue(4)) {
            return Mano.POKER;
        } else if (contadorPares(contadorValores) == 2) {
            return Mano.FULL;
        } else if (mismoPalo) {
            return Mano.COLOR;
        } else if (secuencia) {
            return Mano.ESCALERA;
        } else if (contadorPares(contadorValores) == 1) {
            return Mano.TRIO;
        } else if (contadorPares(contadorValores) == 2) {
            return Mano.DOBLE_PAR;
        } else if (contadorPares(contadorValores) == 1) {
            return Mano.PAR;
        } else {
            return Mano.CARTA_ALTA;
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
    public static Carta[] determinarManoGanadora(Carta[][] manos) {
        Mano mejorMano = Mano.CARTA_ALTA;
        Carta[] manoGanadora = null;
        for (Carta[] mano : manos) {
            Mano Jugada = identificarJugada(mano);
            if (Jugada.getValor() > mejorMano.getValor()) {
                mejorMano = Jugada;
                manoGanadora = mano;
            } else if (Jugada.getValor() == mejorMano.getValor()) {
                manoGanadora = desempatarManos(mano, manoGanadora);
            }
        }
        return manoGanadora;
    }
    private static Carta[] desempatarManos(Carta[] mano1, Carta[] mano2) {
        Arrays.sort(mano1, (a, b) -> Integer.compare(a.getValorNum(), b.getValorNum()));
        Arrays.sort(mano2, (a, b) -> Integer.compare(a.getValorNum(), b.getValorNum()));
        for (int i = 0; i < mano1.length; i++) {
            if (mano1[i].getValorNum() > mano2[i].getValorNum()) {
                return mano1;
            } else if (mano1[i].getValorNum() < mano2[i].getValorNum()) {
                return mano2;
            }
        }
        return mano1;
    }
    public static void main(String[] args) {
        Carta[][] mano = {
                {
                        new Carta('7', 'H'),
                        new Carta('8', 'H'),
                        new Carta('9', 'H'),
                        new Carta('T', 'H'),
                        new Carta('J', 'H')
                },
                {
                        new Carta('9', 'D'),
                        new Carta('9', 'H'),
                        new Carta('9', 'S'),
                        new Carta('9', 'C'),
                        new Carta('9', 'H')
                },
                {
                        new Carta('A', 'H'),
                        new Carta('A', 'S'),
                        new Carta('K', 'S'),
                        new Carta('Q', 'D'),
                        new Carta('J', 'S')
                }
        };
        Carta[] manoGanadora = determinarManoGanadora(mano);
        System.out.println("La Mano GANADORA es:  " + Arrays.toString(manoGanadora));
    }
}

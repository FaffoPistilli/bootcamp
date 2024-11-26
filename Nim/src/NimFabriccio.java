import java.util.Scanner;
public class NimFabriccio {
    public static void mostrarPilas(int pila1, int pila2, int pila3) {
        System.out.println("Estados de Pilas: ");
        System.out.println("Pila 1: " + pila1 + " contador");
        System.out.println("Pila 2: " + pila2 + " contador");
        System.out.println("Pila 3: " + pila3 + " contador");
    }
    public static boolean FINdelJuego(int pila1, int pila2, int pila3) {
        return pila1 == 0 && pila2 == 0 && pila3 == 0;
    }
    public static void turnodelJugador(String nombredelJugador,Scanner scanner, int [] pilas) {
        boolean turnoValido = false;
        mostrarPilas(pilas[0], pilas[1], pilas[2]);
        while (!turnoValido) {
            System.out.println(nombredelJugador + " Por favor, seleccione una Pila (1, 2, o 3): ");
            int pilaSeleccionada = scanner.nextInt() - 1;
            if (pilaSeleccionada < 0 || pilaSeleccionada > 2 || pilas[pilaSeleccionada] == 0) {
                System.out.println("Pila Invalida. Por favor seleccione otra diferente");
                continue;
            }
            System.out.println("Cuantos contadores deseas quitar de la pila " + (pilaSeleccionada + 1) + "( 1 a " + pilas[pilaSeleccionada] + " contador): ");
            int contadorQuitar = scanner.nextInt();
            if (contadorQuitar < 1 || contadorQuitar > pilas[pilaSeleccionada]) {
                System.out.println("Numero de Contador Invalido, Favor quitar entre 1 y  " + pilas[pilaSeleccionada]); continue;
            }
            pilas[pilaSeleccionada] -= contadorQuitar;
            turnoValido = true;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] pilas = {20, 20, 20};
        String Player1 = "Player 1";
        String Player2 = "Player 2";

        while (!FINdelJuego(pilas[0], pilas[1], pilas[2])) {
            turnodelJugador(Player1, scanner, pilas);
            if (FINdelJuego(pilas[0], pilas[1], pilas[2])) {
                System.out.println("¡EL " + Player1 + " ha quitado el ultimo contador y ha perdido!\n Player 2, Felicidades, eres el ganador!");
                break;
            }
            turnodelJugador(Player2, scanner, pilas);
            if (FINdelJuego(pilas[0], pilas[1], pilas[2])) {
                System.out.println("¡EL " + Player2 + " ha quitado el ultimo contador y ha perdido!\n Player 1, Felicidades, eres el ganador!");
                break;
            }
        }
        scanner.close();
    }
}


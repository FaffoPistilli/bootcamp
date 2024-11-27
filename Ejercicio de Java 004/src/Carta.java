public class Carta {
 private char valor;
 private char palo;
    public Carta(char valor, char palo) {
     this.valor = valor;
     this.palo = palo;
    }
    public char getValor() {
     return valor;
    }
    public char getPalo() {
     return palo;
    }
    public int getValorNum() {
     switch (valor) {
         case 'A': return 14;
         case 'K': return 13;
         case 'Q': return 12;
         case 'J': return 11;
         case 'T': return 10;
         case '9': return 9;
         case '8': return 8;
         case '7': return 7;
         case '6': return 6;
         case '5': return 5;
         case '4': return 4;
         case '3': return 3;
         case '2': return 2;
         default: return -1;
     }
    }
@Override
    public String toString() {
     return "" + valor + palo;
    }
}


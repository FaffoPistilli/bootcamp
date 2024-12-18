import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Scanner;

public class Generala {
    String Jugadas(String dados) {
        if (!dados.matches("[1-6]{5}")) {
            return "Invalido";
        }
        int[] dadosArray = new int[5];
        for (int i = 0; i < 5; i++) {
            dadosArray[i] = Character.getNumericValue(dados.charAt(i));
        }
        int[] count = new int[7];
        for (int dado : dadosArray) {
            count[dado]++;
        }
        // GENERALA
        if (Arrays.stream(count).anyMatch(c -> c == 5)) {
            return "Generala";
        }
        // POKER"
        if (Arrays.stream(count).anyMatch(c -> c == 4)) {
            return "POKER";
        }
        //FULL
        if (Arrays.stream(count).anyMatch(c -> c == 3) && Arrays.stream(count).anyMatch(c -> c == 2)) {
            return "FULL";
        }
        //ESCALERA
        Arrays.sort(dadosArray);
        if (isEscalera(dadosArray)) {
            return "ESCALERA";
        }
        return "NADA";
    }

    private boolean isEscalera(int[] dadosArray) {
        return (dadosArray[0] + 1 == dadosArray[1] && dadosArray[1] + 1 == dadosArray[2]
                && dadosArray[2] + 1 == dadosArray[3] && dadosArray[3] + 1 == dadosArray[4])
                || (dadosArray[0] == 3 && dadosArray[1] == 4 && dadosArray[2] == 5 && dadosArray[3] == 6 && dadosArray[4] == 1)
                || (dadosArray[0] == 2 && dadosArray[1] == 3 && dadosArray[2] == 4 && dadosArray[3] == 5 && dadosArray[4] == 6);
    }

    //String[] jugadas(String[] losdados) {
    //    String[] ret = new String[losdados.length];
    //    int i = 0;
    //    for (String dados : losdados) {
    //        ret[i] = this.Jugadas(dados);
    //        i++;
    //    }
    //    return ret;
    //}

    // Ustedes pueden ignorar esto
   // static String[] processBatch(String fileName) throws Exception {
   //     Scanner sc = new Scanner(new File(fileName));
   //     List<String> lines = new ArrayList<String>();
   //     while (sc.hasNextLine()) {
   //         lines.add(sc.nextLine());
   //     }
   //     return lines.toArray(new String[0]);
   // }


    public static void main(String[] args) throws Exception {
        Generala g = new Generala();
       // if (args.length > 0) {
       //     String[] Jugadas = processBatch(args[0]);
       //     String resultados[] = g.jugadas(Jugadas);
       //     for (String res : resultados) {
       //         System.out.println(res);
       //     }
       //     return;
       // }
        System.out.println(g.Jugadas("11111"));
    }
}


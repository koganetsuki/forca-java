import java.util.Random;
import java.util.Scanner;

public class App {
    static final Scanner scan = new Scanner (System.in);

    public static void main (String[] args) throws Exception {
        banner (0);
        forca ();
        banner (1);
    }

    static void banner (int bn) {
        if (bn == 0) {
            System.out.println(" ╦┌─┐┌─┐┌─┐  ┌┬┐┌─┐  ╔═╗┌─┐┬─┐┌─┐┌─┐");
            System.out.println(" ║│ ││ ┬│ │   ││├─┤  ╠╣ │ │├┬┘│  ├─┤");
            System.out.println("╚╝└─┘└─┘└─┘  ─┴┘┴ ┴  ╚  └─┘┴└─└─┘┴ ┴");
        }

        if (bn == 1) {
            System.out.println("╔═╗┌┬┐┌─┐┬ ┬┌─┐┬");
            System.out.println("╠═╣ ││├┤ │ │└─┐│");
            System.out.println("╩ ╩─┴┘└─┘└─┘└─┘o");
        }

        if (bn == 2) {
            System.out.println ("___________________");
            System.out.println ("|                 |");
            System.out.println ("|                 |");
            System.out.println ("|                  ");
            System.out.println ("|                  ");
            System.out.println ("|                  ");
            System.out.println ("|                  ");
            System.out.println ("|                  ");
            System.out.println ("|                  ");
            System.out.print ("||");
        }
    }

    static void forca () {
        int acertos = 0;
        int erros = 0;
        Random random = new Random ();
        String[] palavras = {
            "tomate", "banana", "batata", "figado", "queijo", "manjar",
            "comida", "alface", "pepino", "salada", "farofa", "geleia",
            "lingua", "frango", "carnes"
        };

        int sorteio = random.nextInt (palavras.length);
        String sorteada = palavras[sorteio];

        char[] palavraRevelada = new char[sorteada.length ()];
        for (int i = 0; i < sorteada.length (); i++) {
            palavraRevelada[i] = '_';
        }

        while (acertos < sorteada.length () && erros < 6) { 
            banner (2);
            System.out.println (new String (palavraRevelada));
            System.out.println ("A palavra tem " + sorteada.length () + " letras. O tema é ALIMENTOS."); 
            System.out.println ("Acertos: " + acertos + " | Erros: " + erros); 
            System.out.print ("Insira uma letra: ");
            char palpite = scan.next ().toLowerCase ().charAt (0); 

            boolean acertou = false;
            boolean letraRevelada = false;

            for (int i = 0; i < sorteada.length (); i++) {
                if (sorteada.charAt (i) == palpite) {
                    if (palavraRevelada[i] == '_') {
                        palavraRevelada[i] = palpite;
                        acertos++;
                        acertou = true;
                    } 
                    
                    else {
                        acertou = true; 
                        letraRevelada = true;
                    }
                }
            }

            if (acertou) {
                if (!letraRevelada) {
                    System.out.println("Boa! A letra '" + palpite + "' está na palavra!");
                }
            }

            else {
                    System.out.println("Ops! A letra '" + palpite + "' não está na palavra ou já foi totalmente revelada.");
                    erros++;
            }

            if (acertos == sorteada.length()) {
                System.out.println("\nPalavra final: " + new String(palavraRevelada));
                System.out.println("Parabéns! Você acertou a palavra: " + sorteada);
                break; 
            }

            if (erros >= 6) { 
                System.out.println("\nPalavra final: " + new String(palavraRevelada));
                System.out.println("Que pena! Você foi enforcado. A palavra era: " + sorteada);
                break;
            }
        }
    }
}
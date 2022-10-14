package TicTacToe_MinMax;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tictactoe {

    public static ArrayList<String> tabuleiro = new ArrayList<String>();
    public static Scanner escolha = new Scanner(System.in);
    public static int jogadas = 1;

    public static void main(String[] args) {

        for (int a = 0; a < 9; a++) {
            String b = new String(Integer.toString(a + 1));

            tabuleiro.add(b); // add indices

        }
        System.out.println("Bem vindo ao OX!");
        System.out.println();

        for (int count = 0; count < 9; count++) {
            System.out.print(tabuleiro.get(count) + " "); // imprime matriz

            if (count == 2 || count == 5 || count == 8) { // pular linha para imprimir matriz
                System.out.println();
            }

        }

        int contjog = 0;
        while (true) {

            contjog++;
            System.out.println();

            if (jogadas == 1) { // alterna as jogadas de cada player

                int escIA = 0;
                Random rand1 = new Random();
                for (int i = 0; i < 20; i++) {

                    int rand = rand1.nextInt(10); // randomiza numeros

                    if ((rand == 1) || (rand == 3) || (rand == 7) || (rand == 9)) { // IA escolhe um canto para começar
                        if (!tabuleiro.get(rand - 1).equals("X")) {
                            escIA = rand; // seta o canto
                        }

                    }
                }

                int esc1 = escIA - 1;

                tabuleiro.set(esc1, "X");
                jogadas = 0;
            } else { // vez do player
                int esc1 = escolha.nextInt() - 1;
                tabuleiro.set(esc1, "O");
                jogadas = 1;
            }

            for (int count = 0; count < 9; count++) { // percorrer matriz
                System.out.print(tabuleiro.get(count) + " "); // imprime matriz

                if (count == 2 || count == 5 || count == 8) { // pular linha para imprimir matriz
                    System.out.println();
                }

            }

            // quais opçoes de jogada sobraram
            for (int i = 0; i < 9; i++) {
                if ((!tabuleiro.get(i).equals("X")) && (!tabuleiro.get(i).equals("O"))) {
                    System.out.print(tabuleiro.get(i) + ", ");
                }

            }

            for (int i = 0; i < 9; i = i + 3) { // verifica se ganhou nas linhas
                if ((tabuleiro.get(i) + tabuleiro.get(i + 1) + tabuleiro.get(i + 2)).equals("XXX")) {
                    System.out.println("X WIN");
                    System.exit(1);
                } else if ((tabuleiro.get(i) + tabuleiro.get(i + 1) + tabuleiro.get(i + 2)).equals("OOO")) {
                    System.out.println("O WIN");
                    System.exit(1);
                }
            }

            for (int i = 0; i < 3; i++) { // verifica se ganhou nas colunas
                if ((tabuleiro.get(i) + tabuleiro.get(i + 3) + tabuleiro.get(i + 6)).equals("XXX")) {
                    System.out.println("X WIN");
                    System.exit(1);
                } else if ((tabuleiro.get(i) + tabuleiro.get(i + 3) + tabuleiro.get(i + 6)).equals("OOO")) {
                    System.out.println("O WIN");
                    System.exit(1);
                }
            }

            // verifica se ganhou nas diagonais
            if ((tabuleiro.get(0) + tabuleiro.get(4) + tabuleiro.get(8)).equals("XXX")) {
                System.out.println("X WIN");
                System.exit(1);
            } else if ((tabuleiro.get(0) + tabuleiro.get(4) + tabuleiro.get(8)).equals("OOO")) {
                System.out.println("O WIN");
                System.exit(1);
            } else if ((tabuleiro.get(2) + tabuleiro.get(4) + tabuleiro.get(6)).equals("XXX")) {
                System.out.println("X WIN");
                System.exit(1);
            } else if ((tabuleiro.get(2) + tabuleiro.get(4) + tabuleiro.get(6)).equals("OOO")) {
                System.out.println("O WIN");
                System.exit(1);
            }

            if (contjog == 9) { // caso do empate
                System.out.println("Empate");
                System.exit(1);
            }

        }

    }
}
//testeee
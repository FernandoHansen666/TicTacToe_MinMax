package AStar_Ascent;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Scanner;

public class Grafo {

    public static int min = 666;
    public static String menorcam;
    public static String escolha;
    public static int dist;
    public static String Boom2;
    public static ArrayList<String> pathlist = new ArrayList<String>();
    public static Scanner bombvalue = new Scanner(System.in);

    ArrayList<Aresta> arestas = new ArrayList<Aresta>();
    ArrayList<Vertice> vertices = new ArrayList<Vertice>();

    public static void main(String[] args) {
        new Grafo();

    }

    public Grafo() {
        this.addVertice("bombA", 0, 126);
        this.addVertice("ceu", 15, 100);
        this.addVertice("corredor", 23, 109);
        this.addVertice("jardim", 26, 83);
        this.addVertice("lion", 52, 105);
        this.addVertice("basect", 55, 61);
        this.addVertice("gelato", 59, 63);
        this.addVertice("meio", 57, 70);
        this.addVertice("books", 71, 87);
        this.addVertice("mercado", 87, 18);
        this.addVertice("shop", 103, 47);
        this.addVertice("basetr", 106, 97);
        this.addVertice("bombB", 105, 0);
        this.addVertice("casa", 122, 16);

        this.addAresta(30, "bombA", "ceu");
        this.addAresta(46, "bombA", "corredor");
        this.addAresta(53, "bombA", "jardim");
        this.addAresta(90, "ceu", "basect");
        this.addAresta(99, "jardim", "basect");
        this.addAresta(63, "jardim", "meio");
        this.addAresta(62, "corredor", "lion");
        this.addAresta(57, "lion", "books");
        this.addAresta(120, "lion", "basetr");
        this.addAresta(54, "basect", "gelato");
        this.addAresta(99, "basect", "mercado");
        this.addAresta(73, "gelato", "meio");
        this.addAresta(79, "gelato", "mercado");
        this.addAresta(98, "meio", "shop");
        this.addAresta(50, "meio", "books");
        this.addAresta(69, "books", "basetr");
        this.addAresta(108, "shop", "basetr");
        this.addAresta(96, "shop", "mercado");
        this.addAresta(38, "mercado", "bombB");
        this.addAresta(33, "bombB", "casa");

        // A* para bomb ----- A* -> F(n) = G(n) + H(n)
        // _____________________________________________________________________________

        String Boom = new String(bombvalue.nextLine()); // seleciona o Bomb -A ou -B

        if (Boom.equals("-A")) {
            Boom2 = new String("bombA");
            System.out.println("Bomb A Selecionado\n__________________\n");
        } else if (Boom.equals("-B")) {
            Boom2 = new String("bombB");
            System.out.println("Bomb B Selecionado\n__________________\n");
        }

        escolha = "basetr"; // Seleciona o ponto de origem
        if (escolha.equals(Boom2)) {
            System.out.println("Você Já esta no objetivo ;)\n");
        }
        pathlist.add(escolha);
        while (!escolha.equals(Boom2)) {

            for (Vertice a : vertices) {

                if (a.getNome().equals(escolha)) {

                    for (Aresta b : a.getAresta()) {

                        if (Boom.equals("-A")) {
                            dist = b.getDestino().getAheur();
                        } else if (Boom.equals("-B")) {
                            dist = b.getDestino().getBheur();
                        } else {
                            System.out.println("Valor inexistente");
                            System.exit(1);
                        }

                        String nomes = a.getNome();
                        int f = dist + b.getDist(); // função A*
                        if (f < min) { // compara o valor atual com o armazenado anteriormente, se for menos substitui
                            // o min
                            min = f;

                        }
                        if (true) {
                            System.out.println("Nome: " + nomes);
                            System.out.println(
                                    b.getOrigem().getNome() + " >>> " + b.getDestino().getNome() + " = " +
                                            b.getDist());
                            if (Boom.equals("-A")) {
                                System.out.println("Heuristica \"A\" de " + b.getDestino().getNome() + ": "
                                        + b.getDestino().getAheur());
                            } else {
                                System.out.println("Heuristica \"B\" de " + b.getDestino().getNome() + ": "
                                        + b.getDestino().getBheur());
                            }
                            System.out.println("custo = " + f);
                            System.out.println("==================================\n");

                        }

                        if (f > min) {
                        } else { // ta funcionando assim, entao fodase kkkkj
                            menorcam = new String("" + b.getDestino().getNome() + "");
                            System.out.println("Atual menor: " + menorcam + " | Custo: " + min + "\n");
                            escolha = menorcam;
                        }

                    }

                    System.out.println("******************************************************\n");
                    System.out.println("Caminho escolhido: " + escolha + " | Custando: " + min +
                            "\n");
                    pathlist.add(escolha); // armazena os caminhos escolhidos
                    min = 666; // reseta o valor min para a prox execucao
                    if (escolha.equals(Boom2)) {
                        System.out.println("CHEGOOOOOOOOOOOOOOOOOOOUUU\n");
                        System.out.println("Bomb escolhido: " + Boom2 + "\nCaminho feito: " +
                                pathlist);
                        System.exit(1);

                    }

                }

            }

        }
        // _________________________________________________________________________________________________
        // FIM ASTAR

    }

    public void addVertice(String nome, int aheur, int bheur) {
        Vertice v = new Vertice(nome, aheur, bheur);
        this.vertices.add(v);
    }

    public void addAresta(int dist, String o, String d) {
        Vertice vo = new Vertice();
        Vertice vd = new Vertice();
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).getNome().equals(o)) {
                vo = this.vertices.get(i);
            }
            if (this.vertices.get(i).getNome().equals(d)) {
                vd = this.vertices.get(i);
            }
        }
        Aresta ao = new Aresta(dist, vo, vd);
        Aresta ad = new Aresta(dist, vd, vo);
        this.arestas.add(ao);
        this.arestas.add(ad);
        vo.addArestra(ao);
        vd.addArestra(ad);
    }

}

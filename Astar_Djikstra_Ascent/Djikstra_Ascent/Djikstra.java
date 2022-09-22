package Djikstra_Ascent;

import java.util.ArrayList;
import java.util.Scanner;

public class Djikstra {

    public static String escolha;
    public static int dist;
    public static int soma = 0;
    public static int count2 = 0;
    public static int visitados;
    public static ArrayList<Vertice> pathlist = new ArrayList<Vertice>();
    public static ArrayList<Vertice> listavisitados = new ArrayList<Vertice>();
    public static ArrayList<Vertice> backtrack = new ArrayList<Vertice>();

    ArrayList<Aresta> arestas = new ArrayList<Aresta>();
    ArrayList<Vertice> vertices = new ArrayList<Vertice>();

    public static void main(String[] args) {

        // Entrada de dados

        System.out.println("escolha o Objetivo (-A, -B):");
        Scanner obj = new Scanner(System.in);
        String o = obj.nextLine();
        System.out.println("Qual o ponto inicial: ");
        Scanner esc = new Scanner(System.in);
        String e = esc.nextLine();
        new Djikstra(o, e);

    }

    public Djikstra(String obj, String esc) {

        this.addVertice("bombA");
        this.addVertice("ceu");
        this.addVertice("corredor");
        this.addVertice("jardim");
        this.addVertice("lion");
        this.addVertice("basect");
        this.addVertice("gelato");
        this.addVertice("meio");
        this.addVertice("books");
        this.addVertice("mercado");
        this.addVertice("shop");
        this.addVertice("basetr");
        this.addVertice("bombB");
        this.addVertice("casa");

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

        // _____________________________________________________________________________

        Vertice escolha = this.getVertice(esc);
        Vertice objetivo = null;

        if (obj.equals("-A")) { // decisão objetivo
            objetivo = this.getVertice("bombA");
        }
        if (obj.equals("-B")) {
            objetivo = this.getVertice("bombB");
        }

        while (true) { // rodar pakas
            for (Vertice a : vertices) {
                int count = 0;
                while (count < 4) { // sei que tem no max 4 pontos em cada aresta

                    if (a.getNome().equals(escolha.getNome())) { // se o ponto for o escolhido

                        for (Aresta b : a.getAresta()) { // lê atributos do ponto
                            String nomes = a.getNome();

                            pathlist.add(b.getDestino()); // lista dos pontos que foram abertos

                            if (true) {
                                System.out.println("Nome: " + nomes);
                                System.out.println(
                                        b.getOrigem().getNome() + " >>> " + b.getDestino().getNome() + " = "
                                                + b.getDist());

                                System.out.println("===================================\n");
                            }

                        }

                        if (!listavisitados.contains(a)) {
                            System.out.print("Fechado: ");
                            listavisitados.add(a); // lista dos pontos que foram fechados/finalizados
                            for (Vertice l : listavisitados) {
                                System.out.print(l.getNome() + ", ");
                            }
                            System.out.println();

                        }

                        System.out.print("Abriu: ");
                        for (Vertice l : pathlist) {
                            System.out.print(l.getNome() + ", "); // printa os abertos

                        }

                        System.out.println();
                        System.out.println("++++++++++++++++");
                        escolha = pathlist.get(count2);                     // seta o primeiro da lista de fechados
                        while (listavisitados.contains(escolha)) {          //enquanto conter (primeiro dos fechados)
                            count2++;                                       // altera o contador pra pegar o segundo dos fechados
                            escolha = pathlist.get(count2);                 //seta o segundo dos fechados
                        }
            
                        System.out.println("escolhido: " + escolha.getNome() + "\n"); // printa o ultimo escolhido

                        if (escolha.getNome().equals(objetivo.getNome())) { //compara se a escolha e igual o objetivo

                            System.out.println("\nCHEGOOOOOOUUUU\n");   // printa que chegou no objetivo

                            System.out.println(escolha.getNome()); //printa o nome do objetivo

                            int var = 0;
                            int var2 = listavisitados.size() - 1;

                            while (!escolha.getNome().equals(listavisitados.get(0).getNome())) { // enquanto escolha (primeira execução bomb, depois vai trocando fazendo backtrack)
                                                                                                        //  for diferente do primeiro item (Ponto de partida escolhido)
                                int soma2 = 0;

                                if (var < listavisitados.size()) {
                                    var++;

                                    for (Aresta art : listavisitados.get(var2).getAresta()) {       // compara se a aresta anterior faz ligação com a atual (de traz pra frente)
                                        if (art.destino.getNome().equals(objetivo.getNome())) {

                                            soma += art.getDist();
                                            System.out.println(art.getOrigem().getNome() + " " + art.getDist()); // nome e custo individual dos caminhos
                                            objetivo = art.getOrigem();
                                        }
                                        soma2 = soma2 + soma; // soma dos custos dos caminhos

                                    }

                                    escolha = listavisitados.get(var2); // substitui a escolha pra fazer o backtrack
                                    var2--;

                                }
                            }

                            System.out.println("Soma caminho:" + soma); // printa a soma

                            System.exit(1);       // encerrar o programa pq eu fiz um while true kk
                        }

                    }
                    count++;
                    if (listavisitados.contains(escolha)) { //pular nós que ja foram fechados olhando a lista pra não abrir caminhos que ja foram vistos
                        count2++; // pula um item na arraylist
                    }

                }
                
                if (count2 < listavisitados.size()) { //parar de contar apos atingir numero da lista
                    count2++;
                }

            }
        }

        // _________________________________________________________________________________________________
        // FIM Dijkstra

    }

    public void addVertice(String nome) {
        Vertice v = new Vertice(nome);
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

    public Vertice getVertice(String nome) {
        Vertice vertice = null;

        for (Vertice v : vertices) {
            if (v.getNome().equals(nome)) {
                vertice = v;
            }

        }
        return vertice;
    }

}

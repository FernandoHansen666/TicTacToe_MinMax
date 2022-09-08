package Djikstra_Ascent;

import java.util.ArrayList;

public class Djikstra {

    public static String escolha;
    public static int dist;
    public static ArrayList<String> pathlist = new ArrayList<String>();

    ArrayList<Aresta> arestas = new ArrayList<Aresta>();
    ArrayList<Vertice> vertices = new ArrayList<Vertice>();

    public static void main(String[] args) {
        new Djikstra();

    }

    public Djikstra() {

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

        escolha = "basetr"; // Seleciona o ponto de origem

        String objetivo = new String("bombA"); // Ponto de objetivo BOMB A

        for (Vertice a : vertices) {
            if (a.getNome().equals(escolha)) {

                for (Aresta b : a.getAresta()) {
                    String nomes = a.getNome();

                    // String [] listanome = {b.getOrigem().getNome(), b.getDestino().getNome()};

                    // Aresta listanome = {b.getOrigem().getNome(), b.getDestino().getNome()};

                    // pathlist.add();
                    //System.out.println(pathlist + "\n");
                    //System.out.println(a.getAresta());

                    if (true) {
                        System.out.println("Nome: " + nomes);
                        System.out.println(b.getOrigem().getNome() + " >>> " + b.getDestino().getNome() + " = " + b.getDist());

                        System.out.println("===================================\n");

                    }

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

}

package Astar_Djikstra_Ascent.Djikstra_Ascent;

import java.util.ArrayList;

public class Vertice {

    String nome;
    int somatoria;

    public int getSomatoria() {
        return somatoria;
    }

    public void setSomatoria(int somatoria) {
        this.somatoria = somatoria;
    }

    ArrayList<Aresta> aresta = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Aresta> getAresta() {
        return aresta;
    }

    public void setAresta(ArrayList<Aresta> aresta) {
        this.aresta = aresta;
    }

    
    public void addArestra(Aresta a){
        this.aresta.add(a);
    }

    public Vertice(String nome) {
        this.nome = nome;

    }

    public Vertice(){}

}

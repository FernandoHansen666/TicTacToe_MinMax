package Djikstra_Ascent;

import java.util.ArrayList;

public class Vertice {

    String nome;
    Boolean visitado = false;

    public Boolean getVisitado() {
        return visitado;
    }

    public void setVisitado(Boolean visitado) {
        this.visitado = visitado;
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

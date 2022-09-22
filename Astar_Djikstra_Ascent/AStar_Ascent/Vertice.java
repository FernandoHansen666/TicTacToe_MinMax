package Astar_Djikstra_Ascent.AStar_Ascent;

import java.util.ArrayList;

public class Vertice {

    String nome;
    int aheur;
    int bheur;
    ArrayList<Aresta> aresta = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAheur() {
        return aheur;
    }

    public void setAheur(int aheur) {
        this.aheur = aheur;
    }

    public int getBheur() {
        return bheur;
    }

    public void setBheur(int bheur) {
        this.bheur = bheur;
    }

    public ArrayList<Aresta> getAresta() {
        return aresta;
    }

    public void addArestra(Aresta a){
        this.aresta.add(a);
    }

    public Vertice(String nome, int ah, int bh){
        this.nome = nome;
        this.aheur = ah;
        this.bheur = bh;
    }

    public Vertice(){}
    
}

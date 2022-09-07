package AStar_Ascent;


public class Aresta {
    
    Vertice origem;
    Vertice destino;
    int dist;

    public Vertice getOrigem() {
        return origem;
    }

    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public Aresta(int dist, Vertice origem, Vertice destino){
        this.dist = dist;
        this.origem = origem;
        this.destino = destino;

    }

}


      

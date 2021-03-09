package br.com.davesmartins.grafo_api;

public class Aresta {

    private Vertice v1;
    private Vertice v2;
    private double distancia=1; //valor da aresta


    public Aresta(Vertice v1, Vertice v2, double distancia) { //construtor com valor 
        this.v1 = v1;
        this.v2 = v2;
        this.distancia = distancia;
    }
    public Aresta(Vertice v1, Vertice v2) { //construtor sem valor 
        this.v1 = v1;
        this.v2 = v2; 
    }

    public Vertice getV1() {
        return v1;
    }

    public void setV1(Vertice v1) {
        this.v1 = v1;
    }

    public Vertice getV2() {
        return v2;
    }

    public void setV2(Vertice v2) {
        this.v2 = v2;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
}

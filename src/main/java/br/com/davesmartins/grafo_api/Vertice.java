package br.com.davesmartins.grafo_api;

public class Vertice {

    private String nome;
    private int quantidade_aresta; //quantidade de arestas que o vertie possui
    private Vertice pai;
    private Aresta arestaPai; 
    private double distance = Double.POSITIVE_INFINITY; //distancia do vertice ao vértice origem
    private int grupo;
    
    
    Vertice(String vertice) {
        this.nome = vertice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade_aresta() {
        return quantidade_aresta;
    }

    public void setQuantidade_aresta(int quantidade_aresta) {
        this.quantidade_aresta = quantidade_aresta;
    }

    public Vertice getPai() {
        return pai;
    }

    public void setPai(Vertice pai) {
        this.pai = pai;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Aresta getArestaPai() {
        return arestaPai;
    }

    public void setArestaPai(Aresta arestaPai) {
        this.arestaPai = arestaPai;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }
    

}

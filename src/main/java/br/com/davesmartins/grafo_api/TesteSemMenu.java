package br.com.davesmartins.grafo_api;

import br.com.davesmartins.api.Graph;
import java.io.IOException;
import java.util.Scanner;


public class TesteSemMenu {

    public static void main(String[] args) throws IOException {
        GrafoOrientado  sad = new GrafoOrientado();
        Grafo grafo = new Grafo();
        

        Vertice v1 = new Vertice("v1");
        Vertice v2 = new Vertice("v2");
        Vertice v3 = new Vertice("v3");
        Vertice v4 = new Vertice("v4");
        Vertice v5 = new Vertice("v5");

        grafo.addVertice(v1);
        grafo.addVertice(v2);
        grafo.addVertice(v3);
        grafo.addVertice(v4);
        grafo.addVertice(v5);

        Aresta a1 = new Aresta(v1, v2, 4);
        Aresta a2 = new Aresta(v2, v3, 5);
        Aresta a3 = new Aresta(v3, v4, 2);
        Aresta a4 = new Aresta(v4, v5, 1);
        Aresta a5 = new Aresta(v2, v5, 10);

        grafo.addAresta(a1);
        grafo.addAresta(a2);
        grafo.addAresta(a3);
        grafo.addAresta(a4);
        grafo.addAresta(a5);
        
        Graph.createStringDotToPng(grafo.imprimeArvore(), "Arvorekruskal.png");
    }
}

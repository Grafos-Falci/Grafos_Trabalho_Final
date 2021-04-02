package br.com.davesmartins.grafo_api;

import br.com.davesmartins.api.Graph;
import java.io.IOException;
import java.util.Scanner;

public class TesteSemMenu {

    public static void main(String[] args) throws IOException {
//        GrafoOrientado grafo = new GrafoOrientado();
        Grafo grafo = new Grafo();

        Vertice a = new Vertice("a");
        Vertice b = new Vertice("b");
        Vertice c = new Vertice("c");
        Vertice d = new Vertice("d");
        Vertice e = new Vertice("e");
        Vertice f = new Vertice("f");

        grafo.addVertice(a);
        grafo.addVertice(b);
        grafo.addVertice(c);
        grafo.addVertice(d);
        grafo.addVertice(e);
        grafo.addVertice(f);

        Aresta a1 = new Aresta(a, b, 1);
        Aresta a2 = new Aresta(d, a, 8);
        Aresta a3 = new Aresta(b, e, 9);
        Aresta a4 = new Aresta(e, d, 1);
        Aresta a5 = new Aresta(e, f, 5);
  
        grafo.addAresta(a1);
        grafo.addAresta(a2);
        grafo.addAresta(a3);
        grafo.addAresta(a4);
        grafo.addAresta(a5);

        Graph.createStringDotToPng(grafo.imprimeArvore(), "arvorinharennnan");

    }
}

package br.com.davesmartins.grafo_api;

import br.com.davesmartins.api.Graph;
import java.io.IOException;
import java.util.Scanner;


public class TesteSemMenu {

    public static void main(String[] args) throws IOException {
        GrafoOrientado grafo = new GrafoOrientado();
        //Grafo grafo = new Grafo();
        

        Vertice a = new Vertice("a");
        Vertice b = new Vertice("b");
        Vertice c = new Vertice("c");
        Vertice d = new Vertice("d");
        Vertice e = new Vertice("e");
        Vertice f = new Vertice("f");
        Vertice g = new Vertice("g");
        Vertice h = new Vertice("h");
        Vertice i = new Vertice("i");


        grafo.addVertice(a);
        grafo.addVertice(b);
        grafo.addVertice(c);
        grafo.addVertice(d);
        grafo.addVertice(e);
        grafo.addVertice(f);
        grafo.addVertice(g);
        grafo.addVertice(h);
        grafo.addVertice(i);

        Aresta a1 = new Aresta(i, a, 4);
        Aresta a2 = new Aresta(i, g, 5);
        Aresta a3 = new Aresta(h, i, 2);
        Aresta a4 = new Aresta(h, a, 1);
        Aresta a5 = new Aresta(g, h, 10);
        Aresta a6 = new Aresta(g, d, 5);
        Aresta a7 = new Aresta(a, b, 2);
        Aresta a8 = new Aresta(a, g, 1);
        Aresta a9 = new Aresta(b, c, 10);
        Aresta a10 = new Aresta(c, d, 10);
        Aresta a11 = new Aresta(d, b, 10);
        Aresta a12 = new Aresta(e, d, 10);
        Aresta a13 = new Aresta(e, f, 10);
        Aresta a14 = new Aresta(f, e, 10);
        Aresta a15 = new Aresta(f, g, 10);

        grafo.addAresta(a1);
        grafo.addAresta(a2);
        grafo.addAresta(a3);
        grafo.addAresta(a4);
        grafo.addAresta(a5);
        grafo.addAresta(a6);
        grafo.addAresta(a7);
        grafo.addAresta(a8);
        grafo.addAresta(a9);
        grafo.addAresta(a10);
        grafo.addAresta(a11);
        grafo.addAresta(a12);
        grafo.addAresta(a13);
        grafo.addAresta(a14);
        grafo.addAresta(a15);
        
        
        grafo.malgrange();
        Graph.createStringDotToPng(grafo.dotOrientado(), "final.png");
    }
}

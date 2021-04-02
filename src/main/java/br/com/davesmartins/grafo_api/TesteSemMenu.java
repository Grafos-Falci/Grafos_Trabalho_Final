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

        Aresta a1 = new Aresta(a, b, 1);
        Aresta a2 = new Aresta(a, d, 4);
        Aresta a3 = new Aresta(b, d, 6);
        Aresta a4 = new Aresta(d, e, 3);
        Aresta a5 = new Aresta(b, c, 2);
        Aresta a6 = new Aresta(e, c, 5);
        Aresta a7 = new Aresta(e, f, 8);
        Aresta a8 = new Aresta(c, f, 6);
        Aresta a9 = new Aresta(f, g, 3);
        Aresta a10 = new Aresta(g, e, 7);
        Aresta a11 = new Aresta(d, g, 4);

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

//        Graph.createStringDotToPng(grafo.dotSimples(), "dotSimples");
//        Graph.createStringDotToPng(grafo.dotSimplesValorado(), "dotSimplesValorado");
//        Graph.createStringDotToPng(grafo.imprimeArvore(), "newtree");

            System.out.println(grafo.Grafo_completo());


    }
}

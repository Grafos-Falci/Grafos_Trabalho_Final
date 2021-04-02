package br.com.davesmartins.grafo_api;

import br.com.davesmartins.api.Graph;
import java.io.IOException;
import java.util.Scanner;

public class TesteSemMenu {

    public static void main(String[] args) throws IOException {
        GrafoOrientado grafo1 = new GrafoOrientado();
        Grafo grafo = new Grafo();

        Vertice a = new Vertice("0");
        Vertice b = new Vertice("1");
        Vertice c = new Vertice("2");
        Vertice d = new Vertice("3");
        Vertice e = new Vertice("4");
        Vertice f = new Vertice("4");

        grafo.addVertice(a);
        grafo.addVertice(b);
        grafo.addVertice(c);
        grafo.addVertice(d);
        grafo.addVertice(e);

        Aresta a1 = new Aresta(a, d, 100);
        Aresta a2 = new Aresta(a, b, 50);
        Aresta a3 = new Aresta(b, e, 100);
        Aresta a4 = new Aresta(d, e, 125);
        Aresta a5 = new Aresta(e, f, 50);
  
        grafo.addAresta(a1);
        grafo.addAresta(a2);
        grafo.addAresta(a3);
        grafo.addAresta(a4);
        grafo.addAresta(a5);


//        for(Vertice v: grafo.arestasDoVertice(a)){
//            System.out.println(v.getNome());
//    }
        System.out.println(grafo.imprimeArvore());
    }
}

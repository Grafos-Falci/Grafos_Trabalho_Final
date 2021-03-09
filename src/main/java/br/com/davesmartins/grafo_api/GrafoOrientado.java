package br.com.davesmartins.grafo_api;

import java.util.ArrayList;
import java.util.Collections;

public class GrafoOrientado extends Grafo {

    public String dotOrientado() {

        String DOT;
        DOT = "digraph{\n";
        for (Aresta aresta : lista_aresta) {
            DOT = DOT + aresta.getV1().getNome() + " -> " + aresta.getV2().getNome() + ";\n";
        }
        DOT = DOT + "}";
        return DOT;
    }

    public ArrayList<Aresta> buscaV1(Vertice v1) { //busca as arestas ligadas ao vertice 1
        ArrayList<Aresta> aresta = new ArrayList<Aresta>();
        for (Aresta a : lista_aresta) {
            if (a.getV1() == v1) {
                aresta.add(a);
            }
        }
        return aresta;
    }

    public ArrayList<Aresta> buscaV2(Vertice v2) { //busca as arestas ligadas ao vertice 2
        ArrayList<Aresta> aresta = new ArrayList<Aresta>();
        for (Aresta a : lista_aresta) {
            if (a.getV2() == v2) {
                aresta.add(a);
            }
        }
        return aresta;
    }

    public ArrayList<Vertice> transitivoDireto(Vertice v) { //
        controle_vertice.add(v);
        ArrayList<Vertice> vertice = new ArrayList<Vertice>();
        ArrayList<Aresta> aresta = buscaV1(v);
        for (Aresta a : aresta) {
            vertice.add(a.getV2());
            if (!(controle_vertice.contains(a.getV2()))) {
                vertice.addAll(transitivoDireto(a.getV2()));
            }
        }
        return vertice;
    }

    public ArrayList<Vertice> transitivoIndireto(Vertice v) {
        controle_vertice.add(v);
        ArrayList<Vertice> vertice = new ArrayList<Vertice>();
        ArrayList<Aresta> aresta = buscaV2(v);
        for (Aresta a : aresta) {
            vertice.add(a.getV1());
            if (!(controle_vertice.contains(a.getV1()))) {
                vertice.addAll(transitivoIndireto(a.getV1()));
            }
        }
        return vertice;
    }

    public ArrayList<Vertice> buscaTD(Vertice v) { //busca os vertices aos quais um vertice consegue chegar
        controle_vertice.removeAll(controle_vertice);
        return transitivoDireto(v);
    }

    public ArrayList<Vertice> buscaTI(Vertice v) { //busca os vertices que um vertice consegue receber
        controle_vertice.removeAll(controle_vertice);
        return transitivoIndireto(v);
    }

    public ArrayList<Vertice> arestasDoVertice(Vertice v) {
        ArrayList<Aresta> aresta = buscaAresta(v);
        ArrayList<Vertice> vertice = new ArrayList<Vertice>();
        vertice.add(v);
        controle_vertice.add(v);
        for (Aresta a : aresta) {
            if ((a.getV1() == v) && (a.getV2() == v)) {

            } else {
                if (a.getV1() == v) {
                    if (!(controle_vertice.contains(a.getV2()))) {
                        vertice.add(a.getV2());
                        vertice.addAll(arestasDoVertice(a.getV2()));
                    } else {
                        if (!(controle_vertice.contains(a.getV1()))) {
                            vertice.add(a.getV1());
                            vertice.addAll(arestasDoVertice(a.getV1()));
                        }
                    }
                }
            }

        }
        return vertice;
    }

    public ArrayList<Vertice> menorCaminho(Vertice origem, Vertice destino) {
        ArrayList<Vertice> abertos = new ArrayList<Vertice>();
        origem.setDistance(0);
        abertos.add(origem);
        while (!abertos.isEmpty()) {
            Vertice v1 = abertos.get(0);
            for (Aresta a : buscaAresta(v1)) {
                Vertice v2 = a.getV2();

                double custo = distancia(a);
                double distanciaMinima = custo + v1.getDistance();
                if (distanciaMinima < v2.getDistance()) {
                    abertos.remove(v2);
                    v2.setDistance(distanciaMinima);
                    v2.setPai(v1);
                    v2.setArestaPai(a);
                    abertos.add(v2);
                }
            }
            abertos.remove(0);
        }
        ArrayList<Vertice> ordemVertices = new ArrayList<Vertice>();
        for (Vertice ref = destino; ref != null; ref = ref.getPai()) { //pegar do destino e voltar para a origem
            ordemVertices.add(ref);
        }
        Collections.reverse(ordemVertices);
        return ordemVertices;
    }

    public String Dijikstra(Vertice origem, Vertice destino) {
        ArrayList<Vertice> menor = menorCaminho(origem, destino);
        ArrayList<Aresta> caminhos = new ArrayList<Aresta>();
        ArrayList<Aresta> outros = new ArrayList<Aresta>();

        for (int i = 0; i < menor.size(); i++) {
            if (i == (menor.size() - 1)) {
                break;
            }
            caminhos.add(menor.get(i + 1).getArestaPai());
        }
        outros.addAll(lista_aresta);
        outros.removeAll(caminhos);

        String dot = "digraph{\n";

        for (Aresta a1 : caminhos) {
            dot = dot + a1.getV1().getNome() + "->" + a1.getV2().getNome();
            if (a1.getDistancia() == 0) {
                dot = dot + a1.getV1().getNome() + "->" + a1.getV2().getNome() + "[color = red];\n";

            } else {
                dot = dot + "[label = \"" + a1.getDistancia() + "\"][color = red];\n";
            }
        }
        for (Aresta a2 : outros) {
            dot = dot + a2.getV1().getNome() + "->" + a2.getV2().getNome();
            if (a2.getDistancia() == 0) {
                dot = dot + a2.getV1().getNome() + "->" + a2.getV2().getNome() + ";\n";
            } else {
                dot = dot + "[label = \"" + a2.getDistancia() + "\"];\n";
            }
        }

        dot = dot + "}";
        return dot;
    }

}

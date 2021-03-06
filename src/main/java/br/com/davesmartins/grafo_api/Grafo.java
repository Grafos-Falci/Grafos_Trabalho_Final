package br.com.davesmartins.grafo_api;

import br.com.davesmartins.api.Graph;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Grafo {

    protected ArrayList<Vertice> lista_vertice = new ArrayList<Vertice>();
    protected ArrayList<Aresta> lista_aresta = new ArrayList<Aresta>();
    protected ArrayList<Vertice> controle_vertice = new ArrayList<Vertice>();

    public ArrayList<Vertice> getLista_vertice() {
        return lista_vertice;
    }

    public void setLista_vertice(ArrayList<Vertice> lista_vertice) {
        this.lista_vertice = lista_vertice;
    }

    public ArrayList<Aresta> getLista_aresta() {
        return lista_aresta;
    }

    public void setLista_aresta(ArrayList<Aresta> lista_aresta) {
        this.lista_aresta = lista_aresta;
    }

    public ArrayList<Vertice> getControle_vertice() {
        return controle_vertice;
    }

    public void setControle_vertice(ArrayList<Vertice> controle_vertice) {
        this.controle_vertice = controle_vertice;
    }

    public void addAresta(Aresta a) { // adiciona uma aresta na lista de arestas
        lista_aresta.add(a);
    }

    public void inserirAresta(String v1, String v2) { //função lê string de vertice e adiciona na aresta 
        Vertice vertice1 = null;
        Vertice vertice2 = null;

        for (Vertice v : lista_vertice) {
            if (v.getNome().equals(v1)) {
                vertice1 = v;
                break;
            }
        }
        for (Vertice v : lista_vertice) {
            if (v.getNome().equals(v2)) {
                vertice2 = v;
                break;
            }
        }
        if (vertice1 != null && vertice2 != null) {
            addAresta(new Aresta(vertice1, vertice2));
        }

    }

    public void inserirArestaValorada(String v1, String v2, double valor) { //função lê string de vertice e valor e adiciona na aresta
        Vertice vertice1 = null;
        Vertice vertice2 = null;

        for (Vertice v : lista_vertice) {
            if (v.getNome().equals(v1)) {
                vertice1 = v;
                break;
            }
        }
        for (Vertice v : lista_vertice) {
            if (v.getNome().equals(v2)) {
                vertice2 = v;
                break;
            }
        }
        if (vertice1 != null && vertice2 != null) {
            addAresta(new Aresta(vertice1, vertice2, valor));
        }
    }

    public Vertice buscaVertice(String nome) { //busca e retorna o objeto através de sua string 
        for (Vertice v : lista_vertice) {
            if (v.getNome().equals(nome)) {
                return v;
            }
        }
        return null;
    }

    public void addVertice(Vertice v) { //adiciona vertice na lista de vertices
        lista_vertice.add(v);
    }

    public void removeAresta(Aresta a) {
        lista_aresta.remove(a);
    }
    public Aresta buscaArestaDosVertices(Vertice v1, Vertice v2) {
        for (Aresta a : lista_aresta) {
            if ((a.getV1().equals(v1) && a.getV2().equals(v2)) ||(a.getV1().equals(v2) && a.getV2().equals(v1)) ) {
                return a;
            }
        }
        return null;
    }

    public int Ordem() {    //calcula a ordem (numero de vertices) do grafo 
        return lista_vertice.size();
    }
    public void removeVertice(Vertice v) {
        this.lista_vertice.remove(v);
        ArrayList<Aresta> listaArestas = new ArrayList<Aresta>();
        for (Aresta a : lista_aresta) {
            if (a != null) {
                if (a.getV1() == v || a.getV2() == v) {
                    listaArestas.add(a);
                }
            }
        }
        this.lista_aresta.removeAll(listaArestas);
    }

    public int Grau(String v) {
        int grau = 0;
        for (Aresta a : lista_aresta) { //percorremos a lista de aresta
            if (v.equals(a.getV1().getNome()) || v.equals(a.getV2().getNome())) { //se o vertice contem a aresta o grau aumenta 
                grau++;
            }
        }
        return grau;
    }

    public String dotSimples() { // grafo em dot
        String DOT;
        DOT = "graph{\n";
        for (Vertice vertice : lista_vertice) {
            DOT = DOT + vertice.getNome() + ";\n";
        }
        for (Aresta aresta : lista_aresta) {
            DOT = DOT + aresta.getV1().getNome() + " -- " + aresta.getV2().getNome() + ";\n";
        }
        DOT = DOT + "}";
        return DOT;
    }

    public String dotSimplesValorado() { // grafo em dot
        String DOT;
        DOT = "graph{\n";
        for (Vertice vertice : lista_vertice) {
            DOT = DOT + vertice.getNome() + ";\n";
        }
        for (Aresta aresta : lista_aresta) {
            DOT = DOT + aresta.getV1().getNome() + " -- " + aresta.getV2().getNome() + "[label = \"" + aresta.getDistancia() + "\"];\n";

        }
        DOT = DOT + "}";
        return DOT;
    }

    public void matrizAdjacencia() { //imprime a matriz de adjacência

        String matriz = "";
        for (Vertice linha : lista_vertice) {

            for (Vertice coluna : lista_vertice) {
                if (verificaAresta(linha, coluna)) {
                    matriz = matriz + 1;
                } else {
                    matriz = matriz + 0;
                }
            }
            matriz = matriz + "\n";
        }
        System.out.println(matriz);

    }

    public boolean verificaAresta(Vertice v1, Vertice v2) { //verifica se os vertices estão conectados
        for (Aresta a : lista_aresta) {
            if ((a.getV1() == v1 && a.getV2() == v2) || (a.getV1() == v2 && a.getV2() == v1)) {
                return true;
            }
        }
        return false;
    }

    public String gravarArquivo(String nome) { //grava em forma de arquivo o nosso dot

        try (FileWriter fw = new FileWriter(nome + ".txt")) {
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(dotSimples());
            bw.flush();
            System.out.println("Gravacao realizada com sucesso");
        } catch (IOException ex) {
            System.out.println("Gravacao realizada com sucesso");
        }
        return null;
    }

    public String lerArquivo(String nome) { //lê um arquivo de texto que contenha um dot

        try (FileReader fr = new FileReader(nome + ".txt")) {
            BufferedReader br = new BufferedReader(fr);
            String content;
            while ((content = br.readLine()) != null) {
                System.out.println(content);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean grafoRegular() { //verifica se ografo é regular

        int grauReferencia = Grau(lista_vertice.get(0).getNome());
        for (Vertice v : lista_vertice) {
            if (grauReferencia != Grau(v.getNome())) {
                return false;
            }
        }
        return true;
    }

    public boolean Grafo_completo() { //verifica se o grafo é completo
        int numArestas = (Ordem() * (Ordem() - 1) / 2);
        if (this.lista_aresta.size() == numArestas) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Aresta> buscaAresta(Vertice v) { // retorna a lista de arestas de um vertice
        ArrayList<Aresta> aresta = new ArrayList<Aresta>();
        for (Aresta a : lista_aresta) {
            if (a.getV1() == v || a.getV2() == v) {
                aresta.add(a);
            }
        }
        return aresta;
    }

    public double distancia(Aresta a) { //retorna a distancia/valor da aresta
        if (a == null) {
            return Double.POSITIVE_INFINITY;
        }
        if (a.getDistancia() == 0) {
            return 1;
        }
        return a.getDistancia();
    }

    public ArrayList<Vertice> menorCaminho(Vertice origem, Vertice destino) { //retorna a lista com o menor caminho de vertices 
        ArrayList<Vertice> abertos = new ArrayList<Vertice>();
        origem.setDistance(0);
        abertos.add(origem);
        while (!abertos.isEmpty()) {
            Vertice v1 = abertos.get(0);
            for (Aresta a : buscaAresta(v1)) {
                Vertice v2;
                if (a.getV1() == v1) {
                    v2 = a.getV2();
                } else {
                    v2 = a.getV1();
                }
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

    public String Dijikstra(Vertice origem, Vertice destino) { //mostra via dot o menor caminho
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

        String dot = "graph{\n";

        for (Aresta a1 : caminhos) {
            dot = dot + a1.getV1().getNome() + "--" + a1.getV2().getNome();
            if (a1.getDistancia() == 0) {
                dot = dot + a1.getV1().getNome() + "--" + a1.getV2().getNome() + "[color = red];\n";

            } else {
                dot = dot + "[label = \"" + a1.getDistancia() + "\"][color = red];\n";
            }
        }
        for (Aresta a2 : outros) {
            dot = dot + a2.getV1().getNome() + "--" + a2.getV2().getNome();
            if (a2.getDistancia() == 0) {
                dot = dot + a2.getV1().getNome() + "--" + a2.getV2().getNome() + ";\n";
            } else {
                dot = dot + "[label = \"" + a2.getDistancia() + "\"];\n";
            }
        }
        dot = dot + "}";
        return dot;
    }

    public Aresta menoresArestas(ArrayList<Aresta> arestas) { //retorna uma lista de arestas ordenadas pela distancia
        Aresta aresta = arestas.get(0);
        for (Aresta a : arestas) {
            if (aresta.getDistancia() > a.getDistancia()) {
                aresta = a;
            }
        }
        return aresta;
    }

    public ArrayList<Aresta> ordenarAresta() {
        ArrayList<Aresta> arestas = new ArrayList<Aresta>();
        arestas.add(getLista_aresta().get(0));
        for (Aresta geral : getLista_aresta()) {
            int posicao = 0;
            for (Aresta a : arestas) {
                if (geral.getDistancia() < a.getDistancia()) {
                    posicao = arestas.indexOf(a);
                    break;
                }
                if (a != geral && geral.getDistancia() > a.getDistancia() && arestas.indexOf(a) == (arestas.size() - 1)) {
                    posicao = arestas.size();
                    break;
                }
            }
            if (posicao != 0) {
                arestas.add(posicao, geral);
            }

        }
        return arestas;
    }

    public Grafo kruskal() {

        ArrayList<Aresta> A = new ArrayList<Aresta>();
        A.addAll(ordenarAresta()); //organiza as arestas por tamanho
        int n = this.getLista_vertice().size();
        ArrayList<Aresta> arvore = new ArrayList<Aresta>();

        Grafo grafo = new Grafo();
        for (Aresta a : A) {
            if ((grafo.buscaVertice(a.getV1().getNome()) == null)
                    && (grafo.buscaVertice(a.getV2().getNome()) == null)) {
                grafo.addVertice(a.getV1());
                grafo.addVertice(a.getV2());
                grafo.addAresta(a);
            }
            if ((grafo.buscaVertice(a.getV1().getNome()) != null)
                    && (grafo.buscaVertice(a.getV2().getNome()) == null)) {
                grafo.addVertice(a.getV2());
                grafo.addAresta(a);
            }
            if ((grafo.buscaVertice(a.getV1().getNome()) == null)
                    && (grafo.buscaVertice(a.getV2().getNome()) != null)) {
                grafo.addVertice(a.getV1());
                grafo.addAresta(a);
            }
        }
        grafo.testeConexa();
        while (!grafo.testeConexa()) {
            Aresta aresta = grafo.completaGrafo(getLista_aresta());

            if (aresta == null) {

            } else {

                grafo.addAresta(aresta);
            }
            grafo.testeConexa();

        }
        return grafo;
    }
    private Aresta completaGrafo(ArrayList<Aresta> lista_aresta) {

        Aresta referencia = null;
        double distancia = Double.POSITIVE_INFINITY;
        for (Vertice vertice : this.getLista_vertice()) {
            for (Vertice v : this.getLista_vertice()) {
                if (v == vertice) {

                } else {
                    controle_vertice.removeAll(controle_vertice);
                    if (!encontrarVertice(v).contains(vertice)) {

                        for (Aresta a : lista_aresta) {
                            if ((a.getV1() == v && a.getV2() == vertice) || (a.getV2() == v && a.getV1() == vertice)) {

                                if (distancia > a.getDistancia()) {

                                    referencia = a;
                                    distancia = a.getDistancia();
                                }
                            }
                        }
                    }
                }

            }
        }
        return referencia;
    }

    private ArrayList<Vertice> encontrarVertice(Vertice v) {
        ArrayList<Vertice> listaVertices = new ArrayList<Vertice>();
        ArrayList<Aresta> listaArestas = buscaAresta(v);
        controle_vertice.add(v);
        listaVertices.add(v);

        for (Aresta a : listaArestas) {
            if (a.getV1() == v) {
                if (!controle_vertice.contains(a.getV2())) {
                    listaVertices.addAll(encontrarVertice(a.getV2()));
                }
            }
            if (a.getV2() == v) {
                if (!controle_vertice.contains(a.getV1())) {
                    listaVertices.addAll(encontrarVertice(a.getV1()));
                }
            }
        }
        return listaVertices;
    }

    public boolean testeConexa() {
        controle_vertice.removeAll(controle_vertice);
        ArrayList<Vertice> road = roadVertice(this.lista_vertice.get(0));
        road = new ArrayList<Vertice>(new HashSet<Vertice>(road));
        if (road.size() == lista_vertice.size()) {
            return true;
        } else {
            return false;
        }
    }

    private ArrayList<Vertice> roadVertice(Vertice v) {
        ArrayList<Aresta> listaAresta = buscaAresta(v);
        ArrayList<Vertice> listaVertice = new ArrayList<Vertice>();
        if (listaAresta.size() == 0) {
            return listaVertice;
        }
        controle_vertice.add(v);
        listaVertice.add(v);
        for (Aresta a : listaAresta) {
            if (a.getV1() == v && a.getV2() == v) {

            } else {
                if (a.getV1() == v) {
                    if (!(controle_vertice.contains(a.getV2()))) {
                        listaVertice.add(a.getV2());
                        listaVertice.addAll(roadVertice(a.getV2()));
                    }

                } else {
                    if (!(controle_vertice.contains(a.getV1()))) {
                        listaVertice.add(a.getV1());
                        listaVertice.addAll(roadVertice(a.getV1()));
                    }
                }

            }
        }
        return listaVertice;
    }

    public String imprimeArvore() {
        Grafo arvore = kruskal();
        return arvore.dotSimplesValorado();
    }

    public ArrayList<Vertice> buscaVerticesAdjacentes(Vertice v) {
        ArrayList<Aresta> aresta = buscaAresta(v);
        ArrayList<Vertice> vertice = new ArrayList<Vertice>();

        for (Aresta a : aresta) {
            if (a.getV1() == v) {
                vertice.add(a.getV2());
            }
            if (a.getV2() == v) {
                vertice.add(a.getV1());
            }
        }
        return vertice;
    }

    public void buscaLargura(Vertice inicio) {
        ArrayList<Vertice> fila = new ArrayList<Vertice>();
        ArrayList<Vertice> visitados = new ArrayList<Vertice>();

        Vertice aux;
        Vertice i = inicio;
        fila.add(i);
        visitados.add(i);

        while (!fila.isEmpty()) {
            visitados.add(i);
            System.out.print("\n" + i.getNome() + " -> ");
            for (Vertice v : buscaVerticesAdjacentes(i)) {
                System.out.print(v.getNome() + " | ");
                aux = v;
                if (!visitados.contains(aux)) {
                    fila.add(aux);
                    visitados.add(aux);
                }
            }
            fila.remove(i);
            if (!fila.isEmpty()) {
                i = fila.get(0);
            }
        }
    }

    public void buscaProfundidade(Vertice v) {
        v.setVisitado(true);
        System.out.print("[" + v.getNome() + "]");
        for (Vertice vertice : buscaVerticesAdjacentes(v)) {
            if (vertice.isVisitado() == false) {
                buscaProfundidade(vertice);
            }
        }
    }

    
}

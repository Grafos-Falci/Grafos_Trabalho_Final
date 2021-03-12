package br.com.davesmartins.grafo_api;

import br.com.davesmartins.api.Graph;
import java.io.IOException;
import java.util.Scanner;

public class TesteMenu {

    public static void main(String[] args) throws IOException {
        Grafo grafo = new Grafo();
        GrafoOrientado grafoOrientado = new GrafoOrientado();

        Scanner leitor = new Scanner(System.in);

        int op = 0;

        while (op != 4) {
            System.out.println("---------------MENU---------------");
            System.out.println("1 - Montar Grafo");
            System.out.println("2 - Ler/Gravar Arquivo");
            System.out.println("3 - Mostrar Dados do Grafo");
            System.out.println("4 - Sair");
            op = leitor.nextInt();

            Aresta a;
            String v1;
            String v2;
            Vertice vert1;
            Vertice vert2;
            double valor;

            switch (op) {

                case 1:
                    int op1 = 0;
                    while (op1 != 3) {
                        System.out.println("---------------Grafo---------------");
                        System.out.println("1 - Montar Grafo nao Orientado");
                        System.out.println("2 - Montar Grafo Orientado");
                        System.out.println("3 - Sair");
                        op1 = leitor.nextInt();

                        switch (op1) {

                            case 1:
                                int op11 = 0;
                                while (op11 != 4) {

                                    System.out.println("---------------Operacoes---------------");
                                    System.out.println("1 - Inserir Vertice");
                                    System.out.println("2 - Inserir Aresta");
                                    System.out.println("3 - Inserir Aresta valorada");
                                    System.out.println("4 - Sair");
                                    op11 = leitor.nextInt();

                                    switch (op11) {
                                        case 1:
                                            System.out.println("Vertice: ");
                                            v1 = leitor.next();
                                            vert1 = new Vertice(v1);
                                            grafo.addVertice(vert1);
                                            break;
                                        case 2:
                                            System.out.println("Vertice 1: ");
                                            v1 = leitor.next();
                                            vert1 = new Vertice(v1);

                                            System.out.println("Vertice 2: ");
                                            v2 = leitor.next();
                                            vert2 = new Vertice(v2);
                                            grafo.inserirAresta(v1, v2);
                                            break;
                                        case 3:
                                            System.out.println("Vertice 1: ");
                                            v1 = leitor.next();
                                            vert1 = new Vertice(v1);

                                            System.out.println("Vertice 2: ");
                                            v2 = leitor.next();
                                            vert2 = new Vertice(v2);

                                            System.out.println("Insira o valor da Aresta: ");
                                            valor = leitor.nextDouble();
                                            grafo.inserirArestaValorada(v1, v2, valor);
                                            break;
                                    }
                                }

                                break;
                            case 2:
                                int op12 = 0;
                                while (op12 != 4) {

                                    System.out.println("---------------Operacoes---------------");
                                    System.out.println("1 - Inserir Vertice");
                                    System.out.println("2 - Inserir Aresta");
                                    System.out.println("3 - Inserir Aresta(Valorada)");
                                    System.out.println("4 - Sair");
                                    op12 = leitor.nextInt();

                                    switch (op12) {
                                        case 1:
                                            System.out.println("Vertice: ");
                                            v1 = leitor.next();
                                            vert1 = new Vertice(v1);
                                            grafoOrientado.addVertice(vert1);
                                            break;
                                        case 2:
                                            System.out.println("Vertice de origem: ");
                                            v1 = leitor.next();
                                            vert1 = new Vertice(v1);

                                            System.out.println("Vertice de destino: ");
                                            v2 = leitor.next();
                                            vert2 = new Vertice(v2);
                                            grafoOrientado.inserirAresta(v1, v2);
                                            break;
                                        case 3:
                                            System.out.println("Vertice 1: ");
                                            v1 = leitor.next();
                                            vert1 = new Vertice(v1);

                                            System.out.println("Vertice 2: ");
                                            v2 = leitor.next();
                                            vert2 = new Vertice(v2);

                                            System.out.println("Insira o valor da Aresta: ");
                                            valor = leitor.nextDouble();
                                            grafoOrientado.inserirArestaValorada(v1, v2, valor);
                                            break;
                                    }

                                }

                                break;
                            case 3:
                                break;
                        }

                    }
                    break;

                case 2:
                    int op2 = 0;
                    while (op2 != 5) {
                        System.out.println("---------------Matriz---------------");
                        System.out.println("1 - Gravar Arquivo (texto)");
                        System.out.println("2 - Ler Arquivo (texto)");
                        System.out.println("3 - Gerar Imagem via arquivo");
                        System.out.println("4 - Gerar Imagem via strin1g");
                        System.out.println("5 - Sair");
                        op2 = leitor.nextInt();

                        switch (op2) {
                            case 1:
                                System.out.println("Informe o nome do arquivo para criar: ");
                                String nome = leitor.next();
                                grafo.gravarArquivo(nome);
                                break;
                            case 2:
                                System.out.println("Informe o nome do arquivo para criar: ");
                                nome = leitor.next();
                                grafo.lerArquivo(nome);
                                break;
                            case 3:
                                System.out.println("Informe o nome do arquivo a ser lido: ");
                                String arquivo = leitor.next();
                                System.out.println("Informe o nome da imagem a ser criada: ");
                                String imagem = leitor.next();
                                 {
                                    try {
                                        Graph.createFileDotToPng(arquivo, imagem);
                                    } catch (IOException ex) {
                                        System.out.println("ERRO");
                                    }
                                }
                                break;

                            case 4:
                                System.out.println("Informe o nome do arquivo (texto) a ser lido: ");
                                nome = leitor.next();
                                System.out.println("Informe o nome da imagem a ser criada: ");
                                imagem = leitor.next();
                                 {
                                    try {
                                        Graph.createStringDotToPng(nome, imagem);
                                    } catch (IOException ex) {
                                        System.out.println("ERRO");
                                    }
                                }
                                break;

                            case 5:
                                break;
                        }

                    }
                    break;

                case 3:
                    int op3 = 0;
                    while (op != 15) {
                        System.out.println("---------------Matriz---------------");
                        System.out.println("1 - Mostrar Ordem");
                        System.out.println("2 - Mostrar Grau");
                        System.out.println("3 - Mostrar Matriz Orientado");
                        System.out.println("4 - Mostrar DOT nao Orientado");
                        System.out.println("5 - Mostrar DOT Orientado");
                        System.out.println("6 - Grafo Regular?");
                        System.out.println("7 - Grafo Completo?");
                        System.out.println("8 - Mostrar Fecho Transitivo Direto");
                        System.out.println("9 - Mostrar Fecho Transitivo Inverso");
                        System.out.println("10 - Mostrar conexidade");
                        System.out.println("11 - Gerar menor caminho (orientado)");
                        System.out.println("12 - Gerar menor caminho (nao orientado)");
                        System.out.println("13 - Gerar imagem da arvore (Kruskal)");
                        System.out.println("14 - Gerar Grafo reduzido (malgrange)");
                        System.out.println("15 - Sair");
                        op3 = leitor.nextInt();

                        switch (op3) {
                            case 1:
                                System.out.println("Ordem: " + grafo.Ordem());
                                break;
                            case 2:
                                System.out.println("Informe o vertice: ");
                                String v = leitor.next();
                                System.out.println("Grau: " + grafo.Grau(v));
                                break;
                            case 3:
                                System.out.println(grafo.matrizAdjacencia());
                                break;
                            case 4:
                                System.out.println(grafo.dotSimples());
                                break;
                            case 5:
                                System.out.println(grafoOrientado.dotOrientado());
                                break;
                            case 6:
                                if (grafo.grafoRegular()) {
                                    System.out.println("Regular");
                                } else {
                                    System.out.println("Nao Regular");
                                }
                                break;
                            case 7:
                                if (grafoOrientado.Grafo_completo()) {
                                    System.out.println("Completo");
                                } else {
                                    System.out.println("Nao Completo");
                                }
                                break;
                            case 8:
                                System.out.println("Fecho Transitivo Direto(Informe o Vertice): ");
                                v1 = leitor.next();
                                Vertice vertice_ftd = new Vertice(v1);
                                grafoOrientado.buscaTD(vertice_ftd);
                                break;
                            case 9:
                                System.out.println("Fecho Transitivo Inverso(Informe o Vertice): ");
                                v1 = leitor.next();
                                grafoOrientado.buscaTD(grafoOrientado.buscaVertice(v1));
                                break;
                            case 10:
                                if (grafoOrientado.grafoConexo()) {
                                    System.out.println("Conexo");
                                } else {
                                    System.out.println("Nao Conexo");
                                }
                                break;
                            case 11:
                                System.out.println("Informe o vertice de origem");
                                v1 = leitor.next();

                                System.out.println("Informe o vertice de destino");
                                v2 = leitor.next();

                                System.out.println(grafoOrientado.Dijikstra(grafoOrientado.buscaVertice(v1), grafoOrientado.buscaVertice(v2)));
                                Graph.createStringDotToPng(grafoOrientado.Dijikstra(grafoOrientado.buscaVertice(v1), grafoOrientado.buscaVertice(v2)), "naoOrientadoDistancia.png");
                                break;

                            case 12:
                                System.out.println("Informe o vertice de origem");
                                v1 = leitor.next();

                                System.out.println("Informe o vertice de destino");
                                v2 = leitor.next();

                                System.out.println(grafo.Dijikstra(grafo.buscaVertice(v1), grafo.buscaVertice(v2)));
                                Graph.createStringDotToPng(grafo.Dijikstra(grafo.buscaVertice(v1), grafo.buscaVertice(v2)), "naoOrientadoDistancia.png");
                                break;

                            case 13:
                                Graph.createStringDotToPng(grafo.imprimeArvore(), "Arvorekruskal.png");
                                break;
                                
                            case 14:
                                grafoOrientado.malgrange();
                                Graph.createStringDotToPng(grafoOrientado.dotOrientado(), "grafoReduzido.png");
                                break;

                        }
                    }
                    break;

                case 4:
                    System.exit(0);

            }
        }

    }
}

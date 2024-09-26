package AlgoGraf;

public class Main {
    public static void main(String args[]) {
        //Exemplo matriz adjacencia:
        /*Grafo g1 = new Grafo(3);
        g1.insereAresta(0,1,1);
        g1.insereAresta(0,2,2);
        g1.insereAresta(2,1,3);
        System.out.println("Imprimindo Matriz de Adjacencia");
        g1.imprime();

        System.out.print("Existe aresta do vertice 1 -> 2? ");
        System.out.println(g1.existeAresta(1,2));
        System.out.printf("Lista de adjacencia vazia no vertice 1? ");
        System.out.println(g1.listaAdjVazia(1));
        System.out.printf("Peso do primeiro vertice da lista de adjacencia ");
        System.out.println(g1.primeiroListaAdj(0).getPeso());

        g1.retiraAresta(0,2);
        System.out.println("Imprimindo Matriz de Adjacencia apos remocao da aresta 0 -> 2");
        g1.imprime();
        */

        GrafoLista g1 = new GrafoLista(4);
        g1.insereAresta(0,1,5);
        g1.insereAresta(1,1,3);
        g1.insereAresta(1,2,7);
        g1.imprime();
        System.out.println("Fim");

        //Criar metodo que retorna o grau de um vertice v.
        //Criar um metodo que apresenta todos os adjacentes de um vertice v.
    }
}

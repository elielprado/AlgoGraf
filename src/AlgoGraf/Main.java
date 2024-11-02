package AlgoGraf;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        GrafoLista g1 = new GrafoLista(8);
        g1.insereAresta(0,2,0);
        g1.insereAresta(0,4,0);
        g1.insereAresta(2,7,0);
        g1.insereAresta(7,5,0);
        g1.insereAresta(5,1,0);
        g1.insereAresta(5,4,0);
        g1.insereAresta(4,5,0);
        g1.insereAresta(4,7,0);
        g1.insereAresta(1,3,0);
        g1.insereAresta(3,6,0);
        g1.insereAresta(6,0,0);
        g1.insereAresta(6,4,0);
        g1.insereAresta(6,2,0);
        g1.insereAresta(7,3,0);
        g1.insereAresta(5,7,0);

        g1.imprime();

        BuscaEmProfundidade busca = new BuscaEmProfundidade(g1);
        busca.buscaEmProfundidade();

        System.out.println("Conteudo do Array d: ");
        for(int i = 0; i<8;i++){
            System.out.print(" " + busca.d(i));
        }
        System.out.println();

        System.out.println("FIM");

        //Criar metodo que retorna o grau de um vertice v.
        //Criar um metodo que apresenta todos os adjacentes de um vertice v.
    }
}

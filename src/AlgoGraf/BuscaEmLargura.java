package AlgoGraf;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class BuscaEmLargura {
    public static final byte branco = 0;
    public static byte cinza = 1;
    public static byte preto = 2;
    private int d[], antecessor[];
    private Grafo grafo;

    public BuscaEmLargura(Grafo grafo){
        this.grafo = grafo;
        int n = this.grafo.getNumVertices();
        d = new int[n];
        antecessor = new int[n];
    }

    public void buscaLargura() throws Exception{
        int cor[] = new int[this.grafo.getNumVertices()];
        for(int u = 0; u < grafo.getNumVertices(); u++){
            cor[u] = branco;
            this.d[u] = Integer.MAX_VALUE;
            antecessor[u] = -1;
        }
        for(int u=0; u<grafo.getNumVertices(); u++){
            if(cor[u] == branco){
                this.visitaBsf(u,cor);
            }
        }
    }

    private void visitaBsf(int u, int cor[]) throws Exception{
        cor[u] = cinza;
        this.d[u] = 0;
        Queue<Integer> fila = new PriorityQueue<>();
        fila.add(u);
        while(!fila.isEmpty()){
            int aux = fila.element();
            fila.remove();
            u=aux;
            if(!this.grafo.listaAdjVazia(u)){
                Aresta a = this.grafo.primeiroListaAdj(u);
                while(a != null){
                    int v = a.getV2();
                    if(cor[v] == branco){
                        cor[v] = cinza;
                        this.d[v] = d[u] + 1;
                        this.antecessor[v] = u;
                        fila.add(v);
                    }
                    a = this.grafo.proxAdj(u);
                }
            }
            cor[u] = preto;
        }
    }

    public boolean exiteCaminho(int x, int y) throws Exception{
        int cor[] = new int[this.grafo.getNumVertices()];

        for (int u=0; u< grafo.getNumVertices();u++){
            cor[u] = branco;
            this.d[u] = Integer.MAX_VALUE;
            antecessor[u] = -1;
        }

        cor[x] = cinza;
        this.d[x] = 0;
        Queue<Integer> fila = new LinkedList<>();
        fila.add(x);

        while (!fila.isEmpty()){
            int u = fila.poll();

            if (u==y){
                return true;
            }

            if(!this.grafo.listaAdjVazia(u)){
                Aresta a = this.grafo.primeiroListaAdj(u);
                while (a != null){
                    int v = a.getV2();
                    if (cor[v] == branco){
                        cor[v] = cinza;
                        this.d[v] = d[u] + 1;
                        this.antecessor[v] = u;
                        fila.add(v);
                    }
                    a = this.grafo.proxAdj(u);
                }
            }
            cor[u] = preto;
        }
        return false;
    }

    public int d(int v) { return this.d[v];}
    public int antecessor(int v) {return this.antecessor(v);}

}

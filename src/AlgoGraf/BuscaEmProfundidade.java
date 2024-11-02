package AlgoGraf;

public class BuscaEmProfundidade {
    public static final byte branco = 0;
    public static byte cinza = 1;
    public static byte preto = 2;
    private int d[], t[], antecessor[];
    private GrafoLista grafo;

    public BuscaEmProfundidade(GrafoLista grafo){
        this.grafo = grafo;
        int n = this.grafo.numVertices();
        d = new int[n];
        t = new int[n];
        antecessor = new int[n];
    }

    public void buscaEmProfundidade(){
        int tempo = 0; int cor[] = new int[this.grafo.numVertices()];
        for(int u=0; u<this.grafo.numVertices(); u++){
            cor[u] = branco;
            this.antecessor[u] = -1;
        }
        for(int u=0; u<this.grafo.numVertices(); u++){
            if(cor[u]==branco){
                tempo = this.visitaDfs(u,tempo,cor);
            }
        }
    }

    private int visitaDfs(int u, int tempo, int cor[]){
        cor[u] = cinza;
        this.d[u]=++tempo;
        if(!this.grafo.listaAdjVazia(u)){
            Aresta a = this.grafo.primeiroListaAdj(u);
            while(a!=null){
                int v = a.getV2();
                if(cor[v]==branco){
                    this.antecessor[v]=u;
                    tempo = this.visitaDfs(v,tempo,cor);
                }
                a = this.grafo.proxAdj(u);
            }
        }
        cor[u] = preto;
        this.t[u] = ++tempo;
        return tempo;
    }
    public int d (int v) { return this.d[v];}
    public int t (int v) { return this.t[v];}
    public int antecessor(int v) { return this.antecessor(v);}

    public int[] getD() {
        return d;
    }

    public int[] getT() {
        return t;
    }
}


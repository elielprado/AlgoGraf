package AlgoGraf;

public class GrafoLista {
    private Lista adj[];
    private int numVertices;

    public GrafoLista(int num){
        this.adj = new Lista[num];
        this.numVertices = num;

        for(int i=0; i<this.numVertices;i++){
            this.adj[i] = new Lista();
        }
    }

    public void insereAresta(int v1,int v2, int peso){
        Celula item = new Celula(v2,peso);
        this.adj[v1].insere(item);
    }

    public boolean existeAresta(int v1,int v2){
        Celula item = new Celula(v2,0);
        return (this.adj[v1].pesquisa(item) != null);
    }

    public boolean listaAdjVazia(int v) {
        return this.adj[v].vazia();
    }

    public Aresta primeiroListaAdj(int v){
        Celula item = (Celula) this.adj[v].primeiro();
        if(item != null){
            return new Aresta(v,item.vertice,item.peso);
        }
        return null;
    }

    public Aresta proxAdj(int v){
        Celula item = (Celula) this.adj[v].proximo();
        if(item != null) {
            return new Aresta(v,item.vertice, item.peso);
        }
        return null;
    }

    public Aresta retiraAresta(int v1, int v2) throws Exception{
        Celula chave = new Celula(v2,0);
        Celula item = (Celula)this.adj[v1].retira(chave);
        if(item != null){
            return  new Aresta(v1,v2,item.peso);
        }
        return null;
    }

    public void imprime() {
        for(int i = 0; i<this.numVertices; i++){
            System.out.print("Vertice " +i+": ");
            Celula item= (Celula) this.adj[i].primeiro();
            while(item!=null){
                System.out.print("" +item.vertice + " ("+item.peso+"),");
                item = (Celula) this.adj[i].proximo();
            }
            System.out.println();
        }
    }

    public int numVertices() {
        return this.numVertices;
    }

    public int grauTotalVertice(int v){
        int grau = 0;

        // Contando as arestas de saída de v
        for(int i = 0; i<this.numVertices; i++){
            if(this.existeAresta(v, i)){
                grau++;
            }
        }

        // Contando as arestas de entrada para v
        for(int i = 0; i<this.numVertices; i++){
            if(this.existeAresta(i, v) && i != v){ // Evitando contar arestas de laço duas vezes
                grau++;
            }
        }

        return grau;
    }


    public void listaAdjacentes(int v){
        Celula item = (Celula) this.adj[v].primeiro();
        while(item != null){
            System.out.print(item.vertice + " ");
            item = (Celula) this.adj[v].proximo();
        }
        System.out.println();
    }

    public int grauSaidaVertice(int v) {
        int grau = 0;
        for (int i = 0; i < this.numVertices; i++) {
            if (this.existeAresta(v, i)) {
                grau++;
            }
        }
        return grau;
    }
}




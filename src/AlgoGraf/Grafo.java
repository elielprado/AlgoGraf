package AlgoGraf;

public class Grafo {
    //para metodo de matriz de adj
    private int mat[][];
    private int numVertices;
    //posicao atual ao se percorrer os adj de um vertice v
    private int pos[];



    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices){
        this.numVertices = numVertices;
    }


    //Construtor para matriz de adj
    public Grafo(int num) {
        this.mat = new int[num][num];
        this.pos = new int[num];
        this.numVertices = num;
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                this.mat[i][j] = 0;
            }
            this.pos[i] = -1;
        }
    }

    public void insereAresta(int v1, int v2, int peso){
        this.mat[v1][v2] = peso;
    }

    public boolean existeAresta(int v1, int v2){
        return this.mat[v1][v2] != 0;
    }

    public boolean listaAdjVazia(int v){
        for(int i=0; i<this.numVertices; i++){
            if(this.mat[v][i] != 0){
                return false;
            }
        }
        return true;
    }


    public Aresta primeiroListaAdj(int v){
        this.pos[v] = -1;
        return this.proxAdj(v);
    }

    public Aresta proxAdj(int v){
        this.pos[v]++;
        while((this.pos[v] < this.numVertices) && (this.mat[v][this.pos[v]] == 0)){
            this.pos[v]++;
        }
        if(this.pos[v] == this.numVertices){
            return null;
        }
        else {
            return (new Aresta(v,this.pos[v],this.mat[v][this.pos[v]]));
        }
    }

    public Aresta retiraAresta(int v1, int v2){
        if(this.mat[v1][v2] == 0){
            return null;
        }
        else {
            Aresta aresta = new Aresta (v1,v2,this.mat[v1][v2]);
            this.mat[v1][v2] = 0;
            return aresta;
        }
    }

    public void imprime(){
        System.out.println("Vertices: ");
        for(int i=0; i < this.numVertices;i++){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Matriz de Adjacencia:");
        for(int i=0;i<this.numVertices;i++){
            System.out.print(i + " ");
            for(int j=0; j<this.numVertices; j++){
                System.out.print(this.mat[i][j] + " ");
            }
            System.out.println();

        }
    }

}

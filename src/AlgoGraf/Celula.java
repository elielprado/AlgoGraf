package AlgoGraf;

public class Celula {
    int vertice, peso;
    public Celula(int v, int p){
        this.vertice = v;
        this.peso = p;
    }

    public boolean equals(Object obj){
        Celula item = (Celula)obj;
        return this.vertice == item.vertice;
    }

}

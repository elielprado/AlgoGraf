package AlgoGraf;

public class Aresta {
    private int v1, v2, peso;


    public Aresta(int v1, int v2, int peso) {
        super();
        this.v1 = v1;
        this.v2 = v2;
        this.peso = peso;
    }

    public Aresta(){
        super();
    }

    public int getV1() {
        return v1;
    }

    public void setV1(int v1) {
        this.v1 = v1;
    }

    public int getV2() {
        return v2;
    }

    public void setV2(int v2) {
        this.v2 = v2;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}

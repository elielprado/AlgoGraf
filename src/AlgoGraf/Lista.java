package AlgoGraf;

public class Lista {
    private static class Celula{Object item; Celula prox;}
    private Celula primeiro, ultimo,pos;

    public Lista(){
        this.primeiro = new Celula();
        this.pos = this.primeiro;
        this.ultimo = this.primeiro;
        this.primeiro.prox = null;
    }

    public boolean vazia() {
        return this.primeiro == this.ultimo;
    }

    public Object pesquisa(Object chave){
        if(this.vazia() || chave == null){
            return null;
        }
        Celula aux = this.primeiro;
        while(aux.prox!=null){
            if(aux.prox.item.equals(chave)) {
                return aux.prox.item;
            }
            aux = aux.prox;
        }
        return null;
    }

    public void insere(Object x){
        this.ultimo.prox = new Celula();
        this.ultimo = this.ultimo.prox;
        this.ultimo.item = x;
        this.ultimo.prox = null;
    }

    public Object retira(Object chave) throws Exception{
        if(this.vazia() || chave == null){
            throw new Exception("Erro: Lista vazia ou chave invalida");
        }
        Celula aux = this.primeiro;
        while(aux.prox != null && !aux.prox.item.equals(chave)){
            aux = aux.prox;
        }
        if(aux.prox == null){
            return null;
        }
        Celula q = aux.prox;
        Object item = q.item;
        aux.prox = q.prox;
        if(aux.prox == null) {
            this.ultimo = aux;
        }
        return item;
    }

    public Object retiraPrimeiro() throws Exception {
        if(this.vazia()){
            throw new Exception("Erro: Lista vazia");
        }
        Celula aux = this.primeiro;
        Celula q = aux.prox;
        Object itemObject = q.item;
        aux.prox = q.prox;
        if(aux.prox == null){
            this.ultimo = aux;
        }
        return itemObject;
    }

    public Object primeiro(){
        this.pos = primeiro;
        return proximo();
    }

    public Object proximo(){
        this.pos = this.pos.prox;
        if(this.pos == null) {
            return null;
        }
        else {
            return this.pos.item;
        }
    }
}

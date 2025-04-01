package estruturas;

public class Iterador {
    
    Lista lista;
    No atual;

    public Iterador(Lista lista, No atual) {
        this.lista = lista;
        this.atual = atual;
    }

    public Boolean haProximo() {
        return this.atual.proximo != null;
    }

    public Boolean haAnterior() {
        return this.atual.anterior != null;
    }

    public void proximo() {
        this.atual = atual.proximo;
    }

    public int getDadoAnterior() {
        return this.atual.anterior.dado;
    }

    public int getDadoProximo() {
        return this.atual.proximo.dado;
    }

    public int getDado() {
        return this.atual.dado;
    }

    public No getAtual() {
        return this.atual;
    }

    public void resetar() {
        this.atual = this.lista.inicio;
    }

    public void display() {
        if (this.haAnterior()) {
            System.out.print("Anterior -> " + this.getDadoAnterior() + " | ");
        }

        System.out.print("No " + this.getDado());
        
        if (this.haProximo()) {
            System.out.println(" | Proximo -> " + this.getDadoProximo());
        }
        System.out.println("");
        this.proximo();
    }

    // Inserir após o nó atual
    public void inserirApos(int valor) {
        No novoNo = new No(valor);

        if (this.atual.proximo != null) {
            novoNo.proximo = this.atual.proximo;
            this.atual.proximo.anterior = novoNo;
        }

        this.atual.proximo = novoNo;
        novoNo.anterior = this.atual;
    }

    // Remover após o nó atual
    public void removerApos() {
        if (this.atual.proximo == null) {
            System.out.println("Não há próximo nó para remover.");
            return;
        }

        No noRemover = this.atual.proximo;
        this.atual.proximo = noRemover.proximo;

        if (noRemover.proximo != null) {
            noRemover.proximo.anterior = this.atual;
        }

        noRemover.proximo = null; // Desconecta o nó removido
        noRemover.anterior = null; // Desconecta o nó removido
    }

    // Inserir antes do nó atual
    public void inserirAntes(int valor) {
        No novoNo = new No(valor);

        if (this.atual.anterior != null) {
            novoNo.anterior = this.atual.anterior;
            this.atual.anterior.proximo = novoNo;
        }

        this.atual.anterior = novoNo;
        novoNo.proximo = this.atual;
        
        // Caso o nó atual seja o primeiro nó (início da lista)
        if (this.atual == this.lista.inicio) {
            this.lista.inicio = novoNo;
        }
    }

    // Remover antes do nó atual
    public void removerAntes() {
        if (this.atual.anterior == null) {
            System.out.println("Não há nó anterior para remover.");
            return;
        }

        No noRemover = this.atual.anterior;
        this.atual.anterior = noRemover.anterior;

        if (noRemover.anterior != null) {
            noRemover.anterior.proximo = this.atual;
        }

        noRemover.anterior = null; // Desconecta o nó removido
        noRemover.proximo = null; // Desconecta o nó removido
    }
}

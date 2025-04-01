package estruturas;

public class Lista {

    public No inicio;
    private int tamanho; //atributo que armazena o tamanho da lista
 
    public Lista() {
        this.inicio = null;
    }

    public void adicionarAoInicio(int valor) {
        No no = new No(valor);

        if (this.inicio == null) {
            this.inicio = no;
            return;
        }

        this.inicio.anterior = no;

        no.proximo = this.inicio;
        this.inicio = no;
        tamanho++;
    }

    public void adicionarAoFim(int valor) {
        No novoNo = new No(valor);
    
        // Se a lista estiver vazia, início = novo nó
        if (this.inicio == null) {
            this.inicio = novoNo;
            return;
        }
    
        // Percorre a lista  até o último nó
        No atual = this.inicio;
        while (atual.proximo != null) {
            atual = atual.proximo;
        }
    
        // Atualiza os ponteiros
        atual.proximo = novoNo;
        novoNo.anterior = atual;
        tamanho++;
    }

    public void inserirAposValor(int valor, int novoValor) {
        No atual = this.inicio;
    
        // Se a lista estiver vazia
        if (atual == null) {
            System.out.println("A lista está vazia.");
            return;
        }
    
        // Percorre a lista até encontrar o nó com o valor desejado
        while (atual != null && atual.dado != valor) {
            atual = atual.proximo;
        }
    
        // Se não encontrou o valor, informa que o valor não existe
        if (atual == null) {
            System.out.println("Valor não encontrado na lista.");
            return;
        }
    
        // Cria o novo nó
        No novoNo = new No(novoValor);
    
        // Insere o novo nó após o nó encontrado
        novoNo.proximo = atual.proximo;
    
        if (atual.proximo != null) {
            atual.proximo.anterior = novoNo;
        }
    
        atual.proximo = novoNo;
        novoNo.anterior = atual;
    
        tamanho++;
    }

    //não entendi 'adicionar tamanho - adicionando nós já estou adicionando tamanho'
    public int obterTamanho(){
        return this.tamanho;
    }

    public void contarNos(){
        if (this.inicio == null){
            System.out.println("A lista está vazia.");
            return;
        }
        No atual = this.inicio;
        int count = 0;
        while (atual.proximo != null){
            count = count+1;
            atual = atual.proximo;
        }
        System.out.println("O número total de nós é: "+count);
    }

    public void mostrarNos() {
        Iterador iterador = this.getIterador();
        
        while (iterador.getAtual() != null) {
            iterador.display();
        }
    }

    public void remover(int valor) {
        No noAux = this.inicio;

        while (noAux != null && noAux.dado != valor) {
            noAux = noAux.proximo;
        }
        if (noAux == null) {
            System.out.println("Valor não encontrado");
            return;
        }

        noAux.anterior.proximo = noAux.proximo;
        noAux.proximo.anterior = noAux.anterior;
    }

    public Iterador getIterador() {
        return new Iterador(this, this.inicio);
    }
}


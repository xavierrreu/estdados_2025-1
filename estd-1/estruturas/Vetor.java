package estruturas;

public class Vetor {

    public Integer[] elementos; // 3fc -> 4fd
    private int tamanho;
    private int capacidade;

    public Vetor(int capacidade) {
        this.elementos = new Integer[capacidade];
        this.capacidade = capacidade;
        this.tamanho = 0;
    }

    public void adicionar(Integer valor) {
        if (this.capacidade == this.tamanho) {
            this.aumentarCapacidade();
        }

        this.elementos[this.tamanho] = valor;
        this.tamanho++;
    }

    public void adicionarAoInicio(Integer valor){
        if (this.capacidade == this.tamanho) {
            this.aumentarCapacidade();
        }

        this.moverElementos();

        this.elementos[this.tamanho - this.tamanho] = valor;
        this.tamanho++;

    }

    private void aumentarCapacidade() {
        int novaCapacidade = this.capacidade + (this.capacidade/2);
        Integer[] novosElementos = new Integer[novaCapacidade];

        for (int i =0; i<this.tamanho; i++) {
            novosElementos[i] = this.elementos[i];
        }

        this.elementos = novosElementos;
        this.capacidade = novaCapacidade;
    }

    public void mostrarElementos() {
        System.out.print("Elementos no vetor:");
        for (int i=0; i < tamanho; i++) {
            System.out.print(" " + this.elementos[i] + " ");
        }
        System.out.println();
    }

    public void moverElementos(){
        for (int i = this.tamanho; i >= 0; i--) {
            if (this.elementos[i+1] == null){
                this.elementos[i+1] = this.elementos[i];
                this.elementos[i] = null;
            }
        }
    }

    public void contem(Integer valor) {
        for (int i=0; i < tamanho; i++) {
            if (this.elementos[i] == valor) {
                System.out.println("Valor encontrado");
                return;
            }
        }
        System.out.println("Valor não encontrado");
    }

    public void remover(int posicao) {
        if (posicao > this.tamanho) {
            System.out.println("Posição informada é inválida");
            return;
        }

        for (int i = posicao; i < this.tamanho-1; i++) {
            this.elementos[i] = this.elementos[i+1];
        }

        this.elementos[this.tamanho-1] = null;
        this.tamanho--;
    }

    public void removerPorValor(Integer valor) {
        for (int i=0; i<this.tamanho; i++) {
            if (this.elementos[i] == valor) {
                this.remover(i);
                System.out.println("Item removido");
                return;
            }
        }

        System.out.println("Item não encontrado");
    }

    public void buscaBinaria(Integer valor) {
        this.organizarElementos();
        
        // Definindo os índices de busca
        int inicio = 0;
        int fim = this.tamanho - 1;
        
        System.out.println("Buscando pelo elemento de valor " + valor + "...");
        // Executa a busca binária enquanto o intervalo for válido
        while (inicio <= fim) {
            // Encontra o índice do meio
            int meio = inicio + (fim - inicio) / 2;
            
            // Verifica se o valor no meio é o que estamos procurando
            if (elementos[meio]==(valor)) {
                System.out.println("Elemento encontrado na posição " + meio);
                return; // Retorna se o valor for encontrado
            }
            
            // Se o valor procurado for maior que o valor no meio, descarta a metade inicio
            if (elementos[meio] < valor) {
                inicio = meio + 1;
            }
            // Se o valor procurado for menor que o valor no meio, descarta a metade fim
            else {
                fim = meio - 1;
            }
        }
        
        // Caso o valor não seja encontrado no vetor
        System.out.println("Elemento não encontrado.");
    }

    public void organizarElementos(){
        if (this.capacidade == this.tamanho) {
            this.aumentarCapacidade();
        }
        int aux;
        for (int i = 0; i < this.tamanho; i++) {
            for (int j = 0; j < this.tamanho; j++) {
                if (this.elementos[j] > this.elementos[i]) {
                    aux = this.elementos[j];
                    this.elementos[j] = this.elementos[i];
                    this.elementos[i] = aux;

                }
            }
        }
    }
}
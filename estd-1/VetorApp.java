import estruturas.*;


public class VetorApp {

    public static void main(String[] args) {
        
        //################################# testes vetor #######################################
        Vetor vetor = new Vetor(10);

        vetor.adicionar(2);
        vetor.adicionar(12);
        vetor.adicionar(54);
        vetor.adicionar(33);
        vetor.adicionar(7);
        vetor.adicionar(9);
        vetor.adicionar(21);
        vetor.adicionar(16);
        vetor.adicionar(42);
        vetor.adicionar(27);

        vetor.mostrarElementos();

        vetor.adicionarAoInicio(28);

        vetor.mostrarElementos();
        vetor.organizarElementos();

        System.out.println("Elementos após organização em ordem crescente: ");
        vetor.mostrarElementos();

        vetor.buscaBinaria(16);
        vetor.buscaBinaria(76); 


        //############################# testes lista duplamente encadeada ####################
        Lista lista = new Lista();
        lista.adicionarAoInicio(2);
        lista.adicionarAoInicio(12);
        lista.adicionarAoInicio(54);
        lista.adicionarAoInicio(33);
        lista.adicionarAoInicio(7);
        lista.adicionarAoInicio(9);
        lista.adicionarAoInicio(21);
        lista.adicionarAoInicio(16);
        lista.adicionarAoInicio(42);
        lista.adicionarAoInicio(27);

        lista.mostrarNos();
        System.out.println("-----");

        System.out.println("Adicionando valor ao fim da lista encadeada...");
        lista.adicionarAoFim(38);
        lista.mostrarNos();

        lista.remover(21);
        lista.mostrarNos();
        lista.contarNos();
        lista.obterTamanho();

        lista.inserirAposValor(7, 340);
        lista.mostrarNos();


        //############### testes iteradores ##########################
        Iterador iterador = new Iterador(lista, lista.inicio);
        iterador.inserirApos(5);  // Insere o valor 5 após o nó atual
        iterador.removerApos();   // Remove o nó após o nó atual
        iterador.inserirAntes(3); // Insere o valor 3 antes do nó atual
        iterador.removerAntes();  // Remove o nó antes do nó atual

    }
}
public class Main {
    public static void main(String[] args) {
        
        /*QUESTÃO 01*/
        ArvoreGenerica<String> arvore = new ArvoreGenerica<>();
        Posicao<String> empresa = arvore.adicionarRaiz("Empresa");
        //Filhos de "Empresa"
        Posicao<String> rh = arvore.adicionarFilho(empresa, "RH");
        Posicao<String> ti = arvore.adicionarFilho(empresa, "TI");
        Posicao<String> financeiro = arvore.adicionarFilho(empresa, "Financeiro");
        //Filhos de "RH"
        Posicao<String> recrutamento = arvore.adicionarFilho(rh, "Recrutamento");
        Posicao<String> beneficios = arvore.adicionarFilho(rh, "Benefícios");
        //Filhos de "Recrutamento" e "Benefícios"
        arvore.adicionarFilho(recrutamento, "Estágios");
        arvore.adicionarFilho(beneficios, "Convênios");
        //Filhos de "TI"
        Posicao<String> desenvolvimento = arvore.adicionarFilho(ti, "Desenvolvimento");
        Posicao<String> suporte = arvore.adicionarFilho(ti, "Suporte");
        //Filhos de "Desenvolvimento"
        Posicao<String> frontend = arvore.adicionarFilho(desenvolvimento, "Front-end");
        Posicao<String> backend = arvore.adicionarFilho(desenvolvimento, "Back-end");
        //Filho de "Front-end"
        arvore.adicionarFilho(frontend, "Angular");
        //Filhos de "Financeiro"
        Posicao<String> contabilidade = arvore.adicionarFilho(financeiro, "Contabilidade");
        //Filho de "Contabilidade"
        arvore.adicionarFilho(contabilidade, "Impostos");
        
        /*QUESTÃO 2*/
        //Pré-ordem
        System.out.println("Percurso em pré-ordem:");
        arvore.percursoPreOrdem(empresa);
        System.out.println();
        //Pós-ordem
        System.out.println("Percurso em pós-ordem:");
        arvore.percursoPosOrdem(empresa);
        System.out.println();

        /*QUESTÃO 04*/
        System.out.println("Nós folha:");
        arvore.imprimirNosFolha(arvore, empresa);

        /*QUESTÃO 05*/
        System.out.println("Profundidade de 'Empresa': " + arvore.profundidade(empresa));
        System.out.println("Profundidade de 'RH': " + arvore.profundidade(rh));
        System.out.println("Profundidade de 'Recrutamento': " + arvore.profundidade(recrutamento));
    }
}
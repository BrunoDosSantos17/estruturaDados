/*
 Fazer um programa para a realização das seguintes operações com uma lista duplamente encadeada:
- incluir um objeto no início na lista
- incluir um objeto no final da lista
- incluir um objeto em um ponto qualquer entre o primeiro e o último.
- verificar se um objeto específico está na lista
- remover um objeto específico da lista
- remover o primeiro objeto da lista
- remover o último objeto da lista
- mostrar todos os objetos da lista na ordem do primeiro para o último
- mostrar todos os objetos da lista na ordem do último para o primeiro
 */
package listaduplaencadeada;

import java.util.Scanner;

public class ListaDuplaEncadeada {

    int contador;
    public Lista primeiro;
    public Lista ultimo;
    static ListaDuplaEncadeada lista = new ListaDuplaEncadeada();

    static Scanner tec = new Scanner(System.in);

    public int pedeInt(String msg) {
        int nume = 0;

        try {
            System.out.println(msg);
            nume = tec.nextInt();
        } catch (Exception e) {
            System.out.println("Você foi burro o suficiente por cair nessa mensagem");
        }
        return nume;
    }

    public static void main(String[] args) {

        lista.pedeMenu();
    }

    private void pedeMenu() {
        int opc = 0;
        System.out.println("1 - incluir um objeto no início na lista\n"
                + "2 - incluir um objeto no final da lista\n"
                + "3 - incluir um objeto em um ponto qualquer entre o primeiro e o último.\n"
                + "4 - verificar se um objeto específico está na lista\n"
                + "5 - remover um objeto específico da lista\n"
                + "6 - remover o primeiro objeto da lista\n"
                + "7 - remover o último objeto da lista\n"
                + "8 - mostrar todos os objetos da lista na ordem do primeiro para o último\n"
                + "9 - mostrar todos os objetos da lista na ordem do último para o primeiro\n"
                + "10 - Sair do programa\n"
                + "Escolha uma das opções acima:");
        
        opc = tec.nextInt();

        do {
            switch (opc) {
                case 1:
                    IncluirPrimeiro();
                    break;
                case 2:
                    IncluiFinalLista();
                    break;
                case 3:
                    IncluirQualquerPonto();
                    break;
                case 4:
                    VerificarLista();
                    break;
                case 5:
                    break;
                case 6:
                    RemoverPrimeiroLista();
                    break;
                case 7:
                    RemoverUltimoLista();
                    break;
                case 8:
                    MostraCrescente();
                    break;
                case 9:
                    MostraDecrescente();
                    break;
                case 10:
                    System.exit(0);
                    break;

            }
        } while (opc != 10);
    }

    //verifica
    public boolean VerificaListaVazia() {
        Lista novo = new Lista();
        if (primeiro == null) {
            System.out.println("Lista vazia.");
            novo.setValor(pedeInt("Digite um número:"));
            primeiro = novo;
            primeiro.anterior = null;
            ultimo = novo;
            ultimo.proximo = null;
            return true;
        } else {
            System.out.println("Lista não vazia.");
            return false;
        }
    }

    //inclui na primeira posição
    public void IncluirPrimeiro() {
        Lista novo = new Lista();
        contador++;
        if (!VerificaListaVazia()) {
            novo.setValor(pedeInt("Digite um número:"));
            primeiro.anterior = novo;
            novo.proximo = primeiro;
            novo.anterior = null;
            primeiro = novo;

        }

        System.out.println("Número incluido.");
        lista.pedeMenu();
    }

    //inclui no final da lista
    public void IncluiFinalLista() {
        Lista novo = new Lista();
        contador++;
        if (!VerificaListaVazia()) {
            novo.setValor(pedeInt("Digite um número:"));
            ultimo.proximo = novo;
            novo.anterior = ultimo;
            novo.proximo = null;
            ultimo = novo;
        }
        System.out.println("Número incluido.");
        lista.pedeMenu();

    }

    //mostra na ordem do primeiro ao ultimo
    public void MostraCrescente() {
        Lista atual = primeiro;
        System.out.println("**************Mostrar lista*****************");
        while (atual != null) {
            System.out.println(atual.getValor());
            atual = atual.proximo;
        }
        System.out.println("*********************************");
        lista.pedeMenu();
    }

    //mostra na ordem do primeiro ao ultimo
    public void MostraDecrescente() {
        Lista atual = ultimo;
        System.out.println("**************Mostrar lista*****************");
        while (atual != null) {
            System.out.println(atual.getValor());
            atual = atual.anterior;
        }
        System.out.println("*********************************");
        lista.pedeMenu();
    }

    public void IncluirQualquerPonto() {
        Lista proximoAtual;
        Lista anteriorAtual;
        Lista novo = new Lista();
        int cont = 0;
        int posicaoAdd;
        if (!VerificaListaVazia()) {
            do {
                posicaoAdd = pedeInt("Digite um número entre ou igual ao número dentro da lista.A lista está possuindo:" + contador + " posições");
            } while (posicaoAdd > contador && posicaoAdd > 0);
            novo.setValor(pedeInt("Digite um número:"));
            do {
                proximoAtual = primeiro.proximo;
                cont++;
            } while (posicaoAdd == cont);
            anteriorAtual = proximoAtual.anterior;
            novo.proximo = proximoAtual;
            proximoAtual.anterior = novo;
            novo.anterior = anteriorAtual;
            anteriorAtual.proximo = novo;
            contador++;
        }

        lista.pedeMenu();
    }

    private void VerificarLista() {
        Lista atual = primeiro;
        int cont = 0;
        int vezes = 0;
        int numeroProcura;
        if (atual == null) {
            System.out.println("Lista vazia");
        }else{
            numeroProcura = pedeInt("Digite um número que desejas procurar: ");
            do {
                if (numeroProcura == atual.valor) {
                    vezes++;
                }
                atual = atual.proximo;
                cont ++;
            } while (contador != cont);
            System.out.println("Esta lista possui:" + vezes + " o número procurado.");
        }
        lista.pedeMenu();
    }

    private void RemoverUltimoLista() {
       Lista Remover = new Lista();
       int cont = 0;
        if (contador == 1) {
            ultimo = null;
            primeiro = null;
        }else{
            do {
                Remover = primeiro.proximo;
                cont++;
            } while (contador != cont);
                ultimo = Remover;
        }
       lista.pedeMenu();
    }

    private void RemoverPrimeiroLista() {
        System.out.println(primeiro);
    }
}

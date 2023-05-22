/**
 * Autor: Nicolas Cunha
 * <p>
 * Fazer um programa para a realização das seguintes operações com uma lista
 * encadeada simples não circular:
 * <p>
 * - incluir um objeto no início na lista
 * <p>
 * - incluir um objeto no final da lista
 * <p>
 * - verificar se um objeto específico está na lista
 * <p>
 * - remover um objeto específico da lista
 * <p>
 * - remover o primeiro objeto da lista
 * <p>
 * - remover o último objeto da lista
 * <p>
 * - mostrar todos os objetos da lista na ordem do primeiro para o último
 * <p>
 * - mostrar todos os objetos da lista na ordem do último para o primeiro
 */
package lista;

import static lista.Util.pedeInt;
import static lista.Util.pedeNumero;

/**
 *
 * @author Bruno dos Santos
 */
public class Lista {

    static Numero inicio = null;
    static Numero fim = null;
    static int Id = 0;

    public static void main(String[] args) {
        int e;
        do {
            e = pedeInt(" * 0- sair\n"
                    + "     * 1- Incluir um objeto no início na lista\n"
                    + "     * 2- incluir um objeto no final da lista\n"
                    + "     * 3- verificar se um objeto específico está na lista\n"
                    + "     * 4- remover um objeto específico da lista\n"
                    + "     * 5- remover o primeiro objeto da lista\n"
                    + "     * 6- remover o último objeto da lista\n"
                    + "     * 7- mostrar todos os objetos da lista na ordem do primeiro para o último\n"
                    + "     * 8- mostrar todos os objetos da lista na ordem do último para o primeiro\n"
                    + "Escolha uma das opções acima:");
            switch (e) {

                case 0:
                    System.exit(0);
                    break;
                case 1:
                    InsereInicioLista();
                    break;
                case 2:
                    InserirNoFim();
                    break;
                case 3:
                    Existencia();
                    break;
                case 4:
                    removerObjeto();
                    break;
                case 5:
                    removerInicio();
                    break;
                case 6:
                    removerFinal();
                    break;
                case 7:
                    PriUlt();
                    break;
                case 8:
                    UltPri();
                    break;

            }
        } while (e != 0);

    }

    public static void SemLista() {
        inicio = pedeNumero();
        fim = inicio;
        inicio.setNu(fim);
        fim.setNu(null);
    }

    private static void InsereInicioLista() {
        if (inicio == null) {
            SemLista();

        } else {
            Numero n = pedeNumero();
            n.setNu(inicio);
            inicio = n;
        }

    }

    private static void InserirNoFim() {
        if (inicio == null) {
            SemLista();
        } else {
            Numero n = pedeNumero();
            fim.setNu(n);
            fim = n;
        }
    }

    private static void Existencia() {
        boolean exist = false;
        int contador = 0;
        int localizar;
        Numero atual;
        do {
            localizar = pedeInt("Escreva o número que desejas localizar de 1 a 100");
        } while (localizar < 1 || localizar > 100);

        atual = inicio;
        if (atual != null) {
            while (atual != null) {
                if (atual.getNumero() == localizar) {
                    exist = true;
                    contador += 1;
                }
                atual = atual.getNu();

            }
        }
        if (exist) {
            System.out.println("Existe o número e tem " + contador + " vezes a ocorrência do número escolhido");
        } else {
            System.out.println("Não a ocorrência deste número");
        }
    }

    private static void removerObjeto() {
        Numero atual = inicio;
        int nu;
        do {
            nu = pedeInt("Escreva o numero que desejas remover entre 1 a 100");
        } while (nu < 1 || nu > 100);

        if (atual == null) {
            System.out.println("Não existe uma lista");
        } else if (nu == inicio.getNumero()) {
            removerInicio();

        } else if (nu == fim.getNumero()) {
            removerFinal();
        } else {
            while (atual != null) {
                if (atual.getNumero() == nu) {
                    Numero ante = busca(atual);
                    ante.setNu(atual.getNu());
                }
                atual = atual.getNu();
            }
            System.out.println("Eliminado com sucesso");
        }

    }

    private static void removerInicio() {
        inicio = inicio.getNu();

    }

    private static void removerFinal() {
        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            Numero atual = inicio;
            while (atual != null) {
                if (atual.getNu().getNu() == null) {
                    atual.setNu(null);
                    fim = atual;
                }
                atual = atual.getNu();

            }
        }

    }

    private static Numero busca(Numero atual) {
        Numero a1 = null;
        Numero a = inicio;
        while (inicio != null) {
            if (a.getNu() == atual) {
                a1 = a;
            }
            atual = atual.getNu();

        }
        return a1;
    }

    private static void PriUlt() {
        if (inicio == null) {
            System.out.println("Não existe lista");

        } else {
            Numero atual = inicio;
            System.out.println("ID - Numero");
            System.out.println("------------------------------------------------------------------------------------");
            while (atual != null) {

                System.out.println(atual.getId() + " - " + atual.getNumero());
                atual = atual.getNu();
            }
        }
    }

    private static void UltPri() {
        if (inicio == null) {
            System.out.println("Não existe lista");
        } else {
            Numero atual = fim;
            System.out.println("ID - Numero");
            System.out.println("------------------------------------------------------------------------------------");
            while (atual != null) {
                System.out.println(atual.getId() + " - " + atual.getNumero());

                if (atual != inicio) {
                    atual = busca(atual);
                } else {
                    atual = null;
                }

            }
        }
    }

}

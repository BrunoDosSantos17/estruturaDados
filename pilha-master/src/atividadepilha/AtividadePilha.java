package atividadepilha;

import java.util.Scanner;

/**
 * Funções do programa: - empilhar um objeto - desempilhar um objeto - mostrar
 * objetos da pilha
 *
 * @author Bruno
 */
public class AtividadePilha {

    static Scanner tec = new Scanner(System.in);
    cores topo = null;
    int contador;

    public static void main(String[] args) {
        AtividadePilha pilha = new AtividadePilha();
        pilha.Menu();

    }

    private void Menu() {
        int escolha = pedeInteiro(4, "1 - empilhar um objeto \n"
                + "2 - desempilhar um objeto \n"
                + "3 - mostrar\n"
                + "Digite uma das opcões na lista:");
        switch (escolha) {
            case 1:
                empilharObjeto();
                break;
            case 2:
                desempilharObjeto();
                break;
            case 3:
                listarObjeto();
        }
    }

    private static int pedeInteiro(int limit, String msg) {
        int mandaInteiro = 0;
        do {
            System.out.println(msg);
            mandaInteiro = tec.nextInt();

        } while (mandaInteiro < 0 && mandaInteiro > limit);

        return mandaInteiro;
    }

    private static String pedeString(String msg) {
        String mandaString;
        tec = new Scanner(System.in);
        do {
            System.out.println(msg);
            mandaString = tec.nextLine().trim();
        } while (mandaString == "");

        return mandaString;
    }

    private void empilharObjeto() {
        contador++;
        cores novo = new cores();
        novo.setCor(pedeString("Escreva uma cor diferente de vázio:"));
        novo.setId(contador);
        novo.proximo = topo;
        topo = novo;
        Menu();
    }

    private void desempilharObjeto() {
        if (topo == null) {
            if (pedeInteiro(3, "Imposivel de executar a operação pois a lista está vazia.\n"
                    + "deseja voltar para o menu(digite 1): \n"
                    + "ou adicionar um objeto(digite 2): ") == 1) {
                Menu();

            } else {
                empilharObjeto();

            }
        } else {
            topo = topo.proximo;
        }
        Menu();
    }

    private void listarObjeto() {
        cores percorer = topo;
        if (percorer == null) {
            System.out.println("Lista vazia");
             System.out.println("*************************************");
        } else {
            while (percorer != null) {
                System.out.println("*************************************");
                System.out.println(percorer.id + ": " + percorer.cor);
                System.out.println("*************************************");

                percorer = percorer.proximo;
            }
        }
        Menu();
    }

}

package Menu;

import java.util.Scanner;
import Arvore.ArvoreBusca;
import Util.*;
import Ordenacao.metodosOrdenacao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author bruno
 */
public class menu {

    private Scanner br;
    private final ArvoreBusca erva;

    public menu() {
        this.br = new Scanner(System.in);
        this.erva = new ArvoreBusca();
    }

    public void menu() {
        byte opc;
        try {
            do {
                System.out.println("Escolha umas das opções abaixo:\n"
                        + "1 - Adicionar novo elemento; \n"
                        + "2 - Remover elemento;\n"
                        + "3 - Verificar se possui elemento;\n"
                        + "4 - Visualizar elementos;\n"
                        + "5 - Sair");
                opc = this.br.nextByte();
            } while (opc < 1 || opc > 5);

            switch (opc) {
                case 1:
                    this.addElement();
                    break;
                case 2:
                    this.delElement();
                    break;
                case 3:
                    this.posElement();
                    break;
                case 4:
                    this.visual();
                    break;
                default:
                    this.saida();
                    break;
            }
        } catch (Exception e) {
            this.br = new Scanner(System.in);
            this.menu();
        }
    }

    private void addElement() {
        int num;
        try {
            do {
                System.out.println("Escreva um número para ser "
                        + "adicionado de 0 até 100");
                num = br.nextByte();
            } while (num < 0 || num > 100);
            this.erva.add(num);
            System.out.println("Adicionado com sucesso\n");

        } catch (Exception e) {
            System.out.println("Ops você digitou algo errado\n");
            this.br = new Scanner(System.in);
        }
        this.menu();
    }

    private void delElement() {
        int num;
        try {
            do {
                System.out.println("Escreva um número para ser "
                        + "removido de 0 até 100");
                num = br.nextByte();
            } while (num < 0 || num > 100);

            System.out.println(this.erva.del(num) ? "Número deletedo"
                    : "Número não encontrado");

        } catch (Exception e) {
            System.out.println("Ops você digitou algo errado\n");
            this.br = new Scanner(System.in);
        }
        this.menu();
    }

    private void posElement() {
        int num;
        try {
            do {
                System.out.println("Escreva um número para ser "
                        + "verificado na árvore de 0 até 100");
                num = br.nextByte();
            } while (num < 0 || num > 100);

            System.out.println(this.erva.possui(num) ? "Elemento na arvore"
                    : "Elemento não está arvore");

        } catch (Exception e) {
            System.out.println("Ops você digitou algo errado\n");
            this.br = new Scanner(System.in);
        }
        this.menu();
    }

    private void visual() {

        if (this.erva.vazio()) {
            System.out.println("Tabela vazia");
        } else {
            System.out.println("\n++++++++++++++++Arvore por nivel++++++++++++++++");
            this.erva.stringArvoreBinaria(this.erva.getRaiz(), 0);
        }

        this.menu();
    }

    private void saida() {
        br.close();
        metodosOrdenacao ordenacao;

        if (this.erva.vazio()) {
            System.out.println("Arvore finalizada sem possuir nenhum elemento");
        } else {
            System.out.println("Tipos de percorrimento da árvore\n");

            System.out.println(this.erva.toString());

            ordenacao = new metodosOrdenacao();

            System.out.println("\n++++++++++++++++Percorimento e "
                    + "seus tempos de ordenação em nanosegundo++++++++++++++++\n");

            System.out.println("In-Ordem: ");
            visualizaArray.visu(this.erva.arrayEmOrdem());

            long inOrdemTempoBubble = ordenacao.tempoOrdenarBubble(
                    this.erva.arrayEmOrdem());

            long inOrdemQuickTempo = ordenacao.tempoOrdenarQuick(
                    this.erva.arrayEmOrdem());

            long inOrdemMergeTempo = ordenacao.ordenarMerge(
                    this.erva.arrayEmOrdem());

            System.out.println("\nBubbleSort: "
                    + inOrdemTempoBubble);
            System.out.println("QuickSort: "
                    + inOrdemQuickTempo);
            System.out.println("MergeSort: "
                    + inOrdemMergeTempo);

            System.out.println("\n++++++++++++++++++++++++++++++"
                    + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

            System.out.println("Pré-ordem: ");
            visualizaArray.visu(this.erva.arrayPreOrdem());

            long preOrdemTempoBubble = ordenacao.tempoOrdenarBubble(
                    this.erva.arrayPreOrdem());

            long preOrdemQuickTempo = ordenacao.tempoOrdenarQuick(
                    this.erva.arrayPreOrdem());

            long preOrdemMergeTempo = ordenacao.ordenarMerge(
                    this.erva.arrayPreOrdem());

            System.out.println("\nBubbleSort: "
                    + preOrdemTempoBubble);
            System.out.println("QuickSort: "
                    + preOrdemQuickTempo);
            System.out.println("MergeSort: "
                    + preOrdemMergeTempo);

            System.out.println("\n++++++++++++++++++++++++++++++"
                    + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

            System.out.println("Pós-ordem: ");
            visualizaArray.visu(this.erva.arrayPreOrdem());

            long posOrdemTempoBubble = ordenacao.tempoOrdenarBubble(
                    this.erva.arrayPosOrdem());

            long posOrdemQuickTempo = ordenacao.tempoOrdenarQuick(
                    this.erva.arrayPosOrdem());

            long posOrdemMergeTempo = ordenacao.ordenarMerge(
                    this.erva.arrayPosOrdem());

            System.out.println("\nBubbleSort: "
                    + posOrdemTempoBubble);
            System.out.println("QuickSort: "
                    + posOrdemQuickTempo);
            System.out.println("MergeSort: "
                    + posOrdemMergeTempo);

            System.out.println("\n++++++++++++++++++++++++++++++"
                    + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

            System.out.println("Por nível: ");
            visualizaArray.visu(this.erva.arrayPorNivel());

            long porNivelTempoBubble = ordenacao.tempoOrdenarBubble(
                    this.erva.arrayPorNivel());

            long porNivelQuickTempo = ordenacao.tempoOrdenarQuick(
                    this.erva.arrayPorNivel());

            long porNivelMergeTempo = ordenacao.ordenarMerge(
                    this.erva.arrayPorNivel());

            System.out.println("\nBubbleSort: "
                    + porNivelTempoBubble);
            System.out.println("QuickSort: "
                    + porNivelQuickTempo);
            System.out.println("MergeSort: "
                    + porNivelMergeTempo);

            System.out.println("\n+++++++++++++++++++*Arvore"
                    + "*+++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

            this.erva.stringArvoreBinaria(this.erva.getRaiz(), 0);

            System.out.println("\n++++++++++++++++++*Tabela"
                    + "*++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

            List<List<String>> linhas = new ArrayList<>();
            List<String> cabecario = Arrays.asList(" ", "BubbleSort",
                    "QuickSort ", "MergeSort ");

            linhas.add(cabecario);
            linhas.add(Arrays.asList("In-Ordem", String.valueOf(inOrdemTempoBubble),
                    String.valueOf(preOrdemQuickTempo), String.valueOf(inOrdemMergeTempo)));

            linhas.add(Arrays.asList("Pré-ordem", String.valueOf(preOrdemTempoBubble),
                    String.valueOf(preOrdemQuickTempo), String.valueOf(preOrdemMergeTempo)));

            linhas.add(Arrays.asList("Pós-ordem", String.valueOf(posOrdemTempoBubble),
                    String.valueOf(posOrdemQuickTempo), String.valueOf(posOrdemMergeTempo)));

            linhas.add(Arrays.asList("Por-Nivel", String.valueOf(porNivelTempoBubble),
                    String.valueOf(porNivelQuickTempo), String.valueOf(porNivelMergeTempo)));

            System.out.println(tabelaDeTempo.formatAsTable(linhas));

        }

        System.exit(0);
    }

}

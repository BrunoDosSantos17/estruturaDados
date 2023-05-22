/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenacao;

import Util.*;

/**
 *
 * @author bruno
 */
public class metodosOrdenacao {

    private Integer[] vet;
    
    public long ordenarMerge(Integer[] vet) {
         
        this.vet = vet;
        
        long tIni = System.nanoTime();

        this.ordenarMerge(this.vet, 0, this.vet.length - 1);

        long tFim = System.nanoTime();

        return tFim - tIni;

    }

    public long tempoOrdenarQuick(Integer[] vet) {
        
        this.vet = vet;

        long tIni = System.nanoTime();

        this.ordenarQuick(this.vet, 0, this.vet.length - 1);

        long tFim = System.nanoTime();

        return tFim - tIni;
    }

    public long tempoOrdenarBubble(Integer[] vet) {
        
        this.vet = vet;

        long tIni = System.nanoTime();

        this.bubbleSort();

        long tFim = System.nanoTime();

        return tFim - tIni;
    }

    private void bubbleSort() {
        int tam = this.vet.length;
        Integer[] vetAux = this.vet;
        for (int i = 0; i < tam - 1; i++) {
            for (int j = 0; j < tam - i - 1; j++) {
                if (vetAux[j] != null && vetAux[j + 1] != null) {
                    if (vetAux[j] > vetAux[j + 1]) {
                        Integer temp = vetAux[j];
                        vetAux[j] = vetAux[j + 1];
                        vetAux[j + 1] = temp;
                    }
                }
            }
        }
    }

    private void ordenarQuick(Integer[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = quick(vetor, inicio, fim);
            ordenarQuick(vetor, inicio, posicaoPivo - 1);
            ordenarQuick(vetor, posicaoPivo + 1, fim);
        }
    }

    private void ordenarMerge(Integer vet[], int ini, int fim) {
        if (ini < fim) {
            int piv = (ini + fim) / 2;
            this.ordenarMerge(vet, ini, piv);
            this.ordenarMerge(vet, piv + 1, fim);
            merge(vet, ini, piv, fim);
        }
    }

    private int quick(Integer[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int ini = inicio + 1, f = fim;
        while (ini <= f) {
            if (vetor[ini] != null) {
                if (vetor[ini] <= pivo) {
                    ini++;
                } else if (pivo < vetor[f]) {
                    f--;
                } else {
                    int troca = vetor[ini];
                    vetor[ini] = vetor[f];
                    vetor[f] = troca;
                    ini++;
                    f--;
                }
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }

    private void merge(Integer arr[], int esq, int meio, int dir) {
        int num1 = meio - esq + 1;
        int num2 = dir - meio;
        int left[] = new int[num1];
        int right[] = new int[num2];
        for (int i = 0; i < num1; ++i) {
            left[i] = arr[esq + i];
        }
        for (int i = 0; i < num2; ++i) {
            right[i] = arr[meio + 1 + i];
        }
        int b = 0, r = 0;
        int u = esq;
        while (b < num1 && r < num2) {
            if (left[b] <= right[r]) {
                arr[u] = left[b];
                b++;
            } else {
                arr[u] = right[r];
                r++;
            }
            u++;
        }
        while (b < num1) {
            arr[u] = left[b];
            b++;
            u++;
        }
        while (r < num2) {
            arr[u] = right[r];
            r++;
            u++;
        }
    }

    

}

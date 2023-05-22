/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaduplaencadeada;

/**
 *
 * @author informatica
 */
public class Lista {
    int valor;
    

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }


    public Lista getProximo() {
        return proximo;
    }

    public void setProximo(Lista proximo) {
        this.proximo = proximo;
    }
    Lista proximo;
    public Lista getAnterior() {
        return anterior;
    }

    public void setAnterior(Lista proximo) {
        this.anterior = proximo;
    }
    Lista anterior;
}

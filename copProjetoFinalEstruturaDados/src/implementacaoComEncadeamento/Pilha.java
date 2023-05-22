/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacaoComEncadeamento;

/**
 *
 * @author bruno
 */
public interface Pilha <T>{
	public void push(T el);
	public T pop();
	public boolean isEmpty();
	public void clear();
	public T top();
	public void showStack();
}
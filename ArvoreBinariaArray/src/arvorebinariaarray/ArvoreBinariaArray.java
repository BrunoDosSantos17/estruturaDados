package arvorebinariaarray;

import estrutura.arvoreArray;

/**
 *
 * @author Bruno dos Santos
 */
public class ArvoreBinariaArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        arvoreArray a1 = new arvoreArray(4);
        System.out.println(a1.insere(1));
        System.out.println(a1.insere(2));
        System.out.println(a1.insere(3));
        System.out.println(a1.insere(4));
        System.out.println(a1.insere(5));
        System.out.println(a1.insere(6));
        
        System.out.println(a1.toStringPreOrdem());
        System.out.println(a1.toStringInOrdem());
        System.out.println(a1.toStringPosOrdem());
        
    }
}

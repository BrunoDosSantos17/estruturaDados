package copprojetofinalestruturadados;

import implementacaoArvoreBinariaBusca.ArvoreBinariaComEncadeamento;

/**
 *
 * @author bruno
 */
public class CopProjetoFinalEstruturaDados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArvoreBinariaComEncadeamento a = new ArvoreBinariaComEncadeamento();
        
        a.insereEmOrdem(5);
        a.insereEmOrdem(6);
        a.insereEmOrdem(4);
        a.insereEmOrdem(8);
        a.insereEmOrdem(9);
        
        System.out.println(a.toString());
    }
    
}

package arvorebinarialink;

/**
 *
 * @author bruno
 */
public class ArvoreBinaria {
    NoArvoreBinaria raiz;
    
    public ArvoreBinaria(){
        this.raiz = null;
    }
    
    public int insere(int v, NoArvoreBinaria esq, NoArvoreBinaria dir){
        NoArvoreBinaria no = new NoArvoreBinaria(v, esq, dir);
        this.raiz = no;
        return v;
    }
    
    public boolean vazia(){
        return (this.raiz == null);
    }
    
    
}

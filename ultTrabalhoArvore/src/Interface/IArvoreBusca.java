package Interface;

import Arvore.No;

/**
 *
 * @author Bruno
 * @param <B>
 */
public interface IArvoreBusca<B>{
    
    public void add(Integer info);
    public boolean del(Integer info);
    public boolean vazio();
    public int alt();
    public boolean possui(Integer num);
    public Integer[] arrayPorNivel();
    public Integer[] arrayPosOrdem();
    public Integer[] arrayPreOrdem();
    public Integer[] arrayEmOrdem();
    public void libera();
    public void stringArvoreBinaria(No root, int level);
}

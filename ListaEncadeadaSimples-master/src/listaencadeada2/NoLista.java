package listaencadeada2;

/**
 *
 * @author bruno
 */
public class NoLista < G>{

    G info;
    NoLista next;

    public NoLista() {
      this(null, null);    
    }

    public NoLista(G info, NoLista next) {
        this.info = info;
        this.next = next;
    }

    public G getInfo() {
        return info;
    }

    public void setInfo(G info) {
        this.info = info;
    }

    public NoLista getNext() {
        return next;
    }

    public void setNext(NoLista next) {
        this.next = next;
    }
    
    
    
}

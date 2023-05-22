package EstruturasAux;

/**
 *
 * @author bruno
 * @param <B>
 */

public class NoLista<B> {

    private B num;
    private NoLista prox;

    public NoLista(B info, NoLista last) {
        this.num = info;
        this.prox = last;
    }

    public B getNum() {
        return this.num;
    }

    public void setNum(B num) {
        this.num = num;
    }

    public void setProx(NoLista<?> last) {
        this.prox = last;
    }

    public NoLista getProx() {
        return this.prox;
    }
}

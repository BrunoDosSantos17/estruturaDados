package EstruturasAux;

import Interface.IPilha;

/**
 *
 * @author bruno
 * @param <B>
 */
public class Pilha <B> implements IPilha<B> {

    private NoLista topo;
    private int qtd;

    @SuppressWarnings("unchecked")
    @Override
    public void add(B el) {
        if (this.vazio()) {
            this.topo = new NoLista(el, null);
        } else {
            NoLista tmp = this.topo;
            this.topo = new NoLista(el, tmp);
        }
        this.qtd++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public B del() {
        if (this.vazio()) {
            throw new IndexOutOfBoundsException("Pilha vazia");
        } else {
            NoLista tmp = this.topo;
            this.topo = this.topo.getProx();
            this.qtd--;
            return (B) tmp.getNum();
        }

    }

    @Override
    public boolean vazio() {
        return this.qtd == 0;
    }

    @Override
    public void liberar() {
        this.qtd = 0;
        this.topo = null;
    }

    @Override
    public B topo() {
        if (this.vazio()) {
            throw new NullPointerException("Não possio nenhum elemento");
        } else {
            return (B) this.topo.getNum();
        }
    }

    @Override
    public void show() {
        if (this.vazio()) {
            System.out.println("[ ]");
        }
        NoLista tmp = this.topo;
        while (tmp != null) {
            System.out.print("[ " + tmp.getNum() + " ] ");
            tmp = tmp.getProx();
        }
    }

    public int size() {
        return this.qtd;
    }

}

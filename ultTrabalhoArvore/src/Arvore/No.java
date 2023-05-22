package Arvore;

/**
 *
 * @author Bruno
 * @param <B>
 */
public class No<B> {

    private B num;
    private No<?> filhoEsq;
    private No<?> filhoDir;

    public No(B num) {
        this.num = num;
        this.filhoEsq = null;
        this.filhoDir = null;
    }

    public No(B info, No<?> filhoEsq, No<?> filhoDir) {
        this.num = info;
        this.filhoEsq = filhoEsq;
        this.filhoDir = filhoDir;
    }

    public No<?> getFilhoEsq() {
        return this.filhoEsq;
    }

    public void setFilhoEsq(B info) {
        No<B> no = new No(info, null, null);
        this.filhoEsq = no;
    }

    public void setFilhoDir(B info) {
        this.filhoDir = new No(info, null, null);
    }

    public void setFilhoEsq(No no) {
        this.filhoEsq = no;
    }

    public void setFilhoDir(No no) {
        this.filhoDir = no;
    }

    public void setNum(B info) {
        this.num = info;
    }

    public No<?> getFilhoDir() {
        return this.filhoDir;
    }

    public B getNum() {
        return this.num;
    }

    public boolean del(Integer value, No no) {
        if (value < (Integer) this.num) {
            if (filhoEsq != null) {
                return filhoEsq.del(value, this);
            } else {
                return false;
            }
        } else if (value > (Integer) this.num) {
            if (filhoDir != null) {
                return filhoDir.del(value, this);
            } else {
                return false;
            }
        } else {
            if (filhoEsq != null && filhoDir != null) {
                this.num = (B) filhoDir.valorMin();
                filhoDir.del((Integer) this.num, this);

            } else if (no.filhoEsq == this) {
                no.filhoEsq = (filhoEsq != null) ? filhoEsq : filhoDir;
            } else if (no.filhoDir == this) {
                no.filhoDir = (filhoEsq != null) ? filhoEsq : filhoDir;
            }

            return true;

        }

    }

    public Integer valorMin() {
        if (filhoEsq == null) {
            return (Integer) num;
        } else {
            return filhoEsq.valorMin();
        }

    }

}

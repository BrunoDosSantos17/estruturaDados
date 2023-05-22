
package atividadepilha;

/**
 *
 * @author Bruno
 */
public class cores {
    int id;
    String cor;
    cores proximo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public cores getProximo() {
        return proximo;
    }

    public void setProximo(cores proximo) {
        this.proximo = proximo;
    }
}

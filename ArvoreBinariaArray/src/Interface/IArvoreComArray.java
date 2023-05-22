package Interface;

/**
 *
 * @author bruno
 * @param <G>
 */
public interface IArvoreComArray <G> {
    public boolean insere(G v);
    public boolean insere(G v, int posPai, boolean sobrescrever);
    public boolean remove();
    public boolean vazio();
    public boolean cheia();
    public boolean pertence(G info);
    public int getQuantidadeMaxNos();
    public int getAlturaAtual();
    public void liberaRecursos();
    public String toStringPreOrdem();
    public String toStringInOrdem();
    public String toStringPosOrdem();
}

package estrutura;

import Interface.IArvoreComArray;

/**
 *
 * @author bruno
 * @param <G>
 */
public final class arvoreArray<G> implements IArvoreComArray<G> {

    private final int h, totalDeNos;
    private int eleArv, alturaArvore;
    private G array[];
    private static String emOrder = "";
    private static String posOrder = "";

    public arvoreArray(int h) {

        this.h = h;
        this.totalDeNos = (int) (Math.pow(2, this.h + 1) - 1);
        this.liberaRecursos();
    }

    @Override
    public boolean insere(G v) {
        if (this.cheia()) {
            System.out.println("Árvore cheia!!!");
            return false;
        } else {
            this.array[this.eleArv] = v;
        }
        this.eleArv++;
        this.tamanhoArvore();
        return true;
    }

    @Override
    public boolean insere(G v, int posPai, boolean sobrescrever) {
        int posFilho = (2 * posPai + 1);
        boolean insercao = false;

        if (posFilho > this.eleArv) {
            return false;
        }

        if (this.array[posPai] != null) {
            if (this.array[posFilho] == null) {
                this.array[posFilho] = v;
                this.eleArv++;
                insercao = true;
                this.tamanhoArvore(posFilho);
            } else {
                if (sobrescrever) {
                    this.array[posFilho] = v;
                    insercao = true;
                    this.tamanhoArvore(posFilho);
                } else {
                    insercao = false;
                }
            }
        }

        return insercao;
    }

    @Override
    public boolean vazio() {
        return this.eleArv == 0;
    }

    @Override
    public boolean cheia() {
        return this.eleArv == this.totalDeNos;
    }

    @Override
    public boolean pertence(Object info) {
        boolean elePer = false;

        if (!this.vazio()) {
            for (int i = 0; i < this.eleArv; i++) {
                if (this.array[i].equals(info)) {
                    elePer = true;
                    break;
                }
            }
        }

        return elePer;
    }

    @Override
    public int getQuantidadeMaxNos() {
        if (this.vazio()) {
            System.out.println("Lista vázia");
        }
        return this.eleArv;
    }

    @Override
    public int getAlturaAtual() {
        if (this.vazio()) {
            System.out.println("Lista vázia");
            return -1;
        }
        return this.alturaArvore;
    }

    @Override
    public void liberaRecursos() {
        this.alturaArvore = -1;
        this.eleArv = 0;
        this.array = (G[]) new Object[this.totalDeNos];
    }

    @Override
    public String toString() {
        String valorArray = "";
        if (!this.vazio()) {

            for (int i = 0; i < this.totalDeNos; i++) {
                if (this.array[i] != null) {
                    valorArray = valorArray + " " + this.array[i];
                }
            }
        }

        return valorArray;
    }

    private void tamanhoArvore() {
        int qtdNosAtuais = (int) (Math.pow(2, this.alturaArvore + 1) - 1);
        if (qtdNosAtuais < this.eleArv) {
            this.alturaArvore++;
        } else if (qtdNosAtuais > this.eleArv) {
            this.alturaArvore--;
        }
    }

    @Override
    public boolean remove() {
        if (this.vazio()) {
            System.out.println("Árvore vázia!!!");
            return false;
        } else {
            this.array[this.eleArv - 1] = null;
        }
        this.eleArv--;
        this.tamanhoArvore();
        return true;
    }

    @Override
    public String toStringPreOrdem() {
        String texto = "";
        int qtdElementosVisualizados = 0;
        int i = 0;
        int qtdVezesNo = 0;
        do {
            texto += "[ " + this.array[i] + " ]";
            if (getIndexEsquerda(i) < this.array.length
                    && this.array[getIndexEsquerda(i)] != null) {

                i = getIndexEsquerda(i);

            } else if (getIndexDireita(i) < this.array.length
                    && this.array[getIndexDireita(i)] != null) {
                i = getIndexDireita(i);
            } else if (noIsFolha(getIndexEsquerda(i), getIndexDireita(i))) {
                if (qtdVezesNo == 1) {
                    i = getIndexDireita(0);
                } else {
                    i = getIndexPai(i);
                    i = getIndexDireita(i);

                }
                qtdVezesNo++;

            }

            qtdElementosVisualizados++;
        } while (qtdElementosVisualizados < this.eleArv);
        return texto;
    }

    @Override
    public String toStringInOrdem() {

        if (emOrder != null) {
            emOrder = "";
        }

        this.inOrdem(0);

        return emOrder;
    }

    @Override
    public String toStringPosOrdem() {
        if (posOrder != null) {
            posOrder = "";
        }
        posOrdem(0);
        return posOrder;
    }

    private void posOrdem(int idxElemento) {
        if (idxElemento < this.eleArv) {
            posOrdem(getIndexEsquerda(idxElemento));
            posOrdem(getIndexDireita(idxElemento));
            arvoreArray.posOrder += "[ " + this.array[idxElemento] + " ]";
        }
    }

    private void inOrdem(int idxElemento) {

        if (idxElemento < this.eleArv) {
            inOrdem(getIndexEsquerda(idxElemento));
            emOrder += "[ " + this.array[idxElemento] + " ]";
            inOrdem(getIndexDireita(idxElemento));
        }
        
    }

    private void tamanhoArvore(int noLonge) {
        int qtdNosAtuais = (int) (Math.pow(2, this.alturaArvore + 1) - 1);
        if (qtdNosAtuais < noLonge) {
            this.alturaArvore++;
        }
    }

    private int getIndexEsquerda(int idxAtual) {
        return (2 * idxAtual) + 1;
    }

    private int getIndexDireita(int idxAtual) {
        return 2 * idxAtual + 2;
    }

    private boolean noIsFolha(int idxFilhoEsquerda, int idxFilhoDireita) {
        if (idxFilhoEsquerda >= this.array.length || idxFilhoDireita >= this.array.length) {
            return true;
        } else {
            if (this.array[idxFilhoEsquerda] == null && this.array[idxFilhoDireita] == null) {
                return true;
            } else {
                return false;
            }
        }
    }

    private int getIndexPai(int idxFilho) {
        return (int) (idxFilho - 1) / 2;
    }
}

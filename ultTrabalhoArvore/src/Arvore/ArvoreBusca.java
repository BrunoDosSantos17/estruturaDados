package Arvore;

import Interface.IArvoreBusca;
import EstruturasAux.Pilha;

/**
 *
 * @author Bruno
 * @param <B>
 */
public class ArvoreBusca<B> implements IArvoreBusca<B> {

    private No<?> raiz;
    private int qtd;
    private static String stringNivel;
    public static Integer[] arrayNivel;
    private static int index = 0;

    public ArvoreBusca() {
        this.raiz = null;
    }

    @Override
    public void add(Integer num) {
        if (!this.vazio()) {
            this.addAux(this.raiz, num);
        } else {
            this.raiz = this.addAux(this.raiz, num);

        }
        this.qtd++;
    }

    @Override
    public boolean del(Integer num) {
        if (delAux(num)) {
            this.qtd--;
            return true;
        }

        return false;
    }

    @Override
    public boolean vazio() {
        return this.raiz == null;
    }

    @Override
    public int alt() {
        if (this.vazio()) {
            return -1;
        }
        return altura(this.raiz);
    }

    @Override
    public boolean possui(Integer info) {
        Pilha<No<?>> pilha = new Pilha<>();
        No<?> atual = raiz;

        while (atual != null || pilha.size() > 0) {
            while (atual != null) {
                pilha.add(atual);
                atual = atual.getFilhoEsq();
            }

            atual = pilha.del();
            if (info.equals(atual.getNum())) {
                return true;
            }
            atual = atual.getFilhoDir();
        }
        return false;

    }

    @Override
    public Integer[] arrayPorNivel() {
        if (this.vazio()) {
            return null;
        }

        stringNivel();
        return arrayNivel;
    }

    @Override
    public Integer[] arrayPosOrdem() {
        if (this.vazio()) {
            return null;
        }

        Integer[] returnPosOrdem = new Integer[this.qtd];
        Pilha<No<?>> pilha = new Pilha<>();
        pilha.add(this.raiz);
        No<?> noAnt = null;
        int idx = 0;
        while (!pilha.vazio()) {
            No<?> noAtual = pilha.topo();
            if (noAnt == null || noAnt.getFilhoEsq() == noAtual
                    || noAnt.getFilhoDir() == noAtual) {
                if (noAtual.getFilhoEsq() != null) {
                    pilha.add(noAtual.getFilhoEsq());
                } else if (noAtual.getFilhoDir() != null) {
                    pilha.add(noAtual.getFilhoDir());
                } else {
                    pilha.del();
                    if (noAtual.getNum() != null) {
                        returnPosOrdem[idx] = (Integer) noAtual.getNum();
                        idx++;
                    }
                }
            } else if (noAtual.getFilhoEsq() == noAnt) {
                if (noAtual.getFilhoDir() != null) {
                    pilha.add(noAtual.getFilhoDir());
                } else {
                    pilha.del();
                    if (noAtual.getNum() != null) {
                        returnPosOrdem[idx] = (Integer) noAtual.getNum();
                        idx++;
                    }
                }
            } else if (noAtual.getFilhoDir() == noAnt) {
                pilha.del();
                if (noAtual.getNum() != null) {
                    returnPosOrdem[idx] = (Integer) noAtual.getNum();
                    idx++;
                }
            }
            noAnt = noAtual;
        }

        return returnPosOrdem;
    }

    @Override
    public Integer[] arrayPreOrdem() {
        if (this.vazio()) {
            return null;
        }

        Integer[] returnVet = new Integer[this.qtd];
        Pilha<No<?>> arrayNo = new Pilha<>();
        int idxAux = 0;
        arrayNo.add(this.raiz);

        while (!arrayNo.vazio()) {
            No<?> noAtual = arrayNo.del();
            if (noAtual != null) {
                returnVet[idxAux] = (Integer) noAtual.getNum();
                idxAux++;
            }
            if (noAtual.getFilhoDir() != null) {
                arrayNo.add(noAtual.getFilhoDir());
            }
            if (noAtual.getFilhoEsq() != null) {
                arrayNo.add(noAtual.getFilhoEsq());
            }
        }

        return returnVet;
    }

    @Override
    public Integer[] arrayEmOrdem() {

        if (this.vazio()) {
            return null;
        }

        Integer[] returnVet = new Integer[this.qtd];
        Pilha<No<?>> pilha = new Pilha<>();
        No<?> noAtual = this.raiz;
        int idx = 0;
        while (noAtual != null || pilha.size() > 0) {
            while (noAtual != null) {
                pilha.add(noAtual);
                noAtual = noAtual.getFilhoEsq();
            }
            noAtual = pilha.del();

            if (noAtual.getNum() != null) {
                returnVet[idx] = (Integer) noAtual.getNum();
                idx++;
            }

            noAtual = noAtual.getFilhoDir();
        }
        return returnVet;
    }

    @Override
    public String toString() {
        return ("Em Ordem " + stringInOrdem() + " \n"
                + "Pré Ordem: " + stringPreOrdemAux() + " \n"
                + "Pos Ordem: " + stringPosOrdem() + " \n"
                + "Por nível: " + stringNivel());
    }

    @Override
    public void libera() {
        this.qtd = 0;
        this.raiz = null;

    }

    @Override
    public void stringArvoreBinaria(No root, int level) {
        if (root == null) {
            return;
        }
        stringArvoreBinaria(root.getFilhoDir(), level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|-------" + root.getNum());
        } else {
            System.out.println(root.getNum());
        }
        stringArvoreBinaria(root.getFilhoEsq(), level + 1);
    }

    public No getRaiz() {
        return this.raiz;
    }

    private boolean delAux(Integer num) {
        if (this.vazio() && this.possui(num)) {
            return false;
        } else {
            if (this.raiz.getNum() == num) {
                No noAux = new No(0, null, null);
                noAux.setFilhoEsq(this.raiz);
                boolean result = this.raiz.del(num, noAux);
                this.raiz = noAux.getFilhoEsq();
                return result;
            } else {
                return this.raiz.del(num, null);
            }
        }

    }

    private No addAux(No raizNo, Integer num) {

        No no = new No(num, null, null);
        No raizAux = raizNo;
        No returnNo = null;

        while (raizAux != null) {
            returnNo = raizAux;
            if (num < (Integer) raizAux.getNum()) {
                raizAux = raizAux.getFilhoEsq();
            } else {
                raizAux = raizAux.getFilhoDir();
            }
        }
        if (returnNo == null) {
            returnNo = no;

        } else if (num < (Integer) returnNo.getNum()) {
            returnNo.setFilhoEsq(no);

        } else {
            returnNo.setFilhoDir(no);
        }
        return returnNo;
    }

    private int altura(No raizNo) {
        if (raizNo == null) {
            return 0;

        } else {
            int altDir = altura(raizNo.getFilhoEsq());
            int altEsq = altura(raizNo.getFilhoDir());

            if (altEsq < altDir) {
                return (altDir + 1);

            } else {
                return (altEsq + 1);
            }
        }
    }

    public String stringNivel() {
        if (this.vazio()) {
            return "";
        }
        int altAtual = this.alt();
        stringNivel = "";
        arrayNivel = new Integer[this.qtd];
        index = 0;
        for (int i = 0; i <= altAtual; i++) {
            stringNivelAux(this.raiz, i);
        }

        return stringNivel;
    }

    private void stringNivelAux(No raiz, int nivel) {
        String texto = "";
        if (raiz == null) {
            return;
        }
        if (nivel == 1) {
            texto += raiz.getNum();
            if (raiz.getNum() != null) {
                arrayNivel[index] = (Integer) raiz.getNum();
                index++;
            }
        } else if (nivel > 1) {
            stringNivelAux(raiz.getFilhoEsq(), nivel - 1);
            stringNivelAux(raiz.getFilhoDir(), nivel - 1);
        }

        texto += "|";
        stringNivel += " " + texto;

    }

    private String stringPreOrdemAux() {
        String preOrdem = "";
        Pilha<No<?>> pilhaNo = new Pilha<>();
        pilhaNo.add(this.raiz);
        while (!pilhaNo.vazio()) {
            No<?> atualNo = pilhaNo.del();
            preOrdem += "| " + atualNo.getNum() + "/ ";

            if (atualNo.getFilhoEsq() != null) {
                pilhaNo.add(atualNo.getFilhoEsq());
            }

            if (atualNo.getFilhoDir() != null) {
                pilhaNo.add(atualNo.getFilhoDir());
            }
        }
        return preOrdem;
    }

    private String stringInOrdem() {
        String inOrdem = "";
        Pilha<No<?>> pilha = new Pilha<>();
        No<?> atual = raiz;

        while (atual != null || pilha.size() > 0) {
            while (atual != null) {
                pilha.add(atual);
                atual = atual.getFilhoEsq();
            }
            atual = pilha.del();
            inOrdem += "| " + atual.getNum() + "/";
            atual = atual.getFilhoDir();
        }
        return inOrdem;

    }

    private String stringPosOrdem() {
        String posOrdem = "";
        Pilha<No<?>> pilha = new Pilha<>();
        pilha.add(this.raiz);
        No<?> noAnt = null;
        while (!pilha.vazio()) {
            No<?> noAtual = pilha.topo();
            if (noAnt == null || noAnt.getFilhoEsq() == noAtual
                    || noAnt.getFilhoDir() == noAtual) {
                if (noAtual.getFilhoEsq() != null) {
                    pilha.add(noAtual.getFilhoEsq());
                } else if (noAtual.getFilhoDir() != null) {
                    pilha.add(noAtual.getFilhoDir());
                } else {
                    pilha.del();
                    posOrdem += "|" + noAtual.getNum() + " /";
                }
            } else if (noAtual.getFilhoEsq() == noAnt) {
                if (noAtual.getFilhoDir() != null) {
                    pilha.add(noAtual.getFilhoDir());
                } else {
                    pilha.del();
                    posOrdem += " |" + noAtual.getNum() + " /";
                }
            } else if (noAtual.getFilhoDir() == noAnt) {
                pilha.del();
                posOrdem += " |" + noAtual.getNum() + " /";
            }
            noAnt = noAtual;
        }

        return posOrdem;
    }

}

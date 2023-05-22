package listaencadeada2;

import Interface.IListaComEncadeamento;

/**
 *
 * @author bruno
 */

/*
 Adiciona o elemento passado por parâmetro ao final da lista.

 Adiciona o elemento passado por parâmetro na posição
informada. Ajusta as referências, de forma que o elemento que
antes existia naquela posição seja o “próximo” do elemento
inserido. Esse método pode lançar exceção caso o índice
passado por parâmetro seja menor do que 0 ou maior do que o
tamanho da lista.

 Remove todos os elementos da lista.

 Retorna a quantidade de elementos na lista.

 Retorna um booleano que indica se a lista está vazia.

 Remove o elemento contido na posição passada por parâmetro.
Reajusta as referências conforme necessário. Esse método pode
lançar exceção caso o índice passado por parâmetro seja menor
do que 0 ou maior do que o tamanho da lista.

 Remove a primeira ocorrência do valor passado por parâmetro e
retorna verdadeiro, se presente na lista. Caso contrário, a lista
não é modificada e o método retorna false. Reajusta as
referências conforme necessário.

 Retorna o elemento na posição especificada por parâmetro. Esse
método pode lançar exceção caso o índice passado por
parâmetro seja menor do que 0 ou maior do que o tamanho da
lista.

 Substitui o elemento na posição passada por parâmetro, e retorna
o elemento antigo (o que foi substituído). Esse método pode
lançar exceção caso o índice passado por parâmetro seja menor
do que 0 ou maior do que o tamanho da lista.

 Retorna verdadeiro se a lista contém o elemento passado por
parâmetro.

 Retorna o índice da primeira ocorrência na lista do elemento
passado por parâmetro. Caso o elemento não exista dentro da
lista, é retornado -1.

 Retorna o índice da última ocorrência na lista do elemento
passado por parâmetro. Caso o elemento não exista dentro da
lista, é retornado -1.

 Retorna um array de objetos do tipo Integer, contendo todos os
elementos armazenados na lista.
 */
public class ListaComEncadeamento <G> implements IListaComEncadeamento <G>{

    private NoLista first;
    private NoLista last;
    private int counter;

    public ListaComEncadeamento() {
        this.first = null;
        this.last = null;
        this.counter = 0;
    }

    @Override
    public void add(G ele) {
        NoLista novo = new NoLista(ele, null);
        if (first == null) {
            first = novo;
            last = novo;
        } else {
            last.next = novo;
            last = novo;
        }
        counter++;
    }

    @Override
    public void add(int pos, G ele) {
        NoLista novo = new NoLista();
        NoLista eleGene = first;
        int count = 1;

        if (pos > this.counter - 1 || pos < 0) {
            System.out.println("Erro: Não é possivel acessar o elemento na lista");
        } else {
            novo.setInfo(ele);
            if (pos != 0) {
                while (count != pos) {
                    eleGene = eleGene.next;
                    count++;
                }
                novo.setNext(eleGene.next);
                eleGene.setNext(novo);
                eleGene = novo;
            } else {
                novo.next = first;
                first = novo;
            }
            counter++;
        }
    }

    @Override
    public void clear() {
        this.first = null;
        this.last = null;
        this.counter = 0;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public boolean isEmpty() {
        return counter == 0;
    }

    @Override
    public G remove(int pos) {
        G suc = null;
        NoLista eleGene = first;
        int count = 1;

        if (pos > this.counter - 1 || pos < 0) {
            System.out.println("Erro: Não é possivel acessar o elemento na lista");
        } else {

            if (pos == 0) {
                suc = (G)eleGene.info;
                this.first = eleGene.next;
            } else {
                while (count != pos) {
                    eleGene = eleGene.next;
                    count++;
                }
                suc = (G)eleGene.next.info;
                eleGene.next = eleGene.next.next;
                if (eleGene.next == null) {
                    this.last = eleGene;
                }
            }
            this.counter--;
        }

        return suc;
    }

    @Override
    public boolean removeFirst(G ele) {
        boolean oco = true;
        NoLista eleGene = first;

        if (eleGene.info == ele) {
            eleGene = eleGene.next;
            first = eleGene;
            this.counter--;
        } else {
            boolean nP = false;
            NoLista eleAnt = first;
            while (eleGene.info != ele) {
                if (eleGene.next != null) {
                    if (nP) {
                        eleAnt = eleAnt.next;
                    }
                    nP = true;
                    eleGene = eleGene.next;
                } else {
                    oco = false;
                    break;
                }
            }

            if (oco) {
                if (eleGene.next == null) {
                    eleAnt.next = null;
                    this.last = eleAnt;
                } else {
                    eleAnt.next = eleGene.next;
                }
                this.counter--;
            }
        }

        return oco;
    }

    @Override
    public G get(int pos) {
        G info = null;
        int count = 0;
        NoLista eleGene = this.first;

        if (pos > this.counter - 1 || pos < 0) {
            System.out.println("Erro: Não é possivel acessar o elemento na lista");
        } else {

            while (count != pos) {
                eleGene = eleGene.next;
                count++;
            }
            info = (G)eleGene.info;

        }
        return info;
    }

    @Override
    public G set(int pos, G ele) {
        G info = null;
        int count = 0;
        NoLista eleGene = this.first;

        if (pos > this.counter - 1 || pos < 0) {
            System.out.println("Erro: Não é possivel acessar o elemento na lista");
        } else {

            while (count != pos) {
                eleGene = eleGene.next;
                count++;
            }
            info = (G)eleGene.info;
            eleGene.setInfo(ele);

        }
        return info;
    }

    @Override
    public boolean contains(G ele) {
        return this.indexOf(ele) != -1;
    }

    @Override
    public int indexOf(G ele) {
        int posEle;
        int cont = 0;
        NoLista eleGene = this.first;
        boolean enco = true;

        while (eleGene.info != ele) {
            if (eleGene.next == null) {
                enco = false;
                break;
            }
            cont++;
            eleGene = eleGene.next;
        }
        if (enco) {
            posEle = cont;
        } else {
            posEle = -1;
        }

        return posEle;
    }

    @Override
    public int lastIndexOf(G ele) {
        int posEle = -1;
        int cont = 0;
        NoLista eleGene = this.first;

        while (cont != this.counter) {
            if (eleGene.info == ele) {
                posEle = cont;
            }
            cont++;
            eleGene = eleGene.next;
        }

        return posEle;
    }

    @Override
    public G[] toArray() {
        int cont = 0;
        NoLista eleGene = this.first;
        G [] array = (G[])new Object[this.counter];

        while (cont != this.counter) {
            array[cont] = (G)eleGene.info;
            cont++;
            eleGene = eleGene.next;
            
        }
        return array;
    }

    @Override
    public String toString() {
        String eleLista = "";
        NoLista eleGener = first;
        while (eleGener != null) {
            eleLista = eleLista + "/" + eleGener.info;
            eleGener = eleGener.next;
        }
        return eleLista;
    }

}


package Interface;

/**
 *
 * @author bruno
 */
public interface IListaComEncadeamento <G>{
    public void add(G ele);
    public void add(int pos, G ele);
    public void clear();
    public int size();
    public boolean isEmpty();
    public G remove(int pos);
    public boolean removeFirst(G ele);
    public G get(int pos);
    public G set(int pos, G ele);
    public boolean contains(G ele);
    public int indexOf(G ele);
    public int lastIndexOf(G ele);
    public G[] toArray();
    
}

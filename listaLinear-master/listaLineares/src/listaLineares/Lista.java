package listaLineares;

public interface Lista {
	public void add(Integer ele);
	public void add(int pos, Integer ele);
	public void resizeArrayList();
	public void clear();
	public int size();
	public boolean isEmpty();
	public boolean isFull();
	public Integer remove(int pos);
	public boolean removeFirst(Integer ele);
	public Integer get (int pos);
	public Integer set(int pos, Integer ele);
	public boolean contains(Integer ele);
	public int indeOf(Integer ele);
	public int lastindeOf(Integer ele);
	public Integer[] toArray();
}

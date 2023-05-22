package Interface;

/**
 *
 * @author bruno
 * @param <B>
 */
public interface IPilha <B>{
	public void add(B el);
	public B del();
	public boolean vazio();
	public void liberar();
	public B topo();
	public void show();
}
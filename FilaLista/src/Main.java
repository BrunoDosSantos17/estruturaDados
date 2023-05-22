public class Main {

	public static void main(String[] args) {
		FilaLista fila = new FilaLista();
		
		System.out.println(fila.vazia());
		fila.insere("celular");
		fila.insere("livro");
		fila.insere("anime");	
		fila.insere("filme");
		System.out.println(fila.toString());
		System.out.println(fila.retira());
		System.out.println(fila.retira());
		System.out.println(fila.retira());
		System.out.println(fila.toString());
		fila.libera();
		System.out.println(fila.vazia());	
	}

}

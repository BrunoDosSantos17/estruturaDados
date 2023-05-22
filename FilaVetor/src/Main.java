public class Main {
	
	public static void main(String[] args) {
		
		FilaVetor fila = new FilaVetor(4);
		fila.insere("Ler");
		fila.insere("estudar");
		fila.insere("Jogar");
		fila.insere("estudar");
		System.out.println(fila.toString());
		System.out.println(fila.retira());
		fila.insere("Namorar");
		System.out.println(fila.retira());
		System.out.println(fila.retira());
		System.out.println(fila.retira());
		fila.insere("Jogar");
		System.out.println(fila.toString());
		fila.libera();
		System.out.println(fila.vazia());
		fila.insere("Ler");
		fila.insere("estudar");
		System.out.println(fila.toString());
	}
}

public class Main {

	public static void main(String[] args) throws Exception {

		PilhaFila a = new PilhaFila(5);
		a.push(0);
		a.push(1);
		a.push(2);
		System.out.println(a.toString());
		a.push(4);
		System.out.println(a.pop());
		a.push(5);
		System.out.println(a.toString());
	}

}

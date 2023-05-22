public class Main {

	public static void main(String[] args) throws Exception {
		PilhaLista pil = new PilhaLista();
		pil.push(5);
		//System.out.println(pil.toString());
		pil.push(6);
		pil.push(7);
		pil.pop();
		pil.pop();
		pil.pop();
		System.out.println(pil.toString());
		pil.push(6);
		pil.push(7);
		pil.push(8);
		pil.push(9);
		System.out.println(pil.pop());
		
	}

}

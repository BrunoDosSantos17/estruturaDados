public class PilhaFila implements Pilha{
	private int n;
	private int tam;
	private float vet[];
	
	public PilhaFila(int tam){
		this.n = 0;
		this.tam = tam;
		this.vet = new float[tam];
	}
	
	
	@Override
	public void push(float v) throws Exception {
		this.vet[n] = v;
		this.n++;
		
	}

	@Override
	public float pop() throws Exception {
		float objAnte = this.top();
		this.n--;
		
		return objAnte;
	}

	@Override
	public float top() throws Exception {
		float objAnte;
		objAnte = this.vet[n - 1];
		return objAnte;
	}

	@Override
	public boolean vazia() throws Exception {
		// TODO Auto-generated method stub
		return this.n == 0;
	}

	@Override
	public void libera() throws Exception {
		this.n = 0;
		
	}
	
	public String toString(){
		String vetor = "";
		for(int i = 0; i < this.n; i++){
			vetor = vetor + "//" + this.vet[i];
		}
		return vetor;
		
	}

}

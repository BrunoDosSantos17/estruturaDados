public class FilaVetor implements Fila {
	private int n, ini, tam;
	private Object[] vet;
	
	public FilaVetor(int tam){
		this.libera();
		this.tam = tam;
		this.vet = new Object[tam];
	}
	@Override
	public void insere(Object O) {	
		if(this.n != this.tam){
			vet[(this.ini + this.n)%this.tam] = O;
			this.n ++;
		}else{
			System.out.println("Memória cheia");
		}
		
	}

	@Override
	public Object retira() {
		Object objArray = null;
		if(this.vazia()){
			objArray = "Lista vazia";
		}else{
			objArray = this.vet[ini];
			this.vet[ini] = null;
			ini = (ini + 1) % this.tam;
			this.n--; 
		}
		
		return objArray;
	}

	@Override
	public boolean vazia() {
		return this.n <= 0;
	}

	@Override
	public void libera() {
		this.ini = 0;
		this.n = 0;
	}
	
	@Override
	public String toString(){
		String infoVet = "";
		for(int i = 0; i < this.vet.length; i++){
			infoVet = infoVet + " / " + (String) this.vet[i];
		}
		return infoVet;	
	}

}

public class PilhaLista implements Pilha{
	private NoLista topo, ini;
	private int size;
	
	public PilhaLista() throws Exception{
		this.libera();
	}
	
	@Override
	public void push(float v) throws Exception {
		NoLista objetoAdd = new NoLista(null, v);
		if(this.vazia()){
			this.ini = objetoAdd;
			this.topo = objetoAdd;
			
		}else{
			this.topo.setProx(objetoAdd);
			this.topo = objetoAdd;
		}
		size++;
		
	}

	@Override
	public float pop() throws Exception {
		float valorObj = topo.getInfo();
		NoLista eleGener = this.ini;
		
		if(this.vazia()){
			System.out.println("Lista vazia");
		}else{
			if(this.size != 1){
				while (eleGener.getProx().getProx() != null) {
					eleGener = eleGener.getProx();	
				}
				eleGener.setProx(null);
				this.topo.setProx(eleGener);
				this.topo = eleGener;
				this.size--;
			}else{
				this.libera();
			}
			
		}
		return valorObj;
	}

	@Override
	public float top() throws Exception {
		return this.topo.getInfo();
	}

	@Override
	public boolean vazia() throws Exception {
		return this.size <= 0;
	}

	@Override
	public void libera() throws Exception {
		this.topo = null;
		this.ini = null;
		this.size = 0;
	}
	
	public String toString(){
		String eleLista = "";
		NoLista eleGener = this.ini;
		while (eleGener != null) {
			eleLista = eleLista + "/" + eleGener.getInfo();
			eleGener = eleGener.getProx();
		}
		return eleLista;
	}

}

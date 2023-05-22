public class FilaLista implements Fila {
	private NoLista ini, fim;

	public FilaLista() {
		this.ini = null;
		this.fim = null;
	}

	@Override
	public void insere(Object O) {
		NoLista novo = new NoLista(null, O);
		if (this.vazia()) {
			this.ini = novo;
			this.fim = novo;
		} else {
			novo.setProx(this.ini);
			this.ini = novo;
		}
	}

	@Override
	public Object retira() {
		Object info = this.fim.getInfo();;
		NoLista lis = this.ini;
		if (vazia()) {
			System.out.println("Fila vazia!");
		} else {
			if(lis.getProx() != null){
				while (lis.getProx().getProx() != null) {
					lis = lis.getProx();
				}
				lis.setProx(null);
				this.fim = lis;
			}else{
				libera();
			}
		}
		return info;
	}

	@Override
	public boolean vazia() {	
		return this.ini == null;
	}

	@Override
	public void libera() {
		this.ini = null;
		this.fim = null;
	}

	@Override
	public String toString() {
		String eleLista = "";
		NoLista eleGener = this.ini;
		while (eleGener != null) {
			eleLista = eleLista + "/" + eleGener.getInfo();
			eleGener = eleGener.getProx();
		}
		return eleLista;
	}

}

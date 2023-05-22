public class NoLista {
	private Object info;
	private NoLista prox;
	
	public NoLista(NoLista prox, Object info){
		this.prox = prox;
		this.info = info;
	}
	
	NoLista getProx() {
		return prox;
	}
	
	void setProx(NoLista prox) {
		this.prox = prox;
	}
	
	Object getInfo() {
		return info;
	}
	
	void setInfo(Object info) {
		this.info = info;
	}
	
	
	
}

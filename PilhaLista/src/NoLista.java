public class NoLista {
	private float info;
	private NoLista prox;
	
	public NoLista(NoLista prox, float info){
		this.prox = prox;
		this.info = info;
	}
	
	NoLista getProx() {
		return prox;
	}
	void setProx(NoLista prox) {
		this.prox = prox;
	}
	
	float getInfo() {
		return info;
	}
	void setInfo(float info) {
		this.info = info;
	}
	
}

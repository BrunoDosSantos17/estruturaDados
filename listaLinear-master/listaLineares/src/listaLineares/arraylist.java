package listaLineares;

public class arraylist implements Lista {
	private Integer[] array;
	private boolean rez = true;
	private int initialCapacity, counter;
	static int x;

	public arraylist() {
		this(10);
	}

	public arraylist(int tam) {
		array = new Integer[tam];
		x = 3;
		this.initialCapacity = tam;
		this.counter = 0;
	}

	public arraylist(int tam, boolean rezi) {
		this(tam);
		this.rez = rezi;
	}

	public void add(Integer ele) {
		// verifica se o array esta cheio

		if (array[array.length - 1] != null) {
			if (rez) {
				resizeArrayList();
			} else {
				System.out.println("array cheio");
			}

		}

		// adiciona o valor no primeiro espaço vazio
		if (array[array.length - 1] == null) {
			for (int i = 0; i < array.length; i++) {
				if (array[i] == null) {
					array[i] = ele;
					break;
				}
			}
		}
	}

	public void add(int pos, Integer ele) {
		// verifica se o array esta cheio
		boolean espVazio = false;
		if (array[array.length - 1] == null) {
			espVazio = true;
		}
		// caso não ouver espaço vazio, verifica se array é redimensonavel
		// se for ele aumenta o array senão da erro
		if (!espVazio) {
			if (rez) {
				resizeArrayList();
			} else {
				System.out.println("Erro: array cheio");
			}
		}

		if (pos >= 0 && pos <= array.length - 1) {
			if (array[pos - 1] == null) {
				System.out.println("Erro: posição anterior está vazio");
			} else {
				Integer[] arrayAnt = new Integer[array.length];

				for (int ini = pos; ini < array.length - 1; ini++) {
					arrayAnt[ini] = array[ini];
				}

				for (int ini = pos; ini < array.length - 1; ini++) {
					array[ini + 1] = arrayAnt[ini];
				}
				array[pos] = ele;
			}
		} else {
			System.out.println("Erro: posição não permitida dentro do array");
		}
		;
	};

	public void resizeArrayList() {
		Integer[] array2 = array;
		array = new Integer[array.length + x];

		// preenchimento do array com array antigo
		for (int i = 0; i < array2.length; i++) {
			array[i] = array2[i];
		}
	}

	public void clear() {
		// se rez for true vai criar um array novo zerado, senão prenche todos os campos
		// com nulo
		if (rez) {
			array = new Integer[this.initialCapacity];
		} else {
			for (int i = 0; i < array.length - 1; i++) {
				array[i] = null;
			}
		}
	}

	public int size() {
		int qtdElementos = 0;
		// procura elementos dentro da lista
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] != null) {
				qtdElementos++;
			}
		}
		return qtdElementos;
	}

	public boolean isEmpty() {
		boolean vazio = true;
		// verifica se algum elemento é diferente de nulo, caso for significa que a
		// lista não esta vazia
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] != null) {
				vazio = false;
				break;
			}
		}
		return vazio;
	}

	public boolean isFull() {
		boolean cheio = true;
		// verifica se é redimensonavel caso for verifica se o array está totalmente
		// vazio
		if (!rez) {
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] == null) {
					cheio = false;
					break;
				}
			}
		} else {
			System.out.println("Erro: A lista não é redimensonavel");
		}
		return cheio;
	}

	public Integer remove(int pos) {

		Integer valorAnti = null;
		if (pos >= 0 && pos <= array.length - 1) {
			valorAnti = array[pos];
			Integer[] arrayAnti = new Integer[array.length];

			for (int ini = pos; ini < array.length - 1; ini++) {
				arrayAnti[ini] = array[ini];
			}

			for (int ini = pos; ini < arrayAnti.length - 1; ini++) {
				array[ini] = arrayAnti[ini + 1];
			}
			array[array.length - 1] = null;
		}else {
			System.out.println("Erro: posição não permitida dentro do array");
		}
		return valorAnti;
	}

	public boolean removeFirst(Integer ele) {
		int pos = 0;
		boolean enco = false;
		for(int ini = 0; ini < array.length - 1; ini++) {
			if(array[ini] == ele) {
				pos = ini;
				enco = true;
				break;
			}
		}
		
		if(enco) {
			remove(pos);
		}
		
		return enco;
	}
	
	public Integer get (int pos) {
		if (pos >= 0 && pos <= array.length - 1) {
			return array[pos]; 
		}else {
			System.out.println("Erro: posição não permitida dentro do array");
		}
		return null;
	}

	public Integer set(int pos, Integer ele) {
		Integer eleAnt = null;
		if (pos >= 0 && pos <= array.length - 1) {
			eleAnt = array[pos];
			array[pos] = ele; 
		}else {
			System.out.println("Erro: posição não permitida dentro do array");
		}
		return eleAnt;
	}
	
	public boolean contains(Integer ele) {
		boolean con = false;
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] == ele) {
				con = true;
				break;
			}
		}
		return con;
	}

	public int indeOf(Integer ele) {
		int pos = -1;
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] == ele) {
				pos = i;
				break;
			}
		}
		return pos;
	}

	public int lastindeOf(Integer ele) {
		int pos = -1;
		for(int i = array.length - 1; i > 0 ; i--) {
			if(array[i] == ele) {
				pos = i;
				break;
			}
		}
		return pos;
	}

	public Integer[] toArray() {
		Integer[] arrayAnt = new Integer[array.length];

		for (int ini = 0; ini < array.length - 1; ini++) {
			if(array[ini] != null) {
				arrayAnt[ini] = array[ini];
			}
		}
		return arrayAnt;
	}
}

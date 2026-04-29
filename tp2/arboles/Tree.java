package tp2.arboles;

public class Tree {

	private TreeNode root;

	public Tree() {
		this.root = null;
	}

	public void add(Integer value) {
		if (this.root == null)
			this.root = new TreeNode(value);
		else
			this.add(this.root, value);
	}

	private void add(TreeNode actual, Integer value) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) {
				TreeNode temp = new TreeNode(value);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(), value);
			}
		} else if (actual.getValue() < value) {
			if (actual.getRight() == null) {
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
			} else {
				add(actual.getRight(), value);
			}
		}
	}

	public Integer sumaNodosInternos() {

		return sumaNodosInternosRec(this.root, 0);
	}

	private Integer sumaNodosInternosRec(TreeNode actual, int resultado) {
		if (actual == null) {
			return resultado;
		}
		if (actual.getRight() != null || actual.getLeft() != null) {
			resultado += actual.getValue();

		}
		resultado = sumaNodosInternosRec(actual.getLeft(), resultado);
		resultado = sumaNodosInternosRec(actual.getRight(), resultado);
		return resultado;

	}

	/*
	 * Ejercicio 4
	 * Se posee un árbol binario (no de búsqueda), donde los nodos internos están
	 * vacíos, mientras
	 * que las hojas tienen valores enteros. Se debe implementar un método que
	 * recorra el árbol y
	 * coloque valores en los nodos vacíos (los nodos internos). El valor de cada
	 * nodo interno debe ser
	 * igual al valor de su hijo derecho, menos el valor de su hijo izquierdo. En
	 * caso de que el nodo
	 * tenga un solo hijo, el valor del hijo faltante se reemplaza por un 0. Por
	 * ejemplo, tomando como
	 * entrada el árbol de la izquierda, el árbol resultante debería quedar con los
	 * mismos valores que el
	 * de la derecha.
	 */
	public int rellenarValores(){
		return rellenarValoresRecursivo(this.root);
	}

	private int rellenarValoresRecursivo(TreeNode actual){

		//caso base
		if (actual == null) {
			return 0;
		}

		//con eso no llegamos a la hojas y retornamos operacion
		if (actual.getLeft() == null && actual.getRight() == null) {
			return actual.getValue();
		}

		int valor = rellenarValoresRecursivo(actual.getRight()) - rellenarValoresRecursivo(actual.getLeft());
		actual.setValue(valor);
		return valor;
	}

	public static void main(String[] args) {
		Tree arbol = new Tree();
		arbol.add(10);
		arbol.add(5);
		arbol.add(15);
		arbol.add(3);
		arbol.add(7);
		arbol.add(12);
		arbol.add(18);
		System.out.println("\nEjercicio 2: " + arbol.sumaNodosInternos());
	}
}
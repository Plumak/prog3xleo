package tp1;

import java.util.Iterator;

import tp1.MyIterator;

/* los elementos de la lista se pueden comparar entre sí */
public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T> {

	private Node<T> first;
	private int size;

	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}

	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info, null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;
	}

	public T extractFront() {
		if (this.first == null) {

			return null;
		}
		T tmp = this.first.getInfo();
		this.first = this.first.getNext();
		this.size--;
		return tmp;
	}

	/*
	 * Arrancás desde el primer nodo
	 * 
	 * Vas avanzando uno por uno
	 * 
	 * En cada nodo:
	 * 
	 * comparás el valor
	 * 
	 * si coincide → devolvés el índice
	 * 
	 * Si terminás y no encontraste nada → devolvés -1
	 */
	public int indexOf(T algo) {
		Node<T> nodoTemporal = this.first;
		for (int i = 0; i < this.size; i++) {
			if (nodoTemporal.getInfo().equals(algo)) {
				return i;
			}
			nodoTemporal = nodoTemporal.getNext();
		}
		return -1;
	}

	public boolean isEmpty() {
		return this.first == null;
	}

	public T get(int index) {
		Node<T> nodoTemporal = this.first;
		if (index >= this.size || index < 0) {
			return null;

		}
		for (int i = 0; i < index; i++) {
			nodoTemporal = nodoTemporal.getNext();
		}
		return nodoTemporal.getInfo();
	}

	public int size() {
		return this.size;
	}

	public MySimpleLinkedList<T> fusion(MySimpleLinkedList<T> a, MySimpleLinkedList<T> b) {

		MySimpleLinkedList<T> temp = new MySimpleLinkedList<>();
		// 👉 creo una lista nueva donde voy a guardar los elementos en común

		Node<T> reca = a.first;
		// 👉 arranco a recorrer la lista A desde el primer nodo

		while (reca != null) {
			// 👉 mientras no llegue al final de A

			Node<T> recb = b.first;
			// 👉 cada vez que cambio en A, vuelvo a empezar desde el inicio de B

			while (recb != null) {
				// 👉 recorro toda la lista B

				if (reca.getInfo().equals(recb.getInfo())) {
					// 👉 comparo si el valor de A es igual al de B

					temp.insertFront(reca.getInfo());
					// 👉 si son iguales, lo agrego a la lista resultado (temp)
					// 👉 lo meto al principio porque es lo más fácil
				}

				recb = recb.getNext();
				// 👉 avanzo en la lista B
			}

			reca = reca.getNext();
			// 👉 paso al siguiente nodo de A
		}

		ordenarLista(temp);
		// 👉 una vez que junté todos los elementos, los ordeno

		return temp;
		// 👉 devuelvo la lista final ya ordenada
	}

	public void ordenarLista(MySimpleLinkedList<T> lista) {

		boolean huboCambio = true;
		// 👉 variable para saber si hubo cambios (para repetir el proceso)

		while (huboCambio) {
			// 👉 mientras haya cambios, sigo recorriendo la lista

			huboCambio = false;
			// 👉 lo pongo en false al inicio de cada pasada

			Node<T> actual = lista.first;
			// 👉 arranco desde el primer nodo de la lista

			while (actual != null && actual.getNext() != null) {
				// 👉 recorro la lista comparando el nodo actual con el siguiente

				if (actual.getInfo().compareTo(actual.getNext().getInfo()) > 0) {
					// 👉 si el actual es mayor que el siguiente → están desordenados

					T aux = actual.getInfo();
					// 👉 guardo el valor actual en una variable auxiliar

					actual.setInfo(actual.getNext().getInfo());
					// 👉 al nodo actual le pongo el valor del siguiente

					actual.getNext().setInfo(aux);
					// 👉 al siguiente le pongo el valor que guardé antes

					huboCambio = true;
					// 👉 marco que hubo un cambio → entonces tengo que volver a recorrer
				}

				actual = actual.getNext();
				// 👉 avanzo al siguiente nodo
			}
		}
	}

	public MySimpleLinkedList<T> deleteClones(MySimpleLinkedList<T> listaA, MySimpleLinkedList<T> listaB) {

		MySimpleLinkedList<T> temp = new MySimpleLinkedList<>();

		Iterator<T> i = listaA.iterator();

		while (i.hasNext()) {
			T valorA = i.next();

			boolean estaEnB = false;

			Iterator<T> j = listaB.iterator();

			while (j.hasNext()) {
				if (valorA.equals(j.next())) {
					estaEnB = true;
				}
			}

			if (!estaEnB) {
				temp.insertFront(valorA);
			}
		}

		return temp;
	}

	@Override
	public String toString() {
		Node<T> aux = this.first;
		String concatenacion = "";
		for (int i = 0; i < this.size; i++) {
			concatenacion += aux.getInfo();
			aux = aux.getNext();
		}
		return concatenacion;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator<>(this.first);
	}

}

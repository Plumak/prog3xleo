package tp4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
	private HashMap<Integer, ArrayList<Arco<T>>> vertices;

	public GrafoDirigido() {
		this.vertices = new HashMap<>();
	}

	@Override
	public void agregarVertice(int verticeId) {
		if (!this.vertices.containsKey(verticeId)) {
			this.vertices.put(verticeId, new ArrayList<>());
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		this.vertices.remove(verticeId);
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		// con iterartor
		// Iterator<Arco<T>> it = this.vertices.get(verticeId1).iterator();

		if (!this.vertices.containsKey(verticeId1)) {
			/*
			 * put(key, value): Agrega un par clave-valor a la colección; si la clave ya
			 * existe, reemplaza el valor anterior.
			 */
			/*
			 * for (Arco<T> arco : this.vertices.get(verticeId1)) {
			 * // usar arco
			 * }
			 */
			/*
			 * while (it.hasNext()) {
			 * Arco<T> arco = it.next();
			 * }
			 */
			this.vertices.get(verticeId1).add(new Arco<T>(verticeId1, verticeId2, etiqueta));

		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		Iterator<Arco<T>> it = this.vertices.get(verticeId1).iterator();
		if (this.vertices.containsKey(verticeId1)) {
			while (it.hasNext()) {
				Arco<T> arco = it.next();
				if (arco.getVerticeDestino() == verticeId2) {
					it.remove();
				}
			}
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {

		return this.vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		boolean encontrado = false;
		Iterator<Arco<T>> it = this.vertices.get(verticeId1).iterator();
		if (this.vertices.containsKey(verticeId1)) {
			while (it.hasNext() && !encontrado) {
				Arco<T> arco = it.next();
				if (arco.getVerticeDestino() == verticeId2) {
					encontrado = true;
				}
			}

		}

		return encontrado;
	}

	// a revisar
	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if (this.vertices.containsKey(verticeId1)) {

			Iterator<Arco<T>> it = this.vertices.get(verticeId1).iterator();

			while (it.hasNext()) {
				Arco<T> arco = it.next();

				if (arco.getVerticeDestino() == verticeId2) {
					return arco; // ✔️ devolvés el que encontraste
				}
			}
		}

		return null;
	}

	@Override
	public int cantidadVertices() {
		// return this.vertices.size();
		return this.vertices.entrySet().size();
	}

	@Override
	public int cantidadArcos() {
		int acumuladorDeArcos = 0;
		for (ArrayList<Arco<T>> lista : this.vertices.values()) {
			acumuladorDeArcos += lista.size();
		}
		return acumuladorDeArcos;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		Iterator<Integer> it = this.vertices.keySet().iterator();
		return it;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		ArrayList<Integer> lista = new ArrayList<>();
		if (this.vertices.containsKey(verticeId)) {
			Iterator<Arco<T>> it = this.vertices.get(verticeId).iterator();
			while (it.hasNext()) {
				Arco<T> aux = it.next();
				lista.add(aux.getVerticeDestino());

			}
		}

		return lista.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>> arcos = new ArrayList<>();
		for (ArrayList<Arco<T>> lista : this.vertices.values()) {
			arcos.addAll(lista);
		}
		return arcos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		if (!this.vertices.containsKey(verticeId)) {
			return null;
		}
		return this.vertices.get(verticeId).iterator();
	}

}
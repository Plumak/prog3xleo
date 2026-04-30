package tp4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs<T> {
    private HashMap<Integer, String> estados;
    private Queue<Integer> fila;

    public Bfs() {
        this.estados = new HashMap<>();
        this.fila = new LinkedList<>();
    }

    public void recorridoBfs(Grafo<T> g) {
        //
        this.fila.clear();
        Iterator<Integer> vertices = g.obtenerVertices();
        while (vertices.hasNext()) {
            Integer v = vertices.next();
            this.estados.put(v, "NO_VISITADO");
        }
        while (vertices.hasNext()) {
            Integer v = vertices.next();
            if (this.estados.get(v).equals("NO_VISITADO")) {
                this.recorridoBfsPrivate(g, v);
            }
        }

    }

    private void recorridoBfsPrivate(Grafo<T> g, Integer v) {
        /*
         * BFS (Grafo G, vértice s):
         * Marcar el vértice s como VISITADO.
         * Agregar s a la fila F.
         * Mientras la fila F no esté vacía
         * Tomamos vértice x de la fila,
         * Para cada vértice y adyacente a x:
         * Si y es NO_VISITADO :
         * Marcar el vértice y como VISITADO.
         * Agregar
         */
        this.estados.put(v, "VISITADO");
        this.fila.add(v);
        while (!this.fila.isEmpty()) {
            this.fila.poll();
            Iterator<Integer> y = g.obtenerAdyacentes(v);
            while (y.hasNext()) {
                Integer ver = y.next();
                if (this.estados.get(ver).equals("NO_VISITADO")) {
                    this.estados.put(ver,"VISITADO");
                    this.fila.offer(ver);
                }
            }
        }
    }
}
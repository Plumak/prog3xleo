package tp4;

import java.util.HashMap;
import java.util.Iterator;

public class Dfs<T> {
    private HashMap<Integer, String> visitados;

    public Dfs() {
        this.visitados = new HashMap<>();
    }

    public void recorridoDfs(Grafo<T> g) {
        Iterator<Integer> vertices = g.obtenerVertices();

        while (vertices.hasNext()) {
            Integer v = vertices.next();
            this.visitados.put(v, "BLANCO");
        }
        while (vertices.hasNext()) {
            Integer v = vertices.next();
            if (this.visitados.get(v) == "BLANCO") {
                this.recorridoDfsPrivado(v, g, -1);
            }
        }

    }

    private void recorridoDfsPrivado(Integer v, Grafo<T> g, Integer padre) {
        this.visitados.put(v, "AMARILLO");
        while (g.obtenerAdyacentes(v).hasNext()) {
            Integer aux = g.obtenerAdyacentes(v).next();
            if (this.visitados.get(aux).equals("BLANCO")) {
                recorridoDfsPrivado(aux, g, v);
            }else{
                if (this.visitados.get(aux).equals("AMARILLO") && !v.equals(padre)) {
                    System.out.println("Hay ciclo!");
                }
            }
        }
        this.visitados.put(v, "NEGRO");
    }

}

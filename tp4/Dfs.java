package tp4;

import java.util.ArrayList;
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
            } else {
                if (this.visitados.get(aux).equals("AMARILLO") && !v.equals(padre)) {
                    System.out.println("Hay ciclo!");
                }
            }
        }
        this.visitados.put(v, "NEGRO");
    }

    public ArrayList<Integer> caminoMasLargo(
            Grafo<T> g,
            Integer origen,
            Integer destino) {

        ArrayList<Integer> caminoActual = new ArrayList<>();

        ArrayList<Integer> caminoMasLargo = new ArrayList<>();

        Iterator<Integer> vertices = g.obtenerVertices();

        // pintar todos de blanco
        while (vertices.hasNext()) {

            Integer v = vertices.next();

            this.visitados.put(v, "BLANCO");
        }

        // IMPORTANTE:
        // volver a pedir iterator
        vertices = g.obtenerVertices();

        // recorrer todos los vertices
        while (vertices.hasNext()) {

            Integer v = vertices.next();

            if (this.visitados.get(v).equals("BLANCO")) {

                caminoMasLargoPrivado(
                        origen,
                        destino,
                        g,
                        -1,
                        caminoActual,
                        caminoMasLargo);
            }
        }

        return caminoMasLargo;
    }

    private void caminoMasLargoPrivado(
            Integer actual,
            Integer destino,
            Grafo<T> g,
            Integer padre,
            ArrayList<Integer> caminoActual,
            ArrayList<Integer> caminoMasLargo) {

        this.visitados.put(actual, "AMARILLO");

        caminoActual.add(actual);

        // llegué al destino
        if (actual.equals(destino)) {

            if (caminoActual.size() > caminoMasLargo.size()) {

                caminoMasLargo.clear();

                caminoMasLargo.addAll(caminoActual);
            }
        }

        Iterator<Integer> adyacentes = g.obtenerAdyacentes(actual);

        while (adyacentes.hasNext()) {

            Integer aux = adyacentes.next();

            if (this.visitados.get(aux)
                    .equals("BLANCO")) {

                caminoMasLargoPrivado(
                        aux,
                        destino,
                        g,
                        actual,
                        caminoActual,
                        caminoMasLargo);

            } else {

                if (this.visitados.get(aux)
                        .equals("AMARILLO")
                        && !aux.equals(padre)) {

                    System.out.println(
                            "Hay ciclo");
                }
            }
        }

        caminoActual.remove(
                caminoActual.size() - 1);

        this.visitados.put(actual, "BLANCO");
    }

}

package tp5;

import java.util.ArrayList;

import tp4.GrafoDirigido;

public class Backtracking<T> {

    private ArrayList<T> solucionActual;
    private ArrayList<T> mejorSolucion;

    public Backtracking() {
        solucionActual = new ArrayList<>();
        mejorSolucion = new ArrayList<>();
    }

    public void resolver() {

        GrafoDirigido<T> grafo = new GrafoDirigido<>();

        backtrack(grafo);
    }

    private void backtrack(GrafoDirigido<T> estado) {
        /*
         * si llegué a la salida:
         * si este camino es mejor:
         * actualizar mejor solución
         * seguir buscando
         */

        /*
            * if (esSolucion(estado)) {
            * 
            * } else {
            * 
            * // generar hijoss
            * }
         */
    }
}
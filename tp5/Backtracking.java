package tp5;

import java.util.ArrayList;

import tp4.GrafoDirigido;

public class Backtracking<T> {

    private ArrayList<T> solucionActual;
    private ArrayList<T> mejorSolucion;
    private GrafoDirigido<T> grafo;

    public Backtracking() {
        solucionActual = new ArrayList<>();
        mejorSolucion = new ArrayList<>();
        grafo = new GrafoDirigido<>();
    }

    public void resolver(GrafoDirigido<T> grafo) {

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
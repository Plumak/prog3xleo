package tp5;

import java.util.ArrayList;
import java.util.Iterator;

import tp4.GrafoDirigido;

public class Backtracking<T> {

    private ArrayList<Integer> solucionActual;
    private ArrayList<Integer> mejorSolucion;

    private GrafoDirigido<T> grafo;

    private Integer entrada;
    private Integer salida;

    public Backtracking() {
        solucionActual = new ArrayList<>();
        mejorSolucion = new ArrayList<>();
    }

    public ArrayList<Integer> resolver(
            GrafoDirigido<T> grafo,
            Integer entrada,
            Integer salida) {

        this.grafo = grafo;
        this.entrada = entrada;
        this.salida = salida;

        solucionActual.clear();
        mejorSolucion.clear();

        solucionActual.add(entrada);

        backtrack(this.entrada);

        return mejorSolucion;
    }

    private void backtrack(Integer actual) {

        if (actual.equals(salida)) {

            if (solucionActual.size() > mejorSolucion.size()) {

                mejorSolucion.clear();
                mejorSolucion.addAll(solucionActual);
            }

        } else {

            Iterator<Integer> hijos = grafo.obtenerAdyacentes(actual);

            while (hijos.hasNext()) {

                Integer siguiente = hijos.next();

                if (!solucionActual.contains(siguiente)) {

                    solucionActual.add(siguiente);

                    backtrack(siguiente);

                    solucionActual.remove(solucionActual.size() - 1);
                }
            }
        }
    }
}
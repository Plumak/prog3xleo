package tp5;

import java.util.ArrayList;
import java.util.Iterator;

import tp4.GrafoDirigido;

public class Backtracking<T> {

    private ArrayList<Integer> solucionActual;
    private ArrayList<Integer> mejorSolucion;
    private ObjetoMatriz[][] matriz = new ObjetoMatriz[3][3];
    private GrafoDirigido<T> grafo;

    private Integer entrada;
    private Integer salida;

    public Backtracking() {
        solucionActual = new ArrayList<>();
        mejorSolucion = new ArrayList<>();

        //no escala un choto pero es para probar
        matriz[0][0] = new ObjetoMatriz(false, true, true, false, 1);
        matriz[0][1] = new ObjetoMatriz(false, true, true, true, 4);
        matriz[0][2] = new ObjetoMatriz(false, false, true, true, 3);

        matriz[1][0] = new ObjetoMatriz(true, true, true, false, 4);
        matriz[1][1] = new ObjetoMatriz(true, true, true, true, 6);
        matriz[1][2] = new ObjetoMatriz(true, false, true, true, 5);

        matriz[2][0] = new ObjetoMatriz(true, true, false, false, 1);
        matriz[2][1] = new ObjetoMatriz(true, true, false, true, 9);
        matriz[2][2] = new ObjetoMatriz(true, false, false, true, 7);

    }

    public ArrayList<Integer> resolver(
            GrafoDirigido<T> grafo,
            Integer entrada,
            Integer salida) {

        this.grafo = grafo;
        this.entrada = entrada;
        this.salida = salida;

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
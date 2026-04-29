package tp2;

public class Ejercicio1 {
    public static final int MAX = 9;

    /*
     * Implemente un algoritmo recursivo que determine si un arreglo de tamaño N
     * está ordenado y
     * responda:
     * 1. ¿Qué complejidad O tiene? (La complejidad en el peor caso)
     * 2. ¿Trae algún problema hacerlo recursivo? ¿Cuál?
     * 3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?
     */
    public static void main(String[] args) {
        int[] arreglo = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        recorrerArreglo(arreglo);

    }

    public static boolean recorrerArreglo(int[] arreglo) {
        return recorrerArreglo(arreglo, 0);
    }

    private static boolean recorrerArreglo(int[] arreglo, int i) {

        if (i == MAX - 1) {
            return true;
        }

        if (arreglo[i] > arreglo[i + 1]) {
            return false;
        }

        return recorrerArreglo(arreglo, i + 1);
    }
    /*
     * Ejercicio 4
     * Implemente un algoritmo recursivo que presente los primeros N términos de la
     * secuencia de
     * Fibonacci.
     * Por ej. los 6 primeros términos son: 0 1 1 2 3 5
     */

    public static int fibonacci(int n) {
        return fibonacciRecursivo(n);
    }

    private static int fibonacciRecursivo(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

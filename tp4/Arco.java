package tp4;

/*
* La clase arco representa un arco del grafo. Contiene un vertice origen, un vertice destino y una etiqueta.
* Nota: Para poder exponer los arcos fuera del grafo y que nadie los modifique se hizo esta clase inmutable
* (Inmutable: una vez creado el arco no es posible cambiarle los valores).
*/
public class Arco<T> {

    private int verticeOrigen;
    private int verticeDestino;
    private String verticeDestinoStr;
    private T etiqueta;

    public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.etiqueta = etiqueta;


    }
        public Arco(int verticeOrigen, int verticeDestino, T etiqueta, String verticeDestinoStr) {
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.etiqueta = etiqueta;
        this.verticeDestinoStr = verticeDestinoStr;

    }

    public int getVerticeOrigen() {
        return verticeOrigen;
    }

    public int getVerticeDestino() {
        return verticeDestino;
    }

    public String getVerticeDestinoStr() {
        return verticeDestinoStr;
    }


    public T getEtiqueta() {
        return etiqueta;
    }

    

}

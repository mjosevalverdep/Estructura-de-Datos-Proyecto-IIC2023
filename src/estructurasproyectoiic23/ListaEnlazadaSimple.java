package estructurasproyectoiic23;

public class ListaEnlazadaSimple {
    private Nodo cabeza;

    public class Nodo {
    private Producto producto;
    private Nodo siguiente;

    public Nodo(Producto producto) {
        this.producto = producto;
        this.siguiente = null;
    }

    public ListaEnlazadaSimple() {
        cabeza = null;
    }

    public void modificarProducto(int codigo, String nuevoNombre, String nuevaFechaCaducidad, String nuevaCategoria) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getProducto().getCodigo() == codigo) {
                actual.getProducto().setNombre(nuevoNombre);
                actual.getProducto().setFechaCaducidad(nuevaFechaCaducidad);
                actual.getProducto().setCategoria(nuevaCategoria);
                break;
            }
            actual = actual.getSiguiente();
        }
    }
}
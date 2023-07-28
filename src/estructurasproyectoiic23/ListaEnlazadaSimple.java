/* package estructurasproyectoiic23;

public class ListaEnlazadaSimple {
    public ListaEnlazadaSimple() {
        inicio = null;
    }
    public void modificarProducto(int indice, Producto nuevoProducto) {
        if (indice < 0 || inicio == null) {
            throw new IndexOutOfBoundsException("Índice fuera de rango o lista vacía");
        }
        Nodo temp = inicio;
        for (int i = 0; i < indice; i++) {
            if (temp.siguiente == null) {
                throw new IndexOutOfBoundsException("Índice fuera de rango");
            }
            temp = temp.siguiente;
        }
        temp.producto = nuevoProducto;
    }
} */

//Se comento toda la clase hasta el momento debido a que tiene un error en la clase nodo , falta que Daniel agregue 
//la clase y también lo implementé al menú
//RECUERDE DESCOMENTAR LA CLASE
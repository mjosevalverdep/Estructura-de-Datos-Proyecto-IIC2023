package estructurasproyectoiic23;
import javax.swing.JOptionPane;

public class Pila{
    private Nodo inicio;

    public class Nodo{
        Producto producto;
        Nodo siguiente;

        public Nodo(Producto producto){
            this.producto = producto;
            this.siguiente = null;
        }
    }

    public Pila(){
        this.inicio= null;
    }

    public void agregarProducto(Producto producto){
        Nodo nnodo= new Nodo(producto);
        if(inicio== null) {
            inicio= nnodo;
        }else{
            nnodo.siguiente= inicio;
            inicio= nnodo;
        }
    }

    public boolean vacio(){
        return inicio== null;
    }

    public void ordenarAZ(){
        if (vacio()||inicio.siguiente == null){
            return;
        }

        Nodo nodoA = inicio;
        while (nodoA.siguiente!= null){
            Nodo nodoB = inicio;
            while (nodoB.siguiente!= null){
                Nodo nodo1 = nodoB;
                Nodo nodo2 = nodoB.siguiente;

                if(nodo1.producto.getNombre().compareToIgnoreCase(nodo2.producto.getNombre()) > 0){
                    Producto temp = nodo1.producto;
                    nodo1.producto = nodo2.producto;
                    nodo2.producto = temp;
                }
                nodoB= nodoB.siguiente;
            }
            nodoA= nodoA.siguiente;
        }
    }

    public void eliminarProducto(int codigo){
        Nodo estenodo = inicio;
        Nodo anterior = null;

        while (estenodo != null){
            if (estenodo.producto.getCodigo() == codigo){
                if (anterior != null){
                    anterior.siguiente= estenodo.siguiente;
                }else{
                    inicio = estenodo.siguiente;
                }
                return;
            }
            anterior= estenodo;
            estenodo = estenodo.siguiente;
        }
    }

    public void imprimirPila() {
        if (vacio()){
            JOptionPane.showMessageDialog(null, "La pila está vacía.", "Pila Vacía", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String mensaje= "Lista de productos A-Z:\n";
        Nodo actual= inicio;

        while(actual != null){
            mensaje+= actual.producto.getNombre() + "\n";
            actual= actual.siguiente;
        }

        JOptionPane.showMessageDialog(null, mensaje, "Contenido de la Pila", JOptionPane.INFORMATION_MESSAGE);
    }
}
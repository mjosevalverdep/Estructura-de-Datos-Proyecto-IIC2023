package estructurasproyectoiic23;
import javax.swing.JOptionPane;

public class Cola{
    private Nodo inicio;
    private Nodo finalcola;

    public class Nodo{
        Producto producto;
        Nodo siguiente;

        public Nodo(Producto producto){
            this.producto= producto;
            this.siguiente= null;
        }
    }

    public Cola(){
        this.inicio= null;
        this.finalcola= null;
    }

    public void agregarProducto(Producto producto){
        Nodo nnodo =new Nodo(producto);
        if (vacio()){
            inicio = nnodo;
            finalcola = nnodo;
        }else{
            finalcola.siguiente = nnodo;
            finalcola = nnodo;
        }
    }

    public boolean vacio(){
        return inicio== null;
    }

    public void ordenarZA(){
        if (vacio() || inicio.siguiente == null){
            return;
        }

        Nodo nodoA= inicio;
        while (nodoA.siguiente != null){
            Nodo nodoB= inicio;
            while (nodoB.siguiente != null){
                Nodo nodo1= nodoB;
                Nodo nodo2= nodoB.siguiente;

                if(nodo1.producto.getNombre().compareToIgnoreCase(nodo2.producto.getNombre()) < 0){
                    Producto temp= nodo1.producto;
                    nodo1.producto= nodo2.producto;
                    nodo2.producto= temp;
                }
                nodoB= nodoB.siguiente;
            }
            nodoA= nodoA.siguiente;
        }
    }

    public void eliminarProducto(int codigo){
        Nodo estenodo = inicio;
        Nodo anterior = null;

        while(estenodo!= null){
            if(estenodo.producto.getCodigo()== codigo){
                if(anterior != null){
                    anterior.siguiente = estenodo.siguiente;
                    if(estenodo== inicio){
                        inicio= estenodo.siguiente;
                    }
                    if(estenodo== finalcola){
                        finalcola= anterior;
                    }
                }else{
                    inicio= inicio.siguiente;
                    if(inicio== null) {
                        finalcola= null;
                    }
                }
                return;
            }
            anterior= estenodo;
            estenodo= estenodo.siguiente;
        }
    }

    public void imprimirCola(){
        if (vacio()){
            JOptionPane.showMessageDialog(null, "La cola está vacía.", "Cola Vacía", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String mensaje = "Lista de productos Z-A:\n";
        Nodo actual = inicio;

        while (actual != null){
            mensaje+= actual.producto.getNombre() + "\n";
            actual= actual.siguiente;
        }

        JOptionPane.showMessageDialog(null, mensaje, "Contenido de la Cola", JOptionPane.INFORMATION_MESSAGE);
    }
}
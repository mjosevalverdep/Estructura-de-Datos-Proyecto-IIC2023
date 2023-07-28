package estructurasproyectoiic23;

import javax.swing.JOptionPane;

class ListaEnlazadaSimple {
    Nodo cabeza;

    public class Nodo {
    private Producto producto;
    private Nodo siguiente;

    public Nodo(Producto producto) {
        this.producto = producto;
        this.siguiente = null;
    }
    
    public void modificarProducto(int codigo) {
        Nodo actual = cabeza;
        
        while (current != null) {
            if (actual.producto.getCodigo() == codigo) {
                String nuevoNombre = JOptionPane.showInputDialog(null, "Ingresa el nuevo nombre:");
                String nuevaFechaCaducidad = JOptionPane.showInputDialog(null, "Ingresa la nueva fecha de caducidad:");
                String nuevaCategoria = JOptionPane.showInputDialog(null, "Ingresa la nueva categoría:");
                
                actual.producto.setNombre(nuevoNombre);
                actual.producto.setFechaCaducidad(nuevaFechaCaducidad);
                actual.producto.setCategoria(nuevaCategoria);

                return;
            }
            actual = actual.siguiente;
        }
        
        JOptionPane.showMessageDialog(null, "Producto con el código " + codigo + " no se ha encontrado.");
    }
}
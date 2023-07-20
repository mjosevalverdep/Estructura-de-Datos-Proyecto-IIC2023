package estructurasproyectoiic23;

import javax.swing.JOptionPane;

public class ListaDobleEnlazada {
    private Nodo primero;
    private Nodo ultimo;
    private int tamaño;

    private class Nodo {
        private Producto producto;
        private Nodo siguiente;
        private Nodo prev;

        public Nodo(Producto producto) {
            this.producto = producto;
            this.siguiente = null;
            this.prev = null;
        }
    }
    public ListaDobleEnlazada() {
        primero = null;
        ultimo = null;
        tamaño = 0;
    }
    public void agregarProducto(Producto producto) {
        Nodo newNode = new Nodo(producto);
        if (primero == null) {
            primero = newNode;
            ultimo = newNode;
        } else {
            ultimo.siguiente = newNode;
            newNode.prev = ultimo;
            ultimo = newNode;
        }
        tamaño++;
    }
    public void eliminarProducto(int codigo) {
        if (primero == null){
            JOptionPane.showMessageDialog(null, "El producto indicado no se pudo eliminar", "Lista vacía",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        Nodo current = primero;
        while (current != null) {
            if (current.producto.getCodigo() == codigo) {
                if (current == primero) {
                    primero = current.siguiente;
                    if (primero != null) {
                        primero.prev = null;
                    }
                } else if (current == ultimo) {
                    ultimo = current.prev;
                    if (ultimo != null) {
                        ultimo.siguiente = null;
                    }
                } else {
                    current.prev.siguiente = current.siguiente;
                    current.siguiente.prev = current.prev;
                }
                JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente.");
                tamaño--;
                return;
            }
            current = current.siguiente;
        }
    }
    // Método para recorrer la lista en ambas direcciones
    public void mostrarProductos() {
    if (primero == null) {
        JOptionPane.showMessageDialog(null, "No hay productos registrados", "Lista vacía", JOptionPane.ERROR_MESSAGE);
        return;
    }

    StringBuilder infoBuilder = new StringBuilder();
    Nodo current = primero;
    infoBuilder.append("-------Lista de productos-------").append("\n\n");
    while (current != null) { 
                infoBuilder.append("Nombre: ").append(current.producto.getNombre()).append("\n")
                .append("Código: ").append(current.producto.getCodigo()).append("\n")
                .append("Fecha de caducidad: ").append(current.producto.getFechaCaducidad()).append("\n")
                .append("Categoría: ").append(current.producto.getCategoria()).append("\n")
                .append("-------------------------------------\n");

        current = current.siguiente;
    }
    JOptionPane.showMessageDialog(null, infoBuilder.toString());
}
     // Método para buscar productos por categoría utilizando recursión
    public void buscarProductosPorCategoriaRecursivo(String categoria) {
        StringBuilder productosEncontrados = new StringBuilder();
        buscarProductosPorCategoriaRecursivo(primero, categoria, productosEncontrados);

        if (productosEncontrados.length() > 0) {
            JOptionPane.showMessageDialog(null, "--Productos encontrados en la categoría " + categoria +"--"+"\n" + productosEncontrados.toString());
        } else {
             JOptionPane.showMessageDialog(null, "No se encontraron productos en la categoría " + categoria, "Lista vacía",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    private void buscarProductosPorCategoriaRecursivo(Nodo current, String categoria, StringBuilder productosEncontrados) {
        if (current == null) {
            return;
        }
        if (current.producto.getCategoria().equalsIgnoreCase(categoria)) {
            productosEncontrados.append(current.producto.getNombre()).append("\n");
        }
        buscarProductosPorCategoriaRecursivo(current.siguiente, categoria, productosEncontrados);
    }
}
 
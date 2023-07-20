package estructurasproyectoiic23;

import javax.swing.JOptionPane;


public class ListaEnlazadaCircular {
    private Nodo primero;
    private int tamaño;

    private class Nodo {
        private Producto producto;
        private Nodo siguiente;

        public Nodo(Producto producto) {
            this.producto = producto;
            this.siguiente = null;
        }
    }

    public ListaEnlazadaCircular() {
        primero = null;
        tamaño = 0;
    }

    public void agregarProducto(Producto producto) {
        Nodo newNode = new Nodo(producto);
        if (primero == null) {
            primero = newNode;
            newNode.siguiente = primero;
        } else {
            Nodo last = primero;
            while (last.siguiente != primero) {
                last = last.siguiente;
            }
            last.siguiente = newNode;
            newNode.siguiente = primero;
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
        Nodo previous = null;

        do {
            if (current.producto.getCodigo() == codigo) {
                if (previous != null) {
                    previous.siguiente = current.siguiente;
                    if (current == primero) {
                        primero = current.siguiente;
                    }
                } else if (current == primero) {
                    primero = current.siguiente;
                }
                tamaño--;
                return;
            }
            previous = current;
            current = current.siguiente;
        } while (current != primero);
    }

    //Método para rotar productos en la lista enlazada circular
    public void rotarProductos(int numRotaciones) {
        if (primero == null || numRotaciones <= 0) {
            JOptionPane.showMessageDialog(null, "No hay productos para rotar", "Lista vacía",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }else {
            JOptionPane.showMessageDialog(null, "Productos Rotados Exitosamente","Lista",JOptionPane.INFORMATION_MESSAGE);
        }
        Nodo current = primero;
        for (int i = 0; i < numRotaciones - 1; i++) {
            current = current.siguiente;
        }
        primero = current.siguiente;
    }
    
    //Método mostrar productos rotados
    public void mostrarProductos() {
        if (primero == null) {
            JOptionPane.showMessageDialog(null, "No hay productos en lista", "Lista vacía", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Nodo current = primero;
        StringBuilder infoBuilder = new StringBuilder();
        infoBuilder.append("--Lista de productos después de la rotación--").append("\n\n");
        do {
            infoBuilder.append("Nombre: ").append(current.producto.getNombre()).append("\n")
                    .append("Código: ").append(current.producto.getCodigo()).append("\n")
                    .append("Fecha de caducidad: ").append(current.producto.getFechaCaducidad()).append("\n")
                    .append("Categoría: ").append(current.producto.getCategoria()).append("\n")
                    .append("----------------------------------------------------------\n");
            current = current.siguiente;
        } while (current != primero);
        JOptionPane.showMessageDialog(null, infoBuilder.toString());
    }
}

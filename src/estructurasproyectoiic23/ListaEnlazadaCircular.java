package estructurasproyectoiic23;

import javax.swing.JOptionPane;


public class ListaEnlazadaCircular {
    private Nodo first;
    private int size;

    private class Nodo {
        private Producto producto;
        private Nodo next;

        public Nodo(Producto producto) {
            this.producto = producto;
            this.next = null;
        }
    }

    public ListaEnlazadaCircular() {
        first = null;
        size = 0;
    }

    public void agregarProducto(Producto producto) {
        Nodo newNode = new Nodo(producto);
        if (first == null) {
            first = newNode;
            newNode.next = first;
        } else {
            Nodo last = first;
            while (last.next != first) {
                last = last.next;
            }
            last.next = newNode;
            newNode.next = first;
        }
        size++;
    }

    public void eliminarProducto(int codigo) {
        if (first == null){
           JOptionPane.showMessageDialog(null, "El producto indicado no se pudo eliminar", "Lista vacía",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        Nodo current = first;
        Nodo previous = null;

        do {
            if (current.producto.getCodigo() == codigo) {
                if (previous != null) {
                    previous.next = current.next;
                    if (current == first) {
                        first = current.next;
                    }
                } else if (current == first) {
                    first = current.next;
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        } while (current != first);
    }

    //Método para rotar productos en la lista enlazada circular
    public void rotarProductos(int numRotaciones) {
        if (first == null || numRotaciones <= 0) {
            JOptionPane.showMessageDialog(null, "No hay productos para rotar", "Lista vacía",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }else {
            JOptionPane.showMessageDialog(null, "Productos Rotados Exitosamente","Lista",JOptionPane.INFORMATION_MESSAGE);
        }
        Nodo current = first;
        for (int i = 0; i < numRotaciones - 1; i++) {
            current = current.next;
        }
        first = current.next;
    }
    
    //Método mostrar productos rotados
    public void mostrarProductos() {
        if (first == null) {
            JOptionPane.showMessageDialog(null, "No hay productos en lista", "Lista vacía", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Nodo current = first;
        StringBuilder infoBuilder = new StringBuilder();
        infoBuilder.append("--Lista de productos después de la rotación--").append("\n\n");
        do {
            infoBuilder.append("Nombre: ").append(current.producto.getNombre()).append("\n")
                    .append("Código: ").append(current.producto.getCodigo()).append("\n")
                    .append("Fecha de caducidad: ").append(current.producto.getFechaCaducidad()).append("\n")
                    .append("Categoría: ").append(current.producto.getCategoria()).append("\n")
                    .append("----------------------------------------------------------\n");
            current = current.next;
        } while (current != first);
        JOptionPane.showMessageDialog(null, infoBuilder.toString());
    }
}

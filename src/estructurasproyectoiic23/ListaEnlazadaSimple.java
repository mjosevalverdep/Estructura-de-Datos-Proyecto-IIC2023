package estructurasproyectoiic23;
import javax.swing.JOptionPane;
import java.util.LinkedList;

public class ListaEnlazadaSimple {
    private LinkedList<Producto> listaProductos;

    public ListaEnlazadaSimple() {
        listaProductos = new LinkedList<>();
    }
    
    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public void modificarProducto(int codigo) {
        for (Producto producto : listaProductos) {
            if (producto.getCodigo() == codigo) {
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del producto:");
                producto.setNombre(nuevoNombre);

                String nuevaFechaCaducidad = JOptionPane.showInputDialog("Ingrese la nueva fecha de caducidad del producto:");
                producto.setFechaCaducidad(nuevaFechaCaducidad);

                String nuevaCategoria = JOptionPane.showInputDialog("Ingrese la nueva categoría del producto:");
                producto.setCategoria(nuevaCategoria);

                JOptionPane.showMessageDialog(null, "Producto modificado exitosamente!");
                break;
            }
            else{
                JOptionPane.showMessageDialog(null, "El código es incorrecto. Vuelva a ingresarlo correctamente.");
            }
        }
    }
}
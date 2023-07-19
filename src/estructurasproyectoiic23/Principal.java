package estructurasproyectoiic23;

import javax.swing.JOptionPane;

public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista l = new Lista();
        
        JOptionPane.showMessageDialog(null, "Ingrese productos (haga clic en 'Cancelar' para terminar):");
        
        String producto = JOptionPane.showInputDialog("Ingrese un producto:");
        while (producto != null) {
            l.agregarProducto(producto);
            producto = JOptionPane.showInputDialog("Ingrese otro producto:");
        }
        
        //JOptionPane.showMessageDialog(null, "Lista de productos:\n" + l.mostrarProductos());

        String productoBuscado = JOptionPane.showInputDialog("Ingrese un producto a buscar:");
        if (l.buscarProducto(productoBuscado)) {
            JOptionPane.showMessageDialog(null, productoBuscado + " encontrado.");
        } else {
            JOptionPane.showMessageDialog(null, productoBuscado + " no encontrado.");
        }
    }
    
}

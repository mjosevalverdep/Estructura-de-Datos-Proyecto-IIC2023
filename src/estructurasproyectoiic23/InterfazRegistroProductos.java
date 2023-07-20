package estructurasproyectoiic23;

import javax.swing.JOptionPane;

public class InterfazRegistroProductos {
    private ListaEnlazadaCircular listaEnlazadaCircular;
    private ListaDobleEnlazada listaDobleEnlazada;

    public InterfazRegistroProductos() {
        listaEnlazadaCircular = new ListaEnlazadaCircular();
        listaDobleEnlazada = new ListaDobleEnlazada();
    }

    public void mostrarMenu() {
        String menu = "Seleccione una opción:\n" +
                "1. Agregar producto\n" +
                "2. Eliminar producto\n" +
                "3. Rotar productos (lista enlazada circular)\n" +
                "4. Mostrar productos (lista doblemente enlazada)\n" +
                "5. Buscar productos por categoría (lista doblemente enlazada)\n" +
                "0. Salir";

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    eliminarProducto();
                    break;
                case 3:
                    rotarProductos();
                    break;
                case 4:
                    mostrarProductos();
                    break;
                case 5:
                    buscarProductosPorCategoria();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (opcion != 0);
    }
    private void agregarProducto() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del producto:"));
        String fechaCaducidad = JOptionPane.showInputDialog("Ingrese la fecha de caducidad del producto:");
        String categoria = JOptionPane.showInputDialog("Ingrese la categoría del producto:");

        Producto nuevoProducto = new Producto(nombre, codigo, fechaCaducidad, categoria);
        listaEnlazadaCircular.agregarProducto(nuevoProducto);
        listaDobleEnlazada.agregarProducto(nuevoProducto);

        JOptionPane.showMessageDialog(null, "Producto agregado exitosamente.");
    }

    private void eliminarProducto() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del producto a eliminar:"));
        listaEnlazadaCircular.eliminarProducto(codigo);
        listaDobleEnlazada.eliminarProducto(codigo);
    }

    private void rotarProductos() {
        int numRotaciones = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de rotaciones:"));
        listaEnlazadaCircular.rotarProductos(numRotaciones);
        listaEnlazadaCircular.mostrarProductos();
    }

    private void mostrarProductos() {
        listaDobleEnlazada.mostrarProductos();
    }

    private void buscarProductosPorCategoria() {
        String categoria = JOptionPane.showInputDialog("Ingrese la categoría a buscar:");
        listaDobleEnlazada.buscarProductosPorCategoriaRecursivo(categoria);
    }
}

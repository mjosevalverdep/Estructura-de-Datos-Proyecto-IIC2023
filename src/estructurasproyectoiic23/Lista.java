/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructurasproyectoiic23;

/**
 *
 * @author luisa
 */
public class Lista {
    Nodo cabeza;
    
    public Lista(){
        this.cabeza = null;
    }
    
    public void agregarProducto(String producto){
        Nodo nuevoNodo = new Nodo();
        
        if (cabeza == null){
            cabeza = nuevoNodo;
        }else{
            Nodo actual = cabeza;
            while(actual.siguiente != null){
                actual = actual.siguiente;     
            }
            actual.siguiente = nuevoNodo;
            nuevoNodo.anterior = actual;
        }
    }
    
    public void mostrarProductos() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println(actual.producto);
            actual = actual.siguiente;
        }
    }

    public boolean buscarProducto(String producto) {
        return buscarProductoRecursivo(cabeza, producto);
    }

    private boolean buscarProductoRecursivo(Nodo nodo, String producto) {
        if (nodo == null) {
            return false;
        }

        if (nodo.producto.equals(producto)) {
            return true;
        }
        
        return buscarProductoRecursivo(nodo.siguiente, producto);
    }
    
}

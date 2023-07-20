package estructurasproyectoiic23;

public class Producto {
    
    //Atributos
    private String nombre;
    private int codigo;
    private String fechaCaducidad;
    private String categoria;

    public Producto(String nombre, int codigo, String fechaCaducidad, String categoria) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.fechaCaducidad = fechaCaducidad;
        this.categoria = categoria;
    }
    //Constructor Vacio
    public Producto(){

    }
    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

package Classes;

public class Productos {
    private int id;
    private String producto;
    private float precio;
    
    public Productos() {
        this.id = 0;
        this.producto = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
    
    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        //return getPrecio()+"    "+getProducto();
        return getProducto();
    }
    
}

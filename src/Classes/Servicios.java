package Classes;

public class Servicios {
    private int id;
    private String servicio;
    private float precio;
    private String duracion;
    private int dur;
    
    public Servicios() {
        this.id = 0;
        this.servicio = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    
    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    
    public int getDur() {
        return dur;
    }

    public void setDur(int dur) {
        this.dur = dur;
    }

    @Override
    public String toString() {
        //return getPrecio()+"    "+getServicio();
        return getServicio();
    }
    
}

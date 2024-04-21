package Classes;

public class Barberos {
    private int id;
    private String barbero;
    private String tipo;
    
    public Barberos() {
        this.id = 0;
        this.barbero = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarbero() {
        return barbero;
    }

    public void setBarbero(String barbero) {
        this.barbero = barbero;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return getBarbero();
    }
    
}

package itson.ticketwizard.entidades;

public class Evento{
    
    private String nombre;
    private String ciudad;
    private String estado;
    private String descripcion;
    private String recinto;

    public Evento(String nombre, String ciudad, String estado, String descripcion, String recinto) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estado = estado;
        this.descripcion = descripcion;
        this.recinto = recinto;
    }
    
    public Evento(){
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRecinto() {
        return recinto;
    }

    public void setRecinto(String recinto) {
        this.recinto = recinto;
    }
    
    
}
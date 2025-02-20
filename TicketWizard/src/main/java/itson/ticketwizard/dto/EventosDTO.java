package itson.ticketwizard.dto;

public class EventosDTO {
    private String nombre;
    private String fecha;
    private String ciudad;
    private String estado;
    private String descripcion;
    private String recinto;

    /**
     * Parametros del constructor
     * @param nombre
     * @param fecha
     * @param ciudad
     * @param estado
     * @param descripcion
     * @param recinto
     */
    public EventosDTO(String nombre, String fecha, String ciudad, String estado, String descripcion, String recinto) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ciudad = ciudad;
        this.estado = estado;
        this.descripcion = descripcion;
        this.recinto = recinto;
    }

    public String getNombre() {
        return nombre;
    }
    public String getFecha() {
        return fecha;
    }
    public String getCiudad() {
        return ciudad;
    }
    public String getEstado() {
        return estado;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getRecinto() {
        return recinto;
    }
}

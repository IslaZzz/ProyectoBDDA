package itson.ticketwizard.entidades;

import java.util.Date;
import java.util.Objects;

public class Evento {
    // Atributos de la clase Evento
    private int id;
    private String nombre;
    private Date fecha;
    private String ciudad;
    private String estado;
    private String descripcion;
    private String recinto;

    /**
     * Constructor de la clase Evento que recibe los atributos de la clase Evento
     * 
     * @param id
     * @param nombre
     * @param ciudad
     * @param estado
     * @param descripcion
     * @param recinto
     */
    public Evento(int id, String nombre, String ciudad, String estado, String descripcion, String recinto) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estado = estado;
        this.descripcion = descripcion;
        this.recinto = recinto;
    }

    /**
     * constructor por defecto de la clase Evento
     */
    public Evento() {

    }

    /**
     * Metodos de la clase Evento
     * 
     * @return String que representa el nombre del evento
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodos de la clase Evento
     * 
     * @param nombre que representa el nombre del evento
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return String que representa la ciudad del evento
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * 
     * @param ciudad que representa la ciudad del evento
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * 
     * @return String que representa el estado del evento
     */
    public String getEstado() {
        return estado;
    }

    /**
     * 
     * @param estado que representa el estado del evento
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * 
     * @return String que representa la descripcion del evento
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * 
     * @param descripcion que representa la descripcion del evento
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * 
     * @return String que representa el recinto del evento
     */
    public String getRecinto() {
        return recinto;
    }

    /**
     * 
     * @param recinto que representa el recinto del evento
     */
    public void setRecinto(String recinto) {
        this.recinto = recinto;
    }

    @Override
    public String toString() {
        return "Evento [nombre=" + nombre + ", ciudad=" + ciudad + ", estado=" + estado + ", descripcion=" + descripcion
                + ", recinto=" + recinto + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + ((estado == null) ? 0 : estado.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((recinto == null) ? 0 : recinto.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Evento other = (Evento) obj;
        return Objects.equals(this.id, other.id);
    }
}
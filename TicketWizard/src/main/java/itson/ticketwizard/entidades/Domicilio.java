/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.entidades;

/**
 *
 * @author 52644
 */
public class Domicilio {
    // Atributos de la clase
    private Integer id;
    private String calle;
    private String colonia;
    private String ciudad;
    private String codigoPostal;
    private String estado;

    /**
     * Constructor que recibe los parametros y los asigna a las variables
     * 
     * @param id
     * @param calle
     * @param colonia
     * @param ciudad
     * @param codigoPostal
     * @param estado
     */
    public Domicilio(Integer id, String calle, String colonia, String ciudad, String codigoPostal, String estado) {
        this.calle = calle;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
    }
/**
 * Constructor vacio
 */
    public Domicilio() {

    }
/**
 * 
 * @return string que representa al id de la clase
 */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @return String que representa la calle del domicilio
     */
    public String getCalle() {
        return calle;
    }
/**
 * 
 * @param calle que representa la calle del domicilio
 */
    public void setCalle(String calle) {
        this.calle = calle;
    }
/**
 * 
 * @return String que representa la colonia del domicilio
 */
    public String getColonia() {
        return colonia;
    }
/**
 * 
 * @param colonia que representa la colonia del domicilio
 */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
/**
 * 
 * @return String que representa la ciudad del domicilio
 */
    public String getCiudad() {
        return ciudad;
    }
/**
 * 
 * @param ciudad que representa la ciudad del domicilio
 */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
/**
 * 
 * @return String que representa el codigo postal del domicilio
 */
    public String getCodigoPostal() {
        return codigoPostal;
    }
/**
 * 
 * @param codigoPostal que representa el codigo postal del domicilio
 */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
/**
 * 
 * @return String que representa el estado del domicilio
 */
    public String getEstado() {
        return estado;
    }
/**
 * 
 * @param estado que representa el estado del domicilio
 */
    public void setEstado(String estado) {
        this.estado = estado;
    }
/**
 * 
 * @return int que representa el hashcode del objeto
 */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        return hash;
    }
/**
 * 
 * @param obj que representa el objeto a comparar
 * @return true en caso de que sean el mismo objeto, false en caso contrario
 */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Domicilio other = (Domicilio) obj;
        return this.id == other.id;
    }
/**
 * 
 * @return String que representa el objeto
 */
    @Override
    public String toString(){
        return "Domicilio [calle= "+calle + "colonia= "+colonia + "ciudad= "+ciudad+"codigo postal= "+codigoPostal+"estado= "+estado+"]";
    }

}

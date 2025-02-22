/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.dto;

/**
 *
 * @author Peter
 */
public class NuevaDireccionDTO {
    private String calle;
    private String colonia;
    private String ciudad;
    private String codigoPostal;
    private String estado;

    public NuevaDireccionDTO(String calle, String colonia, String ciudad, String codigoPostal, String estado) {
        this.calle = calle;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
    }

    public String getCalle() {
        return calle;
    }

    public String getColonia() {
        return colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getEstado() {
        return estado;
    }
    
    
    
}

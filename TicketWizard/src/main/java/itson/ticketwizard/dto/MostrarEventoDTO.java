/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.dto;

import java.util.Date;

/**
 *
 * @author pc
 */
public class MostrarEventoDTO {
    private Integer codigo;
    private String nombre;
    private Date fecha;
    private String ciudad;
    private String estado;

    public MostrarEventoDTO(Integer codigo, String nombre, Date fecha, String ciudad, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.ciudad = ciudad;
        this.estado = estado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEstado() {
        return estado;
    }
    
}

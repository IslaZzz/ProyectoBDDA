/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.dto;

import itson.ticketwizard.entidades.Direccion;
import java.sql.Date;

/**
 *
 * @author Peter
 */
public class RegistroUsuarioDTO {
    private String nombres;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String correoElectronico;
    private String contrasenia;
    private Date fechaNacimiento;

    public RegistroUsuarioDTO(String nombres, String apellidoMaterno, String apellidoPaterno, String correoElectronico, String contrasenia, Date fechaNacimiento) {
        this.nombres = nombres;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    
}

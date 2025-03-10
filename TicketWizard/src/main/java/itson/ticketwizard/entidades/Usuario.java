package itson.ticketwizard.entidades;

import java.sql.Date;

public class Usuario {

    private Integer id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correoElectronico;
    private double saldo;
    private int idDireccion;
    private String contrasenia;
    private Date fechaNacimiento;
/**
 * Constructor que establece el valor de los atributos al de los parámetros recibidos
 * @param id
 * @param nombres
 * @param apellidoPaterno
 * @param apellidoMaterno
 * @param correoElectronico
 * @param saldo
 * @param domicilio
 * @param contrasenia
 * @param fechaNacimiento 
 */
    public Usuario(int id, String nombres, String apellidoPaterno, String apellidoMaterno,
            String correoElectronico, double saldo, int domicilio, String contrasenia, Date fechaNacimiento) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.saldo = saldo;
        this.idDireccion = domicilio;
        this.contrasenia = contrasenia;
    }
/**
 * Constructor que establece el valor de los atributos al de los parámetros recibidos
 * @param id
 * @param nombres
 * @param apellidoPaterno
 * @param apellidoMaterno
 * @param correoElectronico
 * @param fechaNacimiento
 * @param saldo
 * @param idDireccion 
 */
    public Usuario(Integer id, String nombres, String apellidoPaterno, String apellidoMaterno, String correoElectronico,  Date fechaNacimiento, double saldo, int idDireccion) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.saldo = saldo;
        this.idDireccion = idDireccion;
    }

    
    public Usuario(Integer id){
        this.id = id;
    }
    public Usuario() {

    }

    public int getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
/**
 * Genera un hashcode para el objeto
 * @return 
 */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        return hash;
    }
/**
 * Método que compara dos objetos Usuarios, retorna true si son el mismo, false caso contrario
 * @param obj
 * @return 
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
        final Usuario other = (Usuario) obj;
        return this.id == other.id;
    }
/**
 * Retorna una cadena que representa al objeto
 * @return 
 */
    @Override
    public String toString() {
        return "Usuario{" + "nombres=" + nombres + ", apellidoMaterno=" + apellidoMaterno
                + ", apellidoPaterno=" + apellidoPaterno + ", correoElectronico=" + correoElectronico
                + ", saldo=" + saldo + ", domicilio=" + idDireccion + ", fechaNacimiento=" + fechaNacimiento + '}';

    }
}

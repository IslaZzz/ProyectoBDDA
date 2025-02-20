package itson.ticketwizard.entidades;

import java.sql.Date;

public class Usuario {

    private Integer id;
    private String nombres;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String correoElectronico;
    private double saldo;
    private Domicilio domicilio;
    private String contrasenia;
    private Date fechaNacimiento;

    public Usuario(int id, String nombres, String apellidoMaterno, String apellidoPaterno,
            String correoElectronico, double saldo, Domicilio domicilio, String contrasenia, Date fechaNacimiento) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.correoElectronico = correoElectronico;
        this.saldo = saldo;
        this.domicilio = domicilio;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = fechaNacimiento;
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

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        return hash;
    }

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

    @Override
    public String toString() {
        return "Usuario{" + "nombres=" + nombres + ", apellidoMaterno=" + apellidoMaterno
                + ", apellidoPaterno=" + apellidoPaterno + ", correoElectronico=" + correoElectronico
                + ", saldo=" + saldo + ", domicilio=" + domicilio + ", fechaNacimiento=" + fechaNacimiento + '}';

    }
}

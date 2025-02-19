package itson.ticketwizard.entidades;

import java.sql.Date;

public class Usuario {

    //Atributos de la clase
    private int id;
    private String nombres;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String correoElectronico;
    private double saldo;
    private Domicilio domicilio;
    private String contrasenia;
    private Date fechaNacimiento;

    /**
     * Constructor que recibe los parametros e inicializa los atributos a su
     * valor
     *
     * @param id
     * @param nombres
     * @param apellidoMaterno
     * @param apellidoPaterno
     * @param correoElectronico
     * @param saldo
     * @param domicilio
     * @param contrasenia
     * @param fechaNacimiento
     */
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

    /**
     * Constructor por defecto
     */
    public Usuario() {

    }

    /**
     *
     * @return Retorna id el del Usuario
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return retorna los nombres del Usuario
     */
    public String getNombres() {
        return nombres;
    }

    /**
     *
     * @param nombres Establece los nombres del Usuario
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     *
     * @return retorna el epellido Materno del Usuario
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     *
     * @param apellidoMaterno establece el apellido materno del Usuario
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     *
     * @return retorna el apellido Paterno del Usuario
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     *
     * @param apellidoPaterno Establece el apellido paterno del Usuario
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     *
     * @return retorna el correo electrónico del Usuario
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     *
     * @param correoElectronico Establace el corro eléctrónico del Usuario
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     *
     * @return retorna el saldo del Usuario
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     *
     * @param saldo esablece el saldo del Usuario
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     *
     * @return retorna el domicilio del Usuario
     */
    public Domicilio getDomicilio() {
        return domicilio;
    }

    /**
     *
     * @param domicilio Establece el domicilio del Usuario
     */
    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    /**
     *
     * @return retorna el valor Hash de la contraseña del Usuario
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     *
     * @param contrasenia Establace la contraseña del Usuario
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     *
     * @return retorna la fecha de nacimiento del Usuario
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     *
     * @return Retorna el código Hash del Usuario
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        return hash;
    }

    /**
     *
     * @param obj objeto a comparar
     * @return retorna true si son el mismo objeto, false caso contrario
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
     *
     * @return Devuelve un String que representa al Usuario
     */
    @Override
    public String toString() {
        return "Usuario{" + "nombres=" + nombres + ", apellidoMaterno=" + apellidoMaterno
                + ", apellidoPaterno=" + apellidoPaterno + ", correoElectronico=" + correoElectronico
                + ", saldo=" + saldo + ", domicilio=" + domicilio + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
}

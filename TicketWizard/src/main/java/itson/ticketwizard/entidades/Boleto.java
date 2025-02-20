/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.entidades;

import java.util.Objects;

/**
 *
 * @author 52644
 */
public class Boleto {

    private String idBoleto;
    private String numeroSerie;
    private double precio;
    private boolean disponible;
    private String fila;
    private Integer asiento;
    private Integer idEvento;
    private Integer precioOriginal;
    private Integer idUsuario;

    public Boleto(String idBoleto, String numeroSerie, double precio, boolean disponible, String fila, Integer asiento, Integer idEvento) {
        this.idBoleto = idBoleto;
        this.numeroSerie = numeroSerie;
        this.precio = precio;
        this.disponible = disponible;
        this.fila = fila;
        this.asiento = asiento;
        this.idEvento = idEvento;
    }
    /**
     * Constructor para boleto teniendo en cuenta el idUsuario (dueño) del boleto
     * para consultar si el boleto está disponible y con dueño (reventa) 
     * o si no tiene dueño (venta de boletera)
     * @param idBoleto id del boleto
     * @param numeroSerie numero de serie del boleto
     * @param precio Precio del boleto
     * @param disponible Disponibilidad del boleto
     * @param fila Fila del boleto
     * @param asiento Asiento del boleto
     * @param idEvento Evento al que pertenece el boleto
     * @param idUsuario Usuario dueño (puede ser null)
     */
    public Boleto(String idBoleto, String numeroSerie, double precio, boolean disponible, String fila, Integer asiento, Integer idEvento, Integer idUsuario) {
        this.idBoleto = idBoleto;
        this.numeroSerie = numeroSerie;
        this.precio = precio;
        this.disponible = disponible;
        this.fila = fila;
        this.asiento = asiento;
        this.idEvento = idEvento;
        this.idUsuario = idUsuario;
    }

    
    /**
     * Constructor que recibe los atributos de un boleto y lo crea a partir de
     * estos, destacar que este metodo es para la compra directamente con la
     * boletera, porque genera el numero de control
     *
     * @param numeroSerie
     * @param precio
     * @param disponible
     * @param fila
     * @param asiento
     */
    public Boleto(String numeroSerie, double precio, boolean disponible, String fila, int asiento, Integer idEvento) {
        //Numero de serie se genera al momento de cada venta, imagino sera un metodo que 
        //pertenece al momento de vender un boleto 
        this.numeroSerie = numeroSerie;
        this.precio = precio;
        this.disponible = disponible;
        this.fila = fila;
        this.asiento = asiento;
        this.idBoleto = generarNumeroControl(fila, asiento, precio);
        
    }

    /**
     * Constructor por defecto
     */
    public Boleto() {

    }

    public Integer getIdEvento() {
        return idEvento;
    }

    //Métodos Get y Set
    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    /**
     * @return retorna el numero de serie del boleto
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * @param numeroSerie asigna el atributo al valor recibido como parametro
     */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * @return retorna el precio del boleto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio asigna el atributo al valor recibido como parametro
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return retorna la disponibilidad del boleto
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * @param disponible asigna el atributo al valor recibido como parametro
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * @return retorna la fila del boleto
     */
    public String getFila() {
        return fila;
    }

    /**
     * @param fila asigna el atributo al valor recibido como parametro
     */
    public void setFila(String fila) {
        this.fila = fila;
    }

    /**
     * @return retorna el numero de asiento del boleto
     */
    public int getAsiento() {
        return asiento;
    }

    /**
     * @param asiento asigna el atributo al valor recibido como parametro
     */
    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    
    /**
     *
     * @return El codigo hash generado a partir del numero de control
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idBoleto);
        return hash;
    }

    /**
     *
     * @param obj Recibe el objeto a comparar
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
        final Boleto other = (Boleto) obj;
        return Objects.equals(this.idBoleto, other.idBoleto);
    }

    public Integer getPrecioOriginal() {
        return precioOriginal;
    }

    public void setPrecioOriginal(Integer precioOriginal) {
        this.precioOriginal = precioOriginal;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    /**
     * @return Un string con la información del boleto
     */
    @Override
    public String toString() {
        return "Boleto{" + "numeroSerie=" + numeroSerie + ", precio=" + precio
                + ", disponible=" + disponible + ", fila=" + fila
                + ", asiento=" + asiento + '}';
    }

    /**
     * Genera el numero de control para
     *
     * @param idAsiento
     * @param precioOriginal
     * @return
     */
    private String generarNumeroControl(String fila, int asiento, double precioOriginal) {
        String noControl = fila + String.valueOf(asiento) + String.valueOf(precioOriginal);

        return noControl;
    }
}

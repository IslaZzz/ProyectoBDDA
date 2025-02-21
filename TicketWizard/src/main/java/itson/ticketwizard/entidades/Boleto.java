/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.entidades;

import itson.ticketwizard.excepciones.BoletoException;

import java.util.List;
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
    private double precioOriginal;
    private Integer idUsuario;

<<<<<<< HEAD
    /*
    constructor del boleto de boletera: se genera el idBoleto, precioOriginal, disponibilidad, fila, asiento, idBoleto
    actualizarBoletoReventa: recibe como parametro idBoleto, idUsuario: se calcula numero de serie y se actualiza precio
     */

     /*
    constructor del boleto de boletera: se genera el idBoleto, precioOriginal, disponibilidad, fila, asiento, idEvento
    actualizarBoletoReventa: recibe como parametro idBoleto, idUsuario: se calcula numero de serie y se actualiza precio
     */

    //Constuctor de boleto por parte de la boletera
    public Boleto(String idBoleto, double precioOriginal, boolean disponible, String fila, int asiento, Integer idEvento) {
        this.idBoleto = idBoleto;
        this.precioOriginal = precioOriginal;
        this.disponible = disponible;
        this.fila = fila;
        this.asiento = asiento;
        this.idEvento = idEvento;
        precio = precioOriginal;
        idUsuario = null;
    }

    public void venderBoletoBoletera(Integer idUsuario, Boleto boleto){
        boleto.setIdUsuario(idUsuario);
        boleto.setDisponible(false);

        //boleto.setPrecio(boleto.getPrecioOriginal());
=======
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
>>>>>>> 1ad219504838f6ab9473940659cc9c8bfb49d7be

    }

    public String getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(String idBoleto) {
        this.idBoleto = idBoleto;
    }
    public String getNumeroSerie() {
        return numeroSerie;
    }
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public String getFila() {
        return fila;
    }
    public void setFila(String fila) {
        this.fila = fila;
    }
    public int getAsiento() {
        return asiento;
    }
    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }
    public Integer getIdEvento() {
        return idEvento;
    }
    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }
<<<<<<< HEAD
    public double getPrecioOriginal() {
        return precioOriginal;
    }
    public void setPrecioOriginal(Integer precioOriginal) {
        this.precioOriginal = precioOriginal;
=======

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
>>>>>>> 1ad219504838f6ab9473940659cc9c8bfb49d7be
    }
    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
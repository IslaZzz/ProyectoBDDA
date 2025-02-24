/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.entidades;

import java.sql.Date;

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
    private Date fechaLimiteVenta;
    
    /**
     * Constructor para mostrar los boletos disponibles de los eventos.
     * @param idBoleto
     * @param numeroSerie
     * @param precio
     * @param disponible
     * @param fila
     * @param asiento
     * @param idEvento
     * @param idUsuario 
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

    public Boleto(String idBoleto, String numeroSerie, double precio, boolean disponible, String fila, Integer asiento, Integer idEvento, double precioOriginal, Integer idUsuario) {
        this.idBoleto = idBoleto;
        this.numeroSerie = numeroSerie;
        this.precio = precio;
        this.disponible = disponible;
        this.fila = fila;
        this.asiento = asiento;
        this.idEvento = idEvento;
        this.precioOriginal = precioOriginal;
        this.idUsuario = idUsuario;
    }
    
    

    /**
     * Constructor para boleto entero
     *
     * @param idBoleto
     * @param numeroSerie
     * @param precio
     * @param disponible
     * @param fila
     * @param asiento
     * @param idEvento
     * @param precioOriginal
     * @param idUsuario
     * @param fechaLimiteVenta 
     */
    public Boleto(String idBoleto, String numeroSerie, double precio, boolean disponible, String fila, Integer asiento, Integer idEvento, double precioOriginal, Integer idUsuario, Date fechaLimiteVenta) {
        this.idBoleto = idBoleto;
        this.numeroSerie = numeroSerie;
        this.precio = precio;
        this.disponible = disponible;
        this.fila = fila;
        this.asiento = asiento;
        this.idEvento = idEvento;
        this.precioOriginal = precioOriginal;
        this.idUsuario = idUsuario;
        this.fechaLimiteVenta = fechaLimiteVenta;
    }
    
    
    
    //Constructor para instanciar un boleto. Cuando se instancia es por parte de la boletera
    public Boleto(String idBoleto,double precio, String fila, Integer asiento, Integer idEvento){
        this.idBoleto = idBoleto;
        this.precio = precio;
        this.fila = fila;
        this.asiento = asiento;
        this.idEvento = idEvento;
        this.precioOriginal = precio;
        this.idUsuario = null;
        this.disponible = true;
        this.numeroSerie = null;
    }
    
    public void crearBoletoDisp(String idBoleto,double precio, String fila, Integer asiento,  Integer idEvento){
        this.idBoleto = idBoleto;
        this.precio = precio;
        this.fila = fila;
        this.asiento = asiento;
        this.idEvento = idEvento;
        this.precioOriginal = precio;
        this.idUsuario = null;
        this.disponible = true;
        this.numeroSerie = null;
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
    public Integer getAsiento() {
        return asiento;
    }
    public void setAsiento(Integer asiento) {
        this.asiento = asiento;
    }
    public Integer getIdEvento() {
        return idEvento;
    }
    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }
    public double getPrecioOriginal() {
        return precioOriginal;
    }
    public void setPrecioOriginal(double precioOriginal) {
        this.precioOriginal = precioOriginal;
    }
    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

}

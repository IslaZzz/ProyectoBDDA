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
    private int asiento;
    private Integer idEvento;
    private double precioOriginal;
    private Integer idUsuario;

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
    public double getPrecioOriginal() {
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
}
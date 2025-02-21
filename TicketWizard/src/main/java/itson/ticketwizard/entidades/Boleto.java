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

    //Constructor para instanciar un boleto. Cuando se instancia es por parte de la boletera
    public  Boleto(String idBoleto,double precio, String fila, Integer asiento, Integer idEvento){
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.dto;

import java.sql.Date;

/**
 *
 * @author Peter
 */
public class MostrarTransaccionDTO {
    private Integer idTransaccion;
    private Date fechaHora;
    private String tipoCompra;
    private double monto;
    private String rol;
    private int idUsuario;
    private int asiento;
    private String fila;
    private String evento;

    public MostrarTransaccionDTO(Integer idTransaccion, Date fechaHora, String tipoCompra, double monto, String rol, int idUsuario, int asiento, String fila, String evento) {
        this.idTransaccion = idTransaccion;
        this.fechaHora = fechaHora;
        this.tipoCompra = tipoCompra;
        this.monto = monto;
        this.rol = rol;
        this.idUsuario = idUsuario;
        this.asiento = asiento;
        this.fila = fila;
        this.evento = evento;
    }

    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public String getTipoCompra() {
        return tipoCompra;
    }

    public double getMonto() {
        return monto;
    }

    public String getRol() {
        return rol;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public int getAsiento() {
        return asiento;
    }

    public String getFila() {
        return fila;
    }

    public String getEvento() {
        return evento;
    }
    
    
}

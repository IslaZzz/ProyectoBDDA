package itson.ticketwizard.entidades;

import itson.ticketwizard.excepciones.TransaccionException;
import java.util.Date;
import java.util.Objects;
/**
 *
 * @author abrilislas
 */
public class Transaccion {
    private Integer idTransaccion;
    private Integer numeroControl;
    private Date fechaHora;
    private String tipoCompra;
    private double monto;
    private String rol;
    private Integer idEvento;
    private String idUsuario;
    private int asiento;
    private String fila;
    private String evento;

    public Transaccion(Integer idTransaccion,Integer numeroControl, Date fechaHora, String tipoCompra, double monto, String rol, String idUsuario, int asiento, String fila, String evento) throws TransaccionException{
        this.idTransaccion=idTransaccion;
        this.numeroControl=numeroControl;
        this.fechaHora=fechaHora;
        this.monto=monto;
        this.rol=rol;
        this.idUsuario=idUsuario;
        this.asiento=asiento;
        this.fila=fila;
        this.evento=evento;

        try{
            if(!tipoCompra.equals("Boletera") ||!tipoCompra.equals("Reventa")){
                throw new TransaccionException("Tipo de compra no válido");
            }else{
                this.tipoCompra=tipoCompra;
            }

        }catch(TransaccionException ex){
            ex.getMessage();
        }
    }

    public Integer getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(int numeroControl) {
        this.numeroControl = numeroControl;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getTipoCompra() {
        return tipoCompra;
    }

    public void setTipoCompra(String tipoCompra) {
        this.tipoCompra = tipoCompra;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.numeroControl;
        hash = 29 * hash + Objects.hashCode(this.fechaHora);
        hash = 29 * hash + Objects.hashCode(this.tipoCompra);
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
        final Transaccion other = (Transaccion) obj;
        return this.numeroControl == other.numeroControl;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "numeroControl=" + numeroControl + ", fechaHora=" + fechaHora + ", tipoCompra=" + tipoCompra + ", monto=" + monto + ", rol=" + rol + ", idEvento=" + idEvento + ", idUsuario=" + idUsuario + ", asiento=" + asiento + ", fila=" + fila + ", evento=" + evento + '}';
    }

    







}
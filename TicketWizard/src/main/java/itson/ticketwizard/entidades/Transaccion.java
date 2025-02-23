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
    private Date fechaHora;
    private String tipoCompra;
    private double monto;
    private String rol;
    private String idUsuario;

    public Transaccion(Integer idTransaccion, Date fechaHora, String tipoCompra, double monto, String rol, String idUsuario) throws TransaccionException{
        this.idTransaccion=idTransaccion;
        this.fechaHora=fechaHora;
        this.monto=monto;
        this.rol=rol;
        this.idUsuario=idUsuario;

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

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
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
        hash = 29 * hash + this.idTransaccion;
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
        return this.idTransaccion == other.idTransaccion;
    }

    @Override
    public String toString() {
        return "Transaccion{" + ", fechaHora=" + fechaHora + ", tipoCompra=" + tipoCompra + ", monto=" + monto + ", rol=" + rol + ", idUsuario=" + idUsuario + '}';
    }

    







}
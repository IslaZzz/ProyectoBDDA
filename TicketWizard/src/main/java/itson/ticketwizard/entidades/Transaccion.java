package itson.ticketwizard.entidades;

import itson.ticketwizard.excepciones.TransaccionException;
import java.util.Date;
import java.util.Objects;
/**
 *
 * @author abrilislas
 */
public class Transaccion {
    private int numeroControl;
    private Date fechaHora;
    private String tipoCompra;
    private double monto;
    //considerar agregar foreign keys

    public Transaccion(int numeroControl, Date fechaHora, String tipoCompra, double monto) throws TransaccionException{

        this.numeroControl=numeroControl;
        this.fechaHora=fechaHora;
        this.monto=monto;

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

    public int getNumeroControl() {
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
        return "Transaccion: " + "numeroControl: " + numeroControl + ", fechaHora: " + fechaHora + ", tipoCompra: " + tipoCompra + ", monto: " + monto;
    }







}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.control;

import itson.ticketwizard.entidades.Boleto;
import itson.ticketwizard.entidades.Usuario;
import itson.ticketwizard.persistencia.BoletosDAO;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author 52644
 */
public class ControlBoletos {
    private BoletosDAO boletosDAO;
    
    public ControlBoletos(BoletosDAO boletosDAO){
        this.boletosDAO = boletosDAO;
    }
    
    public List<Boleto> consultarBoletosEvento(Integer idEvento){
        return boletosDAO.consultarBoletosEvento(idEvento);
    }
    
    public String consultaEvento(Boleto boleto){
        return boletosDAO.consultarEvento(boleto);
        
    }
    
    public String determinarTipoVenta(Boleto boleto){
        if(boleto.getIdUsuario() != 0){
            return "Reventa";
        } else {
            return "Boletera";
        }
    }
    
    public List<Boleto> consultaBoletosUsuario(Usuario usuario){
        return boletosDAO.consultarBoletosUsuario(usuario);
    }
    
    public Boleto reventaBoleto(Usuario usuario, double precio, Boleto boleto, Date fechaLimiteVenta){
        return boletosDAO.reventaBoleto(usuario, precio, boleto, fechaLimiteVenta);
    }
}

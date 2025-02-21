/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.control;

import itson.ticketwizard.entidades.Boleto;
import itson.ticketwizard.persistencia.BoletosDAO;
import java.util.List;

/**
 *
 * @author 52644
 */
public class ControlCompraBoletos {
    private BoletosDAO boletosDAO;
    
    public ControlCompraBoletos(BoletosDAO boletosDAO){
        this.boletosDAO = boletosDAO;
    }
    
    public List<Boleto> consultarBoletosEvento(Integer idEvento){
        return boletosDAO.consultarBoletosEvento(idEvento);
    }
    public String determinarTipoVenta(Boleto boleto){
        if(boleto.getIdUsuario() != 0){
            return "Reventa";
        } else {
            return "Boletera";
        }
    }
}

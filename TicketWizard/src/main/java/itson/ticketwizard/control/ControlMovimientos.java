/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.control;

import itson.ticketwizard.dto.MostrarTransaccionDTO;
import itson.ticketwizard.entidades.Usuario;
import itson.ticketwizard.excepciones.TransaccionException;
import itson.ticketwizard.persistencia.TransaccionesDAO;
import java.util.List;

/**
 *
 * @author Peter
 */
public class ControlMovimientos {
    
    private TransaccionesDAO movimientosDAO;

    public ControlMovimientos(TransaccionesDAO movimientosDAO) {
        this.movimientosDAO = movimientosDAO;
    }
    
    public List<MostrarTransaccionDTO> consultarMovimientos(Usuario usuario) throws TransaccionException{
        return this.movimientosDAO.consultarMovimientos(usuario);
    }
    
    public void comprarBoletera(Usuario usuario, String idBoleto, double precio, String serie) throws TransaccionException{
        this.movimientosDAO.comprarBoletera(usuario, idBoleto, precio, serie);
    }
    public void comprarReventa(Usuario usuario, String idBoleto, double precio, String serie, int usuarioVendedor) throws TransaccionException {
        this.movimientosDAO.comprarReventa(usuario, idBoleto, precio, serie, usuarioVendedor);
    }
}

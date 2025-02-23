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
    
}

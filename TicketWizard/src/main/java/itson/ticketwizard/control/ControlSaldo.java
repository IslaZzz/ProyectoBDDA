/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.control;

import itson.ticketwizard.entidades.Usuario;
import itson.ticketwizard.persistencia.UsuariosDAO;

/**
 *
 * @author pc
 */
public class ControlSaldo {
    private UsuariosDAO usuariosDAO;

    public ControlSaldo(UsuariosDAO usuariosDAO) {
        this.usuariosDAO = usuariosDAO;
    }
    
    public double consultarSaldo(Usuario usuario){
        return usuariosDAO.consultarSaldo(usuario);
    }
    
    public double agregarSaldo(double cantidad, Usuario usuario){
        return usuariosDAO.agregarSaldo(cantidad, usuario);
    }
}

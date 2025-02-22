/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.control;

import itson.ticketwizard.dto.NuevaDireccionDTO;
import itson.ticketwizard.dto.RegistroUsuarioDTO;
import itson.ticketwizard.persistencia.DireccionesDAO;
import itson.ticketwizard.persistencia.UsuariosDAO;

/**
 *
 * @author Peter
 */
public class ControlRegistro {
    private DireccionesDAO direccionesDAO;
    private UsuariosDAO usuariosDAO;
    
    public ControlRegistro(DireccionesDAO direccionesDAO, UsuariosDAO usuariosDAO){
        this.direccionesDAO = direccionesDAO;
        this.usuariosDAO = usuariosDAO;
    }
    
    public void registrarUsuario(NuevaDireccionDTO direccionDTO, RegistroUsuarioDTO usuarioDTO){
        int idDireccion = direccionesDAO.insertarDireccion(direccionDTO);
        usuariosDAO.registrarUsuario(usuarioDTO, idDireccion);
    }
}

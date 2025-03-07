/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.ticketwizard.persistencia.interfaces;

import itson.ticketwizard.dto.NuevaDireccionDTO;
import itson.ticketwizard.dto.RegistroUsuarioDTO;
import itson.ticketwizard.entidades.Usuario;
import java.sql.SQLException;

/**
 *
 * @author 52644
 */
public interface IUsuariosDAO {
    public Usuario validarCredencialesInicioSesion(String correo, String contrasenia) throws SQLException;
    public int registrarUsuario(RegistroUsuarioDTO usuarioDTO, NuevaDireccionDTO nuevaDireccionDTO);  
    public int actualizarUsuario(Usuario usuario, RegistroUsuarioDTO usuarioDTO, NuevaDireccionDTO nuevaDireccionDTO);
}

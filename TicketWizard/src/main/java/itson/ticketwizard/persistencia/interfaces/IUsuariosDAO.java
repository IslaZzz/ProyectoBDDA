/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.ticketwizard.persistencia.interfaces;

import itson.ticketwizard.dto.RegistroUsuarioDTO;
import itson.ticketwizard.entidades.Usuario;

/**
 *
 * @author 52644
 */
public interface IUsuariosDAO {
    public Usuario registrarUsuario(RegistroUsuarioDTO usuarioDTO);
    public boolean validarCredencialesInicioSesion(String correo, String contrasenia);
}

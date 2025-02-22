/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.ticketwizard.persistencia.interfaces;

import itson.ticketwizard.dto.RegistroUsuarioDTO;

/**
 *
 * @author 52644
 */
public interface IUsuariosDAO {
    public int registrarUsuario(RegistroUsuarioDTO usuarioDTO, int idDireccion);
}

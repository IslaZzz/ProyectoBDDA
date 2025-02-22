/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

import itson.ticketwizard.dto.RegistroUsuarioDTO;
import itson.ticketwizard.entidades.Usuario;
import itson.ticketwizard.persistencia.interfaces.IUsuariosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Peter
 */
public class UsuariosDAO implements IUsuariosDAO {

    private ManejadorConexiones manejadorConexion;

    public UsuariosDAO(ManejadorConexiones manejadorConexiones) {
        this.manejadorConexion = manejadorConexiones;
    }

    @Override
    public Usuario registrarUsuario(RegistroUsuarioDTO usuarioDTO) {

        String consulta = """
                   INSERT INTO artistas (nacionalidad, nombre, tipo, añoInicio)
                   VALUES (?, ?, ?, ?);
                   """;
        try {
            Connection conexion = manejadorConexion.crearConexion();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        //TEMPORAL, se necesita sacar el ID del artista que registró
        return null;
    }

    @Override
    public boolean validarCredencialesInicioSesion(String Usuario, String contrasenia) {
        String consulta = """
                          
                          """
        
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

import itson.ticketwizard.dto.NuevaDireccionDTO;
import itson.ticketwizard.dto.RegistroUsuarioDTO;
import itson.ticketwizard.entidades.Seguridad;
import itson.ticketwizard.entidades.Usuario;
import itson.ticketwizard.persistencia.interfaces.IUsuariosDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Peter
 */
public class UsuariosDAO implements IUsuariosDAO {

    private ManejadorConexiones manejadorConexion;

    public UsuariosDAO(ManejadorConexiones manejadorConexiones) {
        this.manejadorConexion = manejadorConexiones;
    }

    /**
     * Metodo para insertar un usuario en la base de datos TicketWizard
     *
     * @param usuarioDTO Paquete con los datos de usuario
     * @param idDireccion id de la direccion del usuario
     * @return
     */
    @Override
    public int registrarUsuario(RegistroUsuarioDTO usuarioDTO, NuevaDireccionDTO nuevaDireccionDTO) {

        String LlamarSP = """
                            Call realizarRegistro(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
                   """;
        try {
            Connection conexion = manejadorConexion.crearConexion();
            CallableStatement sp = conexion.prepareCall(LlamarSP);
            sp.setString(1, usuarioDTO.getNombres());
            sp.setString(2, usuarioDTO.getApellidoPaterno());
            sp.setString(3, usuarioDTO.getApellidoMaterno());
            sp.setString(4, usuarioDTO.getCorreoElectronico());
            sp.setString(5, usuarioDTO.getContrasenia());
            sp.setDate(6, usuarioDTO.getFechaNacimiento());
            sp.setDouble(7, 0);
            sp.setString(8, nuevaDireccionDTO.getCalle());
            sp.setString(9, nuevaDireccionDTO.getColonia());
            sp.setString(10, nuevaDireccionDTO.getCiudad());
            sp.setString(11, nuevaDireccionDTO.getCodigoPostal());
            sp.setString(12, nuevaDireccionDTO.getEstado());
            ResultSet flujo = sp.executeQuery();
            if (flujo.next()) {
                if (flujo.getInt("resultado") != 0) {
                    System.out.println("Se registró el usuario");
                    return 1;
                } else {
                    System.out.println("Hubo un error al registrar el usuario");
                    return 0;
                }

            }
        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
        }
        // TEMPORAL, se necesita sacar el ID del artista que registró
        return 0;
    }

    @Override
    public Usuario registrarUsuario(RegistroUsuarioDTO usuarioDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario validarCredencialesInicioSesion(String correo, String contrasenia) {
        String consultaUsuario = """
                          Select idUsuario, contraseña from Usuarios where correoElectronico = ?;
                          """;
        try {
            Connection conexionPSW = manejadorConexion.crearConexion();
            PreparedStatement consulta = conexionPSW.prepareStatement(consultaUsuario);
            consulta.setString(1, correo);

            ResultSet usuarioDevuelto = consulta.executeQuery();

            if (usuarioDevuelto.next()) {
                String hash = usuarioDevuelto.getString("contraseña");
                int RId = usuarioDevuelto.getInt("idUsuario");

                if (Seguridad.verificar(contrasenia, hash)) {
                    return new Usuario(RId);
                } else {
                    return null;
                }
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

import itson.ticketwizard.dto.RegistroUsuarioDTO;
import itson.ticketwizard.entidades.Seguridad;
import itson.ticketwizard.entidades.Usuario;
import itson.ticketwizard.persistencia.interfaces.IUsuariosDAO;
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
    public int registrarUsuario(RegistroUsuarioDTO usuarioDTO, int idDireccion) {

        String insertSQL = """
                   INSERT INTO usuarios (nombre, apellidoPaterno, apellidoMaterno, correoElectronico, contraseña, fechaNacimiento, saldo, idDireccion)
                   VALUES (?, ?, ?, ?, ?, ?, ?, ?);
                   """;
        try {
            Connection conexion = manejadorConexion.crearConexion();
            PreparedStatement insert = conexion.prepareStatement(insertSQL);
            insert.setString(1, usuarioDTO.getNombres());
            insert.setString(2, usuarioDTO.getApellidoPaterno());
            insert.setString(3, usuarioDTO.getApellidoMaterno());
            insert.setString(4, usuarioDTO.getCorreoElectronico());
            insert.setString(5, usuarioDTO.getContrasenia());
            insert.setDate(6, usuarioDTO.getFechaNacimiento());
            insert.setDouble(7, 0);
            insert.setInt(8, idDireccion);
            int filasAfectadas = insert.executeUpdate();
            if (filasAfectadas != 0) {
                System.out.println("Se registró el usuario");
                return 1;
            } else {
                System.out.println("Hubo un error al registrar el usuario");
                return 0;
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
        Usuario usuario;
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

                if (Seguridad.verificar(Seguridad.encriptar(contrasenia), hash)) {
                    return usuario = new Usuario(RId);
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña Inválida");
                }

            }
            else{
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;

    }

}

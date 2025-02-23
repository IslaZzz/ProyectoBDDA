/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

import itson.ticketwizard.dto.NuevaDireccionDTO;
import itson.ticketwizard.dto.RegistroUsuarioDTO;
import itson.ticketwizard.entidades.Boleto;
import itson.ticketwizard.entidades.Seguridad;
import itson.ticketwizard.entidades.Transaccion;
import itson.ticketwizard.entidades.Usuario;
import itson.ticketwizard.excepciones.TransaccionException;
import itson.ticketwizard.persistencia.interfaces.IUsuariosDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
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
                int resultado = flujo.getInt("resultado");
                if (resultado == 1) {
                    System.out.println("Se registró el usuario");
                } else {
                    System.out.println("Hubo un error al registrar el usuario");
                }
                return resultado;
            }
        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
        }
        // TEMPORAL, se necesita sacar el ID del artista que registró
        return 0;
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
                    consultaUsuario = """
                    SELECT idUsuario, nombres, apellidoPaterno, apellidoMaterno, correoElectronico, fechaNacimiento, saldo, idDireccion FROM usuarios
                                      WHERE idUsuario = ?;
                    """;
                    consulta = conexionPSW.prepareStatement(consultaUsuario);
                    consulta.setInt(1, RId);
                    ResultSet resultado = consulta.executeQuery();
                    if (resultado.next()) {
                        int idUsuario = resultado.getInt("idUsuario");
                        String nombres = resultado.getString("idUsuario");
                        String apellidoPaterno = resultado.getString("apellidoPaterno");
                        String apellidoMaterno = resultado.getString("apellidoMaterno");
                        String correoElectronico = resultado.getString("correoElectronico");
                        Date fechaNacimiento = resultado.getDate("fechaNacimiento");
                        double saldo = resultado.getDouble("saldo");
                        int idDireccion = resultado.getInt("idDireccion");
                        return new Usuario(idUsuario, nombres, apellidoPaterno, apellidoMaterno, correoElectronico, fechaNacimiento, saldo, idDireccion);
                    }
                    return null;
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

    public double agregarSaldo(double cantidad, Usuario usuario) {
        int id = usuario.getId();
        double nSaldo = usuario.getSaldo() + cantidad;
        String updateSaldo = """
                                UPDATE USUARIOS 
                                SET SALDO=?
                                WHERE IDUSUARIO=?;
                                """;
        try {
            Connection conexion = manejadorConexion.crearConexion();
            PreparedStatement consulta = conexion.prepareStatement(updateSaldo);
            consulta.setDouble(1, nSaldo);
            consulta.setInt(2, id);
            int filasActualizadas = consulta.executeUpdate();

            if (filasActualizadas > 0) {
                usuario.setSaldo(nSaldo);
                return nSaldo;
            }
        } catch (SQLException ex) {
            ex.getMessage();
            return usuario.getSaldo();
        }
        return usuario.getSaldo();
    }

    public double consultarSaldo(Usuario usuario) {
        return usuario.getSaldo();
    }

    @Override
    public int actualizarUsuario(Usuario usuario, RegistroUsuarioDTO usuarioDTO, NuevaDireccionDTO nuevaDireccionDTO) {
        String LlamarSP = """
                            Call actualizarusuario(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
                   """;
        try {
            Connection conexion = manejadorConexion.crearConexion();
            CallableStatement sp = conexion.prepareCall(LlamarSP);
            sp.setInt(1, usuario.getId());
            sp.setString(2, usuarioDTO.getNombres());
            sp.setString(3, usuarioDTO.getApellidoPaterno());
            sp.setString(4, usuarioDTO.getApellidoMaterno());
            sp.setString(5, usuarioDTO.getCorreoElectronico());
            sp.setString(6, usuarioDTO.getContrasenia());
            sp.setDate(7, usuarioDTO.getFechaNacimiento());
            sp.setString(8, nuevaDireccionDTO.getCalle());
            sp.setString(9, nuevaDireccionDTO.getColonia());
            sp.setString(10, nuevaDireccionDTO.getCiudad());
            sp.setString(11, nuevaDireccionDTO.getEstado());
            sp.setString(12, nuevaDireccionDTO.getCodigoPostal());
            ResultSet flujo = sp.executeQuery();
            if (flujo.next()) {
                int resultado = flujo.getInt("resultado");
                if (resultado == 1) {
                    System.out.println("Se actualizó el usuario");
                } else {
                    System.out.println("Hubo un error al actualizar el usuario");
                }
                return resultado;
            }
        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
        }
        // TEMPORAL, se necesita sacar el ID del artista que registró
        return 0;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

import itson.ticketwizard.dto.MostrarTransaccionDTO;
import itson.ticketwizard.entidades.Transaccion;
import itson.ticketwizard.entidades.Usuario;
import itson.ticketwizard.excepciones.TransaccionException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Peter
 */
public class TransaccionesDAO {
    private ManejadorConexiones manejadorConexion;

    public TransaccionesDAO(ManejadorConexiones conexion) {
        this.manejadorConexion = conexion;
    }
    
    public List<MostrarTransaccionDTO> consultarMovimientos(Usuario usuario) throws TransaccionException{
            int id = usuario.getId();
            List<MostrarTransaccionDTO> listaTransacciones = new LinkedList<>();
            String consultarMovimientos=  """
                                          CALL consultarTransacciones(?);
                                          """;
            try{
                Connection conexion = manejadorConexion.crearConexion();
                PreparedStatement consulta = conexion.prepareStatement(consultarMovimientos);
                consulta.setInt(1, id);
                ResultSet resultadoConsulta = consulta.executeQuery();
                if(!resultadoConsulta.isBeforeFirst()){
                    throw new TransaccionException("No hay resultados");
                }
                while(resultadoConsulta.next()){
                    
                    Integer idTransaccion = resultadoConsulta.getInt("ID de la transacción");
                    Date fechaHora = resultadoConsulta.getDate("Fecha-hora");
                    String tipoCompra = resultadoConsulta.getString("Tipo de compra");
                    double monto = resultadoConsulta.getDouble("Monto");
                    String rol = resultadoConsulta.getString("Rol");
                    Integer idUsuario = resultadoConsulta.getInt("ID usuario");
                    String fila = resultadoConsulta.getString("Fila");
                    int asiento = resultadoConsulta.getInt("Asiento");
                    String evento = resultadoConsulta.getString("Evento");
                    
                    MostrarTransaccionDTO tran = new MostrarTransaccionDTO(idTransaccion, fechaHora, tipoCompra, monto, rol, idUsuario, asiento,fila,evento);
                    listaTransacciones.add(tran);
                }
                conexion.close();
                consulta.close();
                resultadoConsulta.close();
            
            }catch(SQLException ex){
                ex.getMessage();
            }
            
        return listaTransacciones;
        }
    
    public void comprarBoletera(Usuario usuario, String idBoleto, double precio, String serie) throws TransaccionException {
    int idUsuario = usuario.getId();
    String query = """
                    CALL compraBoletera(?, ?, ?, ?);
                    """;
    try {
        Connection conexion = manejadorConexion.crearConexion();
        
        CallableStatement consulta = conexion.prepareCall(query);
        
        consulta.setString(1, idBoleto);
        consulta.setDouble(2, precio);
        consulta.setString(3, serie);
        consulta.setInt(4, idUsuario);
       
        consulta.execute();
        
        conexion.close();
        consulta.close();
        
    } catch (SQLException ex) {
        throw new TransaccionException("Error en la transacción: " + ex.getMessage());
    }
    }


    public void comprarReventa(Usuario usuarioComprador, String idBoleto, double precio, String serie, int usuarioVendedor) throws TransaccionException {
    int idUsuarioComprador = usuarioComprador.getId();
    
    String query = """
                    CALL comprarReventa(?, ?, ?, ?, ?);
                    """;
    try {
        Connection conexion = manejadorConexion.crearConexion();
        conexion.setAutoCommit(false);
        
        CallableStatement consulta = conexion.prepareCall(query);
        
        consulta.setString(1, idBoleto);
        consulta.setDouble(2, precio);
        consulta.setString(3, serie);
        consulta.setInt(4, idUsuarioComprador);
        consulta.setInt(5, usuarioVendedor);
        consulta.executeUpdate();
        
        conexion.commit();
        
        conexion.close();
        consulta.close();
        
    } catch (SQLException ex) {
        try {
        Connection conexion = manejadorConexion.crearConexion();
        conexion.setAutoCommit(false);
        conexion.rollback();
        }catch (SQLException exc) {
            throw new TransaccionException("Error al hacer rollback: " + exc.getMessage());
            }
        }
    }
}


    


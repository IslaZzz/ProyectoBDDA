/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

import itson.ticketwizard.dto.MostrarEventoDTO;
import itson.ticketwizard.dto.NuevaDireccionDTO;
import itson.ticketwizard.entidades.Direccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Peter
 */
public class DireccionesDAO {
    
    private ManejadorConexiones manejadorConexiones;

    public DireccionesDAO(ManejadorConexiones manejadorConexiones) {
        this.manejadorConexiones = manejadorConexiones;
    }
    
    public Integer insertarDireccion(NuevaDireccionDTO direccionDTO){
        String insertarDireccionSQL = """
                INSERT INTO Direcciones (calle, colonia, ciudad, estado, codigoPostal)
                VALUES (?,?,?,?,?);
                                      """;
        try {
            Connection conexion = this.manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(insertarDireccionSQL);
            comando.setString(1,direccionDTO.getCalle());
            comando.setString(2,direccionDTO.getColonia());
            comando.setString(3,direccionDTO.getCiudad());
            comando.setString(4,direccionDTO.getEstado());
            comando.setString(5,direccionDTO.getCodigoPostal());
            int filasAfectadas = comando.executeUpdate();
            if(filasAfectadas != 0){
                String consultarDireccionInsertada = """
                        SELECT MAX(idDireccion) FROM Direcciones;             
                                                     """;
                comando = conexion.prepareStatement(consultarDireccionInsertada);
                ResultSet resultado = comando.executeQuery();
                resultado.next();
                Integer idDireccion = resultado.getInt(1);
                System.out.println("Direccion registrada");
                return idDireccion;
            } else{
                System.out.println("No se afectaron filas");
            }
        } catch (Exception e) {
            System.err.println("Error al consultar: "+e.getMessage());
        }
        return null;
    }
}

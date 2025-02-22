/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

import itson.ticketwizard.entidades.Boleto;
import itson.ticketwizard.entidades.Evento;
import itson.ticketwizard.excepciones.BoletoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author 52644
 */
public class BoletosDAO {
    private ManejadorConexiones manejadorConexiones;

    public BoletosDAO(ManejadorConexiones manejadorConexiones) {
        this.manejadorConexiones = manejadorConexiones;
    }

    public List<Boleto> consultarBoletosEvento(Integer idEv) {
        String consultarBoletoSQL = """
                                    
                Select idEvento, numSerie, fila, asiento, Disponible, precio, idBoleto, idUsuario
                                    From Boletos WHERE Disponible AND idEvento = ?;
                                    """;
        List<Boleto> listaBoletos = new LinkedList<>();
        try {
            Connection conexion = this.manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(consultarBoletoSQL);
            comando.setInt(1, idEv);
            ResultSet resultadoConsulta = comando.executeQuery();

            while (resultadoConsulta.next()) {
                Integer idEvento = resultadoConsulta.getInt("idEvento");
                String numSerie = resultadoConsulta.getString("numSerie");
                String fila = resultadoConsulta.getString("fila");
                Integer asiento = resultadoConsulta.getInt("asiento");
                boolean disponible = resultadoConsulta.getBoolean("Disponible");
                double precio = resultadoConsulta.getDouble("precio");
                String numControl = resultadoConsulta.getString("idBoleto");
                Integer idUsuario = resultadoConsulta.getInt("idUsuario");
                Boleto boleto = new Boleto(numControl, numSerie, precio, disponible, fila, asiento, idEvento, idUsuario);
                listaBoletos.add(boleto);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar boletos" + e.getMessage());
        }
        return listaBoletos;
    }

    public static String generarNumeroDeSerie(String fila, int asiento) {
        // Genera una parte aleatoria
        String parteAleatoria = UUID.randomUUID().toString().substring(0, 4).toUpperCase();
        // Crear el número de serie con la fila, el asiento y la parte aleatoria
        String numeroDeSerie = fila + asiento + parteAleatoria;
        return numeroDeSerie;
    }

    //@Override
    public List<Boleto> consultarBoletosUsuario(Integer idUsuario) {
        String spUsuariosSQL = """
                        DELIMITER //
                        CREATE PROCEDURE  consultarBoletosUsuario()
                        BEGIN
                        SELECT B.IDBOLETO, E.idEvento, E.NOMBRE, B.FILA, B.ASIENTO, E.FECHA, B.CIUDAD,
                        FROM BOLETOS AS B
                        INNER JOIN USUARIO AS U ON B.idUsuario = U.idUsuario
                        INNER JOIN  EVENTOS AS E ON B.idEvento = E.idEvento
                                                  DELIMITER; 
                    """;
        List<Boleto> listaBoletos = new LinkedList<>();
        try {
            Connection conexion = this.manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(spUsuariosSQL);
            // comando.setInt(1, idEv);
            ResultSet resultadoConsulta = comando.executeQuery();

            while (resultadoConsulta.next()) {
                String idboleto = resultadoConsulta.getString("IDBOLETO");
                Integer idEvento = resultadoConsulta.getInt("E.idEvento");
                String nombreEvento = resultadoConsulta.getString("E.NOMBRE");
                String fila = resultadoConsulta.getString("B.FILA");
                Integer asiento = resultadoConsulta.getInt("B.ASIENTO");
                Date fecha = resultadoConsulta.getDate("E.FECHA");
                String ciudad = resultadoConsulta.getString("B.CIUDAD");
                Integer precio = resultadoConsulta.getInt("B.PRECIO");

                Boleto boleto = new Boleto(idboleto, precio, fila, asiento, idEvento);
                listaBoletos.add(boleto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaBoletos;
    }
}


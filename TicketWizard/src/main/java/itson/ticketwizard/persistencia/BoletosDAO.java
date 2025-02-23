/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

import itson.ticketwizard.entidades.Boleto;
import itson.ticketwizard.entidades.Evento;
import itson.ticketwizard.entidades.Usuario;
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
     public List<Boleto> consultarBoletosUsuario(Usuario usuario){
            int id = usuario.getId();
            List<Boleto> listaBoletosUs =  new LinkedList<>();
            String consultarBoletos ="""
                                CALL consultarBoletosUsuario(?);
                                """;
            try{
                Connection conexion = manejadorConexiones.crearConexion();
                PreparedStatement consulta = conexion.prepareStatement(consultarBoletos);
                consulta.setInt(1, id);
                ResultSet resultadoConsulta = consulta.executeQuery();
                int filasActualizadas = consulta.executeUpdate();
                
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
                    listaBoletosUs.add(boleto);
                }
            }catch (SQLException e) {
            System.err.println("Error al consultar boletos" + e.getMessage());
            }
        return listaBoletosUs;
    }
}


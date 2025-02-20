/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

import itson.ticketwizard.entidades.Boleto;
import itson.ticketwizard.entidades.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import java.util.List;

/**
 *
 * @author 52644
 */
public class BoletosDAO implements IBoletosDAO {

    private ManejadorConexiones manejadorConexiones;

    public BoletosDAO(ManejadorConexiones manejadorConexiones) {
        this.manejadorConexiones = manejadorConexiones;
    }

    @Override
    public List<Boleto> consultarBoletos(Integer idEv) {
        String consultarBoletoSQL = """
                                    Select idEvento, numSerie, fila, asiento, Disponible, precio, numControl
                                    From Boletos;
                                    """;
        List<Boleto> listaBoletos = new LinkedList<>();
        try {
            Connection conexion = this.manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(consultarBoletoSQL);
            ResultSet resultadoConsulta = comando.executeQuery();

            while (resultadoConsulta.next()) {
                Integer idEvento = resultadoConsulta.getInt("idEvento");
                String numSerie = resultadoConsulta.getString("numSerie");
                String fila = resultadoConsulta.getString("fila");
                Integer asiento = resultadoConsulta.getInt("asiento");
                boolean disponible = resultadoConsulta.getBoolean("Disponible");
                double precio = resultadoConsulta.getDouble("precio");
                String numControl = resultadoConsulta.getString("numControl");
                Boleto boleto = new Boleto(numControl, numSerie, precio, disponible, fila, asiento, idEvento);
                if (boleto.isDisponible() && idEvento == idEv) {
                    listaBoletos.add(boleto);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar boletos" + e.getMessage());
        }
        return listaBoletos;
    }
}

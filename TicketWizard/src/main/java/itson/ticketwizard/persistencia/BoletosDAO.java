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
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

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

                if(numControl!=null){


                }
                Boleto boleto = new Boleto(idEvento, precio, fila, asiento, idEvento);
                //listaBoletos.add(boleto);
                if(boleto.isDisponible()==true){
                    listaBoletos.add(boleto);
                }

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

    @Override
    public void venderBoletoBoletera(Integer idUsuario, Boleto boleto){
        boleto.setIdUsuario(idUsuario);
        boleto.setDisponible(false);
        boleto.setNumeroSerie(BoletosDAO.generarNumeroDeSerie(boleto.getFila(), boleto.getAsiento()));
        //boleto.setPrecio(boleto.getPrecioOriginal());

        String actualizarBoletoSQL = """
                                        UPDATE BOLETOS 
                                        SET  numSerie = ?, disponible = ?, idUsuario = ?
                                        WHERE idUsuario = ?;
                                    """;
        try {
            Connection conexion = this.manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(actualizarBoletoSQL);
            ResultSet resultadoConsulta = comando.executeQuery();

            comando.setInt(1, boleto.getIdUsuario());

        } catch (SQLException e) {
            System.err.println("Error al consultar boletos" + e.getMessage());
        }
        return listaBoletos;
    }

    }
        /*
        UPDATE Customers
        SET ContactName = 'Alfred Schmidt', City= 'Frankfurt'
        WHERE CustomerID = 1;
         */
   /* public void actualizarBoletoReventa(List<Boleto> listaBoletos,Integer idBoleto, Integer idUsuario,Integer procentaje) throws BoletoException {

        if(listaBoletos.contains(idBoleto)) {
            String consultarBoletoSQL = """
                                    UPDATE 
                                    From Boletos

                                    WHERE idEvento = ?, ;
                                    """;


            Boleto boleto=listaBoletos.get(idBoleto);
            boleto.setIdUsuario(idUsuario);
            boleto.setDisponible(false);
            boleto.setPrecio(precio*procentaje);




        }else{
            throw new BoletoException("El boleto no existe");
        }


    }*/
}


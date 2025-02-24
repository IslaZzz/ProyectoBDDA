/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

import itson.ticketwizard.entidades.Boleto;
import itson.ticketwizard.entidades.Transaccion;
import itson.ticketwizard.entidades.Usuario;
import itson.ticketwizard.excepciones.TransaccionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
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
    public String consultarEvento(Boleto boleto){
        String consultaEvento = """
                                SELECT Nombre FROM Eventos WHERE idEvento = ?
                                """;
        try{
            Connection conexion = manejadorConexiones.crearConexion();
            PreparedStatement consulta = conexion.prepareStatement(consultaEvento);
            consulta.setInt(1, boleto.getIdEvento());
            ResultSet resultadoConsulta = consulta.executeQuery();
            if(resultadoConsulta.next()){
                String nombreEvento = resultadoConsulta.getString("Nombre");
                return nombreEvento;
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    public Date consultarFechaEvento(Boleto boleto){
        String consultaEvento = """
                                SELECT Fecha FROM Eventos WHERE idEvento = ?
                                """;
        try{
            Connection conexion = manejadorConexiones.crearConexion();
            PreparedStatement consulta = conexion.prepareStatement(consultaEvento);
            consulta.setInt(1, boleto.getIdEvento());
            ResultSet resultadoConsulta = consulta.executeQuery();
            if(resultadoConsulta.next()){
                Date FechaEvento = resultadoConsulta.getDate("Fecha");
                return FechaEvento;
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
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
            //  String idBoleto, String numeroSerie, double precio, boolean disponible,
            //          String fila, Integer asiento, Integer idEvento, Integer idUsuario
                 while (resultadoConsulta.next()) {
                    Integer idEvento = resultadoConsulta.getInt("idEvento");
                    String fila = resultadoConsulta.getString("Fila");
                    Integer asiento = resultadoConsulta.getInt("Asiento");
                    double precio = resultadoConsulta.getDouble("precio");
                    String numControl = resultadoConsulta.getString("idBoleto");
                    double precioOriginal = resultadoConsulta.getDouble("precioOriginal");
                    String numSerie = resultadoConsulta.getString("numero de serie");
                    boolean disp=false;
                    Boleto boleto = new Boleto(numControl,numSerie,precio,disp,fila, asiento,idEvento, precioOriginal,id);
                    listaBoletosUs.add(boleto);
                }
            }catch (SQLException e) {
            System.err.println("Error al consultar boletos" + e.getMessage());
            }
        return listaBoletosUs;
    }
     
     public Boleto reventaBoleto(Usuario usuario, double precio, Boleto boleto, Date fechaLimiteVenta){
        int idUsuario = usuario.getId();
        String idBoleto = boleto.getIdBoleto();
        String spReventa = """
                            CALL revenderBoleto(?,?,?,?)
                           """;
        try{
                Connection conexion = manejadorConexiones.crearConexion();
                PreparedStatement consulta = conexion.prepareStatement(spReventa);
                consulta.setInt(1, idUsuario);
                consulta.setDouble(2, precio);
                consulta.setString(3, idBoleto);
                consulta.setDate(4, fechaLimiteVenta);
                ResultSet resultadoConsulta = consulta.executeQuery();
                if(resultadoConsulta.next()){
                    idBoleto = resultadoConsulta.getString("idBoleto");
                    int idEvento = resultadoConsulta.getInt("idEvento");
                    String numSerie = resultadoConsulta.getString("numSerie");
                    String fila = resultadoConsulta.getString("fila");
                    int asiento = resultadoConsulta.getInt("asiento");
                    boolean disponible = resultadoConsulta.getBoolean("Disponible");
                    double nwprecio = resultadoConsulta.getDouble("precio");
                    double precioOriginal = resultadoConsulta.getDouble("precioOriginal");
                    idUsuario = resultadoConsulta.getInt("idUsuario");
                    Date fechalimite = resultadoConsulta.getDate("fechaLimiteventa");
                    return new Boleto(idBoleto, numSerie, nwprecio, disponible, fila, asiento, idEvento, precioOriginal, idUsuario, fechalimite);
                }
            }catch (SQLException e) {
            System.err.println("Error al consultar boletos" + e.getMessage());
            }
        return null;
    }
}


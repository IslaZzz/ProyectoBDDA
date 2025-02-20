package itson.ticketwizard.persistencia;

import itson.ticketwizard.dto.EventosDTO;
import itson.ticketwizard.entidades.Evento;
import itson.ticketwizard.excepciones.EventoException;
import itson.ticketwizard.persistencia.IEventosDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class EventosDAO implements IEventosDAO {
    
    private ManejadorConexiones manejadorConexiones;
    
    public EventosDAO(ManejadorConexiones manejadorConexiones){
        this.manejadorConexiones = manejadorConexiones;
    }

    @Override
    //**El metodo devuelve una lista con todos los eventos cargados en la BD
    public List<Evento> consultarEventos() {
        //Consulta SQL
        String consultarEventoSQL = """
                SELECT idEvento, nombre, fecha, ciudad, Estado,descripcion, recinto FROM Eventos;""";
        //Se declara la lista de tipo evento donde se almacenaran los eventos
        List<Evento> listaEventos = new LinkedList<>();

        try {
            Connection conexion = this.manejadorConexiones.crearConexion();
            //Creación de sentencia estática
            PreparedStatement comando = conexion.prepareStatement(consultarEventoSQL);
            //Se almacenan los resultados de la consulta del query
            ResultSet resultadoConsulta = comando.executeQuery();
            //Se recorre resultadoConsulta para extraer los parametros de eventos de cada iteracion
            while (resultadoConsulta.next()) {
                //se almacenan los resultados en variables
                Integer idEvento = resultadoConsulta.getInt("idEvento");
                String nombre = resultadoConsulta.getString("nombre");
                Date fecha = resultadoConsulta.getDate("fecha");
                String ciudad = resultadoConsulta.getString("ciudad");
                String estado = resultadoConsulta.getString("Estado");
                String descripcion = resultadoConsulta.getString("descripcion");
                String recinto = resultadoConsulta.getString("recinto");

                //Se crea un evento en cada iteracion con los parametros recibidos anteriormente
                Evento evento = new Evento(idEvento,nombre, fecha, ciudad, estado, descripcion, recinto);
                listaEventos.add(evento);
            }
            //En caso de error en la insercion de datos
        } catch (Exception e) {
            System.err.println("Error al consultar: "+e.getMessage());
        }

        return listaEventos;
    }
}

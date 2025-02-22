package itson.ticketwizard.persistencia;

import itson.ticketwizard.dto.EventosDTO;
import itson.ticketwizard.dto.MostrarEventoDTO;
import itson.ticketwizard.entidades.Evento;
import itson.ticketwizard.excepciones.EventoException;
import itson.ticketwizard.persistencia.interfaces.IEventosDAO;

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
    public List<MostrarEventoDTO> consultarEventos() {
        String consultarEventoSQL = """
                SELECT idEvento, nombre, fecha, ciudad, Estado,descripcion, recinto FROM Eventos;""";
        List<MostrarEventoDTO> listaEventos = new LinkedList<>();

        try {
            Connection conexion = this.manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(consultarEventoSQL);
            ResultSet resultadoConsulta = comando.executeQuery();
            while (resultadoConsulta.next()) {
                Integer idEvento = resultadoConsulta.getInt("idEvento");
                String nombre = resultadoConsulta.getString("nombre");
                Date fecha = resultadoConsulta.getDate("fecha");
                String ciudad = resultadoConsulta.getString("ciudad");
                String estado = resultadoConsulta.getString("Estado");
                String descripcion = resultadoConsulta.getString("descripcion");
                String recinto = resultadoConsulta.getString("recinto");

                //Evento evento = new Evento(idEvento, nombre, fecha, ciudad, estado, descripcion, recinto);
                MostrarEventoDTO evento = new MostrarEventoDTO(idEvento,nombre, fecha, ciudad, estado);
                listaEventos.add(evento);
            }
        } catch (Exception e) {
            System.err.println("Error al consultar: "+e.getMessage());
        }
        return listaEventos;
    }
}

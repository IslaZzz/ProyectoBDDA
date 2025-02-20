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
    public void crearEvento(EventosDTO eventoDTO){
        String crearEventoSQL = "INSERT INTO EVENTOS(NOMBRE,FECHA,CIUDAD,ESTADO,DESCRIPCION,RECINTO) VALUES('?','?','?','?','?','?')";
        try{
            Connection conexion = manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(crearEventoSQL);

            comando.setString(2, eventoDTO.getNombre());
            comando.setString(3, eventoDTO.getFecha());
            comando.setString(4, eventoDTO.getCiudad());
            comando.setString(5, eventoDTO.getEstado());
            comando.setString(6, eventoDTO.getDescripcion());
            comando.setString(7, eventoDTO.getRecinto());

            int rows  = comando.executeUpdate();
            System.out.println("Se  generaron "+rows+" eventos");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Evento> consultarEvento(EventosDTO eventoDTO) {
        String consultarEventoSQL = """
                SELECT idEvento, nombre, fecha, ciudad, Estado,descripcion, recinto FROM Eventos;""";
        List<Evento> listaEventos = new LinkedList<>();

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
                Evento evento = new Evento(idEvento,nombre, fecha, ciudad, estado, descripcion, recinto);
                listaEventos.add(evento);
            }
        } catch (Exception e) {
            System.err.println("Error al consultar: "+e.getMessage());
        }
        return listaEventos;
    }
}

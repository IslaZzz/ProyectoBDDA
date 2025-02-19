package itson.ticketwizard.persistencia;

import itson.ticketwizard.dto.EventosDTO;
import itson.ticketwizard.excepciones.EventoException;
import itson.ticketwizard.persistencia.IEventosDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EventosDAO implements IEventosDAO {
    // public Connection(Connection ManejadorConexiones);

    @Override
    public void crearEvento(EventosDTO eventoDTO){
        String crearEventoSQL = "INSERT INTO EVENTOS(NOMBRE,FECHA,CIUDAD,ESTADO,DESCRIPCION,RECINTO) VALUES('?','?','?','?','?','?')";
        try{
            Connection conexion = Connection.crearConexion();
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
    };

    public void consultarEvento(EventosDTO eventoDTO){
        String crearEventoSQL = "INSERT INTO EVENTOS(NOMBRE,FECHA,CIUDAD,ESTADO,DESCRIPCION,RECINTO) VALUES('?','?','?','?','?','?')";
        try{

    };
    public void eliminarEvento(){


    };
    public void actualizarEvento(){


    };





}

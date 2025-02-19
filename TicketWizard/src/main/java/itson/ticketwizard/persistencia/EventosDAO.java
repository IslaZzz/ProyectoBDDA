package itson.ticketwizard.persistencia;

import itson.ticketwizard.excepciones.EventoException;
import itson.ticketwizard.persistencia.IEventosDAO;
import java.sql.PreparedStatement;

public class EventosDAO implements IEventosDAO {
    // public Connection(Connection ManejadorConexiones);

    public void crearEvento(Evento eventoDTO){
        String crearEventoSQL = "INSERT INTO EVENTOS(NOMBRE,FECHA,CIUDAD,ESTADO,DESCRIPCION,RECINTO) VALUES('?','?','?','?','?','?')";
        try{
            Connection conexion = Connection.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(crearEventoSQL);

           /* comando.setString(2, eventoDTO.);
            comando.setString(3);
            comando.setString(4);
            comando.setString(5);
            comando.setString(6);
            comando.setString(7);*/


        }catch(EventoException ex){
            ex.getMessage();
        }
    };

    @Override
    public void crearEvento() {

    }

    public void consultarEvento(){


    };
    public void eliminarEvento(){


    };
    public void actualizarEvento(){


    };





}

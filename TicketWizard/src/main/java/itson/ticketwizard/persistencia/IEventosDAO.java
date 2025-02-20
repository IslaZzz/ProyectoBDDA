package itson.ticketwizard.persistencia;

import itson.ticketwizard.dto.EventosDTO;
import itson.ticketwizard.entidades.Evento;

import java.util.List;

public interface IEventosDAO {

    //CREAR, CONSULTAR, ELIMINAR

    public List<Evento> consultarEvento(EventosDTO eventoDTO);



}

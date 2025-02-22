package itson.ticketwizard.persistencia.interfaces;

import itson.ticketwizard.dto.EventosDTO;
import itson.ticketwizard.dto.MostrarEventoDTO;
import itson.ticketwizard.entidades.Evento;

import java.util.List;

public interface IEventosDAO {

    //CREAR, CONSULTAR, ELIMINAR

    public List<MostrarEventoDTO> consultarEventos();



}

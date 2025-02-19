package itson.ticketwizard.persistencia;

import itson.ticketwizard.dto.EventosDTO;

public interface IEventosDAO {

    //CREAR, CONSULTAR, ELIMINAR

    public void crearEvento(EventosDTO eventoDTO);
    public void consultarEvento();
    public void eliminarEvento();
    public void actualizarEvento();




}

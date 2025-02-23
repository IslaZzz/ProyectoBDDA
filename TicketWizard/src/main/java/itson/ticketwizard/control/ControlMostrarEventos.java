/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.control;

import itson.ticketwizard.dto.MostrarEventoDTO;
import itson.ticketwizard.entidades.Evento;
import itson.ticketwizard.persistencia.EventosDAO;
import java.util.List;

/**
 *
 * @author pc
 */
public class ControlMostrarEventos {
    private EventosDAO eventosDAO;
    
    public ControlMostrarEventos(EventosDAO eventosDAO){
        this.eventosDAO = eventosDAO;
    }
    
    public List<MostrarEventoDTO> consultarEventos(){
        return this.eventosDAO.consultarEventos();
    }
}

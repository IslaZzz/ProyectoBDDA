/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

import itson.ticketwizard.entidades.Boleto;

import java.util.List;

/**
 *
 * @author 52644
 */
public class BoletosDAO implements IBoletosDAO {

    private ManejadorConexiones manejadorConexiones;

    public BoletosDAO(ManejadorConexiones manejadorConexiones) {
        this.manejadorConexiones = manejadorConexiones;
    }

    @Override
    public List<Boleto> consultarBoleto() {
        String consultarBoletoSQL = """
                                    Select idBoleto, 
                                    """;
                String consultarEventoSQL = """
                SELECT idEvento, nombre, fecha, ciudad, Estado,descripcion, recinto FROM Eventos;""";
       // List<Evento> listaEventos = new LinkedList<>();
       return null;
    }
}

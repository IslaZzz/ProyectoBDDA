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
    
    public BoletosDAO(ManejadorConexiones manejadorConexiones){
        this.manejadorConexiones = manejadorConexiones;
    }
    
    @Override
    public List<Boleto> consultarBoleto() {
        return List.of();
    }

    @Override
    public void crearBoleto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package itson.ticketwizard;

import itson.ticketwizard.control.ControlInicioSesion;
import itson.ticketwizard.persistencia.DireccionesDAO;
import itson.ticketwizard.persistencia.ManejadorConexiones;
import itson.ticketwizard.persistencia.UsuariosDAO;
import presentacion.FrmInicioSesion;
import presentacion.FrmPrincipal;

/**
 *
 * @author Peter
 */
public class TicketWizard {

    public static void main(String[] args) {
        ManejadorConexiones conexion = new ManejadorConexiones();
        UsuariosDAO usuariosDAO = new UsuariosDAO(conexion);
        DireccionesDAO direccionesDAO = new DireccionesDAO(conexion);
        ControlInicioSesion control = new ControlInicioSesion(usuariosDAO, direccionesDAO);
        control.IniciarFlujo();
    }
}   

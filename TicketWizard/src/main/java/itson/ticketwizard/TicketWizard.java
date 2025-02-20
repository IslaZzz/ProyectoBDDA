/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package itson.ticketwizard;

import itson.ticketwizard.control.ControlInicioSesion;
import presentacion.FrmInicioSesion;
import presentacion.FrmPrincipal;

/**
 *
 * @author Peter
 */
public class TicketWizard {

    public static void main(String[] args) {
        ControlInicioSesion control = new ControlInicioSesion();
        control.IniciarFlujo();
    }
}   

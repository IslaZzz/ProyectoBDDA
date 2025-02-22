/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.control;

import itson.ticketwizard.persistencia.DireccionesDAO;
import itson.ticketwizard.persistencia.UsuariosDAO;
import presentacion.FrmInicioSesion;
import presentacion.FrmPrincipal;
import presentacion.FrmRegistroUsuario;

/**
 *
 * @author Peter
 */
public class ControlInicioSesion {

    private UsuariosDAO usuariosDAO;
    private FrmInicioSesion frameInicioSesion;
    private FrmRegistroUsuario frameRegistroUsuario;
    private FrmPrincipal framePrincipal;
    private DireccionesDAO direccionesDAO;
    
    public ControlInicioSesion(UsuariosDAO usuariosDAO, DireccionesDAO direccionesDAO) {
        this.usuariosDAO = usuariosDAO;
        this.direccionesDAO = direccionesDAO;
        
    }

    public void IniciarFlujo() {
        frameInicioSesion = new FrmInicioSesion(this);
        frameRegistroUsuario = new FrmRegistroUsuario(this, new ControlRegistro(direccionesDAO, usuariosDAO));
        framePrincipal = new FrmPrincipal(this);
        frameInicioSesion.setVisible(true);
        frameInicioSesion.setLocationRelativeTo(null);
    }

    
    public void mostrarRegistro() {
        frameInicioSesion.dispose();
        frameRegistroUsuario.setVisible(true);
        frameRegistroUsuario.setLocationRelativeTo(null);
    }

    public void mostrarInicioSesion() {
        if (framePrincipal.isVisible()) {
            framePrincipal.dispose();
        } else if (frameRegistroUsuario.isVisible()) {
            frameRegistroUsuario.dispose();
        }
        frameInicioSesion.setVisible(true);
        frameInicioSesion.setLocationRelativeTo(null);
    }

    public void mostrarFramePrincipal() {
        frameInicioSesion.dispose();
        framePrincipal.setVisible(true);
        framePrincipal.setLocationRelativeTo(null);
    }
}

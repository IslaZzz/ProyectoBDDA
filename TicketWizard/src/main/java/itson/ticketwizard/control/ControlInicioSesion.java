/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.control;

import presentacion.FrmInicioSesion;
import presentacion.FrmPrincipal;
import presentacion.FrmRegistroUsuario;

/**
 *
 * @author Peter
 */
public class ControlInicioSesion {
    
    private FrmInicioSesion frameInicioSesion;
    private FrmRegistroUsuario frameRegistroUsuario;
    private FrmPrincipal framePrincipal;
    public ControlInicioSesion(){
        
    }
    
    public void IniciarFlujo(){
        frameInicioSesion = new FrmInicioSesion(this);
        frameInicioSesion.setVisible(true);
        frameInicioSesion.setLocationRelativeTo(null);
    }
    
    public void mostrarRegistro(){
        if(frameRegistroUsuario == null){
            frameRegistroUsuario = new FrmRegistroUsuario(this);
        }
        frameInicioSesion.dispose();
        frameRegistroUsuario.setVisible(true);
        frameRegistroUsuario.setLocationRelativeTo(null);
    }
    public void mostrarInicioSesion(){
        frameRegistroUsuario.dispose();
        frameInicioSesion.setVisible(true);
        frameRegistroUsuario.setLocationRelativeTo(null);
    }
    
    public void mostrarFramePrincipal(){
        if(framePrincipal == null){
            framePrincipal = new FrmPrincipal(this);
        }
        frameInicioSesion.dispose();
        framePrincipal.setVisible(true);
        framePrincipal.setLocationRelativeTo(null);
    }
}

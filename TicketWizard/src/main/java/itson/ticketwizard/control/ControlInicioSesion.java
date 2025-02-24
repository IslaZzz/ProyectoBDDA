/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.control;

import itson.ticketwizard.entidades.Usuario;
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
    /**
     * Metodo a ser llamado al dar clic en iniciar sesión, consulta el correo y contraseña en la base de datos
     * Retorna un usuario con el id o null si no se encontró al usuario
     * @param correo Correo del usuario a validar
     * @param contrasenia Contrasenia del usuario a validar
     * @return Retorna un usuario con el id o null si no se encontró al usuario
     */
    public Usuario iniciarSesion(String correo, String contrasenia){
        return usuariosDAO.validarCredencialesInicioSesion(correo, contrasenia);
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

    public void mostrarFramePrincipal(Usuario usuario) {
        frameInicioSesion.dispose();
        framePrincipal.dispose();
        framePrincipal = new FrmPrincipal(this);
        framePrincipal.setUsuario(usuario);
        framePrincipal.setVisible(true);
        framePrincipal.setLocationRelativeTo(null);
    }
}

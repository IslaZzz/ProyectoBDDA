/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.entidades;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author 52644
 */
public class Seguridad {
    /**
     * 
     * @param psw
     * @return 
     */
    public static String encriptar(String psw){
        return BCrypt.hashpw(psw    , BCrypt.gensalt(12));
    }
    
    public static boolean verificar(String psw, String hashAlmacenado){
        return BCrypt.checkpw(psw, hashAlmacenado);
    }
}

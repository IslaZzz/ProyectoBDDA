/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.entidades;

import java.security.SecureRandom;
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
    
    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    public static String generarCodigoAlfanumerico() {
        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            int indice = random.nextInt(CARACTERES.length());
            sb.append(CARACTERES.charAt(indice));
        }
        return sb.toString();
    }

}

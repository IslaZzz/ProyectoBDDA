/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    public static String encriptar(String psw) {
        return BCrypt.hashpw(psw, BCrypt.gensalt(12));
    }

    public static boolean verificar(String psw, String hashAlmacenado) {
        return BCrypt.checkpw(psw, hashAlmacenado);
    }

    /**
     * Valida un string de una fecha en un formato en especifico
     *
     * @param s String que contiene la fecha
     * @return
     */
    public static boolean validaFecha(String s) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            dtf.parse(s);
        } catch (DateTimeParseException ex) {
            return false;
        }
        return true;
    }

    public static Date dateMapper(String s) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fecha = df.parse(s);
            return fecha;
        } catch (java.text.ParseException ex) {
            return null;
        }
    }

    public static boolean validaEmail(String s) {
        //Define la expresión regular para un email
        String regEx = "^(\\w\\.?){1,20}@(\\w\\.?){1,20}$";
        //Compila la expresión regular a un patrón
        Pattern pattern = Pattern.compile(regEx);
        //Crea un comparador para comparar la cadena contra el patrón
        Matcher matcher = pattern.matcher(s);
        //Regresa si la cadena se ajusta al patron
        return matcher.matches();
    }

    public static boolean validaDoble(String s) {
        //Define la expresión regular para un doble
        String reCadena = "^\\d+(\\.\\d*)?$";
        // Compila la expresión regular a un patrón
        Pattern pattern = Pattern.compile(reCadena);
        // Crea un comparador para comparar la cadena contra el patrón
        Matcher matcher = pattern.matcher(s);
        //Regresa si la cadena se ajusta al patron
        return matcher.matches();
    }
}

package itson.ticketwizard.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 52644
 */
public class ManejadorConexiones {
    //Informacion para conectar a la base de datos
        private final String cadenaConexion = "jdbc:mysql://127.0.0.1/ticketwizard";
        private final String usuario = "root";
        //INSERTAR SU CONTRASEÑA AQUI
        private final String contrasenia = "admin";
        /**
         * Método que retorna una conexión a la base de datos
         * @return un objeto Connection para hacer solicitudes a la DB
         * @throws SQLException En caso de error
         */
        public Connection crearConexion() throws SQLException{
            Connection conexion = DriverManager.getConnection(
                    cadenaConexion,
                    usuario,
                    contrasenia
                    
            );
            return conexion;
        }
}
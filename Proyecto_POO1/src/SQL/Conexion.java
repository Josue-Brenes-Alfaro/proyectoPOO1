package SQL;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para la conexión de la base de datos SQL
 * @author Alejandra
 * @author Paola
 * @author Josue
 * @version 1.0
 */
public class Conexion {
  /**
   * Método para realizar la conexión a la base de datos Proyecto_POO1
   * @return con conexión con la base de datos Proyecto_POO1
   */
  
  public static Connection getConexion(){
    //Error en la conexión a la base de datos
    String connectionUrl = "jbdc:sqlserver://localhost:1433;"
        +"databaseName=Proyecto_POO1; integratedSecurity=true;";
    
    try {
      System.out.println(connectionUrl);
      Connection con = DriverManager.getConnection(connectionUrl);
      System.out.println("Conectó con la bd");
      return con;
    }
      catch (SQLException ex){
      System.out.println("Error.");
      return null;
    }
  }
}

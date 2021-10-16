package SQL;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Josue
 */
public class Conexion {
  
  public static Connection getConexion(){
    String connectionUrl = "jbdc:sqlserver://DESKTOP-7ARB7AC\\SQLEXPRESS:1433;"
        +"databaseName=Proyecto_POO1;"
        +"IntegratedSecurity=true;";  
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

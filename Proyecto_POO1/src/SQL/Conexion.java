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
    String connectionUrl = "jbdc:sqlserver://localhost\\SQLEXPRESS:1433;"
        +"databaseName=Proyecto_POO1;"
        +"IntegratedSecurity=true;";  
    try {
      System.out.println(connectionUrl);
      Connection con = DriverManager.getConnection(connectionUrl);
      return con;
    } 
      catch (SQLException ex){
      System.out.println("Error.");
      return null;
    }
  }
}

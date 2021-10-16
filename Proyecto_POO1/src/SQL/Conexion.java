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
    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      String connectionUrl = "jbdc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=Proyecto_POO1;IntegratedSecurity=true";
      Connection conect = DriverManager.getConnection(connectionUrl);
      System.out.println("Conectado.");
      return conect;
    } 
      catch (SQLException ex){
      System.out.println("Error.");
      return null;
    } catch (ClassNotFoundException ex){
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    }
  }
}

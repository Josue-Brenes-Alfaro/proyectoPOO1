package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
/**
 *
 * @author Josue
 */
public class Conexion {
  public static Connection getConexion(){
    String conexionURL = "jbdc:sqlserver://localhost\\SQLEXPRESS"
        +"database=Proyecto_POO1"
        +"user="
        +"password="
        +"loginTimeout=30";

    try{
      Connection con = DriverManager.getConnection(conexionURL);
      return con;
    }catch(SQLException ex){
      System.out.println(ex.toString());
      return null;
    }
  }
  
}

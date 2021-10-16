package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Josue
 */
public class Conexion {
  public static Connection getConexion(){
    String conexionURL = "jbdc:sqlserver:localhost\\SQLEXPRESS"
        +"database=Proyecto_POO1"
        +"loginTimeout=30";
//**

    
    try{
      Connection con = DriverManager.getConnection(conexionURL);
      return con;
    }catch(SQLException ex){// hay problemas con la excepcion
      System.out.println(ex.toString());
      
      return null;
    }
  }
  
}

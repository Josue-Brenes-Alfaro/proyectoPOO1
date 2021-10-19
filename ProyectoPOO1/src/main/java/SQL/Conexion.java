package SQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 * Clase para la conexión de la base de datos SQL
 * @author Alejandra
 * @author Paola
 * @author Josue
 * @version 1.0
 */
public class Conexion {
  
  Connection conectar = null;
  
  String usuario = "usuariosql" ;
  String contraseña = "root1";
  String bd = "Proyecto_POO1" ;
  String ip = "localhost";
  String puerto = "1433";
  
  String cadena="jdbc:sqlserver://"+ip+":"+puerto+"/"+bd;
  //*********************************************
  /**
   * Método para realizar la conexión a la base de datos Proyecto_POO1
   * @return con conexión con la base de datos Proyecto_POO1
   */  
  public Connection establecerConexion(){
    
    try{
      String cadena = "jdbc:sqlserver://localhost:"+puerto+";"+"databaseName="+bd;
      conectar = DriverManager.getConnection(cadena,usuario,contraseña);
      JOptionPane.showMessageDialog(null, "Se conecto a la base de datos");
     
    }catch(Exception e){
      JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos, error:"+e.toString());
    }
    return conectar;
  } 
}

package SQL;
import aplicacion.Escuela;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;


public class Conexion {
  
 private String url;
 public Connection connect;

  /**
   * Constructor del objeto {@code Conector} con el url del servidor para la base de datos.
   * @param pUrl
   */
  public Conexion (String pUrl) {
    pUrl = "jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1";
    this.url = pUrl;
   }
  
  /**
   * Método para conectarse a la base de datos por medio del driver JDBC para realizar operaciones.
   */
  public void connect() {
    try {
      connect = DriverManager.getConnection(url);
      if (connect != null) {
        System.out.println("Connected");
      }
    } catch (SQLException ex) {
      System.out.println(ex);
    }
  }
  
  //* Metdo para cerrar la conexion sql server*//
  public void close() {
    try {
      connect.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}

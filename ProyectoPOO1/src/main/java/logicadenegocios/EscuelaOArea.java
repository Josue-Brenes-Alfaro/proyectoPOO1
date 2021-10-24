package logicadenegocios;

import java.util.ArrayList;
import excepciones.CursoDoesNotExistsException;
import interfaces.InterfaceCurso;
import logicadenegocios.EscuelaOArea;
import aplicacion.Escuela;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Esta es una abstraccion de la clase EscuelaoArea con fines academicos
 * @author Alejandra Merino
 * @author Paola López
 * @author Josué Brenes
 * @version 1.0
 */
public class EscuelaOArea{//implements InterfaceCurso{
  private String codigoCarrera;
  private String nombreCarrera;
  private int tieneEscuela;
  private ArrayList<Curso> misCursos;

//metodos accesores  
  public String getCodigoCarrera() {
    return codigoCarrera;
  }

  public void setCodigoCarrera(String codigoCarrera) {
    this.codigoCarrera = codigoCarrera;
  }

  public String getNombreCarrera() {
    return nombreCarrera;
  }

  public void setNombreCarrera(String nombreCarrera) {
    this.nombreCarrera = nombreCarrera;
  }

  public int isTieneEscuela() {
    return tieneEscuela;
  }

  public void setTieneEscuela(int tieneEscuela) {
    this.tieneEscuela = tieneEscuela;
  }

  public ArrayList<Curso> getMisCursos() {
    return misCursos;
  }

  public void setMisCursos(ArrayList<Curso> misCursos) {
    this.misCursos = misCursos;
  }

  public void agregarCurso(Curso pCurso) {
    misCursos.add(pCurso);
  }
  
  /**
   * Método para guardar la información de una carrera, el nombre, código 
   * y si una carrera es escuela o no 
   * @param pNombreCarrera
   * @param pCodigoCarrera
   * @param pEsEscuela 
   */
  public void guardarDatosDeCarrera(String pNombreCarrera, 
      String pCodigoCarrera, int pEsEscuela){
    setNombreCarrera(pNombreCarrera);
    setCodigoCarrera(pCodigoCarrera);
    setTieneEscuela(pEsEscuela);

    try {
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;"
              + "databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("INSERT INTO EscuelaOArea "
              + "VALUES ('"+ getCodigoCarrera() +"','"+ getNombreCarrera() +"',"
                      + "'"+ isTieneEscuela() +"')");
      st.executeUpdate();
      JOptionPane.showMessageDialog(null,"Registro guardado");
    } 
    catch (SQLException ex) {
      System.err.println(ex.getMessage());
    }
  }
  
  /**
   *Este metodo carga la los datos de la tabla carreras
   * y la muestra en la tabla de la aplicacion
   */  
  public void cargaDeDatosEnTablaCarreras(DefaultTableModel modeloTabla){
    Connection connect;
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try {
      connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT nombreCarrera, codigoCarrera, tieneEscuela from EscuelaOArea");
      rs = st.executeQuery();
      rsmd = rs.getMetaData();
      columnas = rsmd.getColumnCount();
      while(rs.next()){
        Object[] fila = new Object[columnas];
        for(int indice=0; indice<columnas; indice++){
          fila[indice]=rs.getObject(indice+1);
        }
        modeloTabla.addRow(fila);
      }
    } catch (SQLException ex) {
      Logger.getLogger(EscuelaOArea.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
}

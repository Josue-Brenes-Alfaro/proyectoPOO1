package logicadenegocios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Esta es una abstraccion de la clase PlanDeEstudio con fines academicos
 * @author Alejandra Merino
 * @author Paola López
 * @author Josué Brenes
 * @version 1.0
 */
public class PlanDeEstudio {//implements InterfaceCurso{
  private String nombrePlanEstudio;
  private String codCarrera;
  private String fechaVigencia;
  private int cantidadCursos=0;
  private int cantidadCreditos=0;

//metodos accesores  
  public String getCodCarrera() {
    return codCarrera;
  }

  public void setCodCarrera(String codCarrera) {
    this.codCarrera = codCarrera;
  }
  
  public String getNombrePlanEstudio() {
    return nombrePlanEstudio;
  }

  public void setNombrePlanEstudio(String pNombrePlanEstudio) {
    this.nombrePlanEstudio = pNombrePlanEstudio;
  }

  public String getFechaVigencia() {
    return fechaVigencia;
  }

  public void setFechaVigencia(String fechaVigencia) {
    this.fechaVigencia = fechaVigencia;
  }

  public int getCantidadCursos() {
    return cantidadCursos;
  }

  public void setCantidadCursos(int cantidadCursos) {
    this.cantidadCursos = cantidadCursos;
  }

  public int getCantidadCreditos() {
    return cantidadCreditos;
  }

  public void setCantidadCreditos(int cantidadCreditos) {
    this.cantidadCreditos = cantidadCreditos;
  }
  
  /**
   * Método para guardar la información de un plan de estudio, el nombre, código 
   * y demas
   * @param pNomPlan
   * @param pFechaVigencia
   */
  public void guardarDatosDePlanesEstudio(String pNomPlan, String pFechaVigencia){
    setNombrePlanEstudio(pNomPlan);
    setFechaVigencia(pFechaVigencia);
    
    try {
    Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName="
            + "Proyecto_POO1;user=usuariosql;password=root1");
    PreparedStatement st = connect.prepareStatement("INSERT INTO PlanDeEstudio"
            + "(idPlan, fechaVigencia ) VALUES ('"+getNombrePlanEstudio()+"','"+ getFechaVigencia() +"')");
    st.executeUpdate();
    }catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,"Datos invalidos");
      System.err.println(ex.getMessage());
    }
  }
  /**
   * Método para guardar la información de un plan de estudio, en la tabla intermedia 
   * @param pCodCarrera
   * @param pNombrePlanEstudio
   */
  public void guardarDatosDePlanesPorEscuela(String pCodCarrera, String pNombrePlanEstudio){
    setCodCarrera(pCodCarrera);
    setNombrePlanEstudio(pNombrePlanEstudio);
    
    try {
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName="
          + "Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("INSERT INTO PlanesPorEscuela "
          + "VALUES ('"+ getCodCarrera() +"','"+  getNombrePlanEstudio() +"')");
      st.executeUpdate();
      JOptionPane.showMessageDialog(null,"Registro guardado");
    } 
    catch (SQLException ex) {
      System.err.println(ex.getMessage());
    }
  }
  
  /**
   *Este metodo carga la los datos de la tabla Planes
   * y la muestra en la tabla de la aplicacion
   * @param modeloTabla
   */  
  public void cargarTablaPlanDeEstudio(DefaultTableModel modeloTabla){
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName="
              + "Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT PlanDeEstudio.idPlan, "
              + "fechaVigencia, codigoCarrera FROM PlanDeEstudio INNER JOIN "
              + "PlanesPorEscuela ON PlanDeEstudio.idPlan = PlanesPorEscuela.idPlan");
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
    }catch(SQLException e){
      
      JOptionPane.showMessageDialog(null,e);
    }
  }
}

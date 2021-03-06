package aplicacion;
import SQL.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Clase de la creación de la ventana RegistroCursoEnPlan
 * dedicada para el registro de cursos en planes de estudio
 * @author Alejandra
 * @author Paola
 * @author Josue
 * @version 1.0
 */
public class RegistroCursosEnPlan extends javax.swing.JFrame {

  Conexion c = new Conexion("");
  ButtonGroup btnGr;
  /**
   * crea el nuevo formulario  y agrega color de fondo
   */
  public RegistroCursosEnPlan() {
    initComponents();
    cargarTablaCursosPlan();
    obtenerNombreCarreras();
    this.getContentPane().setBackground(new Color(223,255,255));
  }
  
  /**
   * Método para insertar el nombre de las carreras en el
   * combobox llamado comBxCarreras
   */
  public void obtenerNombreCarreras(){
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Selecciones una carrera");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT * from EscuelaOArea order by nombreCarrera");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("nombreCarrera"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } comBxCarreras.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
  
  /**
   * Método para extraer las primeras letras de una oración.
   * @param pNombreEscuela
   * @return las iniciales de una oración
   */
  public String generarCodigoEscuela (String pNombreEscuela ){
    int largo = pNombreEscuela.length();
    String ini=" ";
    String xx=pNombreEscuela.substring(0, 1);;
    String x="";
    String xxx="";
    for (int i = 0; i <largo; i++) {
        x=pNombreEscuela.substring(i,i+1);
      if (x.equals(ini)) {
        xxx=pNombreEscuela.substring(i+1, i+2);
        xx=xx+xxx;

      } 
    }
    return xx;
  }

  /**
   * Método para insertar el código de los cursos en el
   * combobox llamado cbxCursos
   */
  public void obtenerCodigoCursos(){
    ResultSet rs;
    String nombreCarrera = comBxCarreras.getSelectedItem().toString();
    String codigoCarrera = generarCodigoEscuela(nombreCarrera);    

    try {
      c.connect();
      
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Selecciones un curso");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      //PreparedStatement st = connect.prepareStatement("SELECT codigoCurso from Curso order by nombreCurso");
      PreparedStatement st = connect.prepareStatement("SELECT codigoCurso from CursosPorEscuela where CursosPorEscuela.codigoCarrera = '"+codigoCarrera+"'");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("codigoCurso"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } cbxCursos.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
    c.close();
  }
  
  /**
   * Método para insertar el código de los Planes de estudio en el
   * combobox llamado cmbCodigoPlanEstudio
   */
  public void obtenerCodigoPlanes(){
    ResultSet rs;
    String nombreCarrera = comBxCarreras.getSelectedItem().toString();
    String codigoCarrera = generarCodigoEscuela(nombreCarrera);
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Selecciones un Plan");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName="
              + "Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT idPlan from PlanesPorEscuela where PlanesPorEscuela.codigoCarrera = '"+codigoCarrera+"'");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("idPlan"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } cmbCodigoPlanEstudio.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
  
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jScrollPane2 = new javax.swing.JScrollPane();
    tblCursosPlan = new javax.swing.JTable();
    jPanel1 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    btnGuardar = new javax.swing.JButton();
    jLabel5 = new javax.swing.JLabel();
    cmbNumBloque = new javax.swing.JComboBox<>();
    jLabel6 = new javax.swing.JLabel();
    cbxCursos = new javax.swing.JComboBox<>();
    cmbCodigoPlanEstudio = new javax.swing.JComboBox<>();
    btnCargarCursos = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    comBxCarreras = new javax.swing.JComboBox<>();
    btnCargarPlanes = new javax.swing.JButton();
    btnEliminarCursoEnPlan = new javax.swing.JButton();
    btnVolver = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("RegistroCursosEnPlan");
    setSize(new java.awt.Dimension(1000, 470));

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel1.setText("Registro de cursos en un plan de estudio");

    tblCursosPlan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    tblCursosPlan.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Plan de Estudio", "Curso", "Bloque"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, true, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane2.setViewportView(tblCursosPlan);

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel2.setText("Código del plan de estudios:");

    btnGuardar.setBackground(new java.awt.Color(69, 119, 186));
    btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnGuardar.setText("Guardar");
    btnGuardar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnGuardarActionPerformed(evt);
      }
    });

    jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel5.setText(" Bloque:");

    cmbNumBloque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    cmbNumBloque.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

    jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel6.setText("Curso:");

    cbxCursos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    cmbCodigoPlanEstudio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    btnCargarCursos.setBackground(new java.awt.Color(69, 119, 186));
    btnCargarCursos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnCargarCursos.setText("Cargar Cursos");
    btnCargarCursos.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCargarCursosActionPerformed(evt);
      }
    });

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel3.setText("Escuela o Área académica:");

    comBxCarreras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    btnCargarPlanes.setBackground(new java.awt.Color(69, 119, 186));
    btnCargarPlanes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnCargarPlanes.setText("Cargar Planes");
    btnCargarPlanes.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCargarPlanesActionPerformed(evt);
      }
    });

    btnEliminarCursoEnPlan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnEliminarCursoEnPlan.setText("Eliminar");
    btnEliminarCursoEnPlan.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnEliminarCursoEnPlanActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jLabel3)
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addGap(186, 186, 186)
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel6)
                .addComponent(jLabel5)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
              .addContainerGap()
              .addComponent(jLabel2))))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(cbxCursos, 0, 287, Short.MAX_VALUE)
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(btnGuardar)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(btnEliminarCursoEnPlan))
                .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(1, 1, 1)
                  .addComponent(cmbNumBloque, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnCargarCursos))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(comBxCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(cmbCodigoPlanEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnCargarPlanes)))
        .addContainerGap(123, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(comBxCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cmbCodigoPlanEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2)
          .addComponent(btnCargarPlanes))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cbxCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel6)
          .addComponent(btnCargarCursos))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cmbNumBloque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel5))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnGuardar)
          .addComponent(btnEliminarCursoEnPlan))
        .addContainerGap())
    );

    btnVolver.setBackground(new java.awt.Color(69, 119, 186));
    btnVolver.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnVolver.setText("Regresar");
    btnVolver.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnVolverActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(172, 903, Short.MAX_VALUE)
            .addComponent(btnVolver))
          .addGroup(layout.createSequentialGroup()
            .addGap(118, 118, 118)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jLabel1)))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(262, 262, 262))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addGap(18, 18, 18)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(btnVolver)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

/**
 * Método para accionar el botón de guardar en la ventala del registro de 
 * cursos en un plan de estudio.
 * @param evt 
 */  
  private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    String idplan = cmbCodigoPlanEstudio.getSelectedItem().toString();
    String codigoCurso = cbxCursos.getSelectedItem().toString();
    String numBloque = cmbNumBloque.getSelectedItem().toString();
    
    c.connect();

    try {
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName="
        + "Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("INSERT INTO CursosPorPlan VALUES ('"+ idplan +"','"+ codigoCurso +"',"+ numBloque +")");
      st.executeUpdate();
      c.close();
    }
    catch (SQLException ex) {
      System.err.println(ex.getMessage());
    }
    cargarTablaCursosPlan();

  }//GEN-LAST:event_btnGuardarActionPerformed

  /**
   * Método para accionar el botón que carga los cursos en la ventana
   * que registra los cursos en un plan de estudio, este llama al método
   * obtenerCodigoCursos
   * @param evt 
   */
  private void btnCargarCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarCursosActionPerformed
    obtenerCodigoCursos();
  }//GEN-LAST:event_btnCargarCursosActionPerformed

  /**
   * Método para accionar el botón que carga los planes de estudio en la ventana
   * que registra los cursos en un plan de estudio, este llama al método
   * obtenerCodigoPlanes
   * @param evt 
   */
  private void btnCargarPlanesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarPlanesActionPerformed
    obtenerCodigoPlanes();
  }//GEN-LAST:event_btnCargarPlanesActionPerformed
  
  /**
   *Este metodo contiene un evento de accion que al apretarlo
   * regresa al menu principal
   * @param evt
   */
  private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
    RegistroPlanesEstudio verPlanEstudio = new RegistroPlanesEstudio();    
    verPlanEstudio.setVisible(true);
    this.setVisible(false);
  }//GEN-LAST:event_btnVolverActionPerformed

  /**
   * Este metodo contiene un evento que al accionarlo, elimina el curso de un Plan
   * @param evt 
   */
  private void btnEliminarCursoEnPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCursoEnPlanActionPerformed
    String idplan = cmbCodigoPlanEstudio.getSelectedItem().toString();
    String codigoCurso = cbxCursos.getSelectedItem().toString();
    String numBloque = cmbNumBloque.getSelectedItem().toString();
    
    c.connect();

    try {
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName="
        + "Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("DELETE from CursosPorPlan WHERE codigoCurso = '"+codigoCurso+"' AND idPlan = '"+idplan+"'");
      st.executeUpdate();
      c.close();
    }
    catch (SQLException ex) {
      System.err.println(ex.getMessage());
    }
    cargarTablaCursosPlan();
  }//GEN-LAST:event_btnEliminarCursoEnPlanActionPerformed

  /**
   * Este metodo Carga los datos de la tabla de la ventana RegistroCursosEnPlan
   */
  private void cargarTablaCursosPlan(){
    DefaultTableModel modeloTabla = (DefaultTableModel) tblCursosPlan.getModel();
    modeloTabla.setRowCount(0);
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    
    int [] anchos = {10, 50, 100, 30, 100};
    for(int i = 0 ; i < tblCursosPlan.getColumnCount(); i++){
      tblCursosPlan.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
    }
    
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName="
              + "Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT * FROM CursosPorPlan");
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
  
  /**
   * Método main de la ventana RegistroCursosEnPlan
   * @param args
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(RegistroCursosEnPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(RegistroCursosEnPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(RegistroCursosEnPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(RegistroCursosEnPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new RegistroCursosEnPlan().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnCargarCursos;
  private javax.swing.JButton btnCargarPlanes;
  private javax.swing.JButton btnEliminarCursoEnPlan;
  private javax.swing.JButton btnGuardar;
  private javax.swing.JButton btnVolver;
  private javax.swing.JComboBox<String> cbxCursos;
  private javax.swing.JComboBox<String> cmbCodigoPlanEstudio;
  private javax.swing.JComboBox<String> cmbNumBloque;
  private javax.swing.JComboBox<String> comBxCarreras;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTable tblCursosPlan;
  // End of variables declaration//GEN-END:variables
}

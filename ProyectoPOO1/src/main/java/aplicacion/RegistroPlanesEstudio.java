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
import logicadenegocios.PlanDeEstudio;

/**
 * Clase de la creación de la ventana RegistroPlanesEstudio
 * dedicada para la creacion de nuevos planes de estudio
 * @author Alejandra
 * @author Paola
 * @author Josue
 * @version 1.0
 */
public class RegistroPlanesEstudio extends javax.swing.JFrame {
  PlanDeEstudio plan = new PlanDeEstudio();
  Conexion c = new Conexion("");
  ButtonGroup btnGr;
  /**
   * crea el nuevo formulario  y agrega color de fondo
   */
  public RegistroPlanesEstudio() {
    initComponents();
    obtenerNombreCarreras();
    cargarTablaPlanEstudio();
    this.getContentPane().setBackground(new Color(223,255,255));
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
   * Método para insertar el nombre de las carreras en el
   * combobox llamado 
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
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    tblPlanesEstudio = new javax.swing.JTable();
    jPanel1 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    comBxCarreras = new javax.swing.JComboBox<>();
    txtCodPlanEstudio = new javax.swing.JTextField();
    txtFechaVigencia = new javax.swing.JTextField();
    btnGuardar = new javax.swing.JButton();
    btnLimpiar = new javax.swing.JButton();
    jLabel7 = new javax.swing.JLabel();
    btnPasarVentanaRegistrarCursosEnPlan = new javax.swing.JButton();
    btnPDF1 = new javax.swing.JButton();
    btnPDF2 = new javax.swing.JButton();
    btnVolver = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("VentanaPlanDeEstudio");
    setSize(new java.awt.Dimension(1000, 470));

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel1.setText("Registro de Planes de Estudio");

    tblPlanesEstudio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    tblPlanesEstudio.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Código del Plan de Estudio", "Fecha de Vigencia", "Código Carrera"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.Object.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, true
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(tblPlanesEstudio);

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel2.setText("Código del plan de estudios:");

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel3.setText("Escuela o Área académica:");

    jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel4.setText("Vigencia del plan de estudios:");

    comBxCarreras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    txtCodPlanEstudio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    txtFechaVigencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    btnGuardar.setBackground(new java.awt.Color(69, 119, 186));
    btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnGuardar.setText("Guardar plan de estudio");
    btnGuardar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnGuardarActionPerformed(evt);
      }
    });

    btnLimpiar.setBackground(new java.awt.Color(69, 119, 186));
    btnLimpiar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnLimpiar.setText("Limpiar");
    btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnLimpiarActionPerformed(evt);
      }
    });

    jLabel7.setText("Año - Mes - Día");

    btnPasarVentanaRegistrarCursosEnPlan.setBackground(new java.awt.Color(69, 119, 186));
    btnPasarVentanaRegistrarCursosEnPlan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnPasarVentanaRegistrarCursosEnPlan.setText("Registrar cursos en un plan de estudio");
    btnPasarVentanaRegistrarCursosEnPlan.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnPasarVentanaRegistrarCursosEnPlanActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jLabel2)
          .addComponent(jLabel4)
          .addComponent(jLabel3))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(comBxCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(6, 6, 6)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(txtCodPlanEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(txtFechaVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(btnGuardar)
        .addGap(29, 29, 29)
        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(172, 172, 172)
        .addComponent(btnPasarVentanaRegistrarCursosEnPlan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(312, 312, 312)
        .addComponent(jLabel7)
        .addGap(0, 0, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(27, 27, 27)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(comBxCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 45, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(txtCodPlanEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(20, 20, 20)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(txtFechaVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel7)
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnPasarVentanaRegistrarCursosEnPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnGuardar)
          .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
    );

    btnPDF1.setText("Regresar");

    btnPDF2.setText("Regresar");

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
        .addGap(126, 903, Short.MAX_VALUE)
        .addComponent(btnVolver)
        .addContainerGap())
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(93, 93, 93))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(200, 200, 200))))
      .addGroup(layout.createSequentialGroup()
        .addGap(342, 342, 342)
        .addComponent(jLabel1)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(0, 0, Short.MAX_VALUE)
          .addComponent(btnPDF1)
          .addGap(0, 0, Short.MAX_VALUE)))
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(0, 0, Short.MAX_VALUE)
          .addComponent(btnPDF2)
          .addGap(0, 0, Short.MAX_VALUE)))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addGap(18, 18, 18)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(29, 29, 29)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(48, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(btnVolver)
        .addContainerGap())
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(0, 0, Short.MAX_VALUE)
          .addComponent(btnPDF1)
          .addGap(0, 0, Short.MAX_VALUE)))
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(0, 0, Short.MAX_VALUE)
          .addComponent(btnPDF2)
          .addGap(0, 0, Short.MAX_VALUE)))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
 * Método para accionar el botón de guardar en la ventana RegistroPlanesEstudio.
 * @param evt 
 */
  private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    String nombreCarrera = comBxCarreras.getSelectedItem().toString();
    String codigoCarrera = generarCodigoEscuela(nombreCarrera);
    String codigoPlanEstudio = txtCodPlanEstudio.getText();
    String fechaVigencia = txtFechaVigencia.getText();
    String NombrePlanEstudio= codigoCarrera+codigoPlanEstudio;
    c.connect();

    plan.guardarDatosDePlanesEstudio(NombrePlanEstudio, fechaVigencia);
    
    
    plan.guardarDatosDePlanesPorEscuela(codigoCarrera, NombrePlanEstudio);
    
    c.close();
    limpiar();
    cargarTablaPlanEstudio();
  }//GEN-LAST:event_btnGuardarActionPerformed

  /**
   * Este metodo carga los datos de la tabla de la ventana RegistroPlanesEstudio
   */
  private void cargarTablaPlanEstudio(){
    DefaultTableModel modeloTabla = (DefaultTableModel) tblPlanesEstudio.getModel();
    modeloTabla.setRowCount(0);
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    
    int [] anchos = {10, 50, 100, 30, 100};
    for(int i = 0 ; i < tblPlanesEstudio.getColumnCount(); i++){
      tblPlanesEstudio.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
    }
    c.connect();
    plan.cargarTablaPlanDeEstudio(modeloTabla);
    c.close();
  }
  
  /**
   *  Metodo del botón Limpiar el cual llama al metodo limpiar.
   * @param evt 
   */
  private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
    limpiar();
  }//GEN-LAST:event_btnLimpiarActionPerformed

  /**
 * Método para accionar el botón para abrir la ventana llamada 
 * RegistroCursosEnPlan.
 * @param evt 
 */
  private void btnPasarVentanaRegistrarCursosEnPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasarVentanaRegistrarCursosEnPlanActionPerformed
    RegistroCursosEnPlan abrir = new RegistroCursosEnPlan();
    abrir.setVisible(true);
    this.setVisible(false);
  }//GEN-LAST:event_btnPasarVentanaRegistrarCursosEnPlanActionPerformed

  /**
   *Este metodo contiene un evento de accion que al apretarlo
   * regresa al menu principal
   * @param evt
   */
  private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
    Menu verMenu = new Menu();    
    verMenu.setVisible(true);
    this.setVisible(false);
  }//GEN-LAST:event_btnVolverActionPerformed

  /**
   * Limpia los campos de la ventana RegistroPlanesEstudio.
   */
  private void limpiar(){
    txtCodPlanEstudio.setText("");
    txtFechaVigencia.setText("");
  }
  /**
   * Método main de la ventana RegistroPlanesEstudio
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
      java.util.logging.Logger.getLogger(RegistroPlanesEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(RegistroPlanesEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(RegistroPlanesEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(RegistroPlanesEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new RegistroPlanesEstudio().setVisible(true);
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnGuardar;
  private javax.swing.JButton btnLimpiar;
  private javax.swing.JButton btnPDF1;
  private javax.swing.JButton btnPDF2;
  private javax.swing.JButton btnPasarVentanaRegistrarCursosEnPlan;
  private javax.swing.JButton btnVolver;
  private javax.swing.JComboBox<String> comBxCarreras;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable tblPlanesEstudio;
  private javax.swing.JTextField txtCodPlanEstudio;
  private javax.swing.JTextField txtFechaVigencia;
  // End of variables declaration//GEN-END:variables
}

package aplicacion;
import SQL.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
/**
 * Clase de la crración de la ventana Escuela
 * @author Alejandra
 * @author Paola
 * @author Josue
 * @version 1.0
 */
public class Escuela extends javax.swing.JFrame {

  ButtonGroup btnGr;
  /**
   * Creaciones de la ventana Escuela
   */
  public Escuela() {
    initComponents();
    btnGr = new ButtonGroup();
    btnGr.add(rbNo);
    btnGr.add(rbSi);
    cargarTabla();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    tblCarreras = new javax.swing.JTable();
    jPanel1 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    txtNombreCarrera = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    txtCodigoCarrera = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    rbSi = new javax.swing.JRadioButton();
    rbNo = new javax.swing.JRadioButton();
    btnGuardar = new javax.swing.JButton();
    btnModificar = new javax.swing.JButton();
    btnEliminar = new javax.swing.JButton();
    btnLimpiar = new javax.swing.JButton();
    jLabel5 = new javax.swing.JLabel();
    txtIdPlan = new javax.swing.JTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Escuela o Área Academica");

    jLabel1.setBackground(new java.awt.Color(153, 204, 255));
    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel1.setText("Registro de Escuela o Área Academica");

    tblCarreras.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Nombre Carrera", "Codigo Carrera", "Es escuela", "Plan de estudio"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, true, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    tblCarreras.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        tblCarrerasMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(tblCarreras);

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de la Ecuela o Área Academica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel2.setText("Nombre:");

    txtNombreCarrera.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel3.setText("Código:  ");

    txtCodigoCarrera.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel4.setText("¿Es una escuela?:");

    rbSi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    rbSi.setText("Si");

    rbNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    rbNo.setText("No");

    btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnGuardar.setText("Guardar");
    btnGuardar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnGuardarActionPerformed(evt);
      }
    });

    btnModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnModificar.setText("Modificar");

    btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnEliminar.setText("Eliminar");

    btnLimpiar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnLimpiar.setText("Limpiar");

    jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel5.setText("Plan de Estudio");

    txtIdPlan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addComponent(btnModificar)
            .addGap(20, 20, 20)
            .addComponent(btnEliminar)
            .addGap(24, 24, 24))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(rbSi, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbNo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel2)
                  .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(txtCodigoCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                  .addComponent(txtNombreCarrera))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(btnLimpiar)
          .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(txtIdPlan))
        .addGap(29, 29, 29))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel2)
              .addComponent(txtNombreCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel3)
              .addComponent(txtCodigoCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(22, 22, 22)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel4)
              .addComponent(rbSi)
              .addComponent(rbNo)))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel5)
            .addGap(9, 9, 9)
            .addComponent(txtIdPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnGuardar)
          .addComponent(btnModificar)
          .addComponent(btnEliminar)
          .addComponent(btnLimpiar))
        .addGap(27, 27, 27))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jLabel1)
        .addGap(72, 72, 72))
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(32, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 23, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(12, 12, 12))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents
/**
 * Método del boton guardar de la ventana Escuela guarda los datos ingresados 
 * @param evt 
 */
  private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    String nombreCarrera = txtNombreCarrera.getText();
    String codigoCarrera = txtCodigoCarrera.getText();
    String idPlan = txtIdPlan.getText();
    int esEscuela;
    if(rbSi.isSelected()==true){
      esEscuela=1;
    }else if(rbNo.isSelected()==true){
      esEscuela=0;
    }else{
      esEscuela=0;
    }
    
    try{
      Connection con = Conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("INSERT INTO EscuelaOArea (codigoCarrera, nombreCarrera, tieneEscuela, idPlan) VALUES (?,?,?,?)");
      ps.setString(1, codigoCarrera);
      ps.setString(2, nombreCarrera);
      ps.setInt(3, esEscuela);
      ps.setString(4, idPlan);
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null,"Registro guardado");
      limpiar();
      cargarTabla();
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null,e.toString());
    }
  }//GEN-LAST:event_btnGuardarActionPerformed

  private void tblCarrerasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCarrerasMouseClicked
    try{
      int fila = tblCarreras.getSelectedRow();
      int id = Integer.parseInt(tblCarreras.getValueAt(fila,0).toString());
      
      Connection con = Conexion.getConexion();
      ps = con.prepareStatement("SELECT nombreCarrera, codigoCarrera, tieneEscuela,"
          +"idPlan from EscuelaOArea WHRE codigoCarrera=?");
      ps.setString(1,codigoCarrera)
      rs = ps.executeQuery();
      
    }catch(){
      
    }
  }//GEN-LAST:event_tblCarrerasMouseClicked

  /**
   * Limpia la tabla de la ventana Escuela
   */
  private void limpiar(){
    txtNombreCarrera.setText("");
    txtCodigoCarrera.setText("");
    txtIdPlan.setText("");
    btnGr.clearSelection(); 
  }
  /**
   * Carga los datos de la tabla de la ventana Escuela
   */
  private void cargarTabla(){
    DefaultTableModel modeloTabla = (DefaultTableModel) tblCarreras.getModel();
    modeloTabla.setRowCount(0);
    
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    
    int [] anchos = {10, 50, 100, 30, 100};
    for(int i = 0 ; i < tblCarreras.getColumnCount(); i++){
      tblCarreras.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
    }
    
    try{
      Connection con = Conexion.getConexion();
      ps = con.prepareStatement("SELECT nombreCarrera, codigoCarrera, tieneEscuela,"
          +"idPlan from EscuelaOArea");
    
      rs = ps.executeQuery();
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
      
      System.out.println("Error en el catch de escuela");
      JOptionPane.showMessageDialog(null,e);
    }
  }
  
  
  
  /**
   * Método main de la ventana Escuela
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
      java.util.logging.Logger.getLogger(Escuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Escuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Escuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Escuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Escuela().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnEliminar;
  private javax.swing.JButton btnGuardar;
  private javax.swing.JButton btnLimpiar;
  private javax.swing.JButton btnModificar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JRadioButton rbNo;
  private javax.swing.JRadioButton rbSi;
  private javax.swing.JTable tblCarreras;
  private javax.swing.JTextField txtCodigoCarrera;
  private javax.swing.JTextField txtIdPlan;
  private javax.swing.JTextField txtNombreCarrera;
  // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplicacion;

import SQL.Conexion;
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
 * Clase de la creación de la ventana ConsultaCorequisitos
 * dedicada para la consulta de correquisitos de un curso
 * @author Alejandra
 * @author Paola
 * @author Josue
 * @version 1.0
 */
public class ConsultaCorequisitos extends javax.swing.JFrame {

  Conexion c = new Conexion("");
  ButtonGroup btnGr;
  /**
   * Creates new form ConsultaCorequisitos
   */
  public ConsultaCorequisitos() {
    initComponents();
    obtenerCodigoCursos();
  }
  
  public void obtenerCodigoCursos(){
    ResultSet rs;
    try {
      c.connect();
      
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Selecciones un curso");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      //PreparedStatement st = connect.prepareStatement("SELECT codigoCurso from Curso order by nombreCurso");
      PreparedStatement st = connect.prepareStatement("SELECT nombreCurso from Requisito");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("nombreCurso"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } cmbNombreCurso.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
    c.close();
  }
  
  private void cargarTablaPlanEstudio(){
    DefaultTableModel modeloTabla = (DefaultTableModel) tblCorequisitos.getModel();
    modeloTabla.setRowCount(0);
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    String nombreCarrera = cmbNombreCurso.getSelectedItem().toString();

    
    
    int [] anchos = {10, 50, 100, 30, 100};
    for(int i = 0 ; i < tblCorequisitos.getColumnCount(); i++){
      tblCorequisitos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
    }
    
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName="
              + "Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT cursoCorrequisito FROM Requisito WHERE Requisito.nombreCurso = '"+nombreCarrera+"'");
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
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    tblCorequisitos = new javax.swing.JTable();
    jPanel1 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    cmbNombreCurso = new javax.swing.JComboBox<>();
    jButton1 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("ConsultaCorequisito");

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel1.setText("Consulta de Corequisitos de un Curso");
    jLabel1.setToolTipText("");

    tblCorequisitos.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Corequisitos"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class
      };
      boolean[] canEdit = new boolean [] {
        false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(tblCorequisitos);

    jPanel1.setToolTipText("");

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel2.setText("Curso");

    cmbNombreCurso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jButton1.setText("Buscar Corequisitos");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(57, 57, 57)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(cmbNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(72, 72, 72)
            .addComponent(jButton1)))
        .addContainerGap(57, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap(29, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(cmbNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(31, 31, 31)
        .addComponent(jButton1)
        .addGap(19, 19, 19))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(73, 73, 73)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addGap(81, 81, 81)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jLabel1)
              .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addContainerGap(165, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addGap(35, 35, 35)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGap(18, 18, 18)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(46, 46, 46))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    cargarTablaPlanEstudio();
  }//GEN-LAST:event_jButton1ActionPerformed

  /**
   * @param args the command line arguments
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
      java.util.logging.Logger.getLogger(ConsultaCorequisitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(ConsultaCorequisitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(ConsultaCorequisitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(ConsultaCorequisitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new ConsultaCorequisitos().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JComboBox<String> cmbNombreCurso;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable tblCorequisitos;
  // End of variables declaration//GEN-END:variables
}

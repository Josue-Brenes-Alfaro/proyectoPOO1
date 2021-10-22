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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author farol
 */
public class Consulta1 extends javax.swing.JFrame {
  Conexion c = new Conexion("");

  /**
   * Creates new form Consulta1
   */
  public Consulta1() {
    initComponents();
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
    jLabel2 = new javax.swing.JLabel();
    txtIdPlan = new javax.swing.JTextField();
    btnPDF = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    tblCursos = new javax.swing.JTable();
    jScrollPane2 = new javax.swing.JScrollPane();
    tblCantCreditos = new javax.swing.JTable();
    btnConsultarPlan = new javax.swing.JButton();
    jScrollPane3 = new javax.swing.JScrollPane();
    tblCantCursos = new javax.swing.JTable();
    jScrollPane4 = new javax.swing.JScrollPane();
    tblEscuela = new javax.swing.JTable();
    btnPDF1 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel1.setText("CONSULTAR PLANES DE ESTUDIO");

    jLabel2.setText("Código del plan de estudio");

    txtIdPlan.setToolTipText("");
    txtIdPlan.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtIdPlanActionPerformed(evt);
      }
    });

    btnPDF.setText("Generar PDF y enviar por correo");
    btnPDF.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnPDFActionPerformed(evt);
      }
    });

    tblCursos.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null}
      },
      new String [] {
        "codigoCurso", "nombreCurso", "numBloque", "horasLectivas", "cantidadCreditos"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false, true, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(tblCursos);

    tblCantCreditos.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null},
        {null},
        {null},
        {null}
      },
      new String [] {
        "Cantidad Créditos"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane2.setViewportView(tblCantCreditos);
    if (tblCantCreditos.getColumnModel().getColumnCount() > 0) {
      tblCantCreditos.getColumnModel().getColumn(0).setHeaderValue("Escuela o Área");
    }

    btnConsultarPlan.setText("Consultar Plan ");
    btnConsultarPlan.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnConsultarPlanActionPerformed(evt);
      }
    });

    tblCantCursos.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null},
        {null},
        {null},
        {null}
      },
      new String [] {
        "Cantidad Cursos"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane3.setViewportView(tblCantCursos);
    if (tblCantCursos.getColumnModel().getColumnCount() > 0) {
      tblCantCursos.getColumnModel().getColumn(0).setHeaderValue("Escuela o Área");
    }

    tblEscuela.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null},
        {null, null},
        {null, null},
        {null, null}
      },
      new String [] {
        "Escuela o Área", "Fecha Vigencia"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane4.setViewportView(tblEscuela);
    if (tblEscuela.getColumnModel().getColumnCount() > 0) {
      tblEscuela.getColumnModel().getColumn(0).setHeaderValue("Escuela o Área");
      tblEscuela.getColumnModel().getColumn(1).setHeaderValue("Fecha Vigencia");
    }

    btnPDF1.setText("Regresar");
    btnPDF1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnPDF1ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(51, 51, 51)
            .addComponent(jLabel2)
            .addGap(18, 18, 18)
            .addComponent(txtIdPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(45, 45, 45)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(btnConsultarPlan)
            .addGap(80, 80, 80))))
      .addGroup(layout.createSequentialGroup()
        .addGap(136, 136, 136)
        .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(btnPDF1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(136, 136, 136))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jLabel1)
        .addGap(314, 314, 314))
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(txtIdPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(btnConsultarPlan, javax.swing.GroupLayout.Alignment.TRAILING))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(41, 41, 41)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnPDF)
          .addComponent(btnPDF1))
        .addGap(14, 14, 14))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_btnPDFActionPerformed

  private void txtIdPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPlanActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_txtIdPlanActionPerformed

  private void btnConsultarPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarPlanActionPerformed
    String idPlan =txtIdPlan.getText();
    c.connect();
      cargarTabla(idPlan);
      cargarTablaCreditos(idPlan);
      cargarTablaCursos(idPlan);
      cargarTablaEscuela(idPlan);
      c.close();
  }//GEN-LAST:event_btnConsultarPlanActionPerformed

  private void btnPDF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDF1ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_btnPDF1ActionPerformed

  private void cargarTabla(String idPlan){
    DefaultTableModel modeloTabla = (DefaultTableModel) tblCursos.getModel();
    modeloTabla.setRowCount(0);
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    
    int [] anchos = {10, 50, 100, 30, 100};
    for(int i = 0 ; i < tblCursos.getColumnCount(); i++){
      tblCursos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
    }
    
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT  a.codigoCurso,a.nombreCurso, b.numBloque, a.horasLectivas, a.cantidadCreditos FROM Curso AS a\n" +
                                                      "INNER JOIN CursosPorPlan AS b\n" +
                                                      "ON ( a.codigoCurso= b.codigoCurso)\n" +
                                                      "WHERE b.idPlan= '"+ idPlan +"'");
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
  
  
    private void cargarTablaCreditos(String idPlan){
    DefaultTableModel modeloTabla = (DefaultTableModel) tblCantCreditos.getModel();
    modeloTabla.setRowCount(0);
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    
    int [] anchos = {10, 50, 100, 30, 100};
    for(int i = 0 ; i < tblCantCreditos.getColumnCount(); i++){
      tblCantCreditos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
    }
    
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT SUM(cantidadCreditos) AS cantidadCreditosPlan FROM Curso AS a\n" +
                                                      "INNER JOIN CursosPorPlan AS b\n" +
                                                      "ON ( a.codigoCurso= b.codigoCurso)" +
                                                      "WHERE b.idPlan= '"+ idPlan +"'");
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
    
    private void cargarTablaCursos(String idPlan){
    DefaultTableModel modeloTabla = (DefaultTableModel) tblCantCursos.getModel();
    modeloTabla.setRowCount(0);
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    
    int [] anchos = {10, 50, 100, 30, 100};
    for(int i = 0 ; i < tblCantCursos.getColumnCount(); i++){
      tblCantCursos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
    }
    
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT COUNT(*) AS cantidadCursosPlan FROM CursosPorPlan\n" +
"                                                      WHERE CursosPorPlan.idPlan= '"+ idPlan +"'");
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
    

  private void cargarTablaEscuela(String idPlan){
    DefaultTableModel modeloTabla = (DefaultTableModel) tblEscuela.getModel();
    modeloTabla.setRowCount(0);
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    
    int [] anchos = {10, 50, 100, 30, 100};
    for(int i = 0 ; i < tblEscuela.getColumnCount(); i++){
      tblEscuela.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
    }
    
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT  a.nombreCarrera, c.fechaVigencia FROM EscuelaOArea AS a\n" +
                                                      "INNER JOIN PlanesPorEscuela AS b\n" +
                                                      "ON ( a.codigoCarrera= b.codigoCarrera)\n" +
                                                      "INNER JOIN PlanDeEstudio AS c\n" +
                                                      "ON ( c.idPlan= b.idPlan)\n" +
                                                      "WHERE b.idPlan= '"+ idPlan +"'");
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
      java.util.logging.Logger.getLogger(Consulta1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Consulta1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Consulta1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Consulta1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Consulta1().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnConsultarPlan;
  private javax.swing.JButton btnPDF;
  private javax.swing.JButton btnPDF1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JScrollPane jScrollPane4;
  private javax.swing.JTable tblCantCreditos;
  private javax.swing.JTable tblCantCursos;
  private javax.swing.JTable tblCursos;
  private javax.swing.JTable tblEscuela;
  private javax.swing.JTextField txtIdPlan;
  // End of variables declaration//GEN-END:variables
}

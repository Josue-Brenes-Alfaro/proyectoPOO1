/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplicacion;

import SQL.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Clase de la creación de la ventana Consulta2
 * dedicada para las consultas de plan de estudio segun curso
 * @author Paola
 * @version 1.0
 */
public class Consulta2 extends javax.swing.JFrame {
  Conexion c = new Conexion("");

  /**
   * crea el nuevo formulario consulta y agrega color de fondo
   */
  public Consulta2() {
    initComponents();
    obtenerCodigoCursos();
    this.getContentPane().setBackground(new Color(223,255,255));
  }
  
  /**
   * Método para insertar el código de los cursos en el
   * combobox llamado cbxCursos
   */
  public void obtenerCodigoCursos(){
    ResultSet rs;
    try {
      c.connect();
      
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Selecciones un curso");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      //PreparedStatement st = connect.prepareStatement("SELECT codigoCurso from Curso order by nombreCurso");
      PreparedStatement st = connect.prepareStatement("SELECT codigoCurso from Curso order by codigoCurso");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("codigoCurso"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } cmbNombreCursos.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
    c.close();
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
    jScrollPane1 = new javax.swing.JScrollPane();
    tblCursos = new javax.swing.JTable();
    btnConsultarPlan = new javax.swing.JButton();
    btnVolver = new javax.swing.JButton();
    cmbNombreCursos = new javax.swing.JComboBox<>();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    setSize(new java.awt.Dimension(1000, 470));

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel1.setText("CONSULTAR PLAN DE ESTUDIO POR CURSO");

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel2.setText("Nombre del Curso:");

    tblCursos.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String [] {
        "ID plan", "Escuela o Carrera", "Bloque", "Fecha Vigencia"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false, true
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(tblCursos);

    btnConsultarPlan.setBackground(new java.awt.Color(69, 119, 186));
    btnConsultarPlan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnConsultarPlan.setText("Consultar Plan ");
    btnConsultarPlan.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnConsultarPlanActionPerformed(evt);
      }
    });

    btnVolver.setBackground(new java.awt.Color(69, 119, 186));
    btnVolver.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnVolver.setText("Regresar");
    btnVolver.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnVolverActionPerformed(evt);
      }
    });

    cmbNombreCursos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1)
        .addContainerGap())
      .addGroup(layout.createSequentialGroup()
        .addGap(48, 48, 48)
        .addComponent(jLabel2)
        .addGap(18, 18, 18)
        .addComponent(cmbNombreCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(61, 61, 61)
        .addComponent(btnConsultarPlan)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(299, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(243, 243, 243))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(19, 19, 19))))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addGap(41, 41, 41)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(btnConsultarPlan)
          .addComponent(cmbNombreCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(14, 14, 14)
        .addComponent(btnVolver)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
   *Este metodo contiene un evento de accion que al apretarlo
   * carga la tabla de consultas en el formulario
   * @param evt
   */
  private void btnConsultarPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarPlanActionPerformed
    String nombreCurso = cmbNombreCursos.getSelectedItem().toString();
    c.connect();
      cargarTabla(nombreCurso);
      c.close();
  }//GEN-LAST:event_btnConsultarPlanActionPerformed

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
   *Este metodo carga la consulta de cursos sql en la tabla
   * y la muestra en la aplicacion
   * @param idPlan
   */  
  private void cargarTabla(String nombreCurso){
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
      PreparedStatement st = connect.prepareStatement("SELECT  a.idPlan, d.nombreCarrera, b.numBloque,a.fechaVigencia FROM PlanDeEstudio AS a\n" +
                                                      "INNER JOIN CursosPorPlan AS b\n" +
                                                      "    ON ( a.idPlan= b.idPlan)\n" +
                                                      "	INNER JOIN PlanesPorEscuela AS c\n" +
                                                      "    ON ( a.idPlan= c.idPlan)\n" +
                                                      "		INNER JOIN EscuelaOArea AS d\n" +
                                                      "    ON ( c.codigoCarrera= d.codigoCarrera)\n" +
                                                      "WHERE b.codigoCurso= '"+ nombreCurso +"'");

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
   * Metodo principal de la clase consulta
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
      java.util.logging.Logger.getLogger(Consulta2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Consulta2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Consulta2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Consulta2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>

    /* crea y muestra el form*/
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Consulta2().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnConsultarPlan;
  private javax.swing.JButton btnVolver;
  private javax.swing.JComboBox<String> cmbNombreCursos;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable tblCursos;
  // End of variables declaration//GEN-END:variables
}

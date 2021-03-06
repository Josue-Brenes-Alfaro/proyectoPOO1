package aplicacion;

import logicadenegocios.EscuelaOArea;
import SQL.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
/**
 * Clase de la creación de la ventana Escuela
 * dedicada para la creacion de nuevas escuelas o áreas académicas
 * @author Josue
 * @version 1.0
 */
public class Escuela extends javax.swing.JFrame {
  EscuelaOArea carrera = new EscuelaOArea();
  Conexion c = new Conexion("");
  ButtonGroup btnGr;
  /**
   * Creaciones de la ventana Escuela
   */
  public Escuela() {
    initComponents();
    btnGr = new ButtonGroup();
    btnGr.add(rbNo);
    btnGr.add(rbSi);
    cargarTablaCarreras();
    this.getContentPane().setBackground(new Color(223,255,255));
  }
  
  /**
   * Este metodo Se encarga de que no se repita el nombre de las escuelas
   * @param pNombreEscuela 
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

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    tblCarreras = new javax.swing.JTable();
    jPanel1 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    txtNombreCarrera = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    rbSi = new javax.swing.JRadioButton();
    rbNo = new javax.swing.JRadioButton();
    btnGuardar = new javax.swing.JButton();
    btnLimpiar = new javax.swing.JButton();
    btnVolver = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("RegistroCarreras");
    setSize(new java.awt.Dimension(1000, 470));

    jLabel1.setBackground(new java.awt.Color(153, 204, 255));
    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel1.setText("Registro de Escuela o Área Academica");

    tblCarreras.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Nombre Carrera", "Codigo Carrera", "Es escuela"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(tblCarreras);

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de la Ecuela o Área Academica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel2.setText("Nombre:");

    txtNombreCarrera.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel4.setText("¿Es una escuela?:");

    rbSi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    rbSi.setText("Si");

    rbNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    rbNo.setText("No");

    btnGuardar.setBackground(new java.awt.Color(69, 119, 186));
    btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnGuardar.setText("Guardar");
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

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(txtNombreCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(rbSi, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbNo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        .addContainerGap(133, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(26, 26, 26)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(txtNombreCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(45, 45, 45)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(rbSi)
          .addComponent(rbNo))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnGuardar)
          .addComponent(btnLimpiar))
        .addGap(27, 27, 27))
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
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(193, 193, 193)
        .addComponent(btnVolver)
        .addGap(23, 23, 23))
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(310, 310, 310)
            .addComponent(jLabel1))
          .addGroup(layout.createSequentialGroup()
            .addGap(215, 215, 215)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(264, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(6, 6, 6)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(11, 11, 11)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(btnVolver)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
 * Método del botón guardar de la ventana Escuela guarda los datos ingresados 
 * @param evt 
 */
  private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    String nombreCarrera = txtNombreCarrera.getText();
    String codigoCarrera = generarCodigoEscuela(nombreCarrera);
    int esEscuela;
    if(rbSi.isSelected()==true){
      esEscuela=1;
    }else if(rbNo.isSelected()==true){
      esEscuela=0;
    }else{
      esEscuela=0;
    }
    c.connect();
    carrera.guardarDatosDeCarrera(nombreCarrera, codigoCarrera, esEscuela);
    Limpiar();
    cargarTablaCarreras();
    c.close();
  }//GEN-LAST:event_btnGuardarActionPerformed

/**
 * Metodo del botón Limpiar el cual llama al metodo limpiar.
 * @param evt 
 */
  private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
    Limpiar();
  }//GEN-LAST:event_btnLimpiarActionPerformed
 
  /**
   *Este metodo contiene un evento de accion (boton) que al apretarlo
   * regresa al menu principal
   * @param evt
   */
  private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
    Menu verMenu = new Menu();    
    verMenu.setVisible(true);
    this.setVisible(false);
  }//GEN-LAST:event_btnVolverActionPerformed
  /**
   * metodo para limpiar los textbox de carrera
   */ 
  public void Limpiar(){
    txtNombreCarrera.setText("");
    btnGr.clearSelection();
 }
  /**
   * Carga los datos de la tabla de la ventana Escuela
   */
  private void cargarTablaCarreras(){
    DefaultTableModel modeloTabla = (DefaultTableModel) tblCarreras.getModel();
    modeloTabla.setRowCount(0);
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    
    int [] anchos = {10, 50, 100, 30, 100};
    for(int i = 0 ; i < tblCarreras.getColumnCount(); i++){
      tblCarreras.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
    }
    c.connect();
    carrera.cargaDeDatosEnTablaCarreras(modeloTabla);
    c.close();
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
  private javax.swing.JButton btnGuardar;
  private javax.swing.JButton btnLimpiar;
  private javax.swing.JButton btnVolver;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JRadioButton rbNo;
  private javax.swing.JRadioButton rbSi;
  private javax.swing.JTable tblCarreras;
  private javax.swing.JTextField txtNombreCarrera;
  // End of variables declaration//GEN-END:variables

}

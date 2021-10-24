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
 * Clase de la creación de la ventana Cursos
 * dedicada para la gestion de cursos
 * @author Alejandra
 * @version 1.0
 */
public class Cursos extends javax.swing.JFrame {
  Conexion c = new Conexion("");
  /**
   * crea el nuevo formulario  y agrega color de fondo
   */
  public Cursos() {
    initComponents();
    cargarTablaCursos ();
    cargarCmbCatiCreditos ();
    cargarCmbHorasLectivas ();
    obtenerNombreEscuela ();
    cargarCodigoCursoEliminado();
    this.getContentPane().setBackground(new Color(223,255,255));
  }
  
   public void cargarCodigoCursoEliminado() {
    ResultSet rs;
    try {
      c.connect();
      
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Seleccione un codigo");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT codigoCurso  from Curso");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("codigoCurso"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } cmbCodigoCursoParaEliminar.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    } c.close();
  }
  
  /**
   * Método para insertar el código de los creditos en el
   * combobox
   */  
  public void cargarCmbCatiCreditos () {
    for(int inicial = 1; inicial < 11; inicial++) {
      String numCadena= inicial+"";
      comBxCantiCreditos.addItem(numCadena );
    }
  }
  /**
   * Método para insertar la cantidad de las horas en el
   * combobox
   */  
  public void cargarCmbHorasLectivas () {
    for(int inicial = 1; inicial < 25; inicial++) {
      String numCadena= inicial+"";
    comBxHorasLectivas.addItem(numCadena );
    }
  }
  
  /**
   * Método para insertar el nombre de la escuela en el
   * combobox
   */    
  public void obtenerNombreEscuela () {
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Selecciones una clave");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT * from EscuelaOArea order by nombreCarrera");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("nombreCarrera"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } comBxEscuelaOAreaCargo.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
  
  /**
   * Método para insertar la cantidad de cursos en el
   * combobox
   */    
  public void cargarCantidadCursos () {
    ResultSet rs;
    try {
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT COUNT (*) AS cantidadCursos FROM Curso");
      rs = st.executeQuery();
    
      try {
        if(rs.next()) {
       //Si hay resultados obtengo el valor. 
        this.cantidadCursos= rs.getInt(1);
     } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      }
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
  
  /**
   * Este Método genera un codigo para curso no repetido
   * @param pNombreEscuela
   */   
  public String generarCodigoCurso (String pNombreEscuela ){
    int largo = pNombreEscuela.length();
    String ini=" ";
    String xx=pNombreEscuela.substring(0, 1);;
    String x="";
    String xxx="";
      for (int i = 0; i <largo; i++) {
        x=pNombreEscuela.substring(i,i+1);
        if (x.equals(ini)) { 
          xxx=pNombreEscuela.substring(i+1, i+2);
          xx=xx+xxx+this.cantidadCursos;
        }     
      } return xx;
  }
  
  /**
   * Este Método genera un codigo para escuela no repetido
   * @param pNombreEscuela
   */   
  public String generarCodigoEscuelaCurso (String pNombreEscuela ){
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
   * metodo para limpiar los textbox
   */ 
  private void limpiarCursos(){
    txtNombreCurso.setText("");
  }
  
  /**
   *Este metodo carga la consulta de cursos sql en la tabla
   * y la muestra en la aplicacion
   */  
  private void cargarTablaCursos (){
    DefaultTableModel modeloTabla = (DefaultTableModel) tblCursos.getModel();
    modeloTabla.setRowCount(0);
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    
    int [] anchos = {10, 50, 100, 30, 100};
    for(int i = 0 ; i < tblCursos.getColumnCount(); i++){
      tblCursos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
    } try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT codigoCurso , nombreCurso , cantidadCreditos, horasLectivas  from Curso");
      rs = st.executeQuery();
      rsmd = rs.getMetaData();
      columnas = rsmd.getColumnCount();
      
      while(rs.next()){
        Object[] fila = new Object[columnas];
        for(int indice=0; indice<columnas; indice++){
          fila[indice]=rs.getObject(indice+1);
        } modeloTabla.addRow(fila);
      }
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
    jLabel2 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    tblCursos = new javax.swing.JTable();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    comBxEscuelaOAreaCargo = new javax.swing.JComboBox<>();
    txtNombreCurso = new javax.swing.JTextField();
    comBxCantiCreditos = new javax.swing.JComboBox<>();
    comBxHorasLectivas = new javax.swing.JComboBox<>();
    btnGuardarCurso = new javax.swing.JButton();
    btnLimpiarCurso = new javax.swing.JButton();
    btnRegresarCursos = new javax.swing.JButton();
    btnEliminarCurso = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    cmbCodigoCursoParaEliminar = new javax.swing.JComboBox<>();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Cursos");
    setSize(new java.awt.Dimension(1000, 470));

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel1.setText("Registro de cursos");

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel2.setText("Escuela o área propietaria del curso:");

    tblCursos.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String [] {
        "Código", "Nombre", "Créditos", "Horas lectivas"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(tblCursos);

    jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel4.setText("Nombre del curso:");

    jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel5.setText("Cantidad de créditos:");

    jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel6.setText("Horas lectivas:");

    comBxEscuelaOAreaCargo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    comBxEscuelaOAreaCargo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        comBxEscuelaOAreaCargoActionPerformed(evt);
      }
    });

    txtNombreCurso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    comBxCantiCreditos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    comBxHorasLectivas.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        comBxHorasLectivasActionPerformed(evt);
      }
    });

    btnGuardarCurso.setBackground(new java.awt.Color(69, 119, 186));
    btnGuardarCurso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnGuardarCurso.setText("Guardar");
    btnGuardarCurso.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnGuardarCursoActionPerformed(evt);
      }
    });

    btnLimpiarCurso.setBackground(new java.awt.Color(69, 119, 186));
    btnLimpiarCurso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnLimpiarCurso.setText("Limpiar");
    btnLimpiarCurso.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnLimpiarCursoActionPerformed(evt);
      }
    });

    btnRegresarCursos.setBackground(new java.awt.Color(69, 119, 186));
    btnRegresarCursos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnRegresarCursos.setText("Regresar");
    btnRegresarCursos.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnRegresarCursosActionPerformed(evt);
      }
    });

    btnEliminarCurso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnEliminarCurso.setText("Eliminar");
    btnEliminarCurso.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnEliminarCursoActionPerformed(evt);
      }
    });

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel3.setText("Código del curso:");

    cmbCodigoCursoParaEliminar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(136, 136, 136)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
        .addComponent(btnRegresarCursos)
        .addGap(49, 49, 49))
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(169, 169, 169)
            .addComponent(jLabel1))
          .addGroup(layout.createSequentialGroup()
            .addGap(284, 284, 284)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(btnLimpiarCurso)
                .addGap(57, 57, 57)
                .addComponent(btnGuardarCurso)
                .addGap(59, 59, 59)
                .addComponent(btnEliminarCurso))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(comBxCantiCreditos, 0, 132, Short.MAX_VALUE)
                  .addComponent(comBxHorasLectivas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(122, 122, 122)))))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(jLabel2)
        .addGap(29, 29, 29)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(comBxEscuelaOAreaCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(cmbCodigoCursoParaEliminar, 0, 333, Short.MAX_VALUE)
          .addComponent(txtNombreCurso))
        .addGap(213, 213, 213))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(btnRegresarCursos))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(comBxEscuelaOAreaCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel2))
            .addGap(17, 17, 17)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel3)
              .addComponent(cmbCodigoCursoParaEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel4)
              .addComponent(txtNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(comBxCantiCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel5))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(comBxHorasLectivas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel6))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(btnGuardarCurso)
              .addComponent(btnLimpiarCurso)
              .addComponent(btnEliminarCurso))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(47, 47, 47))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void comBxEscuelaOAreaCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comBxEscuelaOAreaCargoActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_comBxEscuelaOAreaCargoActionPerformed

  /**
   *Este metodo guarda la informacion administrada en la base de datos
   * y la muestra en la aplicacion
   * @param evt
   */  
  private void btnGuardarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCursoActionPerformed
    String escuelaIng = comBxEscuelaOAreaCargo.getSelectedItem().toString();
    String codigoEscuelaIng = generarCodigoEscuelaCurso (escuelaIng);
      
    String codigoCursoIng = generarCodigoCurso (escuelaIng );
    String nombreCursoIng = txtNombreCurso.getText();
    int cantidadCreditosIng = Integer.parseInt(comBxCantiCreditos.getSelectedItem().toString());
    int horasLectivasIng =  Integer.parseInt(comBxHorasLectivas.getSelectedItem().toString());
    this.cantidadCursos++;
      
    try {
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("INSERT INTO Curso VALUES ('"+ codigoCursoIng +"','"+ nombreCursoIng +"',"+ cantidadCreditosIng +","+ horasLectivasIng +","+ cantidadCursos +")");
      st.executeUpdate();
    } catch (SQLException ex) {
     System.err.println(ex.getMessage());
    } try {
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      System.out.println(codigoEscuelaIng);
      PreparedStatement st = connect.prepareStatement("INSERT INTO CursosPorEscuela VALUES ('"+ codigoEscuelaIng +"','"+ codigoCursoIng +"')");
      st.executeUpdate();
      JOptionPane.showMessageDialog(null,"Registro guardado");
      limpiarCursos();
      cargarTablaCursos ();
      //c.close();
    } catch (SQLException ex) {
     System.err.println(ex.getMessage());
    } 
  }//GEN-LAST:event_btnGuardarCursoActionPerformed
  /**
   * metodo para limpiar los textbox de curso
   */ 
  private void btnLimpiarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCursoActionPerformed
    limpiarCursos();
  }//GEN-LAST:event_btnLimpiarCursoActionPerformed
 
  /**
   *Este metodo contiene un evento de accion que al apretarlo
   * regresa al menu principal
   * @param evt
   */
  private void btnRegresarCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarCursosActionPerformed
    Menu verMenu = new Menu();    
    verMenu.setVisible(true);
    this.setVisible(false);
  }//GEN-LAST:event_btnRegresarCursosActionPerformed

  private void comBxHorasLectivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comBxHorasLectivasActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_comBxHorasLectivasActionPerformed
  /**
   * Metodo que al ser accionado elimina un curso del registro
   * @param evt 
   */
  private void btnEliminarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCursoActionPerformed
    String codigoCursoPorEliminar = cmbCodigoCursoParaEliminar.getSelectedItem().toString();
    
    int cantidadCreditosIng = Integer.parseInt(comBxCantiCreditos.getSelectedItem().toString());
    this.cantidadCursos++;
      
    try {
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("DELETE FROM Curso "
          + "WHERE codigoCurso = '"+codigoCursoPorEliminar+"'");
      st.executeUpdate();
      cargarTablaCursos ();
    } catch (SQLException ex) {
     System.err.println(ex.getMessage());
    }  
  }//GEN-LAST:event_btnEliminarCursoActionPerformed

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
      java.util.logging.Logger.getLogger(Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Cursos().setVisible(true);
      }
    });
  }
  
  private int cantidadCursos; 
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnEliminarCurso;
  private javax.swing.JButton btnGuardarCurso;
  private javax.swing.JButton btnLimpiarCurso;
  private javax.swing.JButton btnRegresarCursos;
  private javax.swing.JComboBox<String> cmbCodigoCursoParaEliminar;
  private javax.swing.JComboBox<String> comBxCantiCreditos;
  private javax.swing.JComboBox<String> comBxEscuelaOAreaCargo;
  private javax.swing.JComboBox<String> comBxHorasLectivas;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable tblCursos;
  private javax.swing.JTextField txtNombreCurso;
  // End of variables declaration//GEN-END:variables
}

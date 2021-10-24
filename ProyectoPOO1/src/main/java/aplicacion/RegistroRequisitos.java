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
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logicadenegocios.EscuelaOArea;
/**
 * Clase de la creación de la ventana RegistroRequisitos
 * dedicada para el registro de nuevos requisitos de un curso
 * @author Alejandra
 * @author Paola
 * @author Josue
 * @version 1.0
 */
public class RegistroRequisitos extends javax.swing.JFrame {

  Conexion c = new Conexion("");
  ButtonGroup btnGr;  
  /**
   * crea el nuevo formulario y agrega color de fondo
   */
  public RegistroRequisitos() {
    initComponents();
    obtenerNombreEscuelaRe ();
    cargarRequistroRequisitos();
    this.getContentPane().setBackground(new Color(223,255,255));
  }
  
    /**
   * Método para extraer las primeras letras de una oración.
   * @param pNombreEscuela
   * @return las iniciales de una oració
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
   * Método para insertar el nombre de las escuelas en el
   * combobox  
   */  
  public void obtenerNombreEscuelaRe() {
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Selecciones una escuela");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT * from EscuelaOArea order by nombreCarrera");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("nombreCarrera"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } comBxEscuelaAreaRequisitos.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
  
  /**
   * Método para insertar el codigo de los cursosRE en el
   * combobox  
   */  
  public void obtenerCodigoCursoRequisito() {
    ResultSet rs;
    String nombreCarrera = comBxEscuelaAreaRequisitos.getSelectedItem().toString();
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
      } comBxRequisito.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
    c.close();
  }
  /**
   * Método para insertar el codigo de los cursosCO en el
   * combobox  
   */  
  public void obtenerCodigoCursoCorrequistio() {
    ResultSet rs;
    String nombreCarrera = comBxEscuelaAreaRequisitos.getSelectedItem().toString();
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
      } comBxCorrequisito.setModel(listaModelo);
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

    jLabel4 = new javax.swing.JLabel();
    btnVolver = new javax.swing.JButton();
    jLabel5 = new javax.swing.JLabel();
    comBxEscuelaAreaRequisitos = new javax.swing.JComboBox<>();
    comBxCodigoCursoRequisitos = new javax.swing.JComboBox<>();
    comBxRequisito = new javax.swing.JComboBox<>();
    comBxCorrequisito = new javax.swing.JComboBox<>();
    btnGuardarRequisito = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    tblRegistroRequisitos = new javax.swing.JTable();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    btnCargarCursos = new javax.swing.JButton();
    btnCargarRequisitos = new javax.swing.JButton();
    btnCargarCorrequisitos = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setAutoRequestFocus(false);
    setBackground(new java.awt.Color(204, 255, 255));
    setSize(new java.awt.Dimension(1000, 470));

    jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel4.setText("Requisitos del curso:");

    btnVolver.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnVolver.setText("Regresar");
    btnVolver.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnVolverActionPerformed(evt);
      }
    });

    jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel5.setText("Correquisitos del curso:");

    comBxEscuelaAreaRequisitos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    comBxCodigoCursoRequisitos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    comBxRequisito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    comBxRequisito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No tiene" }));
    comBxRequisito.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        comBxRequisitoActionPerformed(evt);
      }
    });

    comBxCorrequisito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    comBxCorrequisito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No tiene" }));
    comBxCorrequisito.setToolTipText("");

    btnGuardarRequisito.setBackground(new java.awt.Color(69, 119, 186));
    btnGuardarRequisito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnGuardarRequisito.setText("Guardar");
    btnGuardarRequisito.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnGuardarRequisitoActionPerformed(evt);
      }
    });

    tblRegistroRequisitos.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Curso", "Curso Requisito", "Curso Correquisito"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(tblRegistroRequisitos);

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel1.setText("Asignar requisitos y Correquisitos");

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel2.setText("Escuela o área propietaria del curso:");

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel3.setText("Código del curso:");

    btnCargarCursos.setBackground(new java.awt.Color(69, 119, 186));
    btnCargarCursos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnCargarCursos.setText("Cargar cursos");
    btnCargarCursos.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCargarCursosActionPerformed(evt);
      }
    });

    btnCargarRequisitos.setBackground(new java.awt.Color(69, 119, 186));
    btnCargarRequisitos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnCargarRequisitos.setText("Cargar Cursos Requisitos");
    btnCargarRequisitos.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCargarRequisitosActionPerformed(evt);
      }
    });

    btnCargarCorrequisitos.setBackground(new java.awt.Color(69, 119, 186));
    btnCargarCorrequisitos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnCargarCorrequisitos.setText("Cargar Cursos Correquisitos");
    btnCargarCorrequisitos.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCargarCorrequisitosActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(423, 903, Short.MAX_VALUE)
        .addComponent(btnVolver)
        .addContainerGap())
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(266, 266, 266))
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(369, 369, 369)
            .addComponent(jLabel1))
          .addGroup(layout.createSequentialGroup()
            .addGap(164, 164, 164)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jLabel4)
              .addComponent(jLabel5)
              .addComponent(jLabel3)
              .addComponent(jLabel2))
            .addGap(37, 37, 37)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addGroup(layout.createSequentialGroup()
                .addComponent(comBxCorrequisito, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCargarCorrequisitos))
              .addGroup(layout.createSequentialGroup()
                .addComponent(comBxRequisito, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCargarRequisitos))
              .addGroup(layout.createSequentialGroup()
                .addComponent(comBxCodigoCursoRequisitos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCargarCursos))
              .addComponent(comBxEscuelaAreaRequisitos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(btnGuardarRequisito)
            .addGap(289, 289, 289)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(comBxEscuelaAreaRequisitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(24, 24, 24)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(comBxCodigoCursoRequisitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnCargarCursos))
        .addGap(39, 39, 39)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(comBxRequisito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnCargarRequisitos))
        .addGap(29, 29, 29)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel5)
          .addComponent(comBxCorrequisito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnCargarCorrequisitos))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
        .addComponent(btnGuardarRequisito)
        .addGap(18, 18, 18)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(8, 8, 8)
        .addComponent(btnVolver)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents
  
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
   *Este metodo registra la informacion de la tabla requisitos en sql
   */  
  private void btnGuardarRequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarRequisitoActionPerformed
    String codigoCurso = this.comBxCodigoCursoRequisitos.getSelectedItem().toString();
    String codigoCursoReque = comBxRequisito.getSelectedItem().toString();
    String codigoCursoCorre = comBxCorrequisito.getSelectedItem().toString();

    try {
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://"
              + ";databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("INSERT INTO Requisito "
              + "VALUES ( '"+ codigoCurso + "','"+ codigoCursoReque +""
                      + "','"+ codigoCursoCorre +"')");
      
      
      st.executeUpdate();
      JOptionPane.showMessageDialog(null,"Registro guardado");
      cargarRequistroRequisitos();
    }
    catch (SQLException ex) {
      System.err.println(ex.getMessage());
    }
  }//GEN-LAST:event_btnGuardarRequisitoActionPerformed

  /**
   *Este metodo carga la consulta de requisitos sql en la tabla
   * y la muestra en la aplicacion
   */  
    private void cargarRequistroRequisitos(){
    DefaultTableModel modeloTabla = (DefaultTableModel) tblRegistroRequisitos.getModel();
    modeloTabla.setRowCount(0);
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;

    int [] anchos = {10, 50, 100, 30, 100};
    for(int i = 0 ; i < tblRegistroRequisitos.getColumnCount(); i++){
      tblRegistroRequisitos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
    }
    
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName="
              + "Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("Select * from Requisito");
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
   *Este metodo carga la consulta de cursos sql en la tabla
   * y la muestra en la aplicacion
   */  
  private void btnCargarCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarCursosActionPerformed
    ResultSet rs;
    String nombreCarrera = comBxEscuelaAreaRequisitos.getSelectedItem().toString();
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
      } comBxCodigoCursoRequisitos.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
    c.close();
  }//GEN-LAST:event_btnCargarCursosActionPerformed
  /**
   * Método para accionar el botón de CargarRequisitos
   * @param evt 
   */
  private void btnCargarRequisitosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarRequisitosActionPerformed
    obtenerCodigoCursoRequisito();
  }//GEN-LAST:event_btnCargarRequisitosActionPerformed

  /**
   * Método para accionar el botón de CargarCoRequisitos
   * @param evt 
   */
  private void btnCargarCorrequisitosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarCorrequisitosActionPerformed
    obtenerCodigoCursoCorrequistio();
  }//GEN-LAST:event_btnCargarCorrequisitosActionPerformed

  private void comBxRequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comBxRequisitoActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_comBxRequisitoActionPerformed

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
      java.util.logging.Logger.getLogger(RegistroRequisitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(RegistroRequisitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(RegistroRequisitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(RegistroRequisitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new RegistroRequisitos().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnCargarCorrequisitos;
  private javax.swing.JButton btnCargarCursos;
  private javax.swing.JButton btnCargarRequisitos;
  private javax.swing.JButton btnGuardarRequisito;
  private javax.swing.JButton btnVolver;
  private javax.swing.JComboBox<String> comBxCodigoCursoRequisitos;
  private javax.swing.JComboBox<String> comBxCorrequisito;
  private javax.swing.JComboBox<String> comBxEscuelaAreaRequisitos;
  private javax.swing.JComboBox<String> comBxRequisito;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable tblRegistroRequisitos;
  // End of variables declaration//GEN-END:variables
}

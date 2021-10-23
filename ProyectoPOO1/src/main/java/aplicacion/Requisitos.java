/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package aplicacion;

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
 *
 * @author Pol_D
 */
public class Requisitos extends javax.swing.JPanel {

  /**
   * Creates new form Requisitos
   */
  public Requisitos() {
    initComponents();
    cargarTablaRequisitosCorrequisitos ();
    obtenerNombreEscuelaRe ();
    obtenerCodigoCurso ();
    obtenerCodigoCursoRequisito ();
    obtenerCodigoCursoCorrequistio ();
    
    
  }
  
  public void obtenerNombreEscuelaRe () {
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
  
  public void obtenerCodigoCurso () {
    String codigoEscuelaConsu = this.comBxEscuelaAreaRequisitos.getSelectedItem().toString();
    
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Seleccione una escuela");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT * from CursosPorEscuela "
                                                      +"WHERE codigoCarrera = '"+codigoEscuelaConsu +"' "
                                                      + "order by codigoCurso ");
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
  }
  
  public void obtenerCodigoCursoRequisito () {
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Selecciones una escuela");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT * from Curso order by codigoCurso ");
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
  }
  
  public void obtenerCodigoCursoCorrequistio () {
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Selecciones una escuela");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT * from Curso order by codigoCurso ");
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
  }
  
  private void cargarTablaRequisitosCorrequisitos (){
    DefaultTableModel modeloTabla = (DefaultTableModel) tblRequisitos.getModel();
    modeloTabla.setRowCount(0);
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    
    int [] anchos = {10, 50, 100, 30, 100};
    for(int i = 0 ; i < tblRequisitos.getColumnCount(); i++){
      tblRequisitos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
    } try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT nombreCurso  , nombreCurso , cursoRequisito , cursoCorrequisito   from Requisito");
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
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    comBxEscuelaAreaRequisitos = new javax.swing.JComboBox<>();
    comBxCodigoCursoRequisitos = new javax.swing.JComboBox<>();
    comBxRequisito = new javax.swing.JComboBox<>();
    comBxCorrequisito = new javax.swing.JComboBox<>();
    btnGuardarRequisito = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    tblRequisitos = new javax.swing.JTable();
    btnEliminarRequisitoCurso = new javax.swing.JButton();
    btnRegresarRequisitos = new javax.swing.JButton();
    btnPDF1 = new javax.swing.JButton();

    setName(""); // NOI18N

    jLabel1.setText("Asignar requisitos");

    jLabel2.setText("Escuela o área propietaria del curso");

    jLabel3.setText("Código del curso");

    jLabel4.setText("Requisitos del curso");

    jLabel5.setText("Correquisitos del curso");

    comBxEscuelaAreaRequisitos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    comBxCodigoCursoRequisitos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    comBxRequisito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    comBxCorrequisito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    btnGuardarRequisito.setText("Guardar");
    btnGuardarRequisito.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnGuardarRequisitoActionPerformed(evt);
      }
    });

    tblRequisitos.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null},
        {null, null, null},
        {null, null, null},
        {null, null, null}
      },
      new String [] {
        "Código del curso ", "Código del requisito", "Código del correquisito"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.String.class
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }
    });
    jScrollPane1.setViewportView(tblRequisitos);

    btnEliminarRequisitoCurso.setText("Eliminar");

    btnRegresarRequisitos.setText("Volver");

    btnPDF1.setText("Regresar");
    btnPDF1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnPDF1ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                  .addGroup(layout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addComponent(btnGuardarRequisito)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarRequisitoCurso))
                  .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel2)
                    .addGap(75, 75, 75)))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(btnRegresarRequisitos)
                  .addComponent(comBxEscuelaAreaRequisitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(comBxCodigoCursoRequisitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(comBxRequisito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(comBxCorrequisito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
          .addGroup(layout.createSequentialGroup()
            .addGap(155, 155, 155)
            .addComponent(jLabel1)))
        .addContainerGap(19, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(btnPDF1)
        .addGap(176, 176, 176))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addGap(23, 23, 23)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(comBxEscuelaAreaRequisitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(24, 24, 24)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(comBxCodigoCursoRequisitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(40, 40, 40)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(comBxRequisito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(30, 30, 30)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel5)
          .addComponent(comBxCorrequisito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(21, 21, 21)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnGuardarRequisito)
          .addComponent(btnEliminarRequisitoCurso)
          .addComponent(btnRegresarRequisitos))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(btnPDF1)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void btnGuardarRequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarRequisitoActionPerformed
    String codigoCurso = this.comBxCodigoCursoRequisitos.getSelectedItem().toString();
    String codigoCursoReque = comBxRequisito.getSelectedItem().toString();
    String codigoCursoCorre = comBxCorrequisito.getSelectedItem().toString();
    
    try {
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("INSERT INTO Requisito VALUES ( "+ codigoCurso + ","+ codigoCursoReque +","+ codigoCursoCorre +")");
      st.executeUpdate();
      JOptionPane.showMessageDialog(null,"Registro guardado");
      cargarTablaRequisitosCorrequisitos ();
      //c.close();
    } 
    catch (SQLException ex) {
     System.err.println(ex.getMessage());
    }
  }//GEN-LAST:event_btnGuardarRequisitoActionPerformed

  private void btnPDF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDF1ActionPerformed
    Menu verMenu = new Menu();    
    verMenu.setVisible(true);
    this.setVisible(false);
  }//GEN-LAST:event_btnPDF1ActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnEliminarRequisitoCurso;
  private javax.swing.JButton btnGuardarRequisito;
  private javax.swing.JButton btnPDF1;
  private javax.swing.JButton btnRegresarRequisitos;
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
  private javax.swing.JTable tblRequisitos;
  // End of variables declaration//GEN-END:variables
}

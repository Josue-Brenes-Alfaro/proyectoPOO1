/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

 import com.itextpdf.text.Document;
 import com.itextpdf.text.DocumentException;
 import com.itextpdf.text.pdf.PdfPTable;
 import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
/**
 *
 * @author Paola Lopez
 */
public class PDF {
    public static void generarPDF(String idPlan) { 

       Document documento = new Document();
       
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Escritorio/Reporte_Alumnos.pdf"));
            documento.open();
            
            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Código Curso");
            tabla.addCell("Nombre Curso");
            tabla.addCell("Bloque");
            tabla.addCell("Horas Lectivas");
            tabla.addCell("Cantidad Créditos");

            try {
                Connection cn = DriverManager.getConnection("jdbc:sqlserver://;databaseName=Proyecto_POO1;user=usuariosql;password=root1");
                PreparedStatement pst = cn.prepareStatement("SELECT  a.codigoCurso,a.nombreCurso, b.numBloque, a.horasLectivas, a.cantidadCreditos FROM Curso AS a\n" +
                                                      "INNER JOIN CursosPorPlan AS b\n" +
                                                      "ON ( a.codigoCurso= b.codigoCurso)\n" +
                                                      "WHERE b.idPlan= '"+ idPlan +"'");

                
                ResultSet rs = pst.executeQuery();
                
                if(rs.next()){
                                       
                    do {                        
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));

                    } while (rs.next());
                    documento.add(tabla);                    
                }
                
            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        }

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

/**
 *
 * @author Josue
 */
public class mainprueba {
  Conexion c = new Conexion("");
  
  public void main(String[] args){
    c.connect();
    c.close();
  }  
}

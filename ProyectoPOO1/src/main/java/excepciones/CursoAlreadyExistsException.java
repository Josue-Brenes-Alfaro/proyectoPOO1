/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 * Esta es una abstraccion de la clase CursoAlreadytExistsException con fines 
 * academicos
 * @author Alejandra Merino
 * @author Paola López
 * @author Josué Brenes
 * @version 1.0
 */
public class CursoAlreadyExistsException extends Exception {
  private String codigoCurso;

  public CursoAlreadyExistsException(String codigoCurso) {
    this.codigoCurso = codigoCurso;
  }
  
  @Override
  public String toString() {
    return "Error: el curso con codigo:  " + codigoCurso +" ya existe";
  }
}

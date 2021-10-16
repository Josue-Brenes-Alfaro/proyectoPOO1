package logicadenegocios;

import logicadenegocios.EscuelaOArea; 
import logicadenegocios.Requisito; 
/**
 * Esta es una abstraccion de la clase Cursos con fines academicos
 * @author Alejandra
 * @author Paola
 * @author Josue
 * @version 1.0
 */
public class Curso {
  private String codigoCurso;
  private String nombreCurso;
  private int cantidadCreditos;
  private int horasLectivas;
  private int numBloque;
  private static int cantidadCursos=0;
  private EscuelaOArea escuelaOAreaACargo;
  private Requisito requisito;
  
  /**
   * Metodo constructor de objetos de la clase Curso
   * @param pCodigoCurso
   * @param pNombreCurso
   * @param pCantidadCreditos
   * @param pHorasLectivas
   * @param pEscuelaOAreaACargo 
   */
  public Curso(String pCodigoCurso, String pNombreCurso, int pCantidadCreditos, int pHorasLectivas, EscuelaOArea pEscuelaOAreaACargo) {
    this.codigoCurso = pCodigoCurso;
    this.nombreCurso = pNombreCurso;
    this.cantidadCreditos = pCantidadCreditos;
    this.horasLectivas = pHorasLectivas;
    this.escuelaOAreaACargo = pEscuelaOAreaACargo;
    this.cantidadCreditos++;
  }
  
  /**
   * Metodo que agrega requisitos a un objeto de la clase Curso
   * @param pRequisito 
   */
  public void agregarRequisito (Requisito pRequisito) {
    this.requisito = pRequisito;
  }
  
  /**
   * Metodo que agrega un numero de bloque a objetos de la clase Curso
   * @param pNumBloque 
   */
  public void agregarNumBloque (int pNumBloque) {
    this.numBloque = pNumBloque;
  }

  /**
   * 
   * @return cadena como String
   */
  public String toString() {
    String cadena = "";
    cadena = "Cédigo del curso: " + codigoCurso + "\n";
    cadena+= "Nombre del curso: " + nombreCurso + "\n";
    cadena+= "Cantidad de créditos: " + cantidadCreditos + "\n";
    cadena+= "Horas lectivas: " + horasLectivas + "\n";
    cadena+= "Némero de bloque: " + numBloque + "\n";
    cadena+= "Escuela o Area Académica a cargo: " + numBloque + "\n";        
    cadena+= "Requisitos: " + requisito + "\n";
    
    return cadena;
  }
}

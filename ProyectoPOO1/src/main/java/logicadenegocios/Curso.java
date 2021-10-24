package logicadenegocios;

import excepciones.CursoDoesNotExistsException;
import interfaces.InterfaceCurso;
import java.util.ArrayList;
import logicadenegocios.EscuelaOArea; 
 
/**
 * Esta es una abstraccion de la clase Cursos con fines academicos
 * @author Alejandra Merino
 * @author Paola López
 * @author Josué Brenes
 * @version 1.0
 */
public class Curso implements InterfaceCurso{
  private String codigoCurso;
  private String nombreCurso;
  private int cantidadCreditos;
  private int horasLectivas;
  private int numBloque;
  private static int cantidadCursos=0;
  private EscuelaOArea escuelaOAreaACargo;
  private ArrayList<Curso> cursosRequisitos;
  private ArrayList<Curso> cursosCorrequisitos;
  
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
   *Este metodo elimina toda informacion de un curso
   * @param pCodigoCurso
   */  
  public void eliminarRequisito(String pCodigoCurso){
  //aqui se debe eliminar el curso, pero primero hay que buscar si existe.
  //lanzaria un error si no existe.
  }
  
  /**
   *Este metodo busca toda informacion de un curso
   * @param pCodigoCurso
   */  
  public Curso buscarCurso (String pCodigoCurso) throws CursoDoesNotExistsException {
    for (Curso cursoActual: cursosRequisitos) {
      if(cursoActual.getCodigoCurso().equals(pCodigoCurso))
        return cursoActual;
    } throw new CursoDoesNotExistsException(pCodigoCurso);
  }
  
  /**
   *Este metodo verifica la existencia de un codigo curso
   * @param pCodigoCurso
   */  
  public boolean existeCurso (String pCodigoCurso){
    for(Curso cursoActual: cursosRequisitos) {
      if(cursoActual.getCodigoCurso().equals(pCodigoCurso))
        return true;
    } return false;
  }
  /**
   *Este metodo busca toda informacion de un cursoCorrequisito
   * @param pCodigoCurso
   */  
  public Curso buscarCursoCorrequisito (String pCodigoCurso) throws CursoDoesNotExistsException {
    for (Curso cursoActual: cursosCorrequisitos) {
      if(cursoActual.getCodigoCurso().equals(pCodigoCurso))
        return cursoActual;
    } throw new CursoDoesNotExistsException(pCodigoCurso);
  }
  
  /**
   *Este metodo busca la existencia de un cursoCorrequisito
   * @param pCodigoCurso
   */  
  public boolean existeCursoCorrequisito (String pCodigoCurso){
    for(Curso cursoActual: cursosCorrequisitos) {
      if(cursoActual.getCodigoCurso().equals(pCodigoCurso))
        return true;
    } return false;
  }

  /**
   * Meotdo que imprime un mensaje con la informacion de un curso.
   * @return cadena como String
   */
  public String toString() {
    String cadena = "";
    cadena = "Código del curso: " + codigoCurso + "\n";
    cadena+= "Nombre del curso: " + nombreCurso + "\n";
    cadena+= "Cantidad de créditos: " + cantidadCreditos + "\n";
    cadena+= "Horas lectivas: " + horasLectivas + "\n";
    cadena+= "Número de bloque: " + numBloque + "\n";
    cadena+= "Escuela o Area Académica a cargo: " + numBloque + "\n";
    cadena+= "Cursos requisitos: \n";
    for(Curso cursoImprime: cursosRequisitos){
      cadena+= "Codigo curso: " + cursoImprime.getCodigoCurso() +"\n";
      cadena+= "Nombre curso: " + cursoImprime.getNombreCurso()+"\n";
    }
    cadena+= "Cursos correquisitos: \n";
    for(Curso cursoImprime: cursosCorrequisitos){
      cadena+= "Codigo curso: " + cursoImprime.getCodigoCurso() +"\n";
      cadena+= "Nombre curso: " + cursoImprime.getNombreCurso()+"\n";
    }
    return cadena;
  }

  //Metodos accesores
  public void setCursoRequisito(Curso pRequisito) {
    this.cursosRequisitos.add(pRequisito);
  }
  public void setCursoCorrerequisito (Curso pCorrequisito) {
    this.cursosCorrequisitos.add(pCorrequisito);
  }
  public void setNumBloque (int pNumBloque) {
    this.numBloque = pNumBloque;
  }
  public void setCantidadCreditos(int pCantidadCreditos) {
    this.cantidadCreditos = pCantidadCreditos;
  }
  public void setHorasLectivas(int pHorasLectivas) {
    this.horasLectivas = pHorasLectivas;
  }
  public void setNombreCurso(String pNombreCurso) {
    this.nombreCurso = pNombreCurso;
  }
  
  public int getNumBloque() {
    return numBloque;
  }
  public String getNombreCurso() {
    return nombreCurso;
  }
  public int getCantidadCreditos() {
    return cantidadCreditos;
  }
  public int getHorasLectivas() {
    return horasLectivas;
  }
  public static int getCantidadCursos() {
    return cantidadCursos;
  }
 
  public String getCodigoCurso() {
    return codigoCurso;
  }
}

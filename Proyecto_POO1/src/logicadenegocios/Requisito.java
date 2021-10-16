package logicadenegocios;

import logicadenegocios.Requisito;
import java.util.*;

/**
 * Esta es una abstracción de la clase Requisito con fines académicos  
 * @author Alejandra
 * @author Paola
 * @author Josue
 * @version 1.0
 */
public class Requisito {
  private ArrayList<Curso> cursosRequisitos;
  private ArrayList<Curso> cursosCorrequisitos;
  private Curso cursoPertenece;

  public Requisito(Curso pCursoPertenece, Curso pCursoRequisito, Curso pCursoCorrequisito) {
    this.cursoPertenece = pCursoPertenece;
  }
  
  public void agregarCursoRequisito (Curso pRequisito) {
    this.cursosRequisitos.add(pRequisito);
  }
  
  public void agregarCursoCorrerequisito (Curso pCorrequisito) {
    this.cursosCorrequisitos.add(pCorrequisito);
  }
  
  public void eliminarRequisito(String pCodigoCurso){
  //aqui se debe eliminar el curso, pero primero hay que buscar si existe.
  //lanzaria un error si no existe.
  }
  
}
package logicadenegocios;

import java.util.ArrayList;

/**
 * 
 * @author Alejandra
 * @author Paola
 * @author Josue
 * @version 1.0
 */
public class EscuelaOArea {
  private String codigoCarrera;
  private String nombreCarrera;
  private boolean tieneEscuela;
  private ArrayList<Curso> misCursos;

  public void agregarCurso(Curso pCurso) {
    misCursos.add(pCurso);
  }
}

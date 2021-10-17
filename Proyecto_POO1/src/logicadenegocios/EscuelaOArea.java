package logicadenegocios;

import java.util.ArrayList;
import interfaces.InterfaceCurso;

/**
 * 
 * @author Alejandra Merino
 * @author Paola López
 * @author Josué Brenes
 * @version 1.0
 */
public class EscuelaOArea implements InterfaceCurso {
  private String codigoCarrera;
  private String nombreCarrera;
  private boolean tieneEscuela;
  private ArrayList<Curso> misCursos;

  public void agregarCurso(Curso pCurso) {
    misCursos.add(pCurso);
  }
}
package logicadenegocios;

/**
 *
 * @author Josue
 */
public class Bloque {

  private String curso;
  private int id;

  /**
   * 
   * @param curso
   * @param id 
   */
  public Bloque(String curso, int id) {
    this.curso = curso;
    this.id = id;
  }

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }

  public void setId(int id) {
    this.id = id;
  }
  
  
  
}

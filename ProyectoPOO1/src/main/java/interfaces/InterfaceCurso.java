/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.CursoDoesNotExistsException;
import logicadenegocios.Curso; 

/**
 * Esta es una abtracción de la clase InterfaceCurso que declara métodos de
 * búsqueda de cursos para las clases que lo requieren.
 * @author Alejandra Merino
 * @author Paola López
 * @author Josué Brenes
 * @version 1.0
 */
public interface InterfaceCurso {
  public abstract Curso buscarCurso (String pCodigoCurso) throws CursoDoesNotExistsException;
  public abstract boolean existeCurso (String pCodigoCurso);
  
}

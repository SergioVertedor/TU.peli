package model.dao;

import model.Work;
import java.util.List;

/** Interface para Work */
public interface WorkInt extends CommonDaoInt<Work> {
  /**
   * Busca Work por id
   *
   * @param title Título de la obra
   * @return Work con el título dado
   */
  public List<Work> searchByTitle(final String title);
}

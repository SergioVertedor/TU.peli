package model.dao;

import java.util.List;
import model.Pelicula;

/** Interfaz con el DAO generico, CommonDaoInt y la interfaz PeliculaInt */
public interface PeliculaDAOInt extends CommonDAOInt<Pelicula> {
  /**
   * Busca Pelicula por título
   *
   * @param title
   * @return
   */
  public List<Pelicula> searchByTitle(String title);
}

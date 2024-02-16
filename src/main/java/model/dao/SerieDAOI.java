package model.dao;

import java.util.List;
import model.Serie;

/** Interface para Serie */
public interface SerieDAOI extends CommonDAOInt<Serie> {

  /**
   * Busca Serie por id
   *
   * @param idSerie
   * @return Serie con id dada
   */
  public Serie searchById(final int idSerie);

  /**
   * Busca Series por titulo
   *
   * @param title
   * @return Series con el titulo dado
   */
  public List<Serie> searchByTitle(final String title);

  /**
   * Busca Series con una duración menor a la indicada
   *
   * @param runtime
   * @return Series con duración menor a la indicada
   */
  public List<Serie> searchByLessRuntime(final Integer runtime);

  /**
   * Busca Series por género
   *
   * @param genre
   * @return Series del género indicado
   */
  public List<Serie> searchByGenre(final String genre);

  /**
   * Busca Series por pais
   *
   * @param country
   * @return Series del pais indicado
   */
  public List<Serie> searchByCountry(final String country);

  /**
   * Busca Series por nombre
   *
   * @param name del nombre
   * @return
   */
  public Serie getSerie(String name);
}

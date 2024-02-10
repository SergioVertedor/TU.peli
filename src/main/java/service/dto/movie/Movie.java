package service.dto.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Movie {
  private boolean adult;
  private String backdropPath;
  private int[] genre_ids;
  private int id;
  private String original_language;
  private String original_title;
  private String overview;
  private double popularity;
  private String poster_path;
  private String release_date;
  private String title;
  private boolean video;
  private double vote_average;
  private int vote_count;

}

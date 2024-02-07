package service.dto.trendingmovie;

import java.util.List;

import lombok.Data;

@Data
public class TrendingMovie {
  private boolean adult;
  private String backdrop_path;
  private int id;
  private String title;
  private String original_language;
  private String original_title;
  private String overview;
  private String poster_path;
  private String media_type;
  private List<Integer> genre_ids;
  private double popularity;
  private String release_date;
  private boolean video;
  private double vote_average;
  private int vote_count;

  // Getters y setters
}

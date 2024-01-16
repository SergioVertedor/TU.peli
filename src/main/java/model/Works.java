package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Works {
  private int idWork;
  private String originalTitle;
  private LocalDate releaseDate;
  private Set<Genres> genres;
  private Integer runtime;
  private String overview;
  private String backdropPath;
  private String posterPath;
  private Double popularity;
  private LocalDate lastViewDate;
  private String userComment;
}

package utils;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import service.dto.movie.Movie;
import service.dto.tv.TV;

public class ListStorage {
  @Setter @Getter private static List<Movie> trendingMovies = new ArrayList<>();
  @Setter @Getter private static List<TV> trendingSeries = new ArrayList<>();
}

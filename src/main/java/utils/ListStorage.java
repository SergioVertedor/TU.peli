package utils;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import service.dto.trendingmovie.TrendingMovie;
import service.dto.tv.TV;

public class ListStorage {
  @Setter @Getter private static List<TrendingMovie> trendingTrendingMovies;
  @Setter @Getter private static List<TV> trendingSeries;
}

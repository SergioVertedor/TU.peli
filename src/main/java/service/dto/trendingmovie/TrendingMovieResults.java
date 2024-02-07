package service.dto.trendingmovie;

import java.util.List;

import lombok.*;

@Data
public class TrendingMovieResults {
  private int page;
  private List<TrendingMovie> results;
  private int total_pages;
  private int total_results;
}

package service.dto.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MovieSearchResult {
  private int page;
  private Movie[] results;
  private int total_pages;
  private int total_results;
}


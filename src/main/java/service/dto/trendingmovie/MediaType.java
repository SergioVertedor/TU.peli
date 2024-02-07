package service.dto.trendingmovie;

import java.io.IOException;

public enum MediaType {
  MOVIE;

  public String toValue() {
    switch (this) {
      case MOVIE: return "movie";
    }
    return null;
  }

  public static MediaType forValue(String value) throws IOException {
    if (value.equals("movie")) return MOVIE;
    throw new IOException("Cannot deserialize MediaType");
  }
}


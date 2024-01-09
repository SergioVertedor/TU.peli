package model.dto.tv;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.dto.OriginCountry;
import model.dto.OriginalLanguage;

@Getter
@AllArgsConstructor
public class TV {
    private boolean adult;
    private String backdropPath;
    private long[] genreIDS;
    private long id;
    private OriginCountry[] originCountry;
    private OriginalLanguage originalLanguage;
    private String originalName;
    private String overview;
    private double popularity;
    private String posterPath;
    private String firstAirDate;
    private String name;
    private double voteAverage;
    private long voteCount;
}

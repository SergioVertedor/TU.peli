package service.dto.tv;

import lombok.AllArgsConstructor;
import lombok.Getter;
import service.dto.OriginCountry;
import service.dto.OriginalLanguage;

@Getter
@AllArgsConstructor
public class TV {
    private boolean adult;
    private String backdrop_path;
    private int[] genre_ids;
    private int id;
    private OriginCountry[] origin_country;
    private OriginalLanguage original_language;
    private String original_name;
    private String overview;
    private double popularity;
    private String poster_path;
    private String first_air_date;
    private String name;
    private double vote_average;
    private long vote_count;
}

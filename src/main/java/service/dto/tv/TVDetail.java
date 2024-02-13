package service.dto.tv;

import lombok.AllArgsConstructor;
import lombok.Getter;
import service.dto.Genre;
import service.dto.ProductionCountry;
import service.dto.SpokenLanguage;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Getter
public class TVDetail {
    private boolean adult;
    private String backdrop_path;
    private CreatedBy[] created_by;
    private long[] episode_run_time;
    private LocalDate first_air_date;
    private Genre[] genres;
    private String homepage;
    private long id;
    private boolean in_production;
    private String[] languages;
    private LocalDate last_air_date;
    private LastEpisodeToAir last_episode_to_air;
    private String name;
    private Object nextEpisode_to_air;
    private Network[] networks;
    private long number_of_episodes;
    private long number_of_seasons;
    private String[] origin_country;
    private String original_language;
    private String original_name;
    private String overview;
    private double popularity;
    private String poster_path;
    private Network[] production_companies;
    private ProductionCountry[] production_countries;
    private Season[] seasons;
    private SpokenLanguage[] spoken_languages;
    private String status;
    private String tag_line;
    private String type;
    private double vote_average;
    private long vote_count;
}

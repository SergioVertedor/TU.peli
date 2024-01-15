package service.dto.tv;

import lombok.AllArgsConstructor;
import lombok.Getter;
import service.dto.Genre;
import service.dto.ProductionCountry;
import service.dto.SpokenLanguage;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class TVDetail {
    private boolean adult;
    private String backdropPath;
    private CreatedBy[] createdBy;
    private long[] episodeRunTime;
    private LocalDate firstAirDate;
    private Genre[] genres;
    private String homepage;
    private long id;
    private boolean inProduction;
    private String[] languages;
    private LocalDate lastAirDate;
    private LastEpisodeToAir lastEpisodeToAir;
    private String name;
    private Object nextEpisodeToAir;
    private Network[] networks;
    private long numberOfEpisodes;
    private long numberOfSeasons;
    private String[] originCountry;
    private String originalLanguage;
    private String originalName;
    private String overview;
    private double popularity;
    private String posterPath;
    private Network[] productionCompanies;
    private ProductionCountry[] productionCountries;
    private Season[] seasons;
    private SpokenLanguage[] spokenLanguages;
    private String status;
    private String tagline;
    private String type;
    private double voteAverage;
    private long voteCount;
}

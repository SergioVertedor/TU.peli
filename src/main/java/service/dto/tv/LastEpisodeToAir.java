package service.dto.tv;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class LastEpisodeToAir {
    private long id;
    private String name;
    private String overview;
    private double voteAverage;
    private long voteCount;
    private LocalDate airDate;
    private long episodeNumber;
    private String episodeType;
    private String productionCode;
    private long runtime;
    private long seasonNumber;
    private long showID;
    private String stillPath;
}

package service.dto.tv;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
public class Season {
    private LocalDate airDate;
    private long episodeCount;
    private long id;
    private String name;
    private String overview;
    private String posterPath;
    private long seasonNumber;
    private double voteAverage;
}

package service.dto.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BelongsToCollection {
    private long id;
    private String name;
    private String posterPath;
    private String backdropPath;
}

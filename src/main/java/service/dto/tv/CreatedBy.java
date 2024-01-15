package service.dto.tv;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreatedBy {
    private long id;
    private String creditID;
    private String name;
    private long gender;
    private String profilePath;
}

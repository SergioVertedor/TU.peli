package model.dto.brute.credits;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Credits {
    private long id;
    private Cast[] cast;
    private Cast[] crew;
}

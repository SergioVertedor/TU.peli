package model.dao.brute;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Credits {
    private long id;
    private Cast[] cast;
    private Cast[] crew;
}

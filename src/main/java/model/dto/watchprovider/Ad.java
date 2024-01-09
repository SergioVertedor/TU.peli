package model.dto.watchprovider;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Ad {
    private String link;
    private Flatrate[] flatrate;
}

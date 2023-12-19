package model.dao.brute;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Ag {
    private String link;
    private Flatrate[] rent;
    private Flatrate[] buy;
    private Flatrate[] flatrate;
    private Flatrate[] ads;
}

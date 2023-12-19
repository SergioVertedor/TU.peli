package model.dto.brute.tv;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Network {
    private long id;
    private String logoPath;
    private String name;
    private String originCountry;
}

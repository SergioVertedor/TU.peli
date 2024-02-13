package service.dto.tv;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Network {
    private long id;
    private String logo_path;
    private String name;
    private String originCountry;
}

package service.dto.watchprovider;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Flatrate {
    private String logo_path;
    private long provider_id;
    private String provider_name;
    private long display_priority;

}

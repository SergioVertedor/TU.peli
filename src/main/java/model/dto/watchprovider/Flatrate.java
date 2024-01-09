package model.dto.watchprovider;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Flatrate {
    private String logoPath;
    private long providerID;
    private String providerName;
    private long displayPriority;

}

package service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductionCompany {
  private long id;
  private String logo_path;
  private String name;
  private String origin_country;
}

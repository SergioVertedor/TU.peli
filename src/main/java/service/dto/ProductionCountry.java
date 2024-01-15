package service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductionCountry {
  private String iso3166_1;
  private String name;
}

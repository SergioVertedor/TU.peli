package model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductionCompany {
  private long id;
  private String logoPath;
  private String name;
  private String originCountry;
}

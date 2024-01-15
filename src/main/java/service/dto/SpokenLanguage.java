package service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SpokenLanguage {
  private String englishName;
  private String iso639_1;
  private String name;
}

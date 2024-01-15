package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Casting {
  private int idCasting;
  private String castName;
  private String character;
  private int castOrder;
  private String profilePath;
}

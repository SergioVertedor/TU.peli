package service.dto;

import lombok.Getter;

import java.io.IOException;

public enum Department {
  ACTING,
  ART,
  CAMERA,
  COSTUME_MAKE_UP,
  CREW,
  DIRECTING,
  EDITING,
  PRODUCTION,
  SOUND,
  VISUAL_EFFECTS,
  WRITING;

  public String toValue() {
    switch (this) {
      case ACTING:
        return "Acting";
      case ART:
        return "Art";
      case CAMERA:
        return "Camera";
      case COSTUME_MAKE_UP:
        return "Costume & Make-Up";
      case CREW:
        return "Crew";
      case DIRECTING:
        return "Directing";
      case EDITING:
        return "Editing";
      case PRODUCTION:
        return "Production";
      case SOUND:
        return "Sound";
      case VISUAL_EFFECTS:
        return "Visual Effects";
      case WRITING:
        return "Writing";
    }
    return null;
  }

  public static Department forValue(String value) throws IOException {
    if (value.equals("Acting")) return ACTING;
    if (value.equals("Art")) return ART;
    if (value.equals("Camera")) return CAMERA;
    if (value.equals("Costume & Make-Up")) return COSTUME_MAKE_UP;
    if (value.equals("Crew")) return CREW;
    if (value.equals("Directing")) return DIRECTING;
    if (value.equals("Editing")) return EDITING;
    if (value.equals("Production")) return PRODUCTION;
    if (value.equals("Sound")) return SOUND;
    if (value.equals("Visual Effects")) return VISUAL_EFFECTS;
    if (value.equals("Writing")) return WRITING;
    throw new IOException("Cannot deserialize Department");
  }
}

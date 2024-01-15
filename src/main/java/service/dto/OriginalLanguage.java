package service.dto;

import java.io.IOException;

public enum OriginalLanguage {
  EN;

  public String toValue() {
    switch (this) {
      case EN:
        return "en";
    }
    return null;
  }

  public static OriginalLanguage forValue(String value) throws IOException {
    if (value.equals("en")) return EN;
    throw new IOException("Cannot deserialize OriginalLanguage");
  }
}

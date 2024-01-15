package service.dto;

import java.io.IOException;

public enum OriginCountry {
  GB,
  US;

  public String toValue() {
    switch (this) {
      case GB:
        return "GB";
      case US:
        return "US";
    }
    return null;
  }

  public static OriginCountry forValue(String value) throws IOException {
    if (value.equals("GB")) return GB;
    if (value.equals("US")) return US;
    throw new IOException("Cannot deserialize OriginCountry");
  }
}

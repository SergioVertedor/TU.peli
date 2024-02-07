package service.dto.trendingmovie;

import java.io.IOException;

public enum OriginalLanguage {
  EN,
  JA,
  KO,
  ZH;

  public String toValue() {
    switch (this) {
      case EN:
        return "en";
      case JA:
        return "ja";
      case KO:
        return "ko";
      case ZH:
        return "zh";
    }
    return null;
  }

  public static OriginalLanguage forValue(String value) throws IOException {
    if (value.equals("en")) return EN;
    if (value.equals("ja")) return JA;
    if (value.equals("ko")) return KO;
    if (value.equals("zh")) return ZH;
    throw new IOException("Cannot deserialize OriginalLanguage");
  }
}

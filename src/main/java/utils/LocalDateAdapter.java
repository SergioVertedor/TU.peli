package utils;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase para adaptar LocalDate a JSON
 * */
public class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
    /**
     * Clase para adaptar LocalDate a JSON
     *
     * @param date
     * @param typeOfSrc
     * @param context
     * @return JsonPrimitive
     */
    @Override
    public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // "yyyy-mm-dd"
    }

    /**
     * Clase para adaptar JSON a LocalDate
     * @param json The Json data being deserialized
     * @param typeOfT The type of the Object to deserialize to
     * @param context
     * @return
     * @throws JsonParseException
     */
    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return LocalDate.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
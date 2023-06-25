package com.akkih.books.serializing;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {
    private static final String[] DATE_FORMATS = {"dd-MM-yyyy", "yyyy-MM-dd"};

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String dateString = jsonParser.getText();
        for (String dateFormat : DATE_FORMATS) {
            try {
                return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(dateFormat));
            } catch (DateTimeParseException ignored) {
            }
        }
        throw new IOException("Failed to parse LocalDate: " + dateString);
    }
}

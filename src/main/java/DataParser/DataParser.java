package DataParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;

import java.io.IOException;

public class DataParser {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static < T > T get(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(Resources.getResource(json) , clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package dota_advisor.utils.jpa;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Map;

/**
 * Created by sf on 29.03.17.
 */
@Converter
public class JpaHeroInfoConverter implements AttributeConverter<Map<String, Object>, String> {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, Object> stringObjectMap) {
        try {
            return MAPPER.writeValueAsString(stringObjectMap);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String s) {
        try {
            return MAPPER.readValue(s, new TypeReference<Map<String, Object>>(){});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

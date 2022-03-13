package ru.metaprofile.app.APIUtils.Api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import ru.metaprofile.app.APIUtils.Exceptions.MPAPIBadResponseException;

public class JSONUtils {
    public static String convertToJSON(Object object) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json;
        try {
            json = ow.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return convertToJSON(e);
        }
        return json;
    }


    public static <T> T convertToObject(Class<T> clazz, String jsonString) throws MPAPIBadResponseException{
        try {
            ObjectMapper mapper = new ObjectMapper();
            return (T) mapper.readValue(jsonString, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MPAPIBadResponseException(jsonString);
        }
    }

}

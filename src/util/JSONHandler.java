package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import util.log.Logcat;

import java.io.IOException;

public class JSONHandler<T>{
    private T object;

    private ObjectMapper mapper = new ObjectMapper();


    public T jsonToObject(String json) throws IOException {
        object = mapper.readValue(json, (Class<T>) Object.class);

        return object;
    }

    public String objectToJson(Object object) throws JsonProcessingException {
        String json = mapper.writeValueAsString(object);

        Logcat.log(json);

        return json;
    }
}

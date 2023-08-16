package utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Board;

public class JsonToPojo {
    private static ObjectMapper objectMapper = getDefaultObjectMapper();
    
    private  static ObjectMapper getDefaultObjectMapper(){
        ObjectMapper defaultObjectMapper = new ObjectMapper();

        return defaultObjectMapper;
    }

    public static Board JSONToBoard(String json) throws JsonMappingException, JsonProcessingException{
    return  objectMapper.readValue(json, Board.class);
    }
}

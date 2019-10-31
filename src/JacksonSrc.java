import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class JacksonSrc <T>{
    JacksonSrc(Class<T> t){
        this.t = t;
    }
    private Class<T> t;
    T converter(String json){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, t);
        } catch (JsonProcessingException e){
            e.printStackTrace();
            return null;
        }
    }
}

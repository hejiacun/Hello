package Utils.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.io.IOException;
import java.util.List;
import java.util.Map;

//import org.apache.poi.ss.formula.functions.T;

public class ObjectUtils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    
    public static String object2Json(Object o) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(o);
    }
    
    public static Map<String, Object> json2Map(String json) throws IOException {
        return OBJECT_MAPPER.readValue(json, new TypeReference<Map<String, Object>>(){});
    }
    
    public static <T> T map2Object(Map<String, Object> map, Class<T> clazz) {
        return OBJECT_MAPPER.convertValue(map, clazz);
    }

    public static <T> T json2Object(String json, Class<T> clazz) throws IOException {
        return OBJECT_MAPPER.readValue(json, clazz);
    }
    
    public static <T> T object2Object(Object o, Class<T> clazz) {
        return OBJECT_MAPPER.convertValue(o, clazz);
    }
    
	public static <T> List<T> json2List(String json, Class<T> clazz) throws IOException {
		JavaType type = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class, clazz);
		return OBJECT_MAPPER.readValue(json, type);
	}

	public static Map<String,Object> object2Map(Object object) {
		return OBJECT_MAPPER.convertValue(object, new TypeReference<Map<String, Object>>() {});
	}
    /**
     * 对象转Map，驼峰转下划线
     * @param object
     * @return
     */
    public static Map<String,Object> Object2Map(Object object) {
        ObjectMapper OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        return OBJECT_MAPPER.convertValue(object, new TypeReference<Map<String, Object>>() {});
    }
}

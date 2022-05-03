package spritecn.github.bytool;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import spritecn.github.bytool.jsonlib.JSONArray;
import spritecn.github.bytool.jsonlib.JSONObject;
import spritecn.github.bytool.jsonlib.exception.ParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author zjb
 */
@SuppressWarnings("ALL")
public class JSON {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static String toJSONString(Object jsonString) {
        try {
            return objectMapper.writeValueAsString(jsonString);
        } catch (Exception e) {
            throw new ParseException(e);
        }
    }

    public static Object parse(String jsonString) {
        if (isJsonObjStr(jsonString)) {
            return parseObject(jsonString);
        }
        if (isJsonArrayStr(jsonString)) {
            return parseArray(jsonString);
        }
        try {
            return objectMapper.readValue(jsonString, JsonNode.class);
        } catch (Exception e) {
            throw new ParseException(e);
        }
    }

    public static JSONObject parseObject(String jsonString) {
        try {
            final Map map = objectMapper.readValue(jsonString, Map.class);
            return mapToJsonObject(map);
        } catch (Exception e) {
            throw new ParseException(e);
        }

    }

    public static <T> T parseObject(String jsonString, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonString, clazz);
        } catch (Exception e) {
            throw new ParseException(e);
        }
    }

    public static JSONArray parseArray(String jsonString) {
        try {
            final List list = objectMapper.readValue(jsonString, List.class);
            return listConvertToJsonArray(list);
        } catch (Exception e) {
            throw new ParseException(e);
        }
    }


    public static <T> List<T> parseArray(String jsonString, Class<T> clazz) {
        try {
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class,clazz);
            return objectMapper.readValue(jsonString, javaType);
        } catch (Exception e) {
            throw new ParseException(e);
        }
    }

    /**
     * 是否为JSON字符串，首尾都为大括号或中括号判定为JSON字符串
     *
     * @param str 字符串
     * @return 是否为JSON字符串
     */
    public static boolean isJsonStr(String str) {
        return isJsonObjStr(str) || isJsonArrayStr(str);
    }

    /**
     * 是否为JSONObject字符串，首尾都为大括号或中括号判定为JSON字符串
     *
     * @param str 字符串
     * @return 是否为JSON字符串
     */
    public static boolean isJsonObjStr(String str) {

        if (isBlank(str)) {
            return false;
        }

        if(not(isWrap(str.trim(), '{', '}'))) return false;

        try{
            parseObject(str);
            return true;
        }catch (Exception e){
            //pass
        }
        return false;
    }

    /**
     * 是否为JSONObject字符串，首尾都为大括号或中括号判定为JSON字符串
     *
     * @param str 字符串
     * @return 是否为JSON字符串
     */
    public static boolean isJsonArrayStr(String str) {
        if (isBlank(str)) {
            return false;
        }
        if(not(isWrap(str.trim(), '[', ']'))) return false;
        try{
            parseArray(str);
            return true;
        }catch (Exception e){
            //pass
        }
        return false;
    }

    private static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    private static boolean isWrap(String str, char start, char end) {
        if (isBlank(str)) {
            return false;
        }
        return str.charAt(0) == start && str.charAt(str.length() - 1) == end;
    }

    private static JSONArray listConvertToJsonArray(List list) {
        List<Object> jsonObjects = new ArrayList<>(list.size());
        for (Object obj : list) {
            jsonObjects.add(mapToJsonObject((Map<String, Object>) obj));
        }
        return new JSONArray(jsonObjects);
    }

    /**
     * jackson parse出来的是map和list,所以把map和list转换为jsonObject和jsonArray
     *
     * @param map
     * @return
     */
    private static JSONObject mapToJsonObject(Map<String, Object> map) {
        JSONObject jsonObject = new JSONObject(map.size());
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            final Object value = entry.getValue();
            if (value instanceof Map) {
                jsonObject.put(entry.getKey(), mapToJsonObject((Map<String, Object>) value));
            } else if (value instanceof List) {
                final List listVal = (List) value;
                JSONArray objects = new JSONArray(listVal.size());
                for (Object o : listVal) {
                    if (o instanceof Map) {
                        objects.add(mapToJsonObject((Map<String, Object>) o));
                    } else if (o instanceof List) {
                        objects.add(listConvertToJsonArray((List) o));
                    }
                }
                jsonObject.put(entry.getKey(), objects);
            } else {
                jsonObject.put(entry.getKey(), value);
            }
        }
        return jsonObject;
    }

    private static boolean not(Boolean v){
        if(Objects.isNull(v)) return false;
        return !v;
    }


}

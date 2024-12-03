package Facade;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonService {
    public String getAttributeValueFromJson(String json, String attribute) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(json);
        if (jsonObject.containsKey(attribute)) {
            return jsonObject.get(attribute).toString();
        } else {
            throw new IllegalArgumentException("Attribute not found in the JSON data");
        }
    }
}

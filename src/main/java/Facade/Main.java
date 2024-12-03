package Facade;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {
    public static void main(String[] args) {
        ApiFacade facade = new ApiFacade();
        try {
            String joke = facade.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value");
            System.out.println("Joke: " + joke);

            // Example of using another API
            String rateJson = facade.getAttributeValueFromJson("https://api.exchangerate-api.com/v4/latest/USD", "rates");
            JSONParser parser = new JSONParser();
            JSONObject rates = (JSONObject) parser.parse(rateJson);

            System.out.println("Exchange Rates:");
            for (Object key : rates.keySet()) {
                System.out.println(key + ": " + rates.get(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

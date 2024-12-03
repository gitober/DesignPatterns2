package Facade;

import java.io.IOException;

public class ApiFacade {
    private HttpService httpService;
    private JsonService jsonService;

    public ApiFacade() {
        this.httpService = new HttpService();
        this.jsonService = new JsonService();
    }

    public String getAttributeValueFromJson(String urlString, String attributeName) throws IllegalArgumentException, IOException {
        try {
            String json = httpService.getJsonFromUrl(urlString);
            return jsonService.getAttributeValueFromJson(json, attributeName);
        } catch (Exception e) {
            if (e instanceof IOException) {
                throw new IOException(e.getMessage());
            } else if (e instanceof IllegalArgumentException) {
                throw new IllegalArgumentException(e.getMessage());
            } else {
                throw new RuntimeException("Unexpected error: " + e.getMessage());
            }
        }
    }
}

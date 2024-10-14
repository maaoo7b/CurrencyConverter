package api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConnection {
    String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    String API_KEY = "YOUR_API_KEY_HERE";

    public String currencyCodeApi() throws IOException, InterruptedException {
        String url = BASE_URL + API_KEY + "/codes";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String currencyConverter(String baseCurrency, String targetCurrency, double amount) throws IOException, InterruptedException {
        String url = BASE_URL + API_KEY + "/pair/"+baseCurrency+"/"+targetCurrency+"/"+amount;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }
}

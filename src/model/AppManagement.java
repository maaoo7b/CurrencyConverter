package model;

import api.ApiConnection;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppManagement {
    List<Currency> currencyList;
    ApiConnection apiConnection;

    public AppManagement() {
        currencyList = new ArrayList<>();
        apiConnection = new ApiConnection();
    }

    public JsonArray getSupportedCodes() throws IOException, InterruptedException {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(apiConnection.currencyCodeApi(), JsonObject.class);
        return jsonObject.getAsJsonArray("supported_codes");
    }

    public List<Currency> currencyList(JsonArray supportedCodes) {
        List<Currency> currencyList = new ArrayList<>();
        for(JsonElement element:supportedCodes){
            JsonArray currencyData = element.getAsJsonArray();
            String code = currencyData.get(0).getAsString();
            String description = currencyData.get(1).getAsString();

            Currency currency = new Currency(code,description);
            currencyList.add(currency);
        }
        return currencyList;
    }
}

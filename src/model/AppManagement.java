package model;

import api.ApiConnection;
import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppManagement {
    List<Currency> currencyList;
    List<CurrencyHistorial> currencyHistorialList;
    ApiConnection apiConnection;
    Gson gson;

    public AppManagement() {
        currencyList = new ArrayList<>();
        currencyHistorialList = new ArrayList<>();
        apiConnection = new ApiConnection();
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public JsonArray getSupportedCodes() throws IOException, InterruptedException {
        JsonObject jsonObject = gson.fromJson(apiConnection.currencyCodeApi(), JsonObject.class);
        return jsonObject.getAsJsonArray("supported_codes");
    }

    public List<Currency> currencyList(JsonArray supportedCodes) {
        for (JsonElement element : supportedCodes) {
            JsonArray currencyData = element.getAsJsonArray();
            String code = currencyData.get(0).getAsString();
            String description = currencyData.get(1).getAsString();
            Currency currency = new Currency(code, description);
            currencyList.add(currency);
        }
        return currencyList;
    }

    public String currencyConverter(String baseCurrency, String targetCurrency, double amount) throws IOException, InterruptedException {
        return apiConnection.currencyConverter(baseCurrency, targetCurrency, amount);
    }

    public List<CurrencyHistorial> currencyHistorial(String currencyConverter, double amount) {
        Gson gson = new Gson();
        CurrencyHistorialOMDB currencyHistorialOMDB = gson.fromJson(currencyConverter, CurrencyHistorialOMDB.class);
        CurrencyHistorial currencyHistorial = new CurrencyHistorial(currencyHistorialOMDB.base_code(), currencyHistorialOMDB.target_code(), new Date(), amount, currencyHistorialOMDB.conversion_result());
        currencyHistorialList.add(currencyHistorial);
        return currencyHistorialList;
    }

    public int getListSize() {
        return currencyHistorialList.size();
    }

    public List<CurrencyHistorial> historial() {
        return currencyHistorialList;
    }

    public void generateHistorical() throws IOException {
        FileWriter fw = new FileWriter("historical.json");
        fw.write(gson.toJson(currencyHistorialList));
        fw.close();
    }
}

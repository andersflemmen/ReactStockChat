/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.hib.mod250.rest;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import no.hib.mod250.stocks.Stock;

/**
 *
 * @author Anders
 */
public class StockConsumer {

    private final Client client;
    private final WebTarget currencyTarget;

    private Calendar lastCurrencyRequest;
    private Calendar lastStockRequest;
    
    private List<Stock> currencyData;
    private String currencyDataString;
    
    private final String ALL_CURRENCIES = "http://finance.yahoo.com/webservice/v1/symbols/allcurrencies/quote?format=json&view=detail";
    private final String STOCK_START = "http://finance.yahoo.com/webservice/v1/symbols/";
    private final String STOCK_END = "/quote?format=json&view=detail";
    
    private Map<String, Stock> stockMap;
    
    private int numberOfSearches = 0;

    public StockConsumer() {
        stockMap = new HashMap<String, Stock>();
        
        client = ClientBuilder.newClient();
        currencyTarget = client.target(ALL_CURRENCIES);

        lastCurrencyRequest = Calendar.getInstance();
        
        currencyData = new ArrayList<>();
        initializeCurrencies();
    }
    
    public String getStock(String symbol) {
        numberOfSearches++;
        
        if (stockMap.containsKey(symbol)) {
            if (lastStockRequest == null || lastStockRequest.getTimeInMillis() + 10000
                    < Calendar.getInstance().getTimeInMillis()) {
                updateAllStocks();    
            }
            return stockMap.get(symbol).generateJsonString();
        }
        
        return getSingleStock(symbol);
    }

    public String getAllCurrencies() {
        if (lastCurrencyRequest.getTimeInMillis() + 10000
                < Calendar.getInstance().getTimeInMillis()) {
            lastCurrencyRequest = Calendar.getInstance();
            updateAllCurrencies();
        }
        return currencyDataString;
    }

    private void updateAllCurrencies() {
        String result = currencyTarget.request(MediaType.APPLICATION_JSON).get(String.class);
        
        JsonArray array = Json.createReader(new StringReader(result)).readObject()
                .getJsonObject("list").getJsonArray("resources");
        
        for (int i = 0; i < array.size(); i++) {
            JsonObject currency = array.getJsonObject(i).getJsonObject("resource").getJsonObject("fields");
            currencyData.get(i).updateFromJson(currency);
        }
        
        generateCurrencyDataString();
    }
    
    private void updateAllStocks() {
        StringBuilder stocks = new StringBuilder();
        
        stockMap.entrySet().stream().forEach((entry) -> {
            stocks.append(entry.getKey()).append(",");
        });
        
        WebTarget stockTarget = client.target(STOCK_START + stocks.toString() + STOCK_END);
        
        String result = stockTarget.request(MediaType.APPLICATION_JSON).get(String.class);
        
        JsonArray array = Json.createReader(new StringReader(result)).readObject()
                .getJsonObject("list").getJsonArray("resources");
        
        for (int i = 0; i < array.size(); i++) {
            JsonObject obj = array.getJsonObject(i);
            
            JsonObject fields = obj.getJsonObject("resource").getJsonObject("fields");
            stockMap.get(fields.getString("symbol")).updateFromJson(fields);
        }
    }
    
    private String getSingleStock(String symbol) {
        WebTarget stockTarget = client.target(STOCK_START + symbol + STOCK_END);
        
        String result = stockTarget.request(MediaType.APPLICATION_JSON).get(String.class);
        
        JsonArray array = Json.createReader(new StringReader(result)).readObject()
                .getJsonObject("list").getJsonArray("resources");
        
        if (array.size() > 0) {
            Stock s = new Stock();
            s.updateFromJson(array.getJsonObject(0).getJsonObject("resource").getJsonObject("fields"));
        
            stockMap.put(symbol, s);
            
            return s.generateJsonString();
        }
        
        return null;
    }
    
    private void initializeCurrencies() {
        String result = currencyTarget.request(MediaType.APPLICATION_JSON).get(String.class);
        
        JsonArray array = Json.createReader(new StringReader(result)).readObject()
                .getJsonObject("list").getJsonArray("resources");
        
        for (int i = 0; i < array.size(); i++) {
            JsonObject currency = array.getJsonObject(i).getJsonObject("resource").getJsonObject("fields");
            Stock s = new Stock();
            s.updateFromJson(currency);
            currencyData.add(s);
        }
        
        generateCurrencyDataString();
    }
    
    private void generateCurrencyDataString() {
        JsonArrayBuilder ab = Json.createArrayBuilder();
        
        for (Stock s : currencyData) {
            ab = ab.add(s.generateJson());
        }
        
        currencyDataString = Json.createObjectBuilder().add("resources", ab).build().toString();
    }
}

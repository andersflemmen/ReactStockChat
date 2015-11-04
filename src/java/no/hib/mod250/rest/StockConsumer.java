/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.hib.mod250.rest;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Anders
 */
public class StockConsumer {

    private final Client client;
    private final WebTarget currencyTarget;

    private Calendar lastCurrencyRequest;
    private Calendar lastStockRequest;
    private String currencyData;
    
    private final String ALL_CURRENCIES = "http://finance.yahoo.com/webservice/v1/symbols/allcurrencies/quote?format=json";
    private final String STOCK_START = "http://finance.yahoo.com/webservice/v1/symbols/";
    private final String STOCK_END = "/quote?format=json&view=detail";
    
    private Map<String, String> stockMap;

    public StockConsumer() {
        stockMap = new HashMap<String, String>();
        
        client = ClientBuilder.newClient();
        currencyTarget = client.target(ALL_CURRENCIES);

        lastCurrencyRequest = Calendar.getInstance();
        updateAllCurrencies();
    }
    
    public String getStock(String symbol) {
        if (stockMap.containsKey("symbol")) {
            if (lastStockRequest == null || lastStockRequest.getTimeInMillis() + 10000
                    < Calendar.getInstance().getTimeInMillis()) {
                updateAllStocks();    
            }
            return stockMap.get(symbol);
        }
        
        return getSingleStock(symbol);
    }

    public String getAllCurrencies() {
        if (lastCurrencyRequest.getTimeInMillis() + 10000
                < Calendar.getInstance().getTimeInMillis()) {
            lastCurrencyRequest = Calendar.getInstance();
            updateAllCurrencies();
        }
        return currencyData;
    }

    private void updateAllCurrencies() {
        currencyData = currencyTarget.request(MediaType.APPLICATION_JSON).get(String.class);
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
            
            String symbol = obj.getJsonObject("resource").getJsonObject("fields").getString("symbol");
            stockMap.put(symbol, obj.toString());
        }
    }
    
    private String getSingleStock(String symbol) {
        WebTarget stockTarget = client.target(STOCK_START + symbol + STOCK_END);
        
        String result = stockTarget.request(MediaType.APPLICATION_JSON).get(String.class);
        
        JsonArray array = Json.createReader(new StringReader(result)).readObject()
                .getJsonObject("list").getJsonArray("resources");
        
        if (array.size() > 0) {
            stockMap.put(symbol, array.getJsonObject(0).toString());
            
            return array.getJsonObject(0).toString();
        }
        
        return null;
    }
}

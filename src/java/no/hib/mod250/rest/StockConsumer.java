/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.hib.mod250.rest;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import no.hib.mod250.stocks.Stock;

/**
 * Class responsible for fetching data from the Yahoo Finance API.
 * 
 * @author Anders
 */
public class StockConsumer {

    private final Client client;
    private final WebTarget currencyTarget;

    private Calendar lastCurrencyRequest;
    private Calendar lastStockRequest;

    private final List<Stock> currencyData;
    private String currencyDataString;

    private final String ALL_CURRENCIES = "http://finance.yahoo.com/webservice/v1/symbols/allcurrencies/quote?format=json&view=detail";
    private final String STOCK_START = "http://finance.yahoo.com/webservice/v1/symbols/";
    private final String STOCK_END = "/quote?format=json&view=detail";

    private final Map<String, Stock> stockMap;
    
    private final int MILLISECONDS_BETWEEN_UPDATES = 10000;

    /**
     * Default constructor initializing data structures, currency web target
     * and timestamps.
     */
    public StockConsumer() {
        stockMap = new HashMap<>();

        client = ClientBuilder.newClient();
        currencyTarget = client.target(ALL_CURRENCIES);

        lastCurrencyRequest = Calendar.getInstance();

        currencyData = new ArrayList<>();
        initializeCurrencies();
    }

    /**
     * Returns single stock data as Json. May cause the server to fetch new 
     * data if enough time has passed since last update. May also return null if 
     * an invalid symbol is received.
     * 
     * @param symbol Symbol of requested stock.
     * @return Stock data as Json, or null.
     */
    public String getStock(String symbol) {
        if (stockMap.containsKey(symbol)) {
            if (lastStockRequest == null || 
                    lastStockRequest.getTimeInMillis() + MILLISECONDS_BETWEEN_UPDATES
                    < Calendar.getInstance().getTimeInMillis()) {
                updateAllStocks();
            }
            return stockMap.get(symbol.toLowerCase()).generateJsonArrayString();
        }

        return fetchSingleStock(symbol);
    }

    /**
     * Returns multiple stock data as Json. May cause the server to fetch new 
     * data if enough time has passed since last update. May also return null if 
     * only invalid symbols are received.
     * 
     * @param symbolString Symbols of requested stocks separated by commas.
     * @return Stock data as Json, or null.
     */
    public String getMultipleStocks(String symbolString) {
        String[] symbolArray = symbolString.split(",");
        JsonArrayBuilder ab = Json.createArrayBuilder();

        if (lastStockRequest == null || 
                lastStockRequest.getTimeInMillis() + MILLISECONDS_BETWEEN_UPDATES
                < Calendar.getInstance().getTimeInMillis()) {
            updateAllStocks();
        }

        for (String s : symbolArray) {

            String result = "";

            if (!stockMap.containsKey(s)) {
                result = fetchSingleStock(s);
            }
            if (result != null) {
                ab = ab.add(stockMap.get(s.toLowerCase()).generateJson());
            }
        }

        return Json.createObjectBuilder().add("resources", ab).build().toString();
    }

    /**
     * Returns all currency data as Json. May cause the server to fetch new 
     * data if enough time has passed since last update.
     * 
     * @return Currency data as Json.
     */
    public String getAllCurrencies() {
        if (lastCurrencyRequest.getTimeInMillis() + MILLISECONDS_BETWEEN_UPDATES
                < Calendar.getInstance().getTimeInMillis()) {
            lastCurrencyRequest = Calendar.getInstance();
            updateAllCurrencies();
        }
        return currencyDataString;
    }

    /**
     * Updates all currency data using the Yahoo Finance API. Updates
     * the buffer string with the new data.
     */
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

    /**
     * Updates all stock data for all stocks found in the stockMap, using the
     * Yahoo Finance API. Updates all the Stock objects kept in the map.
     */
    private void updateAllStocks() {
        StringBuilder stocks = new StringBuilder();

        if (stockMap.size() > 0) {
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
                stockMap.get(fields.getString("symbol").toLowerCase()).updateFromJson(fields);
            }
        }
    }

    /**
     * Tries to fetch a single stock from the Yahoo Finance API using the
     * provided symbol. Returns null if an invalid stock symbol is provided.
     * 
     * @param symbol Symbol of the requested stock.
     * @return Stock data as Json, or null.
     */
    private String fetchSingleStock(String symbol) {
        WebTarget stockTarget = client.target(STOCK_START + symbol + STOCK_END);

        String result = stockTarget.request(MediaType.APPLICATION_JSON).get(String.class);

        JsonArray array = Json.createReader(new StringReader(result)).readObject()
                .getJsonObject("list").getJsonArray("resources");

        if (array.size() > 0) {
            Stock s = new Stock();
            s.updateFromJson(array.getJsonObject(0).getJsonObject("resource").getJsonObject("fields"));

            stockMap.put(symbol.toLowerCase(), s);

            return s.generateJsonArrayString();
        }

        return null;
    }

    /**
     * Fetches data for all currencies using the Yahoo Finance API. Generates
     * stock objects and adds them to the currencydata list. Updates the buffer 
     * string with the received data.
     */
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

    /**
     * Iterates over all currencies and converts them into a Json string, storing
     * the result in currencyDataString.
     */
    private void generateCurrencyDataString() {
        JsonArrayBuilder ab = Json.createArrayBuilder();

        for (Stock s : currencyData) {
            ab = ab.add(s.generateJson());
        }

        currencyDataString = Json.createObjectBuilder().add("resources", ab).build().toString();
    }
}

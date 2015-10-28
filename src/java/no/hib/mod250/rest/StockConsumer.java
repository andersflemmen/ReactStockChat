/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.hib.mod250.rest;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
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
    private final WebTarget target;

    private Calendar lastRequest;
    private String result;

    public StockConsumer() {
        client = ClientBuilder.newClient();
        target = client.target("http://finance.yahoo.com/webservice/v1/symbols/allcurrencies/quote?format=json");

        lastRequest = Calendar.getInstance();
        updateStocks();
    }

    public String getStocks() {

        if (lastRequest.getTimeInMillis() + 10000
                < Calendar.getInstance().getTimeInMillis()) {
            lastRequest = Calendar.getInstance();
            updateStocks();
        }
        return result;
    }

    private void updateStocks() {
        result = target.request(MediaType.APPLICATION_JSON).get(String.class);
    }
}

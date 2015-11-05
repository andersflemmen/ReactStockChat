/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.hib.mod250.stocks;

import java.math.BigDecimal;
import java.util.Calendar;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author Anders
 */
public class Stock {

    private String name;
    private String symbol;

    private String type;
    private int volume;

    private String time;

    private double price;

    private double dayLow;
    private double dayHigh;
    private double yearLow;
    private double yearHigh;

    private double change;
    private double changePercent;

    public JsonObjectBuilder generateJson() {
        return Json.createObjectBuilder()
                .add("name", name)
                .add("symbol", symbol)
                .add("type", type)
                .add("volume", volume)
                .add("utctime", time)
                .add("price", price)
                .add("day_low", dayLow)
                .add("day_high", dayHigh)
                .add("year_low", yearLow)
                .add("year_high", yearHigh)
                .add("change", change)
                .add("chg_percent", changePercent);
    }

    public void updateFromJson(JsonObject fields) {
        try {
            name = fields.getString("name");
            symbol = fields.getString("symbol");
            type = fields.getString("type");

            try {
                volume = Integer.parseInt(fields.getString("volume"));
                price = Double.parseDouble(fields.getString("price"));

                change = Double.parseDouble(fields.getString("change"));
                changePercent = Double.parseDouble(fields.getString("chg_percent"));
                dayLow = Double.parseDouble(fields.getString("day_low"));
                dayHigh = Double.parseDouble(fields.getString("day_high"));
                yearLow = Double.parseDouble(fields.getString("year_low"));
                yearHigh = Double.parseDouble(fields.getString("year_high"));             
            } catch (NumberFormatException e) {
            } catch (NullPointerException e) {
            }

            time = fields.getString("utctime");
        } catch (NullPointerException e) {
        }
    }
    
    public String generateJsonString() {
        JsonArrayBuilder ab = Json.createArrayBuilder().add(generateJson());
        return Json.createObjectBuilder().add("resources", ab).build().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDayLow() {
        return dayLow;
    }

    public void setDayLow(double dayLow) {
        this.dayLow = dayLow;
    }

    public double getDayHigh() {
        return dayHigh;
    }

    public void setDayHigh(double dayHigh) {
        this.dayHigh = dayHigh;
    }

    public double getYearLow() {
        return yearLow;
    }

    public void setYearLow(double yearLow) {
        this.yearLow = yearLow;
    }

    public double getYearHigh() {
        return yearHigh;
    }

    public void setYearHigh(double yearHigh) {
        this.yearHigh = yearHigh;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(double changePercent) {
        this.changePercent = changePercent;
    }
}

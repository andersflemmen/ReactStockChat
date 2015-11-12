/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.hib.mod250.rest;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import no.hib.mod250.stocks.StockTestGenerator;

/**
 * Rest class responsible for serving stock data to incoming requests.
 * Uses the Yahoo Finance API through the StockConsumer class.
 * 
 * @author Anders
 */
@Singleton
@Path("stocks")
@Lock(LockType.WRITE)
public class StockFacadeREST {

    private final StockConsumer sc;
    
    private final StockTestGenerator stg;
    private int testIndex = 0;

    public StockFacadeREST() {
        sc = new StockConsumer();
        stg = new StockTestGenerator();
    }

    /**
     * REST method for fetching data for all rates converting from USD to all
     * currencies provided by the Yahoo Finance API.
     * 
     * @return List of all retrieved currencies.
     */
    @GET
    @Path("allCurrencies")
    @Produces({"application/json"})
    public String countREST() {
        return sc.getAllCurrencies();
    }

    /**
     * REST method for getting data concerning a single stock using the Yahoo
     * Finance API. If the stock is not found, an empty string is returned.
     * 
     * @param symbol Symbol of the requested stock.
     * @return Stock data as Json, or null.
     */
    @GET
    @Path("single/{symbol}")
    @Produces({"application/json"})
    public String getSingleStock(@PathParam("symbol") String symbol) {
        String result = sc.getStock(symbol);

        if (result == null) {
            return "";
        }

        return result;
    }

    /**
     * REST method for getting data concerning multiple stocks using the Yahoo
     * Finance API. If the stocks are not found, an empty string is returned.
     * 
     * @param symbols Symbols of the requested stocks.
     * @return Stock data as Json, or null.
     */
    @GET
    @Path("multi/{symbols}")
    @Produces({"application/json"})
    public String getMultipleStocks(@PathParam("symbols") String symbols) {
        String result = sc.getMultipleStocks(symbols);

        if (result == null) {
            return "";
        }

        return result;
    }
    
    @GET
    @Path("test")
    @Produces({"application/json"})
    public String getTestData() {
        return stg.getData(testIndex++);
    }
}

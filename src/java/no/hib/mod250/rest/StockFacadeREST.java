/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.hib.mod250.rest;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.json.JsonValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Anders
 */
@Singleton
@Path("stocks")
@Lock(LockType.WRITE)
public class StockFacadeREST {

    private final StockConsumer sc;

    public StockFacadeREST() {
        sc = new StockConsumer();
    }

    @GET
    @Path("allCurrencies")
    @Produces({"application/json"})
    public String countREST() {
        return sc.getAllCurrencies();
    }

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
}

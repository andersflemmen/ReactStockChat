/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.hib.mod250.rest;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Anders
 */
@Stateless
@Path("stocks")
public class StockFacadeREST {
    
    private StockConsumer sc;
    
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
        return sc.getStock(symbol);
    }
}

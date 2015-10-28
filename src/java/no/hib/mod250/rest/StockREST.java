/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.hib.mod250.rest;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Anders
 */
@Stateless
@Path("stocks")
public class StockREST {
    
    private StockConsumer sc;
    
    public StockREST() {
        sc = new StockConsumer();
    }
    
    @GET
    @Path("all")
    @Produces({"application/json"})
    public String countREST() {
        return sc.getStocks();
    }
}

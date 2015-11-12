/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.hib.mod250.rest;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * REST class responsible for serving stats to incoming GET requests.
 * Communicates with the database using the other facades.
 * 
 * @author Anders
 */
@Singleton
@Path("stats")
@Lock(LockType.WRITE)
public class StatsFacadeREST {
   
    @EJB
    private MessageFacadeREST mf;
    
    @EJB
    private CommentFacadeREST cf;
    
    /**
     * REST method for fetching application stats.
     * Stats returned in Json format: 
     * num_comments (Number of comments ever, int)
     * num_comments_today (Number of comments today, int)
     * num_messages (Number of chat messages ever, int)
     * num_messages_today (Number of chat messages today, int)
     * top_ten_commented (Array containing up to 10 most commented stocks,
     * each Json object containing the attributes symbol (string) and count (long))
     * 
     * @return Json string of the newest stats.
     */
    @GET
    @Path("all")
    @Produces({"application/json"})
    public String getStats() {
        JsonArrayBuilder ab = Json.createArrayBuilder();
        
        List<Object[]> topTenComments = cf.topTenCommented();
        for (Object[] row : topTenComments) {
            ab.add(Json.createObjectBuilder().add("symbol", (String)row[0]).add("count", (long)row[1]));
        }
        
        return Json.createObjectBuilder()
                .add("num_comments", cf.count())
                .add("num_comments_today", cf.countToday())
                .add("num_messages", mf.count())
                .add("num_messages_today", mf.countToday())
                .add("top_ten_commented", ab)
                .build().toString();
    }
}

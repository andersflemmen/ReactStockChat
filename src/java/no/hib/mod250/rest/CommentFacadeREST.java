/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.hib.mod250.rest;

import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import no.hib.mod250.entities.Comment;

/**
 *
 * @author Anders
 */
@Stateless
@Path("comments")
public class CommentFacadeREST extends AbstractFacade<Comment> {
    @PersistenceContext(unitName = "ChatServerPU")
    private EntityManager em;

    public CommentFacadeREST() {
        super(Comment.class);
    }
    
    @POST
    @Consumes("application/json")
    @Path("new")
    public void newComment(final Comment c) {
        c.setPostedTime(Calendar.getInstance());
        this.create(c);
    }
    
    @GET
    @Produces("application/json")
    @Path("get/{symbol}")
    public String getCommentsBySymbol(@PathParam("symbol") String symbol) {
        Query q = em.createQuery("SELECT c FROM Comment c WHERE c.symbol = symbol");
        
        List<Comment> comments = q.getResultList();
        
        JsonObjectBuilder builder = Json.createObjectBuilder();
        
        for (Comment c : comments) {
            
        }
        
        return null;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}

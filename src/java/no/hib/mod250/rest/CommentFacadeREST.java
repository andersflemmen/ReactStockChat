/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.hib.mod250.rest;

import java.util.Calendar;
import java.util.List;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
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
 * REST class responsible for serving comments from the database to incoming
 * GET requests, and store data incoming from POST requests.
 * 
 * @author Anders
 */
@Singleton
@Path("comments")
@Lock(LockType.WRITE)
public class CommentFacadeREST extends AbstractFacade<Comment> {
    @PersistenceContext(unitName = "ChatServerPU")
    private EntityManager em;

    /**
     * Default constructor initializing the AbstractFacade.
     */
    public CommentFacadeREST() {
        super(Comment.class);
    }
    
    /**
     * REST method taking a new comment formatted as Json, storing it to the
     * database. Responsible for adding server timestamp and retrieved symbol
     * to the stored comment.
     * 
     * @param symbol Stock symbol of the new comment.
     * @param c The new comment object.
     */
    @POST
    @Consumes("application/json")
    @Path("new/{symbol}")
    public void newComment(@PathParam("symbol") String symbol, final Comment c) {
        c.setPostedTime(Calendar.getInstance());
        c.setSymbol(symbol);
       
        this.create(c);
    }
    
    /**
     * REST method fetching and returning all comments related to a specific
     * stock symbol from the database.
     * 
     * @param symbol Stock symbol of the requested comments.
     * @return List of all Comments related to the specified symbol.
     */
    @GET
    @Produces("application/json")
    @Path("get/{symbol}")
    public List<Comment> getCommentsBySymbol(@PathParam("symbol") String symbol) {
        Query q = em.createQuery("SELECT c FROM Comment c WHERE c.symbol LIKE :symbol ORDER BY c.postedTime DESC");
   
        q.setParameter("symbol", symbol);
        
        return q.getResultList();
    }

    /**
     * Automatically generated method for getting the EntityManager.
     * 
     * @return The session bean's EntityManager.
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    /**
     * Method for getting the number of new comments on the current day from 
     * the database.
     * 
     * @return The number of new comments on current day.
     */
    public long countToday() {
        Query q = em.createQuery("SELECT COUNT(c.id) FROM Comment c WHERE c.postedTime >= CURRENT_DATE");
        return (long)q.getSingleResult();
    }
    
    /**
     * Method for getting the top 10 most commented stocks.
     * 
     * @return List of the top 10 most commented stocks.
     */
    public List<Object[]> topTenCommented() {
        Query q = em.createNativeQuery("SELECT symbol, COUNT(*) as sum FROM chat_comment GROUP BY symbol ORDER BY sum DESC").setMaxResults(10);
        return q.getResultList();
    }
}

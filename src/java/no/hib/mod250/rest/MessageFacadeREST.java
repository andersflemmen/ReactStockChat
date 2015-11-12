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
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import no.hib.mod250.entities.Message;

/**
 * REST class responsible for serving chat messages from the database to incoming
 * GET requests, and store data incoming from POST requests.
 * 
 * @author Anders
 */
@Singleton
@Path("messages")
@Lock(LockType.WRITE)
public class MessageFacadeREST extends AbstractFacade<Message> {
    
    @PersistenceContext(unitName = "ChatServerPU")
    private EntityManager em;

    /**
     * Default constructor initializing the AbstractFacade.
     */
    public MessageFacadeREST() {
        super(Message.class);
    }

    /**
     * REST method used for storing a new chat message to the database.
     * Responsible for adding server timestamp on the stored message.
     * 
     * @param m The new message to be added.
     */
    @POST
    @Path("new")
    public void newMessage(final Message m) { 
        m.setPostedTime(Calendar.getInstance());
       
        super.create(m);
    }

    /**
     * REST method for fetching the 100 newest chat messages from the database.
     * 
     * @return The 100 newest chat messages.
     */
    @GET
    @Path("last")
    @Produces({"application/json"})
    public List<Message> getMessages() {      
        Query q = em.createQuery("SELECT m FROM Message m ORDER BY m.postedTime");

        List l = q.getResultList();
     
        if(q.getResultList().size() > 100) {
            return l.subList(l.size() - 100, l.size());   
        } else {
            return l;
        }
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
     * Method for getting the number of new chat messages on the current day from 
     * the database.
     * 
     * @return The number of new chat messages on current day.
     */
    public long countToday() {
        Query q = em.createQuery("SELECT COUNT(m.id) FROM Message m WHERE m.postedTime >= CURRENT_DATE");
        return (long)q.getSingleResult();
    }
}

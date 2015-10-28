/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.hib.mod250.rest;

import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import no.hib.mod250.entity.Message;

/**
 *
 * @author Anders
 */
@Stateless
@Path("messages")
public class MessageFacadeREST extends AbstractFacade<Message> {
    
    @PersistenceContext(unitName = "ChatServerPU")
    private EntityManager em;
    
    @EJB
    private RoomFacade rf;

    public MessageFacadeREST() {
        super(Message.class);
    }

    @POST
    @Path("add/{roomId}/{message}")
    public void newMessage(@PathParam("roomId") long roomId, 
            @PathParam("message") String message) {
        
        Message m = new Message();
        m.setMessage(message);
        m.setRoom(rf.find(roomId));
        m.setTime(Calendar.getInstance());
    
        super.create(m);
    }

    @GET
    @Path("{roomId}")
    @Produces({"application/json"})
    public List<Message> getMessagesByRoom(@PathParam("roomId") long roomId) {      
        Query q = em.createQuery("SELECT m FROM Message m WHERE m.room.id = :roomId");
        q.setParameter("roomId", roomId);

        return q.getResultList();
    }
    
    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}

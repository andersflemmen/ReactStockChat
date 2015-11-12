/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.hib.mod250.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * REST application config.
 * 
 * @author Anders
 */
@javax.ws.rs.ApplicationPath("REST")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
       resources.add(no.hib.mod250.rest.CommentFacadeREST.class);
        resources.add(no.hib.mod250.rest.MessageFacadeREST.class);
        resources.add(no.hib.mod250.rest.StatsFacadeREST.class);
        resources.add(no.hib.mod250.rest.StockFacadeREST.class);
        
    }
    
}

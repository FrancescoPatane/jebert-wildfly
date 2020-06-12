package it.pcc.jberetwildfly.rest;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.pcc.jberetwildfly.rest.batch.Scheduler;

@Path("batch")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BatchRestResource {
	
	@EJB
	private Scheduler scheduler;
	
	@GET
	@Path("/test")
    public String testConnection() {
        return "Connected _";
    }
	
	@GET
	@Path("/start")
    public String launchBatchlet() {
        return scheduler.launchBatchlet();
    }

}

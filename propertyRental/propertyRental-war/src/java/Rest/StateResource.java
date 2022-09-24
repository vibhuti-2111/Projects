/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package Rest;

import entity.Statemaster;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import sessionBean.propertyRentalSessionBeanLocal;

/**
 * REST Web Service
 *
 * @author Admin
 */
@Path("state")
public class StateResource {

    @EJB propertyRentalSessionBeanLocal psl;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StateResource
     */
    public StateResource() {
    }

    @Path("showAllState")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Statemaster> showAllState()
    {
        return psl.showState();
    }
    
    @GET
    @Path("getState/{stateIDPK}")
    public Statemaster getState(@PathParam("stateIDPK") int stateIDPK)
    {
        return psl.searchState(stateIDPK);
    }
    
    @POST
    @Path("addState")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addState(Statemaster s)
    {
        psl.insertState(s);
    }
    
    @POST
    @Path("updateState")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateState(Statemaster s)
    {
        psl.updateState(s);
    }
    
    @DELETE
    @Path("deleteState/{stateIDPK}")
    public void deleteState(@PathParam("stateIDPK") int stateIDPK)
    {
        psl.deleteState(stateIDPK);
    }
}

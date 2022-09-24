/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package Rest;

import entity.Citymaster;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@Path("city")
public class CityResource {

    @EJB propertyRentalSessionBeanLocal psl;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CityResource
     */
    public CityResource() {
    }

    @Path("showAllCity")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Citymaster> showAllCity()
    {
        return psl.showCity();
    }
    
    @GET
    @Path("getCity/{cityIDPK}")
    public Citymaster getCity(@PathParam("cityIDPK") int cityIDPK)
    {
        return psl.searchCity(cityIDPK);
    }
    
    @POST
    @Path("addCity")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCity(Citymaster c)
    {
        psl.insertCity(c);
    }
    
    @POST
    @Path("updateCity")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateCity(Citymaster c)
    {
        psl.updateCity(c);
    }
    
    @DELETE
    @Path("deleteCity/{cityIDPK}")
    public void deleteCity(@PathParam("cityIDPK") int cityIDPK)
    {
        psl.deleteCity(cityIDPK);
    }
}

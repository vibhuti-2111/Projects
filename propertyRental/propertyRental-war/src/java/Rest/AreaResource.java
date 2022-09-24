/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package Rest;

import entity.Areamaster;
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
@Path("area")
public class AreaResource {

    @EJB propertyRentalSessionBeanLocal psl;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AreaResource
     */
    public AreaResource() {
    }

    @Path("showAllArea")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Areamaster> showAllArea()
    {
        return psl.showArea();
    }
    
    @GET
    @Path("getArea/{areaIDPK}")
    public Areamaster getArea(@PathParam("areaIDPK") int areaIDPK)
    {
        return psl.searchArea(areaIDPK);
    }
    
    @POST
    @Path("addArea")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addArea(Areamaster a)
    {
        psl.insertArea(a);
    }
    
    @POST
    @Path("updateArea")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateArea(Areamaster a)
    {
        psl.updateArea(a);
    }
    
    @DELETE
    @Path("deleteArea/{areaIDPK}")
    public void deleteArea(@PathParam("areaIDPK") int areaIDPK)
    {
        psl.deleteArea(areaIDPK);
    }
}

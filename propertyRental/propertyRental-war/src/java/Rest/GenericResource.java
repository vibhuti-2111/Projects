/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package Rest;

import entity.Propertytypemaster;
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
@Path("generic")
public class GenericResource {

    @EJB propertyRentalSessionBeanLocal psl;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    @Path("showAllPropertyType")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Propertytypemaster> showAllPropertyType()
    {
        return psl.showPropertyType();
    }
    
    @GET
    @Path("getPropertyType/{propertyTypeIDPK}")
    public Propertytypemaster getPropertyType(@PathParam("propertyTypeIDPK") int propertyTypeIDPK)
    {
        return psl.searchPropertyType(propertyTypeIDPK);
    }
    
    @POST
    @Path("addPropertyType")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPropertyType(Propertytypemaster p)
    {
        psl.insertPropertyType(p);
    }
    
    @POST
    @Path("updatePropertyType")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePropertyType(Propertytypemaster p)
    {
        psl.updatePropertyType(p);
    }
    
    @DELETE
    @Path("deletePropertyType/{propertyTypeIDPK}")
    public void deletePropertyType(@PathParam("propertyTypeIDPK") int propertyTypeIDPK)
    {
        psl.deletePropertyType(propertyTypeIDPK);
    }
}

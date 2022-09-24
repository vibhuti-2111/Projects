/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedBean;

import entity.Propertytypemaster;
import entity.Statemaster;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import sessionBean.propertyRentalSessionBeanLocal;

/**
 *
 * @author Admin
 */
@Named(value = "propertyTypeBean")
@ApplicationScoped
public class propertyTypeManagedBean {

    @EJB
    private propertyRentalSessionBeanLocal propertyRentalSessionBean;

    /**
     * Creates a new instance of propertyTypeManagedBean
     */
    public propertyTypeManagedBean() {
    }
    
    int propertyTypeIDPK;
    String propertyTypeName, propertyTypeSubName;
    Propertytypemaster propertyType = new Propertytypemaster();
    List<Propertytypemaster> propertyTypeList;

    public int getPropertyTypeIDPK() {
        return propertyTypeIDPK;
    }

    public void setPropertyTypeIDPK(int propertyTypeIDPK) {
        this.propertyTypeIDPK = propertyTypeIDPK;
    }

    public String getPropertyTypeName() {
        return propertyTypeName;
    }

    public void setPropertyTypeName(String propertyTypeName) {
        this.propertyTypeName = propertyTypeName;
    }
    
    @PostConstruct
    public void init(){
        propertyTypeIDPK = 0;
    }

    public Propertytypemaster getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(Propertytypemaster propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyTypeSubName() {
        return propertyTypeSubName;
    }

    public void setPropertyTypeSubName(String propertyTypeSubName) {
        this.propertyTypeSubName = propertyTypeSubName;
    }
    
    
    public List<Propertytypemaster> show_propertyTypeList()
    {
        try {
            //System.out.println("managedBean.propertyTypeManagedBean.show_propertyTypeList()"+propertyRentalSessionBean.showPropertyType().size());
            return propertyRentalSessionBean.showPropertyType();
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Propertytypemaster> showPropertyByType(String propertyTypeName)
    {
        try {
            //System.out.println("managedBean.propertyTypeManagedBean.show_propertyTypeList()"+propertyRentalSessionBean.showPropertyType().size());
            return propertyRentalSessionBean.showPropertyByType(propertyTypeName);
        } catch (Exception e) {
            return null;
        }
    }
    
    public String insertPropertyType_click()
    {
        try {
            propertyType.setPropertyTypeIDPK(0);
            propertyType.setPropertyTypeName(propertyTypeName);
            propertyType.setPropertySubTypeName(propertyTypeSubName);
            propertyType.setIsActive(Short.valueOf("1"));
            propertyRentalSessionBean.insertPropertyType(propertyType);
            clear();
            return "/admin/showPropertyType.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String updatePropertyType_click()
    {
        try {
            propertyType.setPropertyTypeIDPK(propertyTypeIDPK);
            propertyType.setPropertyTypeName(propertyTypeName);
            propertyType.setPropertySubTypeName(propertyTypeSubName);
            System.out.println(propertyRentalSessionBean.updatePropertyType(propertyType));
            
            clear();
            return "/admin/showPropertyType.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String deletePropertyType_click(int propertyTypeIDPK)
    {
        try {
            propertyRentalSessionBean.deletePropertyType(propertyTypeIDPK);
            return "/admin/showPropertyType.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String searchPropertyType_click(int id)
    {
        try {
            propertyType = propertyRentalSessionBean.searchPropertyType(id);
            propertyTypeIDPK = propertyType.getPropertyTypeIDPK();
            propertyTypeName = propertyType.getPropertyTypeName();
            propertyTypeSubName = propertyType.getPropertySubTypeName();
            return "/admin/addPropertyType.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public void clear(){
        propertyTypeIDPK = 0;
        propertyTypeName = "";
        propertyTypeSubName = "";
    }
}

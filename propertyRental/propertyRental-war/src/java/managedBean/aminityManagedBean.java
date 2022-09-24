/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedBean;

import entity.Aminitymaster;
import entity.Areamaster;
import entity.Citymaster;
import entity.Propertytypemaster;
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
@Named(value = "aminityBean")
@ApplicationScoped
public class aminityManagedBean {

    @EJB
    private propertyRentalSessionBeanLocal propertyRentalSessionBean;

    /**
     * Creates a new instance of aminityManagedBean
     */
    public aminityManagedBean() {
    }
    
    int aminityIDPK, propertyTypeIDFK, isNumber;
    String aminityName, propertyTypeName, propertySubTypeName;
    Aminitymaster aminity = new Aminitymaster();
    List<Propertytypemaster> propertyTypeList;

    @PostConstruct
    public void init() {
        aminityIDPK = 0;
        propertyTypeList = propertyRentalSessionBean.showPropertyType();
    }

    public String getPropertyTypeName() {
        return propertyTypeName;
    }

    public void setPropertyTypeName(String propertyTypeName) {
        this.propertyTypeName = propertyTypeName;
    }

    public String getPropertySubTypeName() {
        return propertySubTypeName;
    }

    public void setPropertySubTypeName(String propertySubTypeName) {
        this.propertySubTypeName = propertySubTypeName;
    }
    
    

    public int getIsNumber() {
        return isNumber;
    }

    public void setIsNumber(int isNumber) {
        this.isNumber = isNumber;
    }
    
    
    
    public int getAminityIDPK() {
        return aminityIDPK;
    }

    public void setAminityIDPK(int aminityIDPK) {
        this.aminityIDPK = aminityIDPK;
    }

    public int getPropertyTypeIDFK() {
        return propertyTypeIDFK;
    }

    public void setPropertyTypeIDFK(int propertyTypeIDFK) {
        this.propertyTypeIDFK = propertyTypeIDFK;
    }

    public String getAminityName() {
        return aminityName;
    }

    public void setAminityName(String aminityName) {
        this.aminityName = aminityName;
    }

    public List<Propertytypemaster> getPropertyTypeList() {
        return propertyTypeList;
    }

    public void setPropertyTypeList(List<Propertytypemaster> propertyTypeList) {
        this.propertyTypeList = propertyTypeList;
    }
    
    public List<Propertytypemaster> show_propertyTypeList() {
        try {
            return propertyRentalSessionBean.showPropertyType();
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Aminitymaster> show_aminityList() {
        try {
            return propertyRentalSessionBean.showAminity();
        } catch (Exception e) {
            return null;
        }
    }
    
    public String insertAminity_click()
    {
        try {
            Propertytypemaster propertyType = propertyRentalSessionBean.searchPropertyType(propertyTypeIDFK);
            aminity.setAminityIDPK(0);
            aminity.setAminityName(aminityName);
            aminity.setIsNumber(isNumber);
            aminity.setPropertyTypeIDFK(propertyType);
            aminity.setIsActive(Short.valueOf("1"));
            propertyRentalSessionBean.insertAminity(aminity);
            clear();
            return "/admin/showAmenity.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String updateAminity_click()
    {
        try {
            Propertytypemaster propertyType = propertyRentalSessionBean.searchPropertyType(propertyTypeIDFK);
            aminity.setAminityIDPK(aminityIDPK);
            aminity.setAminityName(aminityName);
            aminity.setIsNumber(isNumber);
            aminity.setPropertyTypeIDFK(propertyType);
            System.out.println(propertyRentalSessionBean.updateAminity(aminity));
            clear();
            return "/admin/showAmenity.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String deleteAminity_click(int aminityIDPK)
    {
        try {
            propertyRentalSessionBean.deleteAminity(aminityIDPK);
            return "/admin/showAmenity.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String searchAminity_click(int id)
    {
        try {
            aminity = propertyRentalSessionBean.searchAminity(id);
            aminityIDPK = aminity.getAminityIDPK();
            aminityName = aminity.getAminityName();
            isNumber = aminity.getIsNumber();
            propertyTypeIDFK = aminity.getPropertyTypeIDFK().getPropertyTypeIDPK();
            return "/admin/addAmenity.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public void clear(){
        aminityIDPK = 0;
        aminityName = "";
        isNumber = 0;
        propertyTypeIDFK = 0;
    }
    
}

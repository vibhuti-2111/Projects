/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedBean;

import entity.Citymaster;
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
@Named(value = "cityBean")
@ApplicationScoped
public class cityManagedBean {

    @EJB
    private propertyRentalSessionBeanLocal propertyRentalSessionBean;
    
    /**
     * Creates a new instance of cityManagedBean
     */
    public cityManagedBean() {
    }
    
    int cityIDPK, stateIDFK;
    String cityName;
    List<Statemaster> stateList; 
    Citymaster city = new Citymaster();
    
    @PostConstruct
    public void init() {
        stateList = propertyRentalSessionBean.showState();
        cityIDPK = 0;
    }

    public int getCityIDPK() {
        return cityIDPK;
    }

    public void setCityIDPK(int cityIDPK) {
        this.cityIDPK = cityIDPK;
    }

    public int getStateIDFK() {
        return stateIDFK;
    }

    public void setStateIDFK(int stateIDFK) {
        this.stateIDFK = stateIDFK;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Statemaster> getStateList() {
        return stateList;
    }

    public void setStateList(List<Statemaster> stateList) {
        this.stateList = stateList;
    }
    
    public List<Statemaster> show_stateList() {
        try {
            return propertyRentalSessionBean.showState();
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Citymaster> show_cityList() {
        try {
            return propertyRentalSessionBean.showCity();
        } catch (Exception e) {
            return null;
        }
    }
    
    public String insertCity_click()
    {
        try {
            Statemaster state = propertyRentalSessionBean.searchState(stateIDFK);
            city.setCityIDPK(0);
            city.setCityName(cityName);
            city.setStateIDFK(state);
            city.setIsActive(Short.valueOf("1"));
            propertyRentalSessionBean.insertCity(city);
            clear();
            return "/admin/showCity.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String updateCity_click()
    {
        try {
            Statemaster state = propertyRentalSessionBean.searchState(stateIDFK);
            city.setCityIDPK(cityIDPK);
            city.setCityName(cityName);
            city.setStateIDFK(state);
            System.out.println(propertyRentalSessionBean.updateCity(city));
            clear();
            return "/admin/showCity.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String deleteCity_click(int cityIDPK)
    {
        try {
            propertyRentalSessionBean.deleteCity(cityIDPK);
            return "/admin/showCity.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String searchCity_click(int id)
    {
        try {
            city = propertyRentalSessionBean.searchCity(id);
            cityIDPK = city.getCityIDPK();
            cityName = city.getCityName();
            stateIDFK = city.getStateIDFK().getStateIDPK();
            return "/admin/addCity.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public void clear(){
        cityIDPK = 0;
        cityName = "";
        stateIDFK = 0;
    }
}

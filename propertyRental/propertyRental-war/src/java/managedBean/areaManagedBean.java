/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedBean;

import entity.Areamaster;
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
@Named(value = "areaBean")
@ApplicationScoped
public class areaManagedBean {

    @EJB
    private propertyRentalSessionBeanLocal propertyRentalSessionBean;

    /**
     * Creates a new instance of areaManagedBean
     */
    public areaManagedBean() {
    }
    
    int areaIDPK, cityIDFK, stateIDFK;
    String areaName;
    List<Citymaster> cityList;
    List<Statemaster> stateList;
    Areamaster area = new Areamaster();
    
    @PostConstruct
    public void init() {
        stateList = propertyRentalSessionBean.showState();
        areaIDPK = 0;
    }

    public void fillCity() {
        cityList = propertyRentalSessionBean.showCityByState(stateIDFK);
    }
    
    public List<Statemaster> getStateList() {
        return stateList;
    }

    public void setStateList(List<Statemaster> stateList) {
        this.stateList = stateList;
    }

    
    public int getStateIDFK() {
        return stateIDFK;
    }

    public void setStateIDFK(int stateIDFK) {
        this.stateIDFK = stateIDFK;
    }

    
    public int getAreaIDPK() {
        return areaIDPK;
    }

    public void setAreaIDPK(int areaIDPK) {
        this.areaIDPK = areaIDPK;
    }

    public int getCityIDFK() {
        return cityIDFK;
    }

    public void setCityIDFK(int cityIDFK) {
        this.cityIDFK = cityIDFK;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public List<Citymaster> getCityList() {
        return cityList;
    }

    public void setCityList(List<Citymaster> cityList) {
        this.cityList = cityList;
    }
    
    public List<Citymaster> show_cityList() {
        try {
            return propertyRentalSessionBean.showCity();
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Areamaster> show_areaList() {
        try {
            return propertyRentalSessionBean.showArea();
        } catch (Exception e) {
            return null;
        }
    }
    
    public String insertArea_click()
    {
        try {
            Citymaster city = propertyRentalSessionBean.searchCity(cityIDFK);
            area.setAreaIDPK(0);
            area.setAreaName(areaName);
            area.setCityIDFK(city);
            area.setIsActive(Short.valueOf("1"));
            propertyRentalSessionBean.insertArea(area);
            clear();
            return "/admin/showArea.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String updateArea_click()
    {
        try {
            Citymaster city = propertyRentalSessionBean.searchCity(cityIDFK);
            area.setAreaIDPK(areaIDPK);
            area.setAreaName(areaName);
            area.setCityIDFK(city);
            System.out.println(propertyRentalSessionBean.updateArea(area));
            clear();
            return "/admin/showArea.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String deleteArea_click(int areaIDPK)
    {
        try {
            propertyRentalSessionBean.deleteArea(areaIDPK);
            return "/admin/showArea.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String searchArea_click(int id)
    {
        try {
            area = propertyRentalSessionBean.searchArea(id);
            areaIDPK = area.getAreaIDPK();
            areaName = area.getAreaName();
            cityIDFK = area.getCityIDFK().getCityIDPK();
            return "/admin/addArea.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public void clear(){
        areaIDPK = 0;
        areaName = "";
        cityIDFK = 0;
    }
}

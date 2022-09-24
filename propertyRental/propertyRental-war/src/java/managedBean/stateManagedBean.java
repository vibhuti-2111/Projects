/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedBean;

import Client.stateClient;
import entity.Statemaster;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import sessionBean.propertyRentalSessionBeanLocal;

/**
 *
 * @author Admin
 */
@Named(value = "stateBean")
@ApplicationScoped
public class stateManagedBean {

    @EJB
    private propertyRentalSessionBeanLocal propertyRentalSessionBean;
    
    stateClient client = new stateClient();

    /**
     * Creates a new instance of stateManagedBean
     */
    public stateManagedBean() {
    }
    
    int stateIDPK;
    String stateName;
    Statemaster state = new Statemaster();
    private List<Statemaster> st;

    @PostConstruct
    public void init(){
        stateIDPK = 0;
    }
    
    public int getStateIDPK() {
        return stateIDPK;
    }

    public void setStateIDPK(int stateIDPK) {
        this.stateIDPK = stateIDPK;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    
    public List<Statemaster> show_stateList()
    {
        try {
//            return propertyRentalSessionBean.showState();
            Response r=client.showAllState(Response.class);
            ArrayList<Statemaster> ad=new ArrayList<>();
            GenericType<List<Statemaster>> dis= new GenericType<List<Statemaster>>(){};
            st=(ArrayList<Statemaster>) r.readEntity(dis);
            return st;
        } catch (Exception e) {
            return null;
        }
    }
    
    public String insertState_click()
    {
        try {
            state.setStateIDPK(0);
            state.setStateName(stateName);
            //state.setIsActive(Short.valueOf("true"));
//            propertyRentalSessionBean.insertState(state);
            client.addState(state);
            clear();
            return "/admin/showState.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String updateState_click()
    {
        try {
            state.setStateIDPK(stateIDPK);
            state.setStateName(stateName);
//            System.out.println(propertyRentalSessionBean.updateState(state));
            client.updateState(state);
            clear();
            return "/admin/showState.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String deleteState_click(int stateIDPK)
    {
        try {
//            propertyRentalSessionBean.deleteState(stateIDPK);
            client.deleteState(stateIDPK);
            return "/admin/showState.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String searchState_click(int id)
    {
        try {
            state = propertyRentalSessionBean.searchState(id);
            stateIDPK = state.getStateIDPK();
            stateName = state.getStateName();
            return "/admin/addState.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public void clear(){
        stateIDPK = 0;
        stateName = "";
    }
}

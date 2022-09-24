/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedBean;

import entity.Chatmaster;
import entity.Statemaster;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import sessionBean.propertyRentalSessionBeanLocal;

/**
 *
 * @author Admin
 */
@Named(value = "chatBean")
@ApplicationScoped
public class chatManagedBean {

    @EJB
    private propertyRentalSessionBeanLocal propertyRentalSessionBean;

    /**
     * Creates a new instance of chatManagedBean
     */
    public chatManagedBean() {
    }
    
    int chatIDPK, toUserIDFK, fromUserIDFK, propertyIDFK;
    String chatText;
    Chatmaster chat = new Chatmaster();

    public void addProperty(int id, int uid) {
        propertyIDFK = id;
        toUserIDFK = uid;
    }
    
    @PostConstruct
    public void init(){
        chatIDPK = 0;
    }
    
    public int getChatIDPK() {
        return chatIDPK;
    }

    public int getPropertyIDFK() {
        return propertyIDFK;
    }

    public void setPropertyIDFK(int propertyIDFK) {
        this.propertyIDFK = propertyIDFK;
    }

    public void setChatIDPK(int chatIDPK) {
        this.chatIDPK = chatIDPK;
    }

    public int getToUserIDFK() {
        return toUserIDFK;
    }

    public void setToUserIDFK(int toUserIDFK) {
        this.toUserIDFK = toUserIDFK;
    }

    public int getFromUserIDFK() {
        return fromUserIDFK;
    }

    public void setFromUserIDFK(int fromUserIDFK) {
        this.fromUserIDFK = fromUserIDFK;
    }

    public String getChatText() {
        return chatText;
    }

    public void setChatText(String chatText) {
        this.chatText = chatText;
    }
    
    public List<Chatmaster> show_chatList()
    {
        try {
            return propertyRentalSessionBean.showChat();
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Chatmaster> showChatsByProperty(int id)
    {
        try {
            return propertyRentalSessionBean.showChatByProperty(id);
        } catch (Exception e) {
            return null;
        }
    }
    
    public String insertChat_click()
    {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            HttpSession userSession = request.getSession();
            System.out.println("userID:::" + Integer.parseInt(userSession.getAttribute("userIDPK").toString()));
            
            chat.setChatIDPK(0);
            chat.setChatText(chatText);
            chat.setToUserIDFK(toUserIDFK);
            chat.setPropertyIDFK(propertyIDFK);
            chat.setFromUserIDFK(Integer.parseInt(userSession.getAttribute("userIDPK").toString()));
            chat.setIsActive(Short.valueOf("1"));
            propertyRentalSessionBean.insertChat(chat);
            clear();
            return "/client/index.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String updateChat_click()
    {
        try {
            chat.setChatIDPK(chatIDPK);
            chat.setChatText(chatText);
            chat.setToUserIDFK(toUserIDFK);
            chat.setFromUserIDFK(fromUserIDFK);
            System.out.println(propertyRentalSessionBean.updateChat(chat));
            clear();
            return "/admin/showChat.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String deleteChat_click(int chatIDPK)
    {
        try {
            propertyRentalSessionBean.deleteChat(chatIDPK);
            return "/admin/showChat.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String searchChat_click(int id)
    {
        try {
            chat = propertyRentalSessionBean.searchChat(id);
            chatIDPK = chat.getChatIDPK();
            chatText = chat.getChatText();
            toUserIDFK = chat.getToUserIDFK();
            fromUserIDFK = chat.getFromUserIDFK();
            return "/admin/addChat.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public void clear(){
        chatIDPK = 0;
        chatText = "";
        toUserIDFK = 0;
        fromUserIDFK = 0;
    }
}

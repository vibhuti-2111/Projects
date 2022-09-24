/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedBean;

import entity.Citymaster;
import entity.Propertymaster;
import entity.Statemaster;
import entity.Usermaster;
import entity.Userrequestmaster;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import sessionBean.propertyRentalSessionBeanLocal;

/**
 *
 * @author Admin
 */
@Named(value = "userRequestBean")
@ApplicationScoped
public class userRequestManagedBean {

    @EJB
    private propertyRentalSessionBeanLocal propertyRentalSessionBean;

    /**
     * Creates a new instance of userRequestManagedBean
     */
    public userRequestManagedBean() {
    }

    int userRequestIDPK, status, propertyIDFK, userIDFK;
    List<Propertymaster> propertyList;
    List<Usermaster> userList;
    Userrequestmaster userRequest = new Userrequestmaster();
    String comment;

    @PostConstruct
    public void init() {
        propertyList = propertyRentalSessionBean.showProperty();
        userList = propertyRentalSessionBean.showUser();
        userRequestIDPK = 0;
    }

    public int getUserRequestIDPK() {
        return userRequestIDPK;
    }

    public void setUserRequestIDPK(int userRequestIDPK) {
        this.userRequestIDPK = userRequestIDPK;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPropertyIDFK() {
        return propertyIDFK;
    }

    public void setPropertyIDFK(int propertyIDFK) {
        this.propertyIDFK = propertyIDFK;
    }

    public int getUserIDFK() {
        return userIDFK;
    }

    public void setUserIDFK(int userIDFK) {
        this.userIDFK = userIDFK;
    }

    public List<Propertymaster> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Propertymaster> propertyList) {
        this.propertyList = propertyList;
    }

    public List<Usermaster> getUserList() {
        return userList;
    }

    public void setUserList(List<Usermaster> userList) {
        this.userList = userList;
    }

    public List<Usermaster> show_userList() {
        try {
            return propertyRentalSessionBean.showUser();
        } catch (Exception e) {
            return null;
        }
    }
    
    
    public List<Propertymaster> show_propertyList() {
        try {
            return propertyRentalSessionBean.showProperty();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Userrequestmaster> show_userRequestList() {
        try {
            return propertyRentalSessionBean.showUserRequest();
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Userrequestmaster> showRequestByUser() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            HttpSession userSession = request.getSession();

            return propertyRentalSessionBean.showRequestByUser(Integer.parseInt(userSession.getAttribute("userIDPK").toString()));
        } catch (Exception e) {
            return null;
        }
    }

    public List<Userrequestmaster> showRequestByProperty(int propertyIDFK) {
        try {

            return propertyRentalSessionBean.showRequestByProperty(propertyIDFK);
        } catch (Exception e) {
            return null;
        }
    }

    public void sendEmail(String email, String propertyName,String userName) throws IOException, MessagingException {
        String[] to
                = {
                    email
                }; // list of recipient email addresses
        String subject = "Inquiry for property:" + propertyName;

        comment = "Hello, I am "+ userName+" intrested in your rental peroperty on real house.. I would love to set up an appointment to see the property..Thank you for your time. I look forward to hearing from you. ";
        String result = intiSendEmail(to, subject, comment);
        System.out.println("Result:: "+result);
    }
    
    public void sendEmailFromPropertyOwner(String email, String propertyName,String userName) throws IOException, MessagingException {
        String[] to
                = {
                    email
                }; // list of recipient email addresses
        String subject = "About your request for property:" + propertyName;

        comment = "Hello, I am "+ userName+". I saw your intrest in my peroperty on real house..Thank you for inquiring aboutI’ll get started on your home’s valuation report as soon as possible. You’ll receive the report within 4-5 working days.";
        String result = intiSendEmail(to, subject, comment);
        System.out.println("Result:: "+result);
    }
    
    public void sendEmailToClient(String email, String propertyName,String userName) throws IOException, MessagingException {
        String[] to
                = {
                    email
                }; // list of recipient email addresses
        String subject = "Thanking :" + propertyName;

        comment = "Hello, I am "+ userName+". I saw your intrest in my peroperty on real house..Thank you for inquiring about. I’ll get started on your home’s valuation report as soon as possible. You’ll receive the report within 4-5 working days.";
        String result = intiSendEmail(to, subject, comment);
        System.out.println("Result:: "+result);
    }

    public String intiSendEmail(String[] to, String subject, String body) throws IOException, MessagingException {
        String status;
        String USER_NAME = "vibhutipatel@metanoiainfotech.com", PASSWORD = "vibhuti@2103";
        Properties props = System.getProperties();
        String host = "mail.metanoiainfotech.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", USER_NAME);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(USER_NAME, "Real House"));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (InternetAddress toAddres : toAddress) {
                message.addRecipient(Message.RecipientType.TO, toAddres);
            }

            message.setSubject(subject);
            message.setText(body);

            Transport transport = session.getTransport("smtp");
            transport.connect(host, USER_NAME, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (AddressException ae) {
            return status = "Cannot send Message!";
        } catch (MessagingException me) {
            return status = "Cannot send Message!";
        }

        return status = "Message is send!";
    }

    public String changeStatus(int userRequestIDPK, String status) {
        try {
            Userrequestmaster userReq = propertyRentalSessionBean.searchUserRequest(userRequestIDPK);

            sendEmailFromPropertyOwner(userReq.getUserIDFK().getUserEmail(), userReq.getPropertyIDFK().getPropertyName(), userReq.getPropertyIDFK().getUserIDFK().getUserFname() + " " + userReq.getPropertyIDFK().getUserIDFK().getUserLname());
            propertyRentalSessionBean.changeStatus(userRequestIDPK, status);
            return "/client/favoriteProperty.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    
    public String insertUserRequest_click(int id) {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            HttpSession userSession = request.getSession();

            Propertymaster property = propertyRentalSessionBean.searchProperty(id);
            //Usermaster user = propertyRentalSessionBean.searchUser(userIDFK);

            Usermaster user = propertyRentalSessionBean.searchUser(Integer.parseInt(userSession.getAttribute("userIDPK").toString()));

            userRequest.setUserRequestIDPK(0);
            userRequest.setStatus(Short.valueOf("0"));
            userRequest.setPropertyIDFK(property);
            userRequest.setUserIDFK(user);
            userRequest.setIsActive(Short.valueOf("1"));
            System.out.println("Email::" + property.getUserIDFK().getUserEmail());
            sendEmail(property.getUserIDFK().getUserEmail() , property.getPropertyName(),user.getUserFname()+" "+user.getUserLname());
            propertyRentalSessionBean.insertUserRequest(userRequest);
            clear();
            return "/client/index.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String updateUserRequest_click() {
        try {
            Propertymaster property = propertyRentalSessionBean.searchProperty(propertyIDFK);
            Usermaster user = propertyRentalSessionBean.searchUser(userIDFK);
            userRequest.setUserRequestIDPK(userRequestIDPK);
            userRequest.setUserRequestIDPK(0);
            userRequest.setStatus(Short.valueOf("0"));
            userRequest.setPropertyIDFK(property);
            userRequest.setUserIDFK(user);
            System.out.println(propertyRentalSessionBean.updateUserRequest(userRequest));
            clear();
            return "/admin/showUserRequest.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String deleteUserRequest_click(int userRequestIDPk) {
        try {
            propertyRentalSessionBean.deleteUserRequest(userRequestIDPk);
            return "/admin/showUserRequest.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String searchUserRequest_click(int id) {
        try {
            userRequest = propertyRentalSessionBean.searchUserRequest(id);
            userRequestIDPK = userRequest.getUserRequestIDPK();
            status = userRequest.getStatus();
            userIDFK = userRequest.getUserIDFK().getUserIDPK();
            propertyIDFK = userRequest.getPropertyIDFK().getPropertyIDPK();
            return "/admin/addUserRequest.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public void clear() {
        userRequestIDPK = 0;
        status = 0;
        userIDFK = 0;
        propertyIDFK = 0;
    }
}

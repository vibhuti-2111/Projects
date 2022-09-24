/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedBean;

import entity.Usermaster;
import java.io.IOException;
import java.util.Properties;
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
import sessionBean.propertyRentalSessionBean;
import sessionBean.propertyRentalSessionBeanLocal;

/**
 *
 * @author Admin
 */
@Named(value = "loginManagedBean")
@ApplicationScoped
public class loginManagedBean {

    @EJB
    private propertyRentalSessionBeanLocal propertyRentalSessionBean;

    /**
     * Creates a new instance of loginManagedBean
     */
    public loginManagedBean() {
    }

    String userEmail, userPassword, oldPass, newPass, userType, message, comment, emailmessage, conmessage;
    Integer userIDPK;
    Usermaster um = new Usermaster();

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public String getConmessage() {
        return conmessage;
    }

    public void setConmessage(String conmessage) {
        this.conmessage = conmessage;
    }

    
    
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserIDPK() {
        return userIDPK;
    }

    public void setUserIDPK(Integer userIDPK) {
        this.userIDPK = userIDPK;
    }

    public String login() {
        try {
            Usermaster user = propertyRentalSessionBean.login(userEmail, userPassword);

            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            if (user != null) {
                HttpSession userSession = request.getSession();

                userSession.setAttribute("userIDPK", user.getUserIDPK());
                userSession.setAttribute("userFname", user.getUserFname());
                userSession.setAttribute("userLname", user.getUserLname());
                userSession.setAttribute("userType", user.getUserType());
                userSession.setAttribute("userImage", user.getUserImage());
                userSession.setAttribute("userEmail", user.getUserEmail());

                //String userID = userSession.getAttribute("userIDPK");
                if (user.getUserType().equals("Admin")) {
                    return "/admin/index.xhtml?faces-redirect=true";
                } else if (user.getUserType().equals("Client")) {
                    return "/client/index.xhtml?faces-redirect=true";
                } else if (user.getUserType().equals("Property Owner")) {
                    return "/client/index.xhtml?faces-redirect=true";
                } else {
                    if (!user.getUserEmail().contains(userEmail)) {
                        message = "username and password incorrect";
                        return "/login.xhtml?faces-redirect=true";
                    }

                }
            } else {
                message = "Your Email Or Password is Invalid!!";
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        return null;
    }

    public String logout() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession userSession = request.getSession();
            userSession.invalidate();
            System.out.println("managedBean.loginManagedBean.logout() Logout!!");
            return "/client/index.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String validateUserLogin() {
        String navResult = "";

        if (userType.equals("Admin") || userType == null) {
            navResult = "admin";
        } else {
            navResult = "client";
        }
        return navResult;
    }

    public void sendEmail(String email, String desc, String sub) throws IOException, MessagingException {
        String[] to
                = {
                    email
                };

// list of recipient email addresses
        String subject = "Change Password:" + sub;
        String comment;
        comment = "Your Description :" + desc;
        String result = intiSendEmail(to, subject, comment);
        System.err.println("Email ++ " + result);
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
            message.setContent(body, "text/html;charset=utf-8");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, USER_NAME, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (AddressException ae) {
            System.out.println("managedBean.loginManagedBean.intiSendEmail()" + ae);
            return status = "Cannot send Message!";
        } catch (MessagingException me) {
            System.out.println("managedBean.loginManagedBean.intiSendEmail()" + me);
            return status = "Cannot send Message!";
        }

        return status = "Message is send!";
    }

    public String forgotPassword() {
        try {

            Usermaster us = propertyRentalSessionBean.findmail(userEmail);

            System.out.println("managedBean.loginManagedBean.forgotPassword()" + userEmail);
            if (getUserEmail().equalsIgnoreCase(userEmail)) {
                System.out.println("managedBean.loginManagedBean.forgotPassword() hii" + userEmail);

                comment = "<h4>Change Your Password Through Below Link</h4>"
                        + "<a href='http://localhost:8080/propertyRental-war/client/resetPassword.xhtml'>Click link to change password</a>";
                sendEmail(userEmail, comment, "Forgot Password");
                emailmessage = "";
            } else {
                emailmessage = "Email is not valid";
                return "/forgetPassword.xhtml?faces-redirect=true";
            }

        } catch (Exception e) {
            return emailmessage = "Email is not valid";
        }
        return "/client/login.xhtml?faces-redirect=true";
    }

    public String updatepass_click() {
        try {
            Usermaster us = propertyRentalSessionBean.findmail(userEmail);
            System.out.println("managedBean.userManagedBean.updatepass_click() id"+ us.getUserEmail() + " -" + userPassword);
            us.setUserIDPK(us.getUserIDPK());
            us.setUserFname(us.getUserFname());
            us.setUserLname(us.getUserLname());
            us.setUserType(us.getUserType());
            us.setUserEmail(us.getUserEmail());
            us.setUserPassword(userPassword);
            us.setUserContactNo(us.getUserContactNo());
            //us.setUserGender(us.getUserGender());

            propertyRentalSessionBean.updateUserPassword(us);

            return "/client/login.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }

    }
    
    public String updatePassword(int id) {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession userSession = request.getSession();

        userEmail = userSession.getAttribute("userEmail").toString();
        userType = userSession.getAttribute("userType").toString();
        Usermaster a = propertyRentalSessionBean.findmail(userEmail);
        id = Integer.parseInt(userSession.getAttribute("userIDPK").toString());
        

        if (a.getUserPassword().equals(oldPass)) {
            
            Usermaster m = propertyRentalSessionBean.searchUser(id);
            
 
                if(newPass.equals(userPassword))
                {
                    m.setUserPassword(newPass);
                    propertyRentalSessionBean.updateUserPassword(m);
                    conmessage="";
                    message="";
                }else
                {
                    message="";
                    conmessage="old password and confirm password doesen't match";
                    return "/client/changePassword.xhtml?faces-redirect=true";
                }
            
            message = "";
        } else {
            message = "old password is not correct";
            return "/client/changePssword.xhtml?faces-redirect=true";
        }
        oldPass="";
        newPass="";
        userPassword="";
        System.out.println("managedBean.loginManagedBean.updatePassword() ID:: "+id);
        return "/client/index.xhtml?faces-redirect=true";
    }
}

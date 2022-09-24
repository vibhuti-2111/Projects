/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedBean;

import entity.Areamaster;
import entity.Citymaster;
import entity.Statemaster;
import entity.Usermaster;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import sessionBean.propertyRentalSessionBeanLocal;

/**
 *
 * @author Admin
 */
@Named(value = "userBean")
@ApplicationScoped
public class userManagedBean {

    @EJB
    private propertyRentalSessionBeanLocal propertyRentalSessionBean;

    /**
     * Creates a new instance of userManagedBean
     */
    public userManagedBean() {
    }

    int userIDPK, areaIDFK, stateIDFK, cityIDFK;
    String userFname, userLname, userType, userEmail, userPassword, userDateOfBirth, userGender, userContactNo, userFullAddress, userShortAddress, grfile;
    Part file;
    List<Areamaster> areaList;
    List<Statemaster> stateList;
    List<Citymaster> cityList;
    Usermaster user = new Usermaster();

    public int getStateIDFK() {
        return stateIDFK;
    }

    public void setStateIDFK(int stateIDFK) {
        this.stateIDFK = stateIDFK;
    }

    public int getCityIDFK() {
        return cityIDFK;
    }

    public void setCityIDFK(int cityIDFK) {
        this.cityIDFK = cityIDFK;
    }

    public List<Statemaster> getStateList() {
        return stateList;
    }

    public void setStateList(List<Statemaster> stateList) {
        this.stateList = stateList;
    }

    public List<Citymaster> getCityList() {
        return cityList;
    }

    public void setCityList(List<Citymaster> cityList) {
        this.cityList = cityList;
    }

    @PostConstruct
    public void init() {
        stateList = propertyRentalSessionBean.showState();
        System.out.println("managedBean.userManagedBean.init()" + stateList.size());
        userIDPK = 0;
    }

    public String fillUser() {
        Usermaster usr = new Usermaster();

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        HttpSession userSession = request.getSession();
        
        if (userSession.getAttribute("userIDPK") != null) 
        {

            if (userSession.getAttribute("userType").toString().equalsIgnoreCase("Client") || userSession.getAttribute("userType").toString().equalsIgnoreCase("Property Owner")) 
            {
                userIDPK = Integer.parseInt(userSession.getAttribute("userIDPK").toString());

                System.out.println("managedBean.userManagedBean.init()" + userIDPK);
                usr = propertyRentalSessionBean.searchUser(userIDPK);
                userIDPK = usr.getUserIDPK();
//            username=userSession.getAttribute("userName").toString();
                userFname = usr.getUserFname();
                userType = usr.getUserType();
                userLname = usr.getUserLname();
                userEmail = usr.getUserEmail();
                userPassword = usr.getUserPassword();
                userGender = usr.getUserGender();
                userContactNo = usr.getUserContactNo();
                grfile = usr.getUserImage();
            }
        }
        return "/client/myProfile.xhtml?faces-redirect=true";
    }

    public void fillCity() {
        cityList = propertyRentalSessionBean.showCityByState(stateIDFK);
    }

    public void fillArea() {
        areaList = propertyRentalSessionBean.showAreaByCity(cityIDFK);
    }

    public int getUserIDPK() {
        return userIDPK;
    }

    public void setUserIDPK(int userIDPK) {
        this.userIDPK = userIDPK;
    }

    public int getAreaIDFK() {
        return areaIDFK;
    }

    public void setAreaIDFK(int areaIDFK) {
        this.areaIDFK = areaIDFK;
    }

    public String getUserFname() {
        return userFname;
    }

    public void setUserFname(String userFname) {
        this.userFname = userFname;
    }

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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

    public String getUserDateOfBirth() {
        return userDateOfBirth;
    }

    public void setUserDateOfBirth(String userDateOfBirth) {
        this.userDateOfBirth = userDateOfBirth;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserContactNo() {
        return userContactNo;
    }

    public void setUserContactNo(String userContactNo) {
        this.userContactNo = userContactNo;
    }

    public String getGrfile() {
        return grfile;
    }

    public void setGrfile(String grfile) {
        this.grfile = grfile;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public List<Areamaster> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Areamaster> areaList) {
        this.areaList = areaList;
    }

    public Usermaster getUser() {
        return user;
    }

    public void setUser(Usermaster user) {
        this.user = user;
    }

    public List<Areamaster> show_areaList() {
        try {
            return propertyRentalSessionBean.showArea();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Usermaster> show_userList() {
        try {
            return propertyRentalSessionBean.showUser();
        } catch (Exception e) {
            return null;
        }
    }

    public String insertUser_click() {
        try {
            InputStream input = file.getInputStream();
            String path = "D:\\SEM_8_PROJECT\\Project\\propertyRental\\propertyRental-war\\web\\uploads";
            Random random = new Random();
            StringBuilder sb = new StringBuilder();

            sb.append(random.nextInt(9) + 1);
            for (int i = 0; i < 11; i++) {
                sb.append(random.nextInt(10));
            }
            String temp = sb.toString();

            grfile = "IMG_" + temp + file.getSubmittedFileName();
            Files.copy(input, new File(path, grfile).toPath());

            user.setUserIDPK(0);
            Areamaster area = propertyRentalSessionBean.searchArea(areaIDFK);
            user.setUserFname(userFname);
            user.setUserLname(userLname);
            user.setUserType("Client");
            user.setUserEmail(userEmail);
            user.setUserPassword(userPassword);

            user.setUserGender(userGender);
            user.setUserContactNo(userContactNo);
            user.setUserImage(grfile);

            user.setIsActive(Short.valueOf("1"));
            propertyRentalSessionBean.insertUser(user);
            clear();
            return "/admin/showUser.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String insertUserForReg_click() {
        try {
            InputStream input = file.getInputStream();
            String path = "D:\\SEM_8_PROJECT\\Project\\propertyRental\\propertyRental-war\\web\\uploads";
            Random random = new Random();
            StringBuilder sb = new StringBuilder();

            sb.append(random.nextInt(9) + 1);
            for (int i = 0; i < 11; i++) {
                sb.append(random.nextInt(10));
            }
            String temp = sb.toString();

            grfile = "IMG_" + temp + file.getSubmittedFileName();
            Files.copy(input, new File(path, grfile).toPath());

            user.setUserIDPK(0);
            Areamaster area = propertyRentalSessionBean.searchArea(areaIDFK);
            user.setUserFname(userFname);
            user.setUserLname(userLname);
            user.setUserType("Client");
            user.setUserEmail(userEmail);
            user.setUserPassword(userPassword);

            user.setUserGender(userGender);
            user.setUserContactNo(userContactNo);
            user.setUserImage(grfile);

            user.setIsActive(Short.valueOf("1"));
            propertyRentalSessionBean.insertUser(user);
            clear();
            return "index.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String updateUser_click() {
        try {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        HttpSession userSession = request.getSession();
        
            if (file != null) {
                InputStream input = file.getInputStream();
                String path = "D:\\SEM_8_PROJECT\\Project\\propertyRental\\propertyRental-war\\web\\uploads";
                Random random = new Random();
                StringBuilder sb = new StringBuilder();

                sb.append(random.nextInt(9) + 1);
                for (int i = 0; i < 11; i++) {
                    sb.append(random.nextInt(10));
                }
                String temp = sb.toString();

                grfile = "IMG_" + temp + file.getSubmittedFileName();
                Files.copy(input, new File(path, grfile).toPath());
            }

            user.setUserIDPK(Integer.parseInt(userSession.getAttribute("userIDPK").toString()));

            user.setUserFname(userFname);
            user.setUserLname(userLname);
            user.setUserType(userType);
            user.setUserEmail(userEmail);
            user.setUserGender(userGender);
            user.setUserContactNo(userContactNo);
            user.setUserImage(grfile);
            System.err.println(""+propertyRentalSessionBean.updateUser(user));
            
                System.out.println("IN ++++ ID:: "+Integer.parseInt(userSession.getAttribute("userIDPK").toString())
                + "Fname: " + userFname + "Lname : "+ userLname + "Phone: " + userContactNo);
            if(userSession.getAttribute("userType").toString().equalsIgnoreCase("Admin"))
            {
                clear();
                return "/admin/showUser.xhtml?faces-redirect=true";
            }
            else{
                return fillUser();
            }
                
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String deleteUser_click(int userIDPK) {
        try {
            propertyRentalSessionBean.deleteUser(userIDPK);
            return "/admin/showUser.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String searchUser_click(int id) {
        try {
            user = propertyRentalSessionBean.searchUser(id);
            userIDPK = user.getUserIDPK();
            userFname = user.getUserFname();
            userLname = user.getUserLname();
            userType = user.getUserType();
            userEmail = user.getUserEmail();
            userGender = user.getUserGender();
            userPassword = user.getUserPassword();
            userContactNo = user.getUserContactNo();
            grfile = user.getUserImage();
            return "/admin/addUser.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public void clear() {
        userIDPK = 0;
        userFname = "";
        userLname = "";
        userType = "";
        userEmail = "";
        userPassword = "";
        userGender = "";
        userContactNo = "";
        grfile = "";
    }
}

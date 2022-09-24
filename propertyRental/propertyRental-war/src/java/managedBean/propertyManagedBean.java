/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedBean;

import entity.Aminitymaster;
import entity.Areamaster;
import entity.Citymaster;
import entity.Propertyimagemaster;
import entity.Propertymaster;
import entity.Propertytypemaster;
import entity.Reviewratingmaster;
import entity.Statemaster;
import entity.Usermaster;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
@Named(value = "propertyBean")
@ApplicationScoped
public class propertyManagedBean {

    @EJB
    private propertyRentalSessionBeanLocal propertyRentalSessionBean;

    /**
     * Creates a new instance of propertyManagedBean
     */
    public propertyManagedBean() {
    }

    int propertyIDPK, reviewRatingIDPK, aminityIDFK, propertyIDFK, areaIDFK, userIDFK, propertyTypeIDFK, stateIDFK, cityIDFK, isAvailable, bedRoomNumber, bathRoomNumber;
    String propertyName, review, rating, propertyDescription, propertyFullAddress, propertyShortAddress, propertyRent, propertyAdvanceRent, features, propertyTypeName, propertySubTypeName, grfile;
    String[] sfeatures, snum, snonnum;
    Part file;
    Date addedDate;
    List<Aminitymaster> numberList = new ArrayList<>();
    List<Aminitymaster> nonNumberList = new ArrayList<>();
    List<Aminitymaster> aminityList;
    List<Areamaster> areaList;
    List<Statemaster> stateList;
    List<Citymaster> cityList;
    List<Usermaster> userList;
    List<Propertytypemaster> propertyTypeList;
    List<Propertytypemaster> propertySubTypeList;
    List<Propertymaster> pListByType;
    List<Propertymaster> propertyList;
    Propertymaster property = new Propertymaster();
    Reviewratingmaster reviewRating = new Reviewratingmaster();

    @PostConstruct
    public void init() {
        propertyTypeList = propertyRentalSessionBean.showPropertyType();
        userList = propertyRentalSessionBean.showUser();
        stateList = propertyRentalSessionBean.showState();
        //aminityList = propertyRentalSessionBean.showAminity();
        propertyIDPK = 0;
    }

    public int getBedRoomNumber() {
        return bedRoomNumber;
    }

    public void setBedRoomNumber(int bedRoomNumber) {
        this.bedRoomNumber = bedRoomNumber;
    }

    public int getBathRoomNumber() {
        return bathRoomNumber;
    }

    public void setBathRoomNumber(int bathRoomNumber) {
        this.bathRoomNumber = bathRoomNumber;
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

    public String getPropertySubTypeName() {
        return propertySubTypeName;
    }

    public void setPropertySubTypeName(String propertySubTypeName) {
        this.propertySubTypeName = propertySubTypeName;
    }

    public String[] getSnum() {
        return snum;
    }

    public void setSnum(String[] snum) {
        this.snum = snum;
    }

    public String[] getSnonnum() {
        return snonnum;
    }

    public void setSnonnum(String[] snonnum) {
        this.snonnum = snonnum;
    }

    public String getPropertyTypeName() {
        return propertyTypeName;
    }

    public void setPropertyTypeName(String propertyTypeName) {
        this.propertyTypeName = propertyTypeName;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getPropertyFullAddress() {
        return propertyFullAddress;
    }

    public void setPropertyFullAddress(String propertyFullAddress) {
        this.propertyFullAddress = propertyFullAddress;
    }

    public String getPropertyShortAddress() {
        return propertyShortAddress;
    }

    public void setPropertyShortAddress(String propertyShortAddress) {
        this.propertyShortAddress = propertyShortAddress;
    }

    public List<Propertytypemaster> getPropertySubTypeList() {
        return propertySubTypeList;
    }

    public void setPropertySubTypeList(List<Propertytypemaster> propertySubTypeList) {
        this.propertySubTypeList = propertySubTypeList;
    }

    public List<Propertymaster> getpListByType() {
        return pListByType;
    }

    public void setpListByType(List<Propertymaster> pListByType) {
        this.pListByType = pListByType;
    }

    public void propertysubTypeByPropertyName() {
        System.out.println("managedBean.propertyManagedBean.propertysubTypeByPropertyName()" + propertyTypeName);
        propertySubTypeList = propertyRentalSessionBean.showPropertySubType(propertyTypeName);

    }

    public List<Propertymaster> showPropertyByPropertyTypeName(String propertyTypeName) {
        return propertyRentalSessionBean.showPropertyByPropertyTypeName(propertyTypeName);
    }

    public String[] getSfeatures() {
        return sfeatures;
    }

    public void setSfeatures(String[] sfeatures) {
        this.sfeatures = sfeatures;
    }

    public List<Aminitymaster> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<Aminitymaster> numberList) {
        this.numberList = numberList;
    }

    public List<Aminitymaster> getNonNumberList() {
        return nonNumberList;
    }

    public void setNonNumberList(List<Aminitymaster> nonNumberList) {
        this.nonNumberList = nonNumberList;
    }

    public List<Propertymaster> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Propertymaster> propertyList) {
        this.propertyList = propertyList;
    }

    public int getReviewRatingIDPK() {
        return reviewRatingIDPK;
    }

    public void setReviewRatingIDPK(int reviewRatingIDPK) {
        this.reviewRatingIDPK = reviewRatingIDPK;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Reviewratingmaster getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(Reviewratingmaster reviewRating) {
        this.reviewRating = reviewRating;
    }

    public int getPropertyIDFK() {
        return propertyIDFK;
    }

    public void setPropertyIDFK(int propertyIDFK) {
        this.propertyIDFK = propertyIDFK;
    }

    public String setDateFormat(Date addDate) {
        try {
//            String date_s = addDate.toString();
//            SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
//            Date date = dt.parse(date_s);
            SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/YYYY");
            System.out.println(dt1.format(addDate));
            return dt1.format(addDate);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public void fillCity() {
        System.out.println("managedBean.propertyManagedBean.fillCity()" + stateIDFK);
        cityList = propertyRentalSessionBean.showCityByState(stateIDFK);
    }

    public void fillArea() {
        areaList = propertyRentalSessionBean.showAreaByCity(cityIDFK);
    }

    public void addPropertyPK(int id) {

        propertyIDPK = id;

    }

    public void addPropertyTypeFK(int id) {

        propertyTypeIDFK = id;
        System.out.println("managedBean.propertyManagedBean.addPropertyTypeFK() ID: " + propertyTypeIDFK);
    }

    public void showPropertyByPropertyType(int id) {
        try {
            System.out.println("managedBean.propertyManagedBean.showPropertyByPropertyType() ID :::" + id);
            propertyList = propertyRentalSessionBean.propertyListByPropertyType(id);
        } catch (Exception e) {

        }
    }
    
    public List<Propertymaster> showByPropertyType(int id) {
        try {
            System.out.println("managedBean.propertyManagedBean.showPropertyByPropertyType() ID :::" + id);
            propertyList = propertyRentalSessionBean.propertyListByPropertyType(id);
            return propertyList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Propertymaster> ListPropertyByType(String propertyTypeName) {
        try {
            //System.out.println("managedBean.propertyTypeManagedBean.show_propertyTypeList()"+propertyRentalSessionBean.showPropertyType().size());
            return propertyRentalSessionBean.ListPropertyByType(propertyTypeName);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Propertymaster> showPropertyByUser() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            HttpSession userSession = request.getSession();
            System.out.println("userID:::" + Integer.parseInt(userSession.getAttribute("userIDPK").toString()));
            return propertyRentalSessionBean.showPropertyByUser(Integer.parseInt(userSession.getAttribute("userIDPK").toString()));
        } catch (Exception e) {
            return null;
        }
    }

    public Propertymaster showPropertyByID() {
        try {
            return propertyRentalSessionBean.searchPropertyByID(propertyIDPK);
        } catch (Exception e) {
            return null;
        }
    }

    public List<String> getFeaturesList(String features) {
        return Arrays.asList(features.split(","));

    }

    public void loadAmenity() {
        aminityList = propertyRentalSessionBean.showAminityByPropertyType(propertyTypeIDFK);
//        numberList.clear();
//        nonNumberList.clear();
//        for (Aminitymaster aminity : aminityList) {
//            if(aminity.getIsNumber()==1){
//                numberList.add(aminity);
//            }
//            else if(aminity.getIsNumber()==0){
//               nonNumberList.add(aminity);
//            }
//        }

    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

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

    public int getPropertyIDPK() {
        return propertyIDPK;
    }

    public void setPropertyIDPK(int propertyIDPK) {
        this.propertyIDPK = propertyIDPK;
    }

    public int getAminityIDFK() {
        return aminityIDFK;
    }

    public void setAminityIDFK(int aminityIDFK) {
        this.aminityIDFK = aminityIDFK;
    }

    public int getAreaIDFK() {
        return areaIDFK;
    }

    public void setAreaIDFK(int areaIDFK) {
        this.areaIDFK = areaIDFK;
    }

    public int getUserIDFK() {
        return userIDFK;
    }

    public void setUserIDFK(int userIDFK) {
        this.userIDFK = userIDFK;
    }

    public int getPropertyTypeIDFK() {
        return propertyTypeIDFK;
    }

    public void setPropertyTypeIDFK(int propertyTypeIDFK) {
        this.propertyTypeIDFK = propertyTypeIDFK;
    }

    public int getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(int isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyDescription() {
        return propertyDescription;
    }

    public void setPropertyDescription(String propertyDescription) {
        this.propertyDescription = propertyDescription;
    }

    public String getPropertyRent() {
        return propertyRent;
    }

    public void setPropertyRent(String propertyRent) {
        this.propertyRent = propertyRent;
    }

    public String getPropertyAdvanceRent() {
        return propertyAdvanceRent;
    }

    public void setPropertyAdvanceRent(String propertyAdvanceRent) {
        this.propertyAdvanceRent = propertyAdvanceRent;
    }

    public List<Aminitymaster> getAminityList() {
        return aminityList;
    }

    public void setAminityList(List<Aminitymaster> aminityList) {
        this.aminityList = aminityList;
    }

    public List<Areamaster> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Areamaster> areaList) {
        this.areaList = areaList;
    }

    public List<Usermaster> getUserList() {
        return userList;
    }

    public void setUserList(List<Usermaster> userList) {
        this.userList = userList;
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

    public List<Propertymaster> show_property() {
        try {
            return propertyRentalSessionBean.showProperty();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Aminitymaster> show_aminityMasterList() {
        try {
            return propertyRentalSessionBean.showAminity();
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

    public List<Usermaster> show_userList() {
        try {
            return propertyRentalSessionBean.showUser();
        } catch (Exception e) {
            return null;
        }
    }

    public String insertProperty_click() {
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

            Propertytypemaster propertyType = propertyRentalSessionBean.searchPropertyType(propertyTypeIDFK);

            features = "";
            for (String sfeature : sfeatures) {
                if (features == "") {
                    features = sfeature;
                } else {

                    features = features + ", " + sfeature;
                }
            }
            if (propertyTypeName.equals("Residential")) {
                features += ", Bedroom : " + bedRoomNumber + ", ";
                features += "Bathroom : " + bathRoomNumber;
            }

            addedDate = new Date();
            Usermaster user = propertyRentalSessionBean.searchUser(17);
            Areamaster area = propertyRentalSessionBean.searchArea(areaIDFK);
            property.setPropertyIDPK(0);
            property.setPropertyName(propertyName);
            property.setPropertyDescription(propertyDescription);
            property.setPropertyFullAddress(propertyFullAddress);
            property.setPropertyShortAddress(propertyShortAddress);
            property.setPropertyRent(propertyRent);
            property.setPropertyAdvanceRent(propertyAdvanceRent);
            property.setAddedDate(addedDate);
            property.setIsAvailable(Short.valueOf("1"));
            property.setPropertyTypeIDFK(propertyType);
            property.setAreaIDFK(area);
            property.setUserIDFK(user);
            property.setFeatures(features);
            property.setMainPropertyImage(grfile);
            property.setIsActive(Short.valueOf("1"));
            System.out.println("Data : " + property.getPropertyName() + " " + property.getPropertyDescription() + " " + property.getPropertyAdvanceRent() + " " + property.getPropertyRent() + " " + property.getPropertyTypeIDFK());
            propertyRentalSessionBean.insertProperty(property);
            clear();
            return "/admin/showProperty.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String updateProperty_click() {
        try {
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

            Propertytypemaster propertyType = propertyRentalSessionBean.searchPropertyType(propertyTypeIDFK);

            Usermaster user = propertyRentalSessionBean.searchUser(userIDFK);
            Areamaster area = propertyRentalSessionBean.searchArea(areaIDFK);

            features = "";
            for (String sfeature : sfeatures) {
                if (features == "") {
                    features = sfeature;
                } else {
                    features = features + "," + sfeature;
                }
            }

            property.setPropertyIDPK(propertyIDPK);
            property.setPropertyName(propertyName);
            property.setPropertyDescription(propertyDescription);
            property.setPropertyFullAddress(propertyFullAddress);
            property.setPropertyShortAddress(propertyShortAddress);
            property.setIsAvailable(Short.valueOf("1"));
            property.setPropertyRent(propertyRent);
            property.setPropertyAdvanceRent(propertyAdvanceRent);
            property.setPropertyTypeIDFK(propertyType);
            property.setAreaIDFK(area);
            property.setUserIDFK(user);
            property.setMainPropertyImage(grfile);
            property.setFeatures(features);
            System.out.println(propertyRentalSessionBean.updateProperty(property));
            clear();
            return "/admin/showProperty.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String isAvailable_Click(int propertyIDPK, String isAvailable) {
        try {
            System.out.println("managedBean.propertyManagedBean.isAvailable_Click()" + isAvailable);
            propertyRentalSessionBean.isAvailableStatus(propertyIDPK, isAvailable);
            return "/admin/showProperty.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String isAvailable_Clickp(int propertyIDPK, String isAvailable) {
        try {
            System.out.println("managedBean.propertyManagedBean.isAvailable_Click()" + isAvailable);
            propertyRentalSessionBean.isAvailableStatus(propertyIDPK, isAvailable);
            return "/client/myProperty.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String deleteProperty_click(int propertyIDPK) {
        try {
            propertyRentalSessionBean.deleteProperty(propertyIDPK);
            return "/admin/showProperty.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String searchProperty_click(int id) {
        try {
            property = propertyRentalSessionBean.searchProperty(id);
            propertyIDPK = property.getPropertyIDPK();
            propertyName = property.getPropertyName();
            propertyDescription = property.getPropertyDescription();
            propertyFullAddress = property.getPropertyFullAddress();
            propertyShortAddress = property.getPropertyShortAddress();
            isAvailable = property.getIsAvailable();
            propertyRent = property.getPropertyRent();
            propertyAdvanceRent = property.getPropertyAdvanceRent();

            propertyTypeIDFK = property.getPropertyTypeIDFK().getPropertyTypeIDPK();
            areaIDFK = property.getAreaIDFK().getAreaIDPK();
            userIDFK = property.getUserIDFK().getUserIDPK();
            features = property.getFeatures();
            sfeatures = features.split(",");
            return "/admin/addProperty.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String insertReviewRating_click(Propertymaster prop) {
        try {
            System.out.println("managedBean.propertyManagedBean.insertReviewRating_click()" + prop.getPropertyIDPK());
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            HttpSession userSession = request.getSession();

            Usermaster user = propertyRentalSessionBean.searchUser(Integer.parseInt(userSession.getAttribute("userIDPK").toString()));

            //Propertymaster property1 = propertyRentalSessionBean.searchProperty(propertyIDFK);
            reviewRating.setReviewRatingIDPK(0);
            reviewRating.setReview(review);
            reviewRating.setRating(rating);
            reviewRating.setPropertyIDFK(prop);
            reviewRating.setUserIDFK(user);
            reviewRating.setIsActive(Short.parseShort("1"));
            System.out.println("managedBean.propertyManagedBean.insertReviewRating_click()Data :: " + reviewRating.getRating() + " " + reviewRating.getReview() + " " + reviewRating.getPropertyIDFK().getPropertyIDPK() + " " + reviewRating.getUserIDFK().getUserIDPK());
            propertyRentalSessionBean.insertReviewRating(reviewRating);
            //clear();
            return "/client/index.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public int getByRating(int id) {
        int avg = 0, rate = 0;
        try {
            List<Reviewratingmaster> r = propertyRentalSessionBean.getRatingByProperty(id);
            for (int i = 0; i < r.size(); i++) {
                rate += Integer.parseInt(r.get(i).getRating());
            }

            avg = rate / r.size();
            return avg;
        } catch (Exception e) {
            return 0;
        }
    }

    public void clear() {
        propertyIDPK = 0;
        propertyName = "";
        propertyDescription = "";
        propertyFullAddress = "";
        propertyShortAddress = "";
        isAvailable = 0;
        propertyRent = "";
        propertyAdvanceRent = "";
        aminityIDFK = 0;
        propertyTypeIDFK = 0;
        areaIDFK = 0;
        userIDFK = 0;
        features = "";
    }

    public List<Propertymaster> showTopProperties() {
        try {
            return propertyRentalSessionBean.showTopPropertyList();
        } catch (Exception e) {
            return null;
        }
    }
}

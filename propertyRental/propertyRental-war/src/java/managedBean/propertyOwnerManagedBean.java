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
import entity.Statemaster;
import entity.Usermaster;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import static managedBean.propertyImageManagedBean.getAllParts;
import sessionBean.propertyRentalSessionBeanLocal;

/**
 *
 * @author Admin
 */
@Named(value = "propertyOwnerBean")
@ApplicationScoped
public class propertyOwnerManagedBean {

    @EJB
    private propertyRentalSessionBeanLocal propertyRentalSessionBean;

    
    /**
     * Creates a new instance of propertyOwnerManagedBean
     */
    public propertyOwnerManagedBean() {
    }
    
    int propertyIDPK, aminityIDFK, areaIDFK, userIDFK, propertyTypeIDFK, stateIDFK, cityIDFK, isAvailable, bedRoomNumber, bathRoomNumber, propertyIDFK;
    String propertyName, propertyDescription,stateName, cityName, areaName, propertyFullAddress, propertyShortAddress, propertyRent, propertyAdvanceRent, features, propertyTypeName, propertySubTypeName, grfile, grfile1;
    String[] sfeatures, snum, snonnum;
    Part file, filelist;
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
    Propertyimagemaster propertyImage = new Propertyimagemaster();
    
    @PostConstruct
    public void init() {
        propertyTypeList = propertyRentalSessionBean.showPropertyType();
        userList = propertyRentalSessionBean.showUser();
        stateList = propertyRentalSessionBean.showState();
        //aminityList = propertyRentalSessionBean.showAminity();
        propertyIDPK = 0;
    }

    public propertyRentalSessionBeanLocal getPropertyRentalSessionBean() {
        return propertyRentalSessionBean;
    }

    public void setPropertyRentalSessionBean(propertyRentalSessionBeanLocal propertyRentalSessionBean) {
        this.propertyRentalSessionBean = propertyRentalSessionBean;
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

    public int getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(int isAvailable) {
        this.isAvailable = isAvailable;
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

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
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

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    
    public String getGrfile() {
        return grfile;
    }

    public void setGrfile(String grfile) {
        this.grfile = grfile;
    }

    public String[] getSfeatures() {
        return sfeatures;
    }

    public void setSfeatures(String[] sfeatures) {
        this.sfeatures = sfeatures;
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

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
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

    public List<Propertymaster> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Propertymaster> propertyList) {
        this.propertyList = propertyList;
    }

    public Propertymaster getProperty() {
        return property;
    }

    public void setProperty(Propertymaster property) {
        this.property = property;
    }

    public Part getFilelist() {
        return filelist;
    }

    public void setFilelist(Part filelist) {
        this.filelist = filelist;
    }

    public Propertyimagemaster getPropertyImage() {
        return propertyImage;
    }

    public void setPropertyImage(Propertyimagemaster propertyImage) {
        this.propertyImage = propertyImage;
    }

    public int getPropertyIDFK() {
        return propertyIDFK;
    }

    public void setPropertyIDFK(int propertyIDFK) {
        this.propertyIDFK = propertyIDFK;
    }

    public String getGrfile1() {
        return grfile1;
    }

    public void setGrfile1(String grfile1) {
        this.grfile1 = grfile1;
    }
    
    
    
    
    public void fillCity() {
        System.out.println("managedBean.propertyManagedBean.fillCity()" + stateIDFK);
        cityList = propertyRentalSessionBean.showCityByState(stateIDFK);
    }

    public void fillArea() {
        areaList = propertyRentalSessionBean.showAreaByCity(cityIDFK);
    }
    
    public void loadAmenity() {
        aminityList = propertyRentalSessionBean.showAminityByPropertyType(propertyTypeIDFK);
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
    
    public void propertysubTypeByPropertyName()
    {
        propertySubTypeList=propertyRentalSessionBean.showPropertySubType(propertyTypeName);
    }

     public static Collection<Part> getAllParts(Part part) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return request.getParts().stream().filter(p -> part.getName().equals(p.getName())).collect(Collectors.toList());
    }
     
    public String insertProperty_click() 
    {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            HttpSession userSession = request.getSession();
            
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
                    
                    features = features+", " + sfeature;
                }
            }
                if(propertyTypeName.equals("Residential")){
                features += ", Bedroom : "+ bedRoomNumber + ", ";
                features += "Bathroom : "+ bathRoomNumber;
                }
            
            
            
            addedDate = new Date();
            Usermaster user = propertyRentalSessionBean.searchUser(Integer.parseInt(userSession.getAttribute("userIDPK").toString()));
            Areamaster area = propertyRentalSessionBean.searchArea(areaIDFK);
            property.setPropertyIDPK(0);
            property.setPropertyName(propertyName);
            property.setPropertyDescription(propertyDescription);
            property.setPropertyFullAddress(propertyFullAddress);
            property.setPropertyShortAddress(propertyShortAddress);
            property.setPropertyRent(propertyRent);
            property.setPropertyAdvanceRent(propertyAdvanceRent);
            property.setAddedDate(addedDate);
            property.setIsAvailable(Short.valueOf("0"));
            property.setPropertyTypeIDFK(propertyType);
            property.setAreaIDFK(area);
            property.setUserIDFK(user);
            property.setFeatures(features);
            property.setMainPropertyImage(grfile);
            property.setIsActive(Short.valueOf("1"));
            //System.out.println("Data : "+ property.getPropertyName()+ " "+property.getPropertyDescription()+" "+property.getPropertyAdvanceRent()+" "+property.getPropertyRent()+" "+property.getPropertyTypeIDFK());
            
            propertyRentalSessionBean.insertProperty(property);
            
            
            for (Part part : getAllParts(filelist)) {
                InputStream input1 = part.getInputStream();
            String path1 = "D:\\SEM_8_PROJECT\\Project\\propertyRental\\propertyRental-war\\web\\uploads";
            Random random1 = new Random();
            StringBuilder sb1 = new StringBuilder();
            
            sb1.append(random.nextInt(9) + 1);
            for (int i = 0; i < 11; i++) {
                sb1.append(random.nextInt(10));
            }
            String temp1 = sb1.toString();
            
            grfile1 = "IMG_" + temp1 + part.getSubmittedFileName();
            Files.copy(input1, new File(path1, grfile1).toPath());
                System.out.println("managedBean.propertyImageManagedBean.insertPropertyImage_click()"+ propertyIDFK);
            propertyImage.setPropertyImageIDPK(0);
            Propertymaster p = propertyRentalSessionBean.getLastInsertedPropertyID();
            propertyImage.setPropertyImage(grfile1);
            propertyImage.setPropertyIDFK(p);
            propertyImage.setIsActive(Short.valueOf("1"));
            propertyRentalSessionBean.insertPropertyImage(propertyImage);  
            }
            clear();
            
            return "/client/myProperty.xhtml?faces-redirect=true";
            
        } catch (Exception e) {
            return e.getMessage();
        }
    } 
     
    public String updateProperty_click() 
    {
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

            //Propertytypemaster propertyType = propertyRentalSessionBean.searchPropertyType(propertyTypeIDFK);

            //Usermaster user = propertyRentalSessionBean.searchUser(userIDFK);
            //Areamaster area = propertyRentalSessionBean.searchArea(areaIDFK);

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
            property.setIsAvailable(Short.valueOf("0"));
            property.setPropertyRent(propertyRent);
            property.setPropertyAdvanceRent(propertyAdvanceRent);
//            property.setPropertyTypeIDFK(propertyType);
//            property.setAreaIDFK(area);
//            property.setUserIDFK(user);
            property.setMainPropertyImage(grfile);
            property.setFeatures(features);
            //System.out.println(propertyRentalSessionBean.updateProperty(property));
            propertyRentalSessionBean.updateProperty(property);
            clear();
            
            return "/client/index.xhtml?faces-redirect=true";
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String deleteProperty_click(int propertyIDPK) {
        try {
            propertyRentalSessionBean.deleteProperty(propertyIDPK);
            return "/client/index.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public void clear() {
        //propertyIDPK = 0;
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
            propertyTypeName = property.getPropertyTypeIDFK().getPropertyTypeName();
            propertysubTypeByPropertyName();
            areaIDFK = property.getAreaIDFK().getAreaIDPK();
            areaName = property.getAreaIDFK().getAreaName();
            cityIDFK = property.getAreaIDFK().getCityIDFK().getCityIDPK();
            cityName = property.getAreaIDFK().getCityIDFK().getCityName();
            
            stateIDFK = property.getAreaIDFK().getCityIDFK().getStateIDFK().getStateIDPK();
            stateName = property.getAreaIDFK().getCityIDFK().getStateIDFK().getStateName();
            fillArea();
            fillCity();
            userIDFK = property.getUserIDFK().getUserIDPK();
            features = property.getFeatures();
            sfeatures = features.split(",");
            
            grfile = property.getMainPropertyImage();
            return "/client/submitProperty.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

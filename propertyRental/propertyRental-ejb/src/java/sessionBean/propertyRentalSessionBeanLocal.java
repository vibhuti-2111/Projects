/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package sessionBean;

import entity.Aminitymaster;
import entity.Areamaster;
import entity.Chatmaster;
import entity.Citymaster;
import entity.Propertyimagemaster;
import entity.Propertymaster;
import entity.Propertytypemaster;
import entity.Reviewratingmaster;
import entity.Statemaster;
import entity.Usermaster;
import entity.Userrequestmaster;
import javax.ejb.Local;
import java.util.List;
/**
 *
 * @author Admin
 */
@Local
public interface propertyRentalSessionBeanLocal {
    
    //login
    public Usermaster login(String userEmail, String userPassword);
    
    public Usermaster findmail(String email); 
    
    //stateMaster
    public List<Statemaster> showState();
    
    public String insertState(Statemaster state);
    
    public String updateState(Statemaster state);
    
    public String deleteState(int stateIDPK);
    
    public Statemaster searchState(int stateIDPK);
    
    //cityMaster
    public List<Citymaster> showCity();
    
    public List<Citymaster> showCityByState(int id);
    
    public List<Areamaster> showAreaByCity(int id);
    
    public List<Propertytypemaster> showPropertyByType(String propertyTypeName);
    
    public List<Aminitymaster> showAminityByPropertyType(int id);
    
    public String insertCity(Citymaster city);
    
    public String updateCity(Citymaster city);
    
    public String deleteCity(int cityIDPK);
    
    public Citymaster searchCity(int cityIDPK);
    
    //areaMaster
    public List<Areamaster> showArea();
    
    public String insertArea(Areamaster area);
    
    public String updateArea(Areamaster area);
    
    public String deleteArea(int areaIDPK);
    
    public Areamaster searchArea(int areaIDPK);
    
    //propertyTypeMaster
    public List<Propertytypemaster> showPropertyType();
    
    public String insertPropertyType(Propertytypemaster propertyType);
    
    public String updatePropertyType(Propertytypemaster propertyType);
    
    public String deletePropertyType(int propertyTypeIDPK);
    
    public Propertytypemaster searchPropertyType(int propertyTypeIDPK);
    
    public List<Propertytypemaster> showPropertySubType(String typeName);
    
    public List<Propertymaster> ListPropertyByType(String propertyTypeName);
    
    public List<Propertymaster> showPropertyByPropertyTypeName(String propertyTypeName);
    
    public List<Propertymaster> showPropertyByUser(int userIDFK);
    
    //aminityMaster
    public List<Aminitymaster> showAminity();
    
    public String insertAminity(Aminitymaster aminity);
    
    public String updateAminity(Aminitymaster aminity);
    
    public String deleteAminity(int aminityIDPK);
    
    public Aminitymaster searchAminity(int aminityIDPK);
    
    //propertyMaster
    public List<Propertymaster> showProperty();
    
    public List<Propertymaster> showTopPropertyList();
    
    public String insertProperty(Propertymaster property);
    
    public String updateProperty(Propertymaster property);
    
    public String deleteProperty(int propertyIDPK);
    
    public String isAvailableStatus(int propertyIDPK, String isAvailable);
    
    public Propertymaster searchProperty(int propertyIDPK);
    
    public String insertPropertyByPropertyOwner(Propertymaster property);
    
    public List<Propertymaster> propertyListByPropertyType(int propertyTypeIDFK);
    
    public Propertymaster searchPropertyByID(int propertyIDPK);
    
    public Propertymaster getLastInsertedPropertyID();

    
    //propertyImageMaster
    public List<Propertyimagemaster> showPropertyImage();
    
    public String insertPropertyImage(Propertyimagemaster propertyImage);
    
    public String updatePropertyImage(Propertyimagemaster propertyImage);
    
    public String deletePropertyImage(int propertyImageIDPK);
    
    public Propertyimagemaster searchPropertyImage(int propertyImageIDPK);
    
    public List<Propertyimagemaster> findByPropertyimg(int id);
    
    //reviewRatingMaster
    public List<Reviewratingmaster> showReviewRating();
    
    public List<Reviewratingmaster> showReviewRatingByProperty(int propertyIDPK);
    
    public String insertReviewRating(Reviewratingmaster reviewRating);
    
    public String updateReviewRating(Reviewratingmaster reviewRating);
    
    public String deleteReviewRating(int reviewRatingIDPK);
    
    public Reviewratingmaster searchReviewRating(int reviewRatingIDPK);
    
    public List<Reviewratingmaster> getRatingByProperty(int propertyIDFK);
    
    //userMaster
    public List<Usermaster> showUser();
    
    public String insertUser(Usermaster user);
    
    public String updateUser(Usermaster user);
    
    public String updateUserPassword(Usermaster user);
    
    public String deleteUser(int userIDPK);
    
    public Usermaster searchUser(int userIDPK);
    
    //userRequestMaster
    public List<Userrequestmaster> showUserRequest();
    
    public String insertUserRequest(Userrequestmaster userRequest);
    
    public String updateUserRequest(Userrequestmaster userRequest);
    
    public String deleteUserRequest(int userRequestIDPK);
    
    public Userrequestmaster searchUserRequest(int userRequestIDPK);
    
    public List<Reviewratingmaster> showTopReviewList();
    
    public List<Userrequestmaster> showRequestByUser(int userIDFK);
    
    public List<Userrequestmaster> showRequestByProperty(int propertyIDFK);
    
    public String changeStatus(int userRequestIDPK, String status);
    
    //chatMaster
    public List<Chatmaster> showChat();
    
    public List<Chatmaster> showChatByProperty(int propertyIDFK);
    
    public String insertChat(Chatmaster chat);
    
    public String updateChat(Chatmaster chat);
    
    public String deleteChat(int chatIDPK);
    
    public Chatmaster searchChat(int chatIDPK);

    
    
}

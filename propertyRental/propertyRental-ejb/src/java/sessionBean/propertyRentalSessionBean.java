/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
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
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Admin
 */
@Stateless
public class propertyRentalSessionBean implements propertyRentalSessionBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = "propertyRental-ejbPU")
    public EntityManager em;

    //login

    @Override
    public Usermaster login(String userEmail, String userPassword) {
        System.out.println("Login Details SS : " + userEmail + userPassword);
        
        try {
            Usermaster um = (Usermaster) em.createNamedQuery("Usermaster.findUserForLogin")
                .setParameter("userEmail", userEmail)
                .setParameter("userPassword", userPassword)
                .getSingleResult();
        return um;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    @Override
    public Usermaster findmail(String email) {
        try {
             Usermaster us=(Usermaster)em.createNamedQuery("Usermaster.findByUserEmail").setParameter("userEmail", email).getSingleResult();
            return us; 
        } catch (Exception e) {
         return null;   
        }
      
    }
    
    
    //Display state
    @Override
    public List<Statemaster> showState() {
        List<Statemaster> stateList = em.createNamedQuery("Statemaster.findAll").getResultList();
        System.out.println("sessionBean.propertyRentalSessionBean.showState()"+stateList.size());
        return stateList;
    }

    //insert state
    @Override
    public String insertState(Statemaster state) {
        try {
            em.persist(state);
            return "Record Inserted!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //update state
    @Override
    public String updateState(Statemaster state) {
        try {
            Statemaster updateState = em.find(Statemaster.class, state.getStateIDPK());
            updateState.setStateName(state.getStateName());
            em.persist(updateState);
            return "Record Updated!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //delete state
    @Override
    public String deleteState(int stateIDPK) {
        try {
            Statemaster state = em.find(Statemaster.class, stateIDPK);
            //state.setIsActive(false);
            em.persist(state);
            return "Record Deleted!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //search state
    @Override
    public Statemaster searchState(int stateIDPK) {
        try {
            Statemaster state = (Statemaster) em.find(Statemaster.class, stateIDPK);
            return state;
        } catch (Exception e) {
            return null;
        }
    }

    //display city
    @Override
    public List<Citymaster> showCity() {
        List<Citymaster> cityList = em.createNamedQuery("Citymaster.findAll").getResultList();
        return cityList;
    }
    
    @Override
    public List<Propertytypemaster> showPropertyByType(String propertyTypeName) {
        List<Propertytypemaster> tList = em.createNamedQuery("Propertytypemaster.findByPropertyTypeName").setParameter("propertyTypeName", propertyTypeName).getResultList();
        return tList;
    }
    
    @Override
    public List<Propertymaster> ListPropertyByType(String propertyTypeName) {
        List<Propertymaster> tList = em.createNamedQuery("Propertymaster.findByPropertyTypeName").setParameter("propertyTypeName", propertyTypeName).getResultList();
        return tList;
    }

    @Override
    public List<Propertymaster> showPropertyByUser(int userIDFK) {
        List<Propertymaster> uList = em.createNamedQuery("Propertymaster.findByUser").setParameter("userIDFK", userIDFK).getResultList();
        System.out.println("Proprty List"+uList.size());
        return uList;
    }
    
    
    @Override
    public List<Citymaster> showCityByState(int id) {
        List<Citymaster> cityList = em.createNamedQuery("Citymaster.findCityByState").setParameter("stateIDFK", id).getResultList();
        return cityList;
    }
    
    @Override
    public List<Aminitymaster> showAminityByPropertyType(int id) {
        List<Aminitymaster> aminityList = em.createNamedQuery("Aminitymaster.findAminityByPropertyType").setParameter("propertyTypeIDFK", id).getResultList();
        return aminityList;
    }
    
    @Override
    public List<Areamaster> showAreaByCity(int id) {
        List<Areamaster> areaList = em.createNamedQuery("Areamaster.findAreaByCity").setParameter("cityIDFK", id).getResultList();
        return areaList;
    }

    //insret city
    @Override
    public String insertCity(Citymaster city) {
        try {
            em.persist(city);
            return "Record Inserted!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //update city
    @Override
    public String updateCity(Citymaster city) {
        try {
            Citymaster updateCity = em.find(Citymaster.class, city.getCityIDPK());
            Statemaster updateState = em.find(Statemaster.class, city.getStateIDFK().getStateIDPK());
            
            updateCity.setCityName(city.getCityName());
            updateCity.setStateIDFK(updateState);
            em.persist(updateCity);
            return "Record Updated!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //delete city
    @Override
    public String deleteCity(int cityIDPK) {
        try {
            Citymaster city = em.find(Citymaster.class, cityIDPK);
            city.setIsActive(Short.valueOf("0"));
            em.persist(city);
            return "Record Deleted!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //search city
    @Override
    public Citymaster searchCity(int cityIDPK) {
        try {
            Citymaster city = (Citymaster) em.find(Citymaster.class, cityIDPK);
            return city;
        } catch (Exception e) {
            return null;
        }
    }

    //display area
    @Override
    public List<Areamaster> showArea() {
        List<Areamaster> areaList = em.createNamedQuery("Areamaster.findAll").getResultList();
        return areaList;
    }

    //insert area
    @Override
    public String insertArea(Areamaster area) {
        try {
            em.persist(area);
            return "Record Inserted!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    //update area
    @Override
    public String updateArea(Areamaster area) {
        try {
            Areamaster updateArea = em.find(Areamaster.class, area.getAreaIDPK());
            Citymaster updateCity = em.find(Citymaster.class, area.getCityIDFK().getCityIDPK());
            
            updateArea.setAreaName(area.getAreaName());
            updateArea.setCityIDFK(updateCity);
            em.persist(updateArea);
            return "Record Updated!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    //delete area
    @Override
    public String deleteArea(int areaIDPK) {
        try {
            Areamaster area = em.find(Areamaster.class, areaIDPK);
            area.setIsActive(Short.valueOf("0"));
            em.persist(area);
            return "Record Deleted!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //search area
    @Override
    public Areamaster searchArea(int areaIDPK) {
        try {
            Areamaster area = (Areamaster) em.find(Areamaster.class, areaIDPK);
            return area;
        } catch (Exception e) {
            return null;
        }
    }

    //display property type
    @Override
    public List<Propertytypemaster> showPropertyType() {
        List<Propertytypemaster> propertyTypeList = em.createNamedQuery("Propertytypemaster.findAll").getResultList();
        return propertyTypeList;
    }

    //insert property type
    @Override
    public String insertPropertyType(Propertytypemaster propertyType) {
        try {
            em.persist(propertyType);
            return "Record Inserted!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //update property type
    @Override
    public String updatePropertyType(Propertytypemaster propertyType) {
        try {
            Propertytypemaster updatePropertyType = em.find(Propertytypemaster.class, propertyType.getPropertyTypeIDPK());
            updatePropertyType.setPropertyTypeName(propertyType.getPropertyTypeName());
            updatePropertyType.setPropertySubTypeName(propertyType.getPropertySubTypeName());
            em.persist(updatePropertyType);
            return "Record Updated!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //delete property type
    @Override
    public String deletePropertyType(int propertyTypeIDPK) {
        try {
            Propertytypemaster propertyType = em.find(Propertytypemaster.class, propertyTypeIDPK);
            propertyType.setIsActive(Short.valueOf("0"));
            em.persist(propertyType);
            return "Record Deleted!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //search property type
    @Override
    public Propertytypemaster searchPropertyType(int propertyTypeIDPK) {
        try {
            Propertytypemaster propertyType = (Propertytypemaster) em.find(Propertytypemaster.class, propertyTypeIDPK);
            return propertyType;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Propertytypemaster> showPropertySubType(String typeName) {
        List<Propertytypemaster> propertyTypeList = em.createNamedQuery("Propertytypemaster.findByPropertyTypeName").setParameter("propertyTypeName", typeName).getResultList();
        return propertyTypeList;
    }

    @Override
    public List<Propertymaster> showPropertyByPropertyTypeName(String propertyTypeName) {
        List<Propertymaster> propertyTypeList = em.createNamedQuery("Propertymaster.findByPropertyTypeName").setParameter("propertyTypeName", propertyTypeName).getResultList();
        return propertyTypeList;
    }
    
    

    //display aminity
    @Override
    public List<Aminitymaster> showAminity() {
        List<Aminitymaster> aminityList = em.createNamedQuery("Aminitymaster.findAll").getResultList();
        return aminityList;
    }

    //insert aminity
    @Override
    public String insertAminity(Aminitymaster aminity) {
        try {
            em.persist(aminity);
            return "Record Inserted!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    // update aminity
    @Override
    public String updateAminity(Aminitymaster aminity) {
        try {
            Aminitymaster updateAminity = em.find(Aminitymaster.class, aminity.getAminityIDPK());
            Propertytypemaster updatePropertyType = em.find(Propertytypemaster.class, aminity.getPropertyTypeIDFK().getPropertyTypeIDPK());
            
            updateAminity.setAminityName(aminity.getAminityName());
            updateAminity.setIsNumber(aminity.getIsNumber());
            updateAminity.setPropertyTypeIDFK(updatePropertyType);
            em.persist(updateAminity);
            return "Record Updated!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //delete aminity
    @Override
    public String deleteAminity(int aminityIDPK) {
        try {
            Aminitymaster aminity = em.find(Aminitymaster.class, aminityIDPK);
            aminity.setIsActive(Short.valueOf("0"));
            em.persist(aminity);
            return "Record Deleted!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //search aminity
    @Override
    public Aminitymaster searchAminity(int aminityIDPK) {
        try {
            Aminitymaster aminity = (Aminitymaster) em.find(Aminitymaster.class, aminityIDPK);
            return aminity;
        } catch (Exception e) {
            return null;
        }
    }

    //display property
    @Override
    public List<Propertymaster> showProperty() {
        List<Propertymaster> propertyList = em.createNamedQuery("Propertymaster.findAll").getResultList();
        return propertyList;
    }

    @Override
    public List<Propertymaster> showTopPropertyList() {
        List<Propertymaster> propertyList = em.createNamedQuery("Propertymaster.findAll").setMaxResults(3).getResultList();
        return propertyList;
    }
    
    

    //insert property
    @Override
    public String insertProperty(Propertymaster property) {
        try {
            em.persist(property);
            return "Record Inserted!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //update property
    @Override
    public String updateProperty(Propertymaster property) {
        try {
            Propertymaster updateProperty = em.find(Propertymaster.class, property.getPropertyIDPK());
            Areamaster updateArea = em.find(Areamaster.class, property.getAreaIDFK().getAreaIDPK());
            Usermaster updateUser = em.find(Usermaster.class, property.getUserIDFK().getUserIDPK());
            
            Propertytypemaster updatePropertyType = em.find(Propertytypemaster.class, property.getPropertyTypeIDFK().getPropertyTypeIDPK());
            
            updateProperty.setPropertyName(property.getPropertyName());
            updateProperty.setPropertyDescription(property.getPropertyDescription());
            updateProperty.setPropertyFullAddress(property.getPropertyFullAddress());
            updateProperty.setPropertyShortAddress(property.getPropertyShortAddress());
            updateProperty.setIsAvailable(property.getIsAvailable());
            updateProperty.setPropertyRent(property.getPropertyRent());
            updateProperty.setPropertyAdvanceRent(property.getPropertyAdvanceRent());
            updateProperty.setMainPropertyImage(property.getMainPropertyImage());
            updateProperty.setPropertyTypeIDFK(updatePropertyType);
            updateProperty.setAreaIDFK(updateArea);
            updateProperty.setUserIDFK(updateUser);
            updateProperty.setFeatures(property.getFeatures());
            
            em.persist(updateProperty);
            return "Record Updated!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //delete property
    @Override
    public String deleteProperty(int propertyIDPK) {
        try {
            Propertymaster property = em.find(Propertymaster.class, propertyIDPK);
            property.setIsActive(Short.valueOf("0"));
            em.persist(property);
            return "Record Deleted!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    //available status
    @Override
    public String isAvailableStatus(int propertyIDPK, String isAvailable) {
        try {
            Propertymaster property = em.find(Propertymaster.class, propertyIDPK);
            
            property.setIsAvailable(Short.valueOf(isAvailable));
            em.persist(property);
            return "Status Changed!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //search property
    @Override
    public Propertymaster searchProperty(int propertyIDPK) {
        try {
            Propertymaster property = (Propertymaster) em.find(Propertymaster.class, propertyIDPK);
            return property;
        } catch (Exception e) {
            return null;
        }
    }

    //insert property by property owner
    @Override
    public String insertPropertyByPropertyOwner(Propertymaster property) {
        try {
            em.persist(property);
            return "Record Inserted!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public List<Propertymaster> propertyListByPropertyType(int propertyTypeIDFK) {
        List<Propertymaster> pList = em.createNamedQuery("Propertymaster.findByPropertyType").setParameter("propertyTypeIDFK", propertyTypeIDFK).getResultList();
        return pList;
    }

    @Override
    public Propertymaster searchPropertyByID(int propertyIDPK) {
        return (Propertymaster) em.createNamedQuery("Propertymaster.findByPropertyIDPK").setParameter("propertyIDPK", propertyIDPK).getSingleResult();  
    }

    @Override
    public Propertymaster getLastInsertedPropertyID() {
        try {
            List<Propertymaster> pr=em.createNamedQuery("Propertymaster.findPropertyIdByLast").getResultList();
            return pr.get(0);
        } catch (Exception e) {
           return null; 
        }

    }

    //display property image
    @Override
    public List<Propertyimagemaster> showPropertyImage() {
        List<Propertyimagemaster> propertyImageList = em.createNamedQuery("Propertymaster.findAll").getResultList();
        return propertyImageList;
    }

    //insert property image
    @Override
    public String insertPropertyImage(Propertyimagemaster propertyImage) {
        try {
            em.persist(propertyImage);
            return "Record Inserted!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //update property image
    @Override
    public String updatePropertyImage(Propertyimagemaster propertyImage) {
        try {
            Propertyimagemaster updatePropertyImage = em.find(Propertyimagemaster.class, propertyImage.getPropertyImageIDPK());
            Propertymaster updateProperty = em.find(Propertymaster.class, propertyImage.getPropertyIDFK().getPropertyIDPK());
            
            updatePropertyImage.setPropertyImage(propertyImage.getPropertyImage());
            updatePropertyImage.setPropertyIDFK(updateProperty);
            em.persist(updatePropertyImage);
            return "Record Updated!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //delete property image
    @Override
    public String deletePropertyImage(int propertyImageIDPK) {
        try {
            Propertyimagemaster propertyImage = em.find(Propertyimagemaster.class, propertyImageIDPK);
            propertyImage.setIsActive(Short.valueOf("0"));
            em.persist(propertyImage);
            return "Record Deleted!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //search property image
    @Override
    public Propertyimagemaster searchPropertyImage(int propertyImageIDPK) {
        try {
            Propertyimagemaster propertyImage = (Propertyimagemaster) em.find(Propertyimagemaster.class, propertyImageIDPK);
            return propertyImage;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Propertyimagemaster> findByPropertyimg(int id) {
        List<Propertyimagemaster> list=em.createNamedQuery("Propertyimagemaster.findByPropertyImg").setParameter("propertyIDFK", id).getResultList();
       return list;
    }
    
    

    //display review rating
    @Override
    public List<Reviewratingmaster> showReviewRating() {
        List<Reviewratingmaster> reviewRatingList = em.createNamedQuery("Reviewratingmaster.findAll").getResultList();
        return reviewRatingList;
    }

    @Override
    public List<Reviewratingmaster> showReviewRatingByProperty(int propertyIDPK) {
        List<Reviewratingmaster> reviewRatingList = em.createNamedQuery("Reviewratingmaster.findByRatingByProperty").setParameter("propertyIDFK", propertyIDPK).getResultList();
        return reviewRatingList;
    }
    
    

    //insert review rating
    @Override
    public String insertReviewRating(Reviewratingmaster reviewRating) {
        try {
            em.persist(reviewRating);
            return "Record Inserted!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //update review raitng
    @Override
    public String updateReviewRating(Reviewratingmaster reviewRating) {
        try {
            Reviewratingmaster updateReviewRating = em.find(Reviewratingmaster.class, reviewRating.getReviewRatingIDPK());
            Propertymaster updateProperty = em.find(Propertymaster.class, reviewRating.getPropertyIDFK().getPropertyIDPK());
            
            updateReviewRating.setRating(reviewRating.getRating());
            updateReviewRating.setReview(reviewRating.getReview());
            updateReviewRating.setPropertyIDFK(updateProperty);
            em.persist(updateReviewRating);
            return "Record Updated!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //delete review rating
    @Override
    public String deleteReviewRating(int reviewRatingIDPK) {
        try {
            Reviewratingmaster reviewRating = em.find(Reviewratingmaster.class, reviewRatingIDPK);
            reviewRating.setIsActive(Short.valueOf("0"));
            em.persist(reviewRating);
            return "Record Deleted!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //search review rating
    @Override
    public Reviewratingmaster searchReviewRating(int reviewRatingIDPK) {
        try {
            Reviewratingmaster reviewRating = (Reviewratingmaster) em.find(Reviewratingmaster.class, reviewRatingIDPK);
            return reviewRating;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Reviewratingmaster> getRatingByProperty(int propertyIDFK) {
        List<Reviewratingmaster> rList = em.createNamedQuery("Reviewratingmaster.findByRatingByProperty").setParameter("propertyIDFK", propertyIDFK).getResultList();
        return rList;
    }
    
    

    //display user
    @Override
    public List<Usermaster> showUser() {
        List<Usermaster> userList = em.createNamedQuery("Usermaster.findAll").getResultList();
        return userList;
    }

    //insert user
    @Override
    public String insertUser(Usermaster user) {
        try {
            em.persist(user);
            return "Record Inserted!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //update user
    @Override
    public String updateUser(Usermaster user) {
        try {
            Usermaster updateUser = em.find(Usermaster.class, user.getUserIDPK());
            
            updateUser.setUserFname(user.getUserFname());
            updateUser.setUserLname(user.getUserLname());
            updateUser.setUserType(user.getUserType());
            updateUser.setUserEmail(user.getUserEmail());
            
            updateUser.setUserContactNo(user.getUserContactNo());
            
            updateUser.setUserImage(user.getUserImage());
            
            em.persist(updateUser);
            return "Record Updated!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updateUserPassword(Usermaster user) {
        try {
            Usermaster updateUser = em.find(Usermaster.class, user.getUserIDPK());
            
            updateUser.setUserFname(user.getUserFname());
            updateUser.setUserLname(user.getUserLname());
            updateUser.setUserType(user.getUserType());
            updateUser.setUserEmail(user.getUserEmail());
            updateUser.setUserPassword(user.getUserPassword());
            updateUser.setUserContactNo(user.getUserContactNo());
            
            //updateUser.setUserImage(user.getUserImage());
            
            em.persist(updateUser);
            return "Record Updated!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    

    //delete user
    @Override
    public String deleteUser(int userIDPK) {
        try {
            Usermaster user = em.find(Usermaster.class, userIDPK);
            user.setIsActive(Short.valueOf("0"));
            em.persist(user);
            return "Record Deleted!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //search user
    @Override
    public Usermaster searchUser(int userIDPK) {
        try {
            Usermaster user = (Usermaster) em.find(Usermaster.class, userIDPK);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    //display user request
    @Override
    public List<Userrequestmaster> showUserRequest() {
        List<Userrequestmaster> userRequestList = em.createNamedQuery("Userrequestmaster.findAll").getResultList();
        return userRequestList;
    }

    @Override
    public List<Reviewratingmaster> showTopReviewList() {
        List<Reviewratingmaster> rList = em.createNamedQuery("Reviewratingmaster.findAll").setMaxResults(3).getResultList();
        return rList;
    }

    //insert user request
    @Override
    public String insertUserRequest(Userrequestmaster userRequest) {
        try {
            em.persist(userRequest);
            return "Record Inserted!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //update user request
    @Override
    public String updateUserRequest(Userrequestmaster userRequest) {
        try {
            Userrequestmaster updateUserRequest = em.find(Userrequestmaster.class, userRequest.getUserRequestIDPK());
            Propertymaster updateProperty = em.find(Propertymaster.class, userRequest.getPropertyIDFK().getPropertyIDPK());
            Usermaster updateUser = em.find(Usermaster.class, userRequest.getUserIDFK().getUserIDPK());
            
            updateUserRequest.setStatus(userRequest.getStatus());
            updateUserRequest.setPropertyIDFK(updateProperty);
            updateUserRequest.setUserIDFK(updateUser);
            em.persist(updateUserRequest);
            return "Record Updated!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //delete user request
    @Override
    public String deleteUserRequest(int userRequestIDPK) {
        try {
            Userrequestmaster userRequest = em.find(Userrequestmaster.class, userRequestIDPK);
            userRequest.setIsActive(Short.valueOf("0"));
            em.persist(userRequest);
            return "Record Deleted!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //search user request
    @Override
    public Userrequestmaster searchUserRequest(int userRequestIDPK) {
        try {
            Userrequestmaster userRequest = (Userrequestmaster) em.find(Userrequestmaster.class, userRequestIDPK);
            return userRequest;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String changeStatus(int userRequestIDPK, String status) {
        try {
            Userrequestmaster userReq = em.find(Userrequestmaster.class, userRequestIDPK);
            
            userReq.setStatus(Short.valueOf(status));
            em.persist(userReq);
            return "Status Changed!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public List<Userrequestmaster> showRequestByProperty(int propertyIDFK) {
        List<Userrequestmaster> pList = em.createNamedQuery("Userrequestmaster.findByProperty").setParameter("propertyIDFK", propertyIDFK).getResultList();
        return pList;
    }

    @Override
    public List<Userrequestmaster> showRequestByUser(int userIDFK) {
        List<Userrequestmaster> uList = em.createNamedQuery("Userrequestmaster.findByUser").setParameter("userIDFK", userIDFK).getResultList();
        return uList;
    }

    //display chat
    @Override
    public List<Chatmaster> showChat() {
        List<Chatmaster> chatList = em.createNamedQuery("Chatmaster.findAll").getResultList();
        return chatList;
    }

    @Override
    public List<Chatmaster> showChatByProperty(int propertyIDFK) {
        List<Chatmaster> cList = em.createNamedQuery("Chatmaster.findByPropertyIDFK").setParameter("propertyIDFK", propertyIDFK).getResultList();
        return cList;
    }

    //insert chat
    @Override
    public String insertChat(Chatmaster chat) {
        try {
            em.persist(chat);
            return "Record Inserted!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    //update chat
    @Override
    public String updateChat(Chatmaster chat) {
        try {
            Chatmaster updateChat = em.find(Chatmaster.class, chat.getChatIDPK());
            
            updateChat.setChatText(chat.getChatText());
            updateChat.setPropertyIDFK(chat.getPropertyIDFK());
            updateChat.setToUserIDFK(chat.getToUserIDFK());
            updateChat.setFromUserIDFK(chat.getFromUserIDFK());
            
            em.persist(updateChat);
            return "Record Updated!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //delete chat
    @Override
    public String deleteChat(int chatIDPK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //search chat
    @Override
    public Chatmaster searchChat(int chatIDPK) {
        try {
            Chatmaster chat = (Chatmaster) em.find(Chatmaster.class, chatIDPK);
            return chat;
        } catch (Exception e) {
            return null;
        }
    }
}

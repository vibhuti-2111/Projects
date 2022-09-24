/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedBean;

import entity.Propertymaster;
import entity.Reviewratingmaster;
import entity.Statemaster;
import entity.Usermaster;
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
@Named(value = "reviewRatingBean")
@ApplicationScoped
public class reviewRatingManagedBean {

    @EJB
    private propertyRentalSessionBeanLocal propertyRentalSessionBean;

    /**
     * Creates a new instance of reviewRatingManagedBean
     */
    public reviewRatingManagedBean() {
    }
    
    int reviewRatingIDPK, propertyIDFK;
    String review, rating;
    List<Propertymaster> propertyList;
    Reviewratingmaster reviewRating = new Reviewratingmaster();
    
    @PostConstruct
    public void init() {
        propertyList = propertyRentalSessionBean.showProperty();
        reviewRatingIDPK = 0;
    }

    public int getReviewRatingIDPK() {
        return reviewRatingIDPK;
    }

    public void setReviewRatingIDPK(int reviewRatingIDPK) {
        this.reviewRatingIDPK = reviewRatingIDPK;
    }

    public int getPropertyIDFK() {
        return propertyIDFK;
    }

    public void setPropertyIDFK(int propertyIDFK) {
        this.propertyIDFK = propertyIDFK;
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

    public List<Propertymaster> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Propertymaster> propertyList) {
        this.propertyList = propertyList;
    }
    
    public List<Propertymaster> show_propertyList()
    {
        try {
            return propertyRentalSessionBean.showProperty();
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Reviewratingmaster> showTopReviewList() {
        try {
            return propertyRentalSessionBean.showReviewRating();
        } catch (Exception e) {
            return null;
        }
    }

    
    public List<Reviewratingmaster> show_reviewRatingList()
    {
        try {
            return propertyRentalSessionBean.showReviewRating();
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Reviewratingmaster> show_reviewRatingListByProperty(int id)
    {
        try {
            System.err.println("ID" + id);
            return propertyRentalSessionBean.showReviewRatingByProperty(id);
        } catch (Exception e) {
            return null;
        }
    }
    
    public String insertReviewRating_click(Propertymaster id)
    {
        try {
//            System.out.println("managedBean.propertyManagedBean.insertReviewRating_click()"+prop.getPropertyIDPK());
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            HttpSession userSession = request.getSession();
            
            Usermaster user = propertyRentalSessionBean.searchUser(Integer.parseInt(userSession.getAttribute("userIDPK").toString()));

            //Propertymaster property1 = propertyRentalSessionBean.searchProperty(propertyIDFK);
            reviewRating.setReviewRatingIDPK(0);
            reviewRating.setReview(review);
            reviewRating.setRating(rating);
            reviewRating.setPropertyIDFK(id);
            reviewRating.setUserIDFK(user);
            reviewRating.setIsActive(Short.parseShort("0"));
            System.out.println("managedBean.propertyManagedBean.insertReviewRating_click()Data :: "+ reviewRating.getRating() + " " + reviewRating.getReview() + " " + reviewRating.getPropertyIDFK().getPropertyIDPK() + " " + reviewRating.getUserIDFK().getUserIDPK());
            propertyRentalSessionBean.insertReviewRating(reviewRating);
            //clear();
            return "/client/index.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    
    public String insertReviewRating_click()
    {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            HttpSession userSession = request.getSession();
            
            Usermaster user = propertyRentalSessionBean.searchUser(Integer.parseInt(userSession.getAttribute("userIDPK").toString()));

            Propertymaster property = propertyRentalSessionBean.searchProperty(propertyIDFK);
            reviewRating.setReviewRatingIDPK(0);
            reviewRating.setReview(review);
            reviewRating.setRating(rating);
            reviewRating.setPropertyIDFK(property);
            reviewRating.setUserIDFK(user);
            propertyRentalSessionBean.insertReviewRating(reviewRating);
            clear();
            return "/admin/showReviewRating.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String updateCity_click()
    {
        try {
            Propertymaster property = propertyRentalSessionBean.searchProperty(propertyIDFK);
            reviewRating.setReviewRatingIDPK(reviewRatingIDPK);
            reviewRating.setReview(review);
            reviewRating.setRating(rating);
            reviewRating.setPropertyIDFK(property);
            System.out.println(propertyRentalSessionBean.updateReviewRating(reviewRating));
            clear();
            return "/admin/showReviewRating.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String deleteReviewRating_click(int reviewRatingIDPK)
    {
        try {
            propertyRentalSessionBean.deleteReviewRating(reviewRatingIDPK);
            return "/admin/showReviewRating.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String searchReviewRating_click(int id)
    {
        try {
            reviewRating = propertyRentalSessionBean.searchReviewRating(id);
            reviewRatingIDPK = reviewRating.getReviewRatingIDPK();
            review = reviewRating.getReview();
            rating = reviewRating.getRating();
            propertyIDFK = reviewRating.getPropertyIDFK().getPropertyIDPK();
            return "/admin/addReviewRating.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public void clear(){
        reviewRatingIDPK = 0;
        review = "";
        rating = "";
        propertyIDFK = 0;
    }
}

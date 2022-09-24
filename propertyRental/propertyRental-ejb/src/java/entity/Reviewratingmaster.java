/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "reviewratingmaster", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reviewratingmaster.findAll", query = "SELECT r FROM Reviewratingmaster r WHERE r.isActive=1"),
    @NamedQuery(name = "Reviewratingmaster.findByReviewRatingIDPK", query = "SELECT r FROM Reviewratingmaster r WHERE r.reviewRatingIDPK = :reviewRatingIDPK"),
    @NamedQuery(name = "Reviewratingmaster.findByReview", query = "SELECT r FROM Reviewratingmaster r WHERE r.review = :review"),
    @NamedQuery(name = "Reviewratingmaster.findByRating", query = "SELECT r FROM Reviewratingmaster r WHERE r.rating = :rating"),
    @NamedQuery(name = "Reviewratingmaster.findByRatingByProperty", query = "SELECT r FROM Reviewratingmaster r WHERE r.propertyIDFK.propertyIDPK = :propertyIDFK"),
    @NamedQuery(name = "Reviewratingmaster.findByIsActive", query = "SELECT r FROM Reviewratingmaster r WHERE r.isActive = :isActive")})
public class Reviewratingmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reviewRatingIDPK", nullable = false)
    private Integer reviewRatingIDPK;
    @Size(max = 255)
    @Column(name = "review", length = 255)
    private String review;
    @Size(max = 255)
    @Column(name = "rating", length = 255)
    private String rating;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private short isActive;
    @JoinColumn(name = "propertyIDFK", referencedColumnName = "propertyIDPK", nullable = false)
    @ManyToOne(optional = false)
    private Propertymaster propertyIDFK;
    @JoinColumn(name = "userIDFK", referencedColumnName = "userIDPK", nullable = false)
    @ManyToOne(optional = false)
    private Usermaster userIDFK;

    public Reviewratingmaster() {
    }

    public Reviewratingmaster(Integer reviewRatingIDPK) {
        this.reviewRatingIDPK = reviewRatingIDPK;
    }

    public Reviewratingmaster(Integer reviewRatingIDPK, short isActive) {
        this.reviewRatingIDPK = reviewRatingIDPK;
        this.isActive = isActive;
    }

    public Integer getReviewRatingIDPK() {
        return reviewRatingIDPK;
    }

    public void setReviewRatingIDPK(Integer reviewRatingIDPK) {
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

    public short getIsActive() {
        return isActive;
    }

    public void setIsActive(short isActive) {
        this.isActive = isActive;
    }

    public Propertymaster getPropertyIDFK() {
        return propertyIDFK;
    }

    public void setPropertyIDFK(Propertymaster propertyIDFK) {
        this.propertyIDFK = propertyIDFK;
    }

    public Usermaster getUserIDFK() {
        return userIDFK;
    }

    public void setUserIDFK(Usermaster userIDFK) {
        this.userIDFK = userIDFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewRatingIDPK != null ? reviewRatingIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reviewratingmaster)) {
            return false;
        }
        Reviewratingmaster other = (Reviewratingmaster) object;
        if ((this.reviewRatingIDPK == null && other.reviewRatingIDPK != null) || (this.reviewRatingIDPK != null && !this.reviewRatingIDPK.equals(other.reviewRatingIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Reviewratingmaster[ reviewRatingIDPK=" + reviewRatingIDPK + " ]";
    }

    public void setPropertyIDFK(int propertyIDFK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

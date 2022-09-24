/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "propertymaster", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propertymaster.findAll", query = "SELECT p FROM Propertymaster p WHERE p.isActive=1"),
    @NamedQuery(name = "Propertymaster.findByPropertyIDPK", query = "SELECT p FROM Propertymaster p WHERE p.propertyIDPK = :propertyIDPK"), 
    @NamedQuery(name = "Propertymaster.findByPropertyName", query = "SELECT p FROM Propertymaster p WHERE p.propertyName = :propertyName"),
    @NamedQuery(name = "Propertymaster.findByPropertyDescription", query = "SELECT p FROM Propertymaster p WHERE p.propertyDescription = :propertyDescription"),
    @NamedQuery(name = "Propertymaster.findByPropertyFullAddress", query = "SELECT p FROM Propertymaster p WHERE p.propertyFullAddress = :propertyFullAddress"),
    @NamedQuery(name = "Propertymaster.findByPropertyShortAddress", query = "SELECT p FROM Propertymaster p WHERE p.propertyShortAddress = :propertyShortAddress"),
    @NamedQuery(name = "Propertymaster.findByIsAvailable", query = "SELECT p FROM Propertymaster p WHERE p.isAvailable = :isAvailable"),
    @NamedQuery(name = "Propertymaster.findByPropertyRent", query = "SELECT p FROM Propertymaster p WHERE p.propertyRent = :propertyRent"),
    @NamedQuery(name = "Propertymaster.findByPropertyAdvanceRent", query = "SELECT p FROM Propertymaster p WHERE p.propertyAdvanceRent = :propertyAdvanceRent"),
    @NamedQuery(name = "Propertymaster.findByAddedDate", query = "SELECT p FROM Propertymaster p WHERE p.addedDate = :addedDate"),
    @NamedQuery(name = "Propertymaster.findByFeatures", query = "SELECT p FROM Propertymaster p WHERE p.features = :features"),
    @NamedQuery(name = "Propertymaster.findBymMainPropertyImage", query = "SELECT p FROM Propertymaster p WHERE p.mainPropertyImage = :mainPropertyImage"),
    @NamedQuery(name = "Propertymaster.findByPropertyType", query = "SELECT p FROM Propertymaster p WHERE p.isActive=1 AND p.propertyTypeIDFK.propertyTypeIDPK = :propertyTypeIDFK"),
    @NamedQuery(name = "Propertymaster.findPropertyIdByLast", query = "SELECT p FROM Propertymaster p ORDER BY p.propertyIDPK DESC"),
    @NamedQuery(name = "Propertymaster.findByPropertyTypeName", query = "SELECT p FROM Propertymaster p WHERE p.isActive=1 AND p.propertyTypeIDFK.propertyTypeName = :propertyTypeName and p.isAvailable=1"),
    @NamedQuery(name = "Propertymaster.findByUser", query = "SELECT p FROM Propertymaster p WHERE p.isActive=1 AND p.userIDFK.userIDPK = :userIDFK"),
    @NamedQuery(name = "Propertymaster.findByIsActive", query = "SELECT p FROM Propertymaster p WHERE p.isActive = :isActive")})
public class Propertymaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "propertyIDPK", nullable = false)
    private Integer propertyIDPK;
    @Size(max = 255)
    @Column(name = "propertyName", length = 255)
    private String propertyName;
    @Size(max = 1000)
    @Column(name = "propertyDescription", length = 1000)
    private String propertyDescription;
    @Size(max = 255)
    @Column(name = "propertyFullAddress", length = 255)
    private String propertyFullAddress;
    @Size(max = 255)
    @Column(name = "propertyShortAddress", length = 255)
    private String propertyShortAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isAvailable", nullable = false)
    private short isAvailable;
    @Size(max = 255)
    @Column(name = "propertyRent", length = 255)
    private String propertyRent;
    @Size(max = 255)
    @Column(name = "propertyAdvanceRent", length = 255)
    private String propertyAdvanceRent;
    @Column(name = "addedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @Size(max = 1000)
    @Column(name = "features", length = 1000)
    private String features;
    @Basic(optional = false)
    @NotNull
    @Size(max = 255)
    @Column(name = "mainPropertyImage", length = 255)
    private String mainPropertyImage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private short isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyIDFK")
    private Collection<Userrequestmaster> userrequestmasterCollection;
    @JoinColumn(name = "areaIDFK", referencedColumnName = "areaIDPK", nullable = false)
    @ManyToOne(optional = false)
    private Areamaster areaIDFK;
    @JoinColumn(name = "propertyTypeIDFK", referencedColumnName = "propertyTypeIDPK", nullable = false)
    @ManyToOne(optional = false)
    private Propertytypemaster propertyTypeIDFK;
    @JoinColumn(name = "userIDFK", referencedColumnName = "userIDPK", nullable = false)
    @ManyToOne(optional = false)
    private Usermaster userIDFK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyIDFK")
    private Collection<Propertyimagemaster> propertyimagemasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyIDFK")
    private Collection<Reviewratingmaster> reviewratingmasterCollection;

    public Propertymaster() {
    }

    public Propertymaster(Integer propertyIDPK) {
        this.propertyIDPK = propertyIDPK;
    }

    public Propertymaster(Integer propertyIDPK, short isAvailable, short isActive) {
        this.propertyIDPK = propertyIDPK;
        this.isAvailable = isAvailable;
        this.isActive = isActive;
    }

    public Integer getPropertyIDPK() {
        return propertyIDPK;
    }

    public void setPropertyIDPK(Integer propertyIDPK) {
        this.propertyIDPK = propertyIDPK;
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

    public short getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(short isAvailable) {
        this.isAvailable = isAvailable;
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

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public short getIsActive() {
        return isActive;
    }

    public String getMainPropertyImage() {
        return mainPropertyImage;
    }

    public void setMainPropertyImage(String mainPropertyImage) {
        this.mainPropertyImage = mainPropertyImage;
    }
    
    

    public void setIsActive(short isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public Collection<Userrequestmaster> getUserrequestmasterCollection() {
        return userrequestmasterCollection;
    }

    public void setUserrequestmasterCollection(Collection<Userrequestmaster> userrequestmasterCollection) {
        this.userrequestmasterCollection = userrequestmasterCollection;
    }

    public Areamaster getAreaIDFK() {
        return areaIDFK;
    }

    public void setAreaIDFK(Areamaster areaIDFK) {
        this.areaIDFK = areaIDFK;
    }

    public Propertytypemaster getPropertyTypeIDFK() {
        return propertyTypeIDFK;
    }

    public void setPropertyTypeIDFK(Propertytypemaster propertyTypeIDFK) {
        this.propertyTypeIDFK = propertyTypeIDFK;
    }

    public Usermaster getUserIDFK() {
        return userIDFK;
    }

    public void setUserIDFK(Usermaster userIDFK) {
        this.userIDFK = userIDFK;
    }

    @XmlTransient
    public Collection<Propertyimagemaster> getPropertyimagemasterCollection() {
        return propertyimagemasterCollection;
    }

    public void setPropertyimagemasterCollection(Collection<Propertyimagemaster> propertyimagemasterCollection) {
        this.propertyimagemasterCollection = propertyimagemasterCollection;
    }

    @XmlTransient
    public Collection<Reviewratingmaster> getReviewratingmasterCollection() {
        return reviewratingmasterCollection;
    }

    public void setReviewratingmasterCollection(Collection<Reviewratingmaster> reviewratingmasterCollection) {
        this.reviewratingmasterCollection = reviewratingmasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (propertyIDPK != null ? propertyIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propertymaster)) {
            return false;
        }
        Propertymaster other = (Propertymaster) object;
        if ((this.propertyIDPK == null && other.propertyIDPK != null) || (this.propertyIDPK != null && !this.propertyIDPK.equals(other.propertyIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Propertymaster[ propertyIDPK=" + propertyIDPK + " ]";
    }
    
}

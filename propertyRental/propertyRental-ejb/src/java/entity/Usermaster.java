/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "usermaster", catalog = "propertyrental", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"userEmail"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usermaster.findAll", query = "SELECT u FROM Usermaster u WHERE u.isActive=1 and u.userType='Client'"),
    @NamedQuery(name = "Usermaster.findByUserIDPK", query = "SELECT u FROM Usermaster u WHERE u.userIDPK = :userIDPK"),
    @NamedQuery(name = "Usermaster.findByUserFname", query = "SELECT u FROM Usermaster u WHERE u.userFname = :userFname"),
    @NamedQuery(name = "Usermaster.findByUserLname", query = "SELECT u FROM Usermaster u WHERE u.userLname = :userLname"),
    @NamedQuery(name = "Usermaster.findByUserType", query = "SELECT u FROM Usermaster u WHERE u.userType = :userType"),
    @NamedQuery(name = "Usermaster.findByUserEmail", query = "SELECT u FROM Usermaster u WHERE u.userEmail = :userEmail"),
    @NamedQuery(name = "Usermaster.findByUserPassword", query = "SELECT u FROM Usermaster u WHERE u.userPassword = :userPassword"),
    @NamedQuery(name = "Usermaster.findByUserGender", query = "SELECT u FROM Usermaster u WHERE u.userGender = :userGender"),
    @NamedQuery(name = "Usermaster.findByUserContactNo", query = "SELECT u FROM Usermaster u WHERE u.userContactNo = :userContactNo"),
    @NamedQuery(name = "Usermaster.findByUserImage", query = "SELECT u FROM Usermaster u WHERE u.userImage = :userImage"),
    @NamedQuery(name = "Usermaster.findUserForLogin", query = "SELECT u FROM Usermaster u WHERE u.userEmail = :userEmail and u.userPassword = :userPassword"),
    @NamedQuery(name = "Usermaster.findByIsActive", query = "SELECT u FROM Usermaster u WHERE u.isActive = :isActive")})
public class Usermaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userIDPK", nullable = false)
    private Integer userIDPK;
    @Size(max = 255)
    @Column(name = "userFname", length = 255)
    private String userFname;
    @Size(max = 255)
    @Column(name = "userLname", length = 255)
    private String userLname;
    @Size(max = 255)
    @Column(name = "userType", length = 255)
    private String userType;
    @Size(max = 255)
    @Column(name = "userEmail", length = 255)
    private String userEmail;
    @Size(max = 255)
    @Column(name = "userPassword", length = 255)
    private String userPassword;
    @Size(max = 255)
    @Column(name = "userGender", length = 255)
    private String userGender;
    @Size(max = 255)
    @Column(name = "userContactNo", length = 255)
    private String userContactNo;
    @Size(max = 255)
    @Column(name = "userImage", length = 255)
    private String userImage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private short isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIDFK")
    private Collection<Userrequestmaster> userrequestmasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIDFK")
    private Collection<Propertymaster> propertymasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIDFK")
    private Collection<Reviewratingmaster> reviewratingmasterCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usermaster")
//    private Collection<Usergroupmaster> usergroupmasterCollection;

    public Usermaster() {
    }

    public Usermaster(Integer userIDPK) {
        this.userIDPK = userIDPK;
    }

    public Usermaster(Integer userIDPK, short isActive) {
        this.userIDPK = userIDPK;
        this.isActive = isActive;
    }

    public Integer getUserIDPK() {
        return userIDPK;
    }

    public void setUserIDPK(Integer userIDPK) {
        this.userIDPK = userIDPK;
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

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public short getIsActive() {
        return isActive;
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

    @XmlTransient
    public Collection<Propertymaster> getPropertymasterCollection() {
        return propertymasterCollection;
    }

    public void setPropertymasterCollection(Collection<Propertymaster> propertymasterCollection) {
        this.propertymasterCollection = propertymasterCollection;
    }

    @XmlTransient
    public Collection<Reviewratingmaster> getReviewratingmasterCollection() {
        return reviewratingmasterCollection;
    }

    public void setReviewratingmasterCollection(Collection<Reviewratingmaster> reviewratingmasterCollection) {
        this.reviewratingmasterCollection = reviewratingmasterCollection;
    }

//    @XmlTransient
//    public Collection<Usergroupmaster> getUsergroupmasterCollection() {
//        return usergroupmasterCollection;
//    }
//
//    public void setUsergroupmasterCollection(Collection<Usergroupmaster> usergroupmasterCollection) {
//        this.usergroupmasterCollection = usergroupmasterCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userIDPK != null ? userIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usermaster)) {
            return false;
        }
        Usermaster other = (Usermaster) object;
        if ((this.userIDPK == null && other.userIDPK != null) || (this.userIDPK != null && !this.userIDPK.equals(other.userIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Usermaster[ userIDPK=" + userIDPK + " ]";
    }
    
}

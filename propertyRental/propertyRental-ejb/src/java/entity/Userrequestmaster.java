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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "userrequestmaster", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userrequestmaster.findAll", query = "SELECT u FROM Userrequestmaster u WHERE u.isActive=1"),
    @NamedQuery(name = "Userrequestmaster.findByUserRequestIDPK", query = "SELECT u FROM Userrequestmaster u WHERE u.userRequestIDPK = :userRequestIDPK"),
    @NamedQuery(name = "Userrequestmaster.findByStatus", query = "SELECT u FROM Userrequestmaster u WHERE u.status = :status"),
    @NamedQuery(name = "Userrequestmaster.findByProperty", query = "SELECT u FROM Userrequestmaster u WHERE u.propertyIDFK.propertyIDPK = :propertyIDFK and u.status=0"),
    @NamedQuery(name = "Userrequestmaster.findByUser", query = "SELECT u FROM Userrequestmaster u WHERE u.userIDFK.userIDPK = :userIDFK"),
    @NamedQuery(name = "Userrequestmaster.findByIsActive", query = "SELECT u FROM Userrequestmaster u WHERE u.isActive = :isActive")})
public class Userrequestmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userRequestIDPK", nullable = false)
    private Integer userRequestIDPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status", nullable = false)
    private short status;
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

    public Userrequestmaster() {
    }

    public Userrequestmaster(Integer userRequestIDPK) {
        this.userRequestIDPK = userRequestIDPK;
    }

    public Userrequestmaster(Integer userRequestIDPK, short status, short isActive) {
        this.userRequestIDPK = userRequestIDPK;
        this.status = status;
        this.isActive = isActive;
    }

    public Integer getUserRequestIDPK() {
        return userRequestIDPK;
    }

    public void setUserRequestIDPK(Integer userRequestIDPK) {
        this.userRequestIDPK = userRequestIDPK;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
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
        hash += (userRequestIDPK != null ? userRequestIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userrequestmaster)) {
            return false;
        }
        Userrequestmaster other = (Userrequestmaster) object;
        if ((this.userRequestIDPK == null && other.userRequestIDPK != null) || (this.userRequestIDPK != null && !this.userRequestIDPK.equals(other.userRequestIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Userrequestmaster[ userRequestIDPK=" + userRequestIDPK + " ]";
    }
    
}

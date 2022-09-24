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
@Table(name = "aminitymaster", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aminitymaster.findAll", query = "SELECT a FROM Aminitymaster a WHERE a.isActive=1"),
    @NamedQuery(name = "Aminitymaster.findByAminityIDPK", query = "SELECT a FROM Aminitymaster a WHERE a.aminityIDPK = :aminityIDPK"),
    @NamedQuery(name = "Aminitymaster.findAminityByPropertyType", query = "SELECT a FROM Aminitymaster a where a.isActive=1 and a.propertyTypeIDFK.propertyTypeIDPK=:propertyTypeIDFK"),
    @NamedQuery(name = "Aminitymaster.findByAminityName", query = "SELECT a FROM Aminitymaster a WHERE a.aminityName = :aminityName"),
    @NamedQuery(name = "Aminitymaster.findByIsNumber", query = "SELECT a FROM Aminitymaster a WHERE a.isNumber = :isNumber"),
    @NamedQuery(name = "Aminitymaster.findByIsActive", query = "SELECT a FROM Aminitymaster a WHERE a.isActive = :isActive")})
public class Aminitymaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aminityIDPK", nullable = false)
    private Integer aminityIDPK;
    @Size(max = 255)
    @Column(name = "aminityName", length = 255)
    private String aminityName;
    @Column(name = "isNumber")
    private Integer isNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private short isActive;
    @JoinColumn(name = "propertyTypeIDFK", referencedColumnName = "propertyTypeIDPK", nullable = false)
    @ManyToOne(optional = false)
    private Propertytypemaster propertyTypeIDFK;

    public Aminitymaster() {
    }

    public Aminitymaster(Integer aminityIDPK) {
        this.aminityIDPK = aminityIDPK;
    }

    public Aminitymaster(Integer aminityIDPK, short isActive) {
        this.aminityIDPK = aminityIDPK;
        this.isActive = isActive;
    }

    public Integer getAminityIDPK() {
        return aminityIDPK;
    }

    public void setAminityIDPK(Integer aminityIDPK) {
        this.aminityIDPK = aminityIDPK;
    }

    public String getAminityName() {
        return aminityName;
    }

    public void setAminityName(String aminityName) {
        this.aminityName = aminityName;
    }

    public Integer getIsNumber() {
        return isNumber;
    }

    public void setIsNumber(Integer isNumber) {
        this.isNumber = isNumber;
    }

    public short getIsActive() {
        return isActive;
    }

    public void setIsActive(short isActive) {
        this.isActive = isActive;
    }

    public Propertytypemaster getPropertyTypeIDFK() {
        return propertyTypeIDFK;
    }

    public void setPropertyTypeIDFK(Propertytypemaster propertyTypeIDFK) {
        this.propertyTypeIDFK = propertyTypeIDFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aminityIDPK != null ? aminityIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aminitymaster)) {
            return false;
        }
        Aminitymaster other = (Aminitymaster) object;
        if ((this.aminityIDPK == null && other.aminityIDPK != null) || (this.aminityIDPK != null && !this.aminityIDPK.equals(other.aminityIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Aminitymaster[ aminityIDPK=" + aminityIDPK + " ]";
    }
    
}

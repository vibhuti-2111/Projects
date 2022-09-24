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
@Table(name = "propertyimagemaster", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propertyimagemaster.findAll", query = "SELECT p FROM Propertyimagemaster p WHERE p.isActive=1"),
    @NamedQuery(name = "Propertyimagemaster.findByPropertyImageIDPK", query = "SELECT p FROM Propertyimagemaster p WHERE p.propertyImageIDPK = :propertyImageIDPK"),
    @NamedQuery(name = "Propertyimagemaster.findByPropertyImg", query = "SELECT p FROM Propertyimagemaster p WHERE p.propertyIDFK.propertyIDPK =:propertyIDFK and p.isActive=1"),
    @NamedQuery(name = "Propertyimagemaster.findByPropertyImage", query = "SELECT p FROM Propertyimagemaster p WHERE p.propertyImage = :propertyImage"),
    @NamedQuery(name = "Propertyimagemaster.findByIsActive", query = "SELECT p FROM Propertyimagemaster p WHERE p.isActive = :isActive")})
public class Propertyimagemaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "propertyImageIDPK", nullable = false)
    private Integer propertyImageIDPK;
    @Size(max = 255)
    @Column(name = "propertyImage", length = 255)
    private String propertyImage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private short isActive;
    @JoinColumn(name = "propertyIDFK", referencedColumnName = "propertyIDPK", nullable = false)
    @ManyToOne(optional = false)
    private Propertymaster propertyIDFK;

    public Propertyimagemaster() {
    }

    public Propertyimagemaster(Integer propertyImageIDPK) {
        this.propertyImageIDPK = propertyImageIDPK;
    }

    public Propertyimagemaster(Integer propertyImageIDPK, short isActive) {
        this.propertyImageIDPK = propertyImageIDPK;
        this.isActive = isActive;
    }

    public Integer getPropertyImageIDPK() {
        return propertyImageIDPK;
    }

    public void setPropertyImageIDPK(Integer propertyImageIDPK) {
        this.propertyImageIDPK = propertyImageIDPK;
    }

    public String getPropertyImage() {
        return propertyImage;
    }

    public void setPropertyImage(String propertyImage) {
        this.propertyImage = propertyImage;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (propertyImageIDPK != null ? propertyImageIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propertyimagemaster)) {
            return false;
        }
        Propertyimagemaster other = (Propertyimagemaster) object;
        if ((this.propertyImageIDPK == null && other.propertyImageIDPK != null) || (this.propertyImageIDPK != null && !this.propertyImageIDPK.equals(other.propertyImageIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Propertyimagemaster[ propertyImageIDPK=" + propertyImageIDPK + " ]";
    }
    
}

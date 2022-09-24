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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "propertytypemaster", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propertytypemaster.findAll", query = "SELECT p FROM Propertytypemaster p WHERE p.isActive=1"),
    @NamedQuery(name = "Propertytypemaster.findByPropertyTypeIDPK", query = "SELECT p FROM Propertytypemaster p WHERE p.propertyTypeIDPK = :propertyTypeIDPK"),
    @NamedQuery(name = "Propertytypemaster.findByPropertyTypeName", query = "SELECT p FROM Propertytypemaster p WHERE p.propertyTypeName = :propertyTypeName"),
    @NamedQuery(name = "Propertytypemaster.findByPropertySubTypeName", query = "SELECT p FROM Propertytypemaster p WHERE p.propertySubTypeName = :propertySubTypeName"),
    @NamedQuery(name = "Propertytypemaster.findByIsActive", query = "SELECT p FROM Propertytypemaster p WHERE p.isActive = :isActive")})
public class Propertytypemaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "propertyTypeIDPK", nullable = false)
    private Integer propertyTypeIDPK;
    @Size(max = 255)
    @Column(name = "propertyTypeName", length = 255)
    private String propertyTypeName;
    @Size(max = 255)
    @Column(name = "propertySubTypeName", length = 255)
    private String propertySubTypeName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private short isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyTypeIDFK")
    private Collection<Aminitymaster> aminitymasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyTypeIDFK")
    private Collection<Propertymaster> propertymasterCollection;

    public Propertytypemaster() {
    }

    public Propertytypemaster(Integer propertyTypeIDPK) {
        this.propertyTypeIDPK = propertyTypeIDPK;
    }

    public Propertytypemaster(Integer propertyTypeIDPK, short isActive) {
        this.propertyTypeIDPK = propertyTypeIDPK;
        this.isActive = isActive;
    }

    public Integer getPropertyTypeIDPK() {
        return propertyTypeIDPK;
    }

    public void setPropertyTypeIDPK(Integer propertyTypeIDPK) {
        this.propertyTypeIDPK = propertyTypeIDPK;
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

    public short getIsActive() {
        return isActive;
    }

    public void setIsActive(short isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public Collection<Aminitymaster> getAminitymasterCollection() {
        return aminitymasterCollection;
    }

    public void setAminitymasterCollection(Collection<Aminitymaster> aminitymasterCollection) {
        this.aminitymasterCollection = aminitymasterCollection;
    }

    @XmlTransient
    public Collection<Propertymaster> getPropertymasterCollection() {
        return propertymasterCollection;
    }

    public void setPropertymasterCollection(Collection<Propertymaster> propertymasterCollection) {
        this.propertymasterCollection = propertymasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (propertyTypeIDPK != null ? propertyTypeIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propertytypemaster)) {
            return false;
        }
        Propertytypemaster other = (Propertytypemaster) object;
        if ((this.propertyTypeIDPK == null && other.propertyTypeIDPK != null) || (this.propertyTypeIDPK != null && !this.propertyTypeIDPK.equals(other.propertyTypeIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Propertytypemaster[ propertyTypeIDPK=" + propertyTypeIDPK + " ]";
    }
    
}

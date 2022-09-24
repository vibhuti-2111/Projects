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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "areamaster", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areamaster.findAll", query = "SELECT a FROM Areamaster a WHERE a.isActive=1"),
    @NamedQuery(name = "Areamaster.findAreaByCity", query = "SELECT a FROM Areamaster a where a.isActive=1 and a.cityIDFK.cityIDPK=:cityIDFK"),
    @NamedQuery(name = "Areamaster.findByAreaIDPK", query = "SELECT a FROM Areamaster a WHERE a.areaIDPK = :areaIDPK"),
    @NamedQuery(name = "Areamaster.findByAreaName", query = "SELECT a FROM Areamaster a WHERE a.areaName = :areaName"),
    @NamedQuery(name = "Areamaster.findByIsActive", query = "SELECT a FROM Areamaster a WHERE a.isActive = :isActive")})
public class Areamaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "areaIDPK", nullable = false)
    private Integer areaIDPK;
    @Size(max = 255)
    @Column(name = "areaName", length = 255)
    private String areaName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private short isActive;
    @JoinColumn(name = "cityIDFK", referencedColumnName = "cityIDPK", nullable = false)
    @ManyToOne(optional = false)
    private Citymaster cityIDFK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaIDFK")
    private Collection<Propertymaster> propertymasterCollection;

    public Areamaster() {
    }

    public Areamaster(Integer areaIDPK) {
        this.areaIDPK = areaIDPK;
    }

    public Areamaster(Integer areaIDPK, short isActive) {
        this.areaIDPK = areaIDPK;
        this.isActive = isActive;
    }

    public Integer getAreaIDPK() {
        return areaIDPK;
    }

    public void setAreaIDPK(Integer areaIDPK) {
        this.areaIDPK = areaIDPK;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public short getIsActive() {
        return isActive;
    }

    public void setIsActive(short isActive) {
        this.isActive = isActive;
    }

    public Citymaster getCityIDFK() {
        return cityIDFK;
    }

    public void setCityIDFK(Citymaster cityIDFK) {
        this.cityIDFK = cityIDFK;
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
        hash += (areaIDPK != null ? areaIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areamaster)) {
            return false;
        }
        Areamaster other = (Areamaster) object;
        if ((this.areaIDPK == null && other.areaIDPK != null) || (this.areaIDPK != null && !this.areaIDPK.equals(other.areaIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Areamaster[ areaIDPK=" + areaIDPK + " ]";
    }
    
}

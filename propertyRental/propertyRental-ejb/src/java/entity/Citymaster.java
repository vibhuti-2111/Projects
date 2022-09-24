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
@Table(name = "citymaster", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Citymaster.findAll", query = "SELECT c FROM Citymaster c WHERE c.isActive=1"),
    @NamedQuery(name = "Citymaster.findByCityIDPK", query = "SELECT c FROM Citymaster c WHERE c.cityIDPK = :cityIDPK"),
    @NamedQuery(name = "Citymaster.findCityByState", query = "SELECT c FROM Citymaster c where c.isActive=1 and c.stateIDFK.stateIDPK=:stateIDFK"),
    @NamedQuery(name = "Citymaster.findByCityName", query = "SELECT c FROM Citymaster c WHERE c.cityName = :cityName"),
    @NamedQuery(name = "Citymaster.findByIsActive", query = "SELECT c FROM Citymaster c WHERE c.isActive = :isActive")})
public class Citymaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cityIDPK", nullable = false)
    private Integer cityIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cityName", nullable = false, length = 255)
    private String cityName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private short isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityIDFK")
    private Collection<Areamaster> areamasterCollection;
    @JoinColumn(name = "stateIDFK", referencedColumnName = "stateIDPK", nullable = false)
    @ManyToOne(optional = false)
    private Statemaster stateIDFK;

    public Citymaster() {
    }

    public Citymaster(Integer cityIDPK) {
        this.cityIDPK = cityIDPK;
    }

    public Citymaster(Integer cityIDPK, String cityName, short isActive) {
        this.cityIDPK = cityIDPK;
        this.cityName = cityName;
        this.isActive = isActive;
    }

    public Integer getCityIDPK() {
        return cityIDPK;
    }

    public void setCityIDPK(Integer cityIDPK) {
        this.cityIDPK = cityIDPK;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public short getIsActive() {
        return isActive;
    }

    public void setIsActive(short isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public Collection<Areamaster> getAreamasterCollection() {
        return areamasterCollection;
    }

    public void setAreamasterCollection(Collection<Areamaster> areamasterCollection) {
        this.areamasterCollection = areamasterCollection;
    }

    public Statemaster getStateIDFK() {
        return stateIDFK;
    }

    public void setStateIDFK(Statemaster stateIDFK) {
        this.stateIDFK = stateIDFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityIDPK != null ? cityIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citymaster)) {
            return false;
        }
        Citymaster other = (Citymaster) object;
        if ((this.cityIDPK == null && other.cityIDPK != null) || (this.cityIDPK != null && !this.cityIDPK.equals(other.cityIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Citymaster[ cityIDPK=" + cityIDPK + " ]";
    }
    
}

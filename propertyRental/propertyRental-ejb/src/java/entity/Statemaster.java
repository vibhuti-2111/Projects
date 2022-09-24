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
@Table(name = "statemaster", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statemaster.findAll", query = "SELECT s FROM Statemaster s"),
    @NamedQuery(name = "Statemaster.findByStateIDPK", query = "SELECT s FROM Statemaster s WHERE s.stateIDPK = :stateIDPK"),
    @NamedQuery(name = "Statemaster.findByStateName", query = "SELECT s FROM Statemaster s WHERE s.stateName = :stateName"),
    @NamedQuery(name = "Statemaster.findByIsActive", query = "SELECT s FROM Statemaster s WHERE s.isActive = :isActive")})
public class Statemaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stateIDPK", nullable = false)
    private Integer stateIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "stateName", nullable = false, length = 255)
    private String stateName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateIDFK")
    private Collection<Citymaster> citymasterCollection;

    public Statemaster() {
    }

    public Statemaster(Integer stateIDPK) {
        this.stateIDPK = stateIDPK;
    }

    public Statemaster(Integer stateIDPK, String stateName, boolean isActive) {
        this.stateIDPK = stateIDPK;
        this.stateName = stateName;
        this.isActive = isActive;
    }

    public Integer getStateIDPK() {
        return stateIDPK;
    }

    public void setStateIDPK(Integer stateIDPK) {
        this.stateIDPK = stateIDPK;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public Collection<Citymaster> getCitymasterCollection() {
        return citymasterCollection;
    }

    public void setCitymasterCollection(Collection<Citymaster> citymasterCollection) {
        this.citymasterCollection = citymasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateIDPK != null ? stateIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statemaster)) {
            return false;
        }
        Statemaster other = (Statemaster) object;
        if ((this.stateIDPK == null && other.stateIDPK != null) || (this.stateIDPK != null && !this.stateIDPK.equals(other.stateIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Statemaster[ stateIDPK=" + stateIDPK + " ]";
    }
    
}

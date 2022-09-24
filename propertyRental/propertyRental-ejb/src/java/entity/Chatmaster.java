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
@Table(name = "chatmaster", catalog = "propertyrental", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chatmaster.findAll", query = "SELECT c FROM Chatmaster c"),
    @NamedQuery(name = "Chatmaster.findByChatIDPK", query = "SELECT c FROM Chatmaster c WHERE c.chatIDPK = :chatIDPK"),
    @NamedQuery(name = "Chatmaster.findByChatText", query = "SELECT c FROM Chatmaster c WHERE c.chatText = :chatText"),
    @NamedQuery(name = "Chatmaster.findByPropertyIDFK", query = "SELECT c FROM Chatmaster c WHERE c.propertyIDFK = :propertyIDFK"),
    @NamedQuery(name = "Chatmaster.findByToUserIDFK", query = "SELECT c FROM Chatmaster c WHERE c.toUserIDFK = :toUserIDFK"),
    @NamedQuery(name = "Chatmaster.findByFromUserIDFK", query = "SELECT c FROM Chatmaster c WHERE c.fromUserIDFK = :fromUserIDFK"),
    @NamedQuery(name = "Chatmaster.findByIsActive", query = "SELECT c FROM Chatmaster c WHERE c.isActive = :isActive")})
public class Chatmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "chatIDPK", nullable = false)
    private Integer chatIDPK;
    @Size(max = 255)
    @Column(name = "chatText", length = 255)
    private String chatText;
    @Basic(optional = false)
    @NotNull
    @Column(name = "propertyIDFK", nullable = false)
    private int propertyIDFK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "toUserIDFK", nullable = false)
    private int toUserIDFK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fromUserIDFK", nullable = false)
    private int fromUserIDFK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private short isActive;

    public Chatmaster() {
    }

    public Chatmaster(Integer chatIDPK) {
        this.chatIDPK = chatIDPK;
    }

    public Chatmaster(Integer chatIDPK, int propertyIDFK, int toUserIDFK, int fromUserIDFK, short isActive) {
        this.chatIDPK = chatIDPK;
        this.propertyIDFK = propertyIDFK;
        this.toUserIDFK = toUserIDFK;
        this.fromUserIDFK = fromUserIDFK;
        this.isActive = isActive;
    }

    public Integer getChatIDPK() {
        return chatIDPK;
    }

    public void setChatIDPK(Integer chatIDPK) {
        this.chatIDPK = chatIDPK;
    }

    public String getChatText() {
        return chatText;
    }

    public void setChatText(String chatText) {
        this.chatText = chatText;
    }

    public int getPropertyIDFK() {
        return propertyIDFK;
    }

    public void setPropertyIDFK(int propertyIDFK) {
        this.propertyIDFK = propertyIDFK;
    }

    public int getToUserIDFK() {
        return toUserIDFK;
    }

    public void setToUserIDFK(int toUserIDFK) {
        this.toUserIDFK = toUserIDFK;
    }

    public int getFromUserIDFK() {
        return fromUserIDFK;
    }

    public void setFromUserIDFK(int fromUserIDFK) {
        this.fromUserIDFK = fromUserIDFK;
    }

    public short getIsActive() {
        return isActive;
    }

    public void setIsActive(short isActive) {
        this.isActive = isActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chatIDPK != null ? chatIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chatmaster)) {
            return false;
        }
        Chatmaster other = (Chatmaster) object;
        if ((this.chatIDPK == null && other.chatIDPK != null) || (this.chatIDPK != null && !this.chatIDPK.equals(other.chatIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Chatmaster[ chatIDPK=" + chatIDPK + " ]";
    }
    
}

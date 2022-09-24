package entity;

import entity.Areamaster;
import entity.Propertyimagemaster;
import entity.Propertytypemaster;
import entity.Reviewratingmaster;
import entity.Usermaster;
import entity.Userrequestmaster;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T15:03:30", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Propertymaster.class)
public class Propertymaster_ { 

    public static volatile SingularAttribute<Propertymaster, Short> isAvailable;
    public static volatile SingularAttribute<Propertymaster, Date> addedDate;
    public static volatile SingularAttribute<Propertymaster, String> propertyDescription;
    public static volatile SingularAttribute<Propertymaster, Areamaster> areaIDFK;
    public static volatile SingularAttribute<Propertymaster, String> mainPropertyImage;
    public static volatile CollectionAttribute<Propertymaster, Userrequestmaster> userrequestmasterCollection;
    public static volatile SingularAttribute<Propertymaster, Short> isActive;
    public static volatile SingularAttribute<Propertymaster, String> propertyAdvanceRent;
    public static volatile SingularAttribute<Propertymaster, String> features;
    public static volatile SingularAttribute<Propertymaster, Usermaster> userIDFK;
    public static volatile SingularAttribute<Propertymaster, String> propertyName;
    public static volatile SingularAttribute<Propertymaster, String> propertyShortAddress;
    public static volatile CollectionAttribute<Propertymaster, Propertyimagemaster> propertyimagemasterCollection;
    public static volatile SingularAttribute<Propertymaster, Integer> propertyIDPK;
    public static volatile CollectionAttribute<Propertymaster, Reviewratingmaster> reviewratingmasterCollection;
    public static volatile SingularAttribute<Propertymaster, String> propertyRent;
    public static volatile SingularAttribute<Propertymaster, Propertytypemaster> propertyTypeIDFK;
    public static volatile SingularAttribute<Propertymaster, String> propertyFullAddress;

}
package entity;

import entity.Propertymaster;
import entity.Usermaster;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T15:03:30", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Reviewratingmaster.class)
public class Reviewratingmaster_ { 

    public static volatile SingularAttribute<Reviewratingmaster, Usermaster> userIDFK;
    public static volatile SingularAttribute<Reviewratingmaster, String> review;
    public static volatile SingularAttribute<Reviewratingmaster, Propertymaster> propertyIDFK;
    public static volatile SingularAttribute<Reviewratingmaster, String> rating;
    public static volatile SingularAttribute<Reviewratingmaster, Integer> reviewRatingIDPK;
    public static volatile SingularAttribute<Reviewratingmaster, Short> isActive;

}
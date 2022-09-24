package entity;

import entity.Propertymaster;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T15:03:30", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Propertyimagemaster.class)
public class Propertyimagemaster_ { 

    public static volatile SingularAttribute<Propertyimagemaster, String> propertyImage;
    public static volatile SingularAttribute<Propertyimagemaster, Integer> propertyImageIDPK;
    public static volatile SingularAttribute<Propertyimagemaster, Propertymaster> propertyIDFK;
    public static volatile SingularAttribute<Propertyimagemaster, Short> isActive;

}
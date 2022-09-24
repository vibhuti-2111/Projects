package entity;

import entity.Propertytypemaster;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T15:03:30", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Aminitymaster.class)
public class Aminitymaster_ { 

    public static volatile SingularAttribute<Aminitymaster, String> aminityName;
    public static volatile SingularAttribute<Aminitymaster, Integer> isNumber;
    public static volatile SingularAttribute<Aminitymaster, Integer> aminityIDPK;
    public static volatile SingularAttribute<Aminitymaster, Propertytypemaster> propertyTypeIDFK;
    public static volatile SingularAttribute<Aminitymaster, Short> isActive;

}
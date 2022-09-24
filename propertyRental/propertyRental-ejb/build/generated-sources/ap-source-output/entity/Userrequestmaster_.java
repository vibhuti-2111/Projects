package entity;

import entity.Propertymaster;
import entity.Usermaster;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T15:03:30", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Userrequestmaster.class)
public class Userrequestmaster_ { 

    public static volatile SingularAttribute<Userrequestmaster, Usermaster> userIDFK;
    public static volatile SingularAttribute<Userrequestmaster, Propertymaster> propertyIDFK;
    public static volatile SingularAttribute<Userrequestmaster, Short> isActive;
    public static volatile SingularAttribute<Userrequestmaster, Integer> userRequestIDPK;
    public static volatile SingularAttribute<Userrequestmaster, Short> status;

}
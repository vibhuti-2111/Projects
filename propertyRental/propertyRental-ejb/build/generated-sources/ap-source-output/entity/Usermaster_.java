package entity;

import entity.Propertymaster;
import entity.Reviewratingmaster;
import entity.Userrequestmaster;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T15:03:30", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Usermaster.class)
public class Usermaster_ { 

    public static volatile SingularAttribute<Usermaster, String> userLname;
    public static volatile SingularAttribute<Usermaster, String> userPassword;
    public static volatile CollectionAttribute<Usermaster, Userrequestmaster> userrequestmasterCollection;
    public static volatile CollectionAttribute<Usermaster, Propertymaster> propertymasterCollection;
    public static volatile SingularAttribute<Usermaster, Short> isActive;
    public static volatile SingularAttribute<Usermaster, String> userImage;
    public static volatile SingularAttribute<Usermaster, String> userContactNo;
    public static volatile CollectionAttribute<Usermaster, Reviewratingmaster> reviewratingmasterCollection;
    public static volatile SingularAttribute<Usermaster, Integer> userIDPK;
    public static volatile SingularAttribute<Usermaster, String> userEmail;
    public static volatile SingularAttribute<Usermaster, String> userGender;
    public static volatile SingularAttribute<Usermaster, String> userType;
    public static volatile SingularAttribute<Usermaster, String> userFname;

}
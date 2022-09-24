package entity;

import entity.Areamaster;
import entity.Statemaster;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T15:03:30", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Citymaster.class)
public class Citymaster_ { 

    public static volatile SingularAttribute<Citymaster, Integer> cityIDPK;
    public static volatile SingularAttribute<Citymaster, String> cityName;
    public static volatile SingularAttribute<Citymaster, Statemaster> stateIDFK;
    public static volatile SingularAttribute<Citymaster, Short> isActive;
    public static volatile CollectionAttribute<Citymaster, Areamaster> areamasterCollection;

}
package entity;

import entity.Citymaster;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T15:03:30", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Statemaster.class)
public class Statemaster_ { 

    public static volatile SingularAttribute<Statemaster, Integer> stateIDPK;
    public static volatile SingularAttribute<Statemaster, String> stateName;
    public static volatile CollectionAttribute<Statemaster, Citymaster> citymasterCollection;
    public static volatile SingularAttribute<Statemaster, Boolean> isActive;

}
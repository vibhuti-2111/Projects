package entity;

import entity.Citymaster;
import entity.Propertymaster;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T15:03:30", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Areamaster.class)
public class Areamaster_ { 

    public static volatile SingularAttribute<Areamaster, String> areaName;
    public static volatile SingularAttribute<Areamaster, Integer> areaIDPK;
    public static volatile SingularAttribute<Areamaster, Citymaster> cityIDFK;
    public static volatile CollectionAttribute<Areamaster, Propertymaster> propertymasterCollection;
    public static volatile SingularAttribute<Areamaster, Short> isActive;

}
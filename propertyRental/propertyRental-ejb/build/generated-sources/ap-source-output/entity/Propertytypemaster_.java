package entity;

import entity.Aminitymaster;
import entity.Propertymaster;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T15:03:30", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Propertytypemaster.class)
public class Propertytypemaster_ { 

    public static volatile CollectionAttribute<Propertytypemaster, Aminitymaster> aminitymasterCollection;
    public static volatile SingularAttribute<Propertytypemaster, String> propertyTypeName;
    public static volatile SingularAttribute<Propertytypemaster, Integer> propertyTypeIDPK;
    public static volatile SingularAttribute<Propertytypemaster, String> propertySubTypeName;
    public static volatile CollectionAttribute<Propertytypemaster, Propertymaster> propertymasterCollection;
    public static volatile SingularAttribute<Propertytypemaster, Short> isActive;

}
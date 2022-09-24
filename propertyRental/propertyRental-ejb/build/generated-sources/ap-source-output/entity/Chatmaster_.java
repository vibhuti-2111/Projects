package entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T15:03:30", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Chatmaster.class)
public class Chatmaster_ { 

    public static volatile SingularAttribute<Chatmaster, Integer> toUserIDFK;
    public static volatile SingularAttribute<Chatmaster, Integer> propertyIDFK;
    public static volatile SingularAttribute<Chatmaster, Integer> fromUserIDFK;
    public static volatile SingularAttribute<Chatmaster, Integer> chatIDPK;
    public static volatile SingularAttribute<Chatmaster, String> chatText;
    public static volatile SingularAttribute<Chatmaster, Short> isActive;

}
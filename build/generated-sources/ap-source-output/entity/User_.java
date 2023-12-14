package entity;

import entity.Order;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-12-08T19:12:25", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> diachi;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> sdt;
    public static volatile SingularAttribute<User, Integer> role;
    public static volatile SingularAttribute<User, String> name;
    public static volatile ListAttribute<User, Order> orders;
    public static volatile SingularAttribute<User, Integer> userId;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}
package entity;

import entity.Orderdetail;
import entity.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-12-01T10:29:42", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Order.class)
public class Order_ { 

    public static volatile SingularAttribute<Order, String> date;
    public static volatile SingularAttribute<Order, String> sdt;
    public static volatile SingularAttribute<Order, Double> total;
    public static volatile SingularAttribute<Order, Integer> orderId;
    public static volatile SingularAttribute<Order, String> adress;
    public static volatile ListAttribute<Order, Orderdetail> Orderdetails;
    public static volatile SingularAttribute<Order, User> user;

}
package entity;

import entity.Order;
import entity.Product;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-12-08T19:12:25", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Orderdetail.class)
public class Orderdetail_ { 

    public static volatile SingularAttribute<Orderdetail, Product> product;
    public static volatile SingularAttribute<Orderdetail, Integer> quantity;
    public static volatile SingularAttribute<Orderdetail, Integer> orderDetailId;
    public static volatile SingularAttribute<Orderdetail, Order> order;

}
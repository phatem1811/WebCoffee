package entity;

import entity.Category;
import entity.Orderdetail;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-12-01T10:29:42", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, String> img;
    public static volatile SingularAttribute<Product, Integer> productID;
    public static volatile SingularAttribute<Product, Integer> productSize;
    public static volatile SingularAttribute<Product, Category> category;
    public static volatile ListAttribute<Product, Orderdetail> Orderdetails;
    public static volatile SingularAttribute<Product, String> productName;
    public static volatile SingularAttribute<Product, Integer> productPrice;

}